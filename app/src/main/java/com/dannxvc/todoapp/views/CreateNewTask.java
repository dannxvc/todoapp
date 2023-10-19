package com.dannxvc.todoapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dannxvc.todoapp.R;

public class CreateNewTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_task);
    }
    public void goToHome(View view){
        Intent intent=new Intent(this, HomeTasks.class);
        startActivity(intent);
    }
}