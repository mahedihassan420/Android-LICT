package com.hisoft.ovi.phoneverification.phoneVerify;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import com.hisoft.ovi.phoneverification.R;
import com.hisoft.ovi.phoneverification.baseActivity.MosqueBaseActivity;
import com.hisoft.ovi.phoneverification.model.MobileVerification;
import com.hisoft.ovi.phoneverification.service.DTOBase;
import com.hisoft.ovi.phoneverification.service.IServiceResultListener;
import com.hisoft.ovi.phoneverification.utility.AppManager;



public class ActivationCodeActivity extends MosqueBaseActivity implements IServiceResultListener{

    private EditText activationCodeEditText;
    private Button sendCodeImageButton;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    private String mVerificationId;
    private String mobile;
    private String countryCode;
    Bundle bundle;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activation_code);

        activationCodeEditText=findViewById(R.id.activationCodeEditText);
        sendCodeImageButton=findViewById(R.id.sendCodeImageButton);

        firebaseAuth = FirebaseAuth.getInstance();

        bundle = getIntent().getExtras();
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
                if (task.isSuccessful()) {
                    firebaseUser = task.getResult().getUser();
                    preferences.setValue("Mobile",mobile);
                    preferences.setValue("CountryCode",countryCode);
                    if(AppManager.hasInternetConnection(ActivationCodeActivity.this)){
                        service.setUserLogin(mobile);
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

    public void OnServiceResult(String method, DTOBase dtoBase, boolean success) {
        if(success){
            if(method.equals("USER_LOGIN")){
                MobileVerification mobileVerification = (MobileVerification) dtoBase;
                preferences.setValue("selector",mobileVerification.getSelector());
                preferences.setValue("validator",mobileVerification.getValidator());
                if(!mobileVerification.getExist()){
                    preferences.setValue("Mobile",mobile);
                    preferences.setValue("CountryCode",countryCode);
                    intent = new Intent(ActivationCodeActivity.this,HomePage.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }else if(mobileVerification.getExist()){
                    intent = new Intent(ActivationCodeActivity.this,UserDetailsActivity.class);
                    bundle = new Bundle();
                    bundle.putString("mobile",mobile);
                    bundle.putString("countryCode",countryCode);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();
                }
            }
        }
    }
}
