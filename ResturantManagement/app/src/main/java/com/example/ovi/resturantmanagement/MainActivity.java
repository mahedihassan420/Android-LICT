package com.example.ovi.resturantmanagement;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView regPage;
    EditText emailEt,passEt;
    Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initAll();
        loginBtn.setOnClickListener(this);
        regPage.setOnClickListener(this);
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
    }
}