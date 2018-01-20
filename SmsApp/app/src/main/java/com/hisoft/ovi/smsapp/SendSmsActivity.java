package com.hisoft.ovi.smsapp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class SendSmsActivity extends Activity {

    Button sendSMSBtn;
    ImageButton receiveSMSBtn;
    EditText toPhoneNumberET;
    EditText smsMessageET, pin;
    AdView mAdView;
    ImageButton contact;
    final static int REQUEST_CODE = 1011;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        sendSMSBtn = findViewById(R.id.btnSendSMS);
        receiveSMSBtn = findViewById(R.id.receivesms);
        toPhoneNumberET = findViewById(R.id.editTextPhoneNo);
        smsMessageET = findViewById(R.id.editTextSMS);
        contact = findViewById(R.id.contacts);
        pin = findViewById(R.id.pin);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toPhoneNumberET.setText("");
                Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
        receiveSMSBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SendSmsActivity.this, ReceiveSmsActivity.class));
            }
        });

        sendSMSBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendSMS();
                smsMessageET.setText("");
                pin.setText("");
                toPhoneNumberET.setText("");
            }
        });
    }

    protected void sendSMS() {
        String toPhoneNumber = toPhoneNumberET.getText().toString();
        try {

            SmsManager smsManager = SmsManager.getDefault();
            int key = Integer.parseInt(pin.getText().toString());
            String smsMessage = smsMessageET.getText().toString();
            String p = Encryption.encrypt(smsMessage, key);
            smsManager.sendTextMessage(toPhoneNumber, null, p, null, null);
            Toast.makeText(getApplicationContext(), "SMS sent.",
                    Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),
                    "Sending SMS failed.",
                    Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == REQUEST_CODE) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                Uri dataUri = data.getData();
                int idx;
                try {
                    Cursor cursor = getContentResolver().query(dataUri, new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER}, null, null, null);
                    if (cursor.moveToFirst()) {
                        idx = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                        String s = cursor.getString(idx);
                        toPhoneNumberET.setText(s);
                        cursor.close();
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Error:" + e, Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}