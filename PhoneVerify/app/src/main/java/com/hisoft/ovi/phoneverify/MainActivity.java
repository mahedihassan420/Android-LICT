package com.hisoft.ovi.phoneverify;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
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

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    EditText name, phnNum;
    Button add, view;
    DatabaseSqlite myDb;
    private FirebaseAuth firebaseAuth;
    //private FirebaseUser firebaseUser;
    private String mVerificationId;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        phnNum = findViewById(R.id.phone);
        add = findViewById(R.id.submit);
        view = findViewById(R.id.show);

        myDb = new DatabaseSqlite(this);
        AddData();
        ViewData();

        firebaseAuth=FirebaseAuth.getInstance();
        onVerificationStateChangedCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                add.setVisibility(View.GONE);
                signInWithPhoneAuthCredential(phoneAuthCredential);
            }

            @Override
            public void onVerificationFailed(FirebaseException ex) {
                Toast.makeText(MainActivity.this,ex.getMessage(),Toast.LENGTH_LONG).show();
                add.setVisibility(View.VISIBLE);
                if (ex instanceof FirebaseAuthInvalidCredentialsException) {
                } else if (ex instanceof FirebaseTooManyRequestsException) {
                    Toast.makeText(MainActivity.this,"Quota exceeded.",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCodeSent(String verificationId, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                mVerificationId = verificationId;
                /*Intent intent2 = new Intent(MainActivity.this,ActivationCodeActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("mVerificationId",mVerificationId);
                bundle.putString("mobile",phoneNumberEditText.getText().toString());
                bundle.putString("countryCode",countryCodePicker.getSelectedCountryCode());
                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent2.putExtras(bundle);
                startActivity(intent2);*/

            }
        };

    }
    private boolean validatePhoneNumber() {
        String phoneNumber = phnNum.getText().toString();
        if (TextUtils.isEmpty(phoneNumber)) {
            phnNum.setError("Phone number not exist");
            return false;
        }

        return true;
    }
    private void startPhoneNumberVerification(String phoneNumber) {
        add.setVisibility(View.GONE);
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



    public void ViewData() {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.getAllData();
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Name:" + res.getString(0) + "\n");
                    buffer.append("Phone Number:" + res.getString(1) + "\n\n");

                    ShowMessage("Member Data", buffer.toString());
                }
            }
        });
    }

    public void ShowMessage(String data, String s) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(data);
        builder.setMessage(s);
        builder.show();
    }

    public void AddData() {
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    if (!validatePhoneNumber()) {
                        return;
                    }
                    startPhoneNumberVerification(phnNum.getText().toString());
                }
                boolean isInsert = (myDb.insertData(name.getText().toString(), phnNum.getText().toString()));
                if (isInsert = true) {
                    Toast.makeText(MainActivity.this, "Data insert", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Data not Insert", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}


