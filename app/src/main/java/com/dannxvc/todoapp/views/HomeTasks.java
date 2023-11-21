package com.dannxvc.todoapp.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dannxvc.todoapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeTasks extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FloatingActionButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_tasks);

        recyclerView = findViewById(R.id.recycerview);
        mFab = findViewById(R.id.fabAddTask);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(HomeTasks.this));

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddNewTask.newInstance().show(getSupportFragmentManager(),AddNewTask.TAG);
            }
        });
    }
    public void goToCreateTask(View view){
        Intent intent=new Intent(this, CreateNewTask.class);
        startActivity(intent);
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