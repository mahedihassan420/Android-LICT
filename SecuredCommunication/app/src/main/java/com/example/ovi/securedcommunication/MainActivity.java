package com.example.ovi.securedcommunication;

import android.content.DialogInterface;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText plainText, key;
    TextView encryptText;
    Button submit, clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initAll();
        representAll();

    }


    public void initAll() {
        plainText = (EditText) findViewById(R.id.plain_text);
        key = (EditText) findViewById(R.id.keyValue);
        encryptText = (TextView) findViewById(R.id.encrypt_text);
        submit = (Button) findViewById(R.id.submitBtn);
        clear = (Button) findViewById(R.id.clearBtn);
    }

    public void representAll() {
        submit.setOnClickListener(this);
        clear.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.submitBtn:
                try {
                    int k = Integer.parseInt(key.getText().toString());

                    String s = plainText.getText().toString();
                    String p = Encryption.encrypt(s, k);
                    encryptText.setText(p);
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            case R.id.clearBtn:
                encryptText.setText("");
                plainText.setText("");
                key.setText("");
                break;
        }
    }


}
