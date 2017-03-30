package com.example.ovi.resturantmanagement;


import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView regPage;
    EditText emailEt,passEt;
    Button loginBtn;
    ProgressDialog progressdialog;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressdialog=new ProgressDialog(this);
        initAll();
        loginBtn.setOnClickListener(this);
        regPage.setOnClickListener(this);
        firebaseAuth=FirebaseAuth.getInstance();
        }

        public void initAll(){
            regPage= (TextView) findViewById(R.id.register);
            emailEt= (EditText) findViewById(R.id.email);
            passEt= (EditText) findViewById(R.id.pass);
            loginBtn= (Button) findViewById(R.id.login);
        }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register:
                Intent registerPage=new Intent(this,Main2Activity.class);
                startActivity(registerPage);
                break;
            case R.id.login:
                userLogin();
        }
    }

    private void userLogin() {
        String email=emailEt.getText().toString().trim();
        String password=passEt.getText().toString().trim();
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please enter Correct email", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please Enter password", Toast.LENGTH_SHORT).show();
            return;
        }
        progressdialog.setMessage("User is registering...");
        progressdialog.show();
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    finish();
                    Intent profile =new Intent(MainActivity.this,FoodList.class);
                    startActivity(profile);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Registration Error",Toast.LENGTH_LONG).show();
                }
                progressdialog.dismiss();
            }
        });
    }
}