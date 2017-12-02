package com.hisoft.ovi.phoneverification;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class ActivationCodeActivity extends AppCompatActivity {

    private EditText activationCodeEditText;
    private Button sendCodeImageButton;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    private String mVerificationId;
    private String mobile;
    private String countryCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activation_code);

        activationCodeEditText=findViewById(R.id.activationCodeEditText);
        sendCodeImageButton=findViewById(R.id.sendCodeImageButton);

        firebaseAuth = FirebaseAuth.getInstance();

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            mVerificationId = bundle.getString("mVerificationId");
            mobile=bundle.getString("mobile");
            countryCode=bundle.getString("countryCode");
        }
        sendCodeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String code = activationCodeEditText.getText().toString();
                if (TextUtils.isEmpty(code)) {
                    activationCodeEditText.setError("Cannot be empty.");
                    return;
                }

                verifyPhoneNumberWithCode(mVerificationId, code);
            }
        });
    }
    private void verifyPhoneNumberWithCode(String verificationId, String code) {
        sendCodeImageButton.setVisibility(View.GONE);
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
        signInWithPhoneAuthCredential(credential);
    }


    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential){
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {/*
                    firebaseUser = task.getResult().getUser();
                    preferences.setValue("Mobile",mobile);
                    preferences.setValue("CountryCode",countryCode);*/
                    startActivity(new Intent(ActivationCodeActivity.this,Welcome.class));
                    if(AppManager.hasInternetConnection(ActivationCodeActivity.this)){
                        //service.setUserLogin(mobile);
                        Toast.makeText(ActivationCodeActivity.this,"Internet Connection Success",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(ActivationCodeActivity.this,"No Internet Connection",Toast.LENGTH_LONG).show();
                    }

                }else{
                    sendCodeImageButton.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
