package com.dannxvc.todoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.dannxvc.todoapp.views.CreateAccount;
import com.dannxvc.todoapp.views.Login;
import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
//navigation
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ){
//        final View view = inflater.inflate(R.layout.activity_main, container,false);
//        Button btnLogin = view.findViewById(R.id.btncontinuarEmail);
//
//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Navigation.findNavController(view).navigate(R.id.action_welcome_to_login);
//            }
//        });
//        return view;
//    }
    public void goToLogin(View view){
        Intent intent=new Intent(this, Login.class);
        startActivity(intent);
    }

    public void goToCreateAcc(View view){
        Intent intent=new Intent(this, CreateAccount.class);
        startActivity(intent);
    }

}