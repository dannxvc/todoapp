package com.dannxvc.todoapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dannxvc.todoapp.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void goToHome(View view){
        Intent intent=new Intent(this, HomeTasks.class);
        startActivity(intent);
    }
}