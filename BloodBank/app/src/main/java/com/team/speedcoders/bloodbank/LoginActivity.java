package com.team.speedcoders.bloodbank;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends MyActivityForConnection {

    private TextView signup;
    private EditText phone, password;
    private String phoneString, passwordString;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initiateAll();
        signup.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    private void initiateAll() {
        login = (Button) findViewById(R.id.login);
        signup = (TextView) findViewById(R.id.signup);
        phone = (EditText) findViewById(R.id.login_phone);
        password = (EditText) findViewById(R.id.login_password);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.signup:
                intent= new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.login:
                getString();
                String link=getString(R.string.loginLink);
                String data=codedData("phone",phoneString)+"&"+codedData("password",passwordString);
                (new ServerConnectionActivity(getApplicationContext(),this,link)).execute(data);
                break;
        }

    }

    private void getString() {
        phoneString=phone.getText().toString();
        passwordString=password.getText().toString();
    }

    @Override
    public void doTheTask(String... s) {
        Intent intent=new Intent(this,HomePageActivity.class);
        intent.putExtra("profileOf",phoneString);
        startActivity(intent);
        finish();
    }


}
