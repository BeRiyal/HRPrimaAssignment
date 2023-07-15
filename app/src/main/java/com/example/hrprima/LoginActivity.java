package com.example.hrprima;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.hrprima.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity  implements View.OnClickListener{

    ActivityLoginBinding loginBinding;
    Intent intent2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loginBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = loginBinding.getRoot();
        setContentView(view);
        init();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==loginBinding.btnLogin.getId()){
            if(loginBinding.edtUserId.getText().toString().trim().equals("Riyal") && loginBinding.edtPasswd.getText().toString().trim().equals("Hey")){
                intent2 = new Intent(this,TestHomeActivity.class);
//                intent2.putExtra("USER_ID",loginBinding.edtUserId.getText().toString().trim());
                User objUser = new User(loginBinding.edtUserId.getText().toString().trim(),loginBinding.edtEmailid.getText().toString().trim());
                intent2.putExtra("USER",objUser);
                startActivity(intent2);
            }
            else{
                Toast.makeText(this, "Invalid Credential", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void init(){
        loginBinding.btnLogin.setOnClickListener(this);
    }
}