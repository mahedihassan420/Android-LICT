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
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.hbb20.CountryCodePicker;
import com.hisoft.ovi.phoneverification.R;
import com.hisoft.ovi.phoneverification.baseActivity.MosqueBaseActivity;
import com.hisoft.ovi.phoneverification.utility.AppManager;

import java.util.concurrent.TimeUnit;

public class MainActivity extends MosqueBaseActivity {

    private EditText phoneNumberEditText;
    private Button sendCodeImageButton;
    private FirebaseAuth firebaseAuth;
    //private FirebaseUser firebaseUser;
    private String mVerificationId;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks;
    private CountryCodePicker countryCodePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneNumberEditText= findViewById(R.id.phoneNumberEditText);
        sendCodeImageButton=findViewById(R.id.sendCodeImageButton);
        countryCodePicker=findViewById(R.id.countryCodePicker);
        if(!preferences.getValue("Mobile").equals("")){
            if(AppManager.hasInternetConnection(context)){
                service.setUserLogin(preferences.getValue("Mobile"));
            }else{
                Toast.makeText(context,"No Internet Connection",Toast.LENGTH_LONG).show();
            }
        }else {
            Toast.makeText(context, "Ok", Toast.LENGTH_SHORT).show();
        }

        firebaseAuth=FirebaseAuth.getInstance();
        onVerificationStateChangedCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                sendCodeImageButton.setVisibility(View.GONE);
                signInWithPhoneAuthCredential(phoneAuthCredential);
            }

            @Override
            public void onVerificationFailed(FirebaseException ex) {
                Toast.makeText(MainActivity.this,ex.getMessage(),Toast.LENGTH_LONG).show();
                sendCodeImageButton.setVisibility(View.VISIBLE);
                if (ex instanceof FirebaseAuthInvalidCredentialsException) {
                    phoneNumberEditText.setError("Invalid phone number.");
                } else if (ex instanceof FirebaseTooManyRequestsException) {
                    Toast.makeText(MainActivity.this,"Quota exceeded.",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCodeSent(String verificationId, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                mVerificationId = verificationId;
                Intent intent2 = new Intent(MainActivity.this,ActivationCodeActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("mVerificationId",mVerificationId);
                bundle.putString("mobile",phoneNumberEditText.getText().toString());
                bundle.putString("countryCode",countryCodePicker.getSelectedCountryCode());
                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent2.putExtras(bundle);
                startActivity(intent2);

            }
        };
        sendCodeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validatePhoneNumber()) {
                    return;
                }
                startPhoneNumberVerification(countryCodePicker.getSelectedCountryCode()+phoneNumberEditText.getText().toString());
            }
        });

    }
    private boolean validatePhoneNumber() {
        String phoneNumber = phoneNumberEditText.getText().toString();
        if (TextUtils.isEmpty(phoneNumber)) {
            phoneNumberEditText.setError("Invalid phone number.");
            return false;
        }

        return true;
    }
    private void startPhoneNumberVerification(String phoneNumber) {
        sendCodeImageButton.setVisibility(View.GONE);
        PhoneAuthProvider.getInstance().verifyPhoneNumber(phoneNumber, 60, TimeUnit.SECONDS,this,onVerificationStateChangedCallbacks);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential){
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    //firebaseUser = task.getResult().getUser();
                    Intent intent = new Intent(MainActivity.this,MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }


}
