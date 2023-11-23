package com.dannxvc.todoapp.views;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dannxvc.todoapp.R;
import com.dannxvc.todoapp.model.ToDoModel;
import com.dannxvc.todoapp.presenters.ToDoAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HomeTasks extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FloatingActionButton mFab;
    private FirebaseFirestore firestore;
    private ToDoAdapter adapter;
    private List<ToDoModel> mList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_tasks);

        recyclerView = findViewById(R.id.recycerview);
        mFab = findViewById(R.id.fabAddTask);
        firestore = FirebaseFirestore.getInstance();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(HomeTasks.this));

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddNewTask.newInstance().show(getSupportFragmentManager(),AddNewTask.TAG);
            }
        });
        mList = new ArrayList<>();
        adapter = new ToDoAdapter(HomeTasks.this, mList);
        recyclerView.setAdapter(adapter);
        showData();
    }

    private void showData(){
        firestore.collection("task").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                for(DocumentChange documentChange: value.getDocumentChanges()){
                    if (documentChange.getType() == DocumentChange.Type.ADDED){
                        String id = documentChange.getDocument().getId();
                        ToDoModel toDoModel = documentChange.getDocument().toObject(ToDoModel.class).withId(id);

                        mList.add(toDoModel);
                        adapter.notifyDataSetChanged();
                    }
                }
                Collections.reverse(mList);
            }
        });
    }


    public void goToHome(View view){
        Intent intent=new Intent(this, HomeTasks.class);
        startActivity(intent);
    }
    public void goToLogin(View view){
        Intent intent=new Intent(this, Login.class);
        startActivity(intent);
    }
}