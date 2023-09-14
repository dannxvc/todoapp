package com.dannxvc.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dannxvc.todoapp.views.CreateAccount;
import com.dannxvc.todoapp.views.Login;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToLogin(View view){
        Intent intent=new Intent(this, Login.class);
        startActivity(intent);
    }
    public void goToCreateAcc(View view){
        Intent intent=new Intent(this, CreateAccount.class);
        startActivity(intent);
    }

}