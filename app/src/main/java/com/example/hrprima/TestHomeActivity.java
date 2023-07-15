package com.example.hrprima;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.hrprima.databinding.ActivityLoginBinding;
import com.example.hrprima.databinding.ActivityTestHomeBinding;

public class TestHomeActivity extends AppCompatActivity {

    ActivityTestHomeBinding activityTestHomeBinding;
    Intent intent3;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityTestHomeBinding = activityTestHomeBinding.inflate(getLayoutInflater());
        View view = activityTestHomeBinding.getRoot();
        setContentView(view);
        init();
    }
    private void init(){
//        intent3 = getIntent();
//        String UserName = intent3.getStringExtra("USER_ID");
//        activityTestHomeBinding.txtWelcome.setText(UserName);

        User userObj = (User)getIntent().getSerializableExtra("USER");
        activityTestHomeBinding.txtWelcome.setText("Welcome " + userObj.userId + " !" + "\n" + userObj.emailId);


    }

}