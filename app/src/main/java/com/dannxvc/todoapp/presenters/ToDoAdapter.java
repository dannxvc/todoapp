package com.dannxvc.todoapp.presenters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dannxvc.todoapp.R;
import com.dannxvc.todoapp.model.ToDoModel;
import com.dannxvc.todoapp.views.HomeTasks;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.MyViewHolder> {

    private List<ToDoModel> todoList;
    private HomeTasks activity;
    private FirebaseFirestore firestore;
    public ToDoAdapter(HomeTasks homeTasks, List<ToDoModel> todoList){
        this.todoList = todoList;
        activity = homeTasks;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.each_task, parent, false);
        firestore = FirebaseFirestore.getInstance();
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ToDoModel toDoModel = todoList.get(position);
        holder.mCheckBok.setText(toDoModel.getTask());
        holder.mDueDateTv.setText(toDoModel.getDue());
        holder.mDueTimeTv.setText(toDoModel.getTime());
        holder.mCheckBok.setChecked(toBoolean(toDoModel.getStatus()));
        holder.mCheckBok.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    firestore.collection("task").document(toDoModel.TaskId).update("status",1);

                }else{
                    firestore.collection("task").document(toDoModel.TaskId).update("status",0);
                }
            }
        });
    }

    private boolean toBoolean(int status){
        return status !=0;
    }
    @Override
    public int getItemCount() {
        return todoList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView mDueDateTv;
        TextView mDueTimeTv;
        CheckBox mCheckBok;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mDueDateTv = itemView.findViewById(R.id.due_date_tv);
            mDueTimeTv = itemView.findViewById(R.id.due_time_tv);
            mCheckBok = itemView.findViewById(R.id.mcheckbox);
        }
    }
}
