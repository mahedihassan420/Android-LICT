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
    TextView signUpTv;
    Button btnSignin;
    FirebaseAuth firebaseAuth;
    EditText emailEt,passwordEt;
    ProgressDialog progressdialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initAll();
        progressdialog = new ProgressDialog(this);

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() !=null){
            finish();
            Intent intent3= new Intent(getApplicationContext(),FoodList.class);
            startActivity(intent3);
        }
    }

    public void initAll(){
        signUpTv = (TextView) findViewById(R.id.register);
        emailEt = (EditText) findViewById(R.id.email);
        passwordEt = (EditText) findViewById(R.id.pass);
        btnSignin = (Button) findViewById(R.id.login);
    }

    @Override
    public void onClick(View v) {
        if(v==btnSignin)
        {
            userLogIn();
        }
        if(v==signUpTv)
        {
            finish();
            Intent intent= new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);
        }
    }

    private void userLogIn() {
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
        progressdialog.setMessage("Please wait some Moment");
        progressdialog.show();
        firebaseAuth.signInWithEmailAndPassword( email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressdialog.dismiss();
                        if(task.isSuccessful()){
                            finish();
                            Intent intent2= new Intent(getApplicationContext(),FoodList.class);
                            startActivity(intent2);
                        }
                    }
                });

    }
}
