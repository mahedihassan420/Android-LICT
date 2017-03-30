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

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{
    Button btnRegister;
    private TextView signinTv;
    private EditText emailEt,passwordEt;

    private ProgressDialog progressdialog;

    private FirebaseAuth  firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        progressdialog = new ProgressDialog(this);

        firebaseAuth = FirebaseAuth.getInstance();

        signinTv = (TextView) findViewById(R.id.sign);
        emailEt = (EditText) findViewById(R.id.emailReg);
        passwordEt = (EditText) findViewById(R.id.passReg);
        btnRegister = (Button) findViewById(R.id.RegBtn);

        btnRegister.setOnClickListener(this);
        signinTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.RegBtn:
                registerUser();
                break;
            case R.id.sign:
                Intent intent4= new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent4);
                break;
            default:
                break;
        }
    }

    private void registerUser() {
        String email= emailEt.getText().toString().trim();
        String password= passwordEt.getText().toString().trim();
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
        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            finish();
                            Toast.makeText(Main2Activity.this, "Succesfully Register", Toast.LENGTH_SHORT).show();

                        }
                        else {
                            Toast.makeText(Main2Activity.this, "Not Register Sucessfully Please Try again!!!", Toast.LENGTH_SHORT).show();
                        }
                        progressdialog.dismiss();
                    }
                });
    }
}
