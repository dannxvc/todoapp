package com.dannxvc.todoapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dannxvc.todoapp.R;

public class HomeTasks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_tasks);
    }
    public void goToCreateTask(View view){
        Intent intent=new Intent(this, CreateNewTask.class);
        startActivity(intent);
    }
    public void goToHome(View view){
        Intent intent=new Intent(this, HomeTasks.class);
        startActivity(intent);
    }
}