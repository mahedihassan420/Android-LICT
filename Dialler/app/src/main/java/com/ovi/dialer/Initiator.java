package com.ovi.dialer;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

class Initiator extends Thread implements View.OnClickListener {
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnSt, btnHs, btnCall;
    private ImageButton back,contactButton;
    private TextView textView;
    final static int REQUEST_CODE=1011;
    private AppCompatActivity appCompatActivity;

    Initiator(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
        start();
    }

    @Override
    public void run() {
        super.run();
        initateAll();
        setListeners();
    }

    private void setListeners() {
        back.setOnClickListener(this);
        //contactButton.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnSt.setOnClickListener(this);
        btnHs.setOnClickListener(this);
        btnCall.setOnClickListener(this);
    }

    private void initateAll() {
        back = (ImageButton) appCompatActivity.findViewById(R.id.backButton);
        //contactButton = (ImageButton) appCompatActivity.findViewById(R.id.contactButton);
        btn1 = (Button) appCompatActivity.findViewById(R.id.button1);
        btn2 = (Button) appCompatActivity.findViewById(R.id.button2);
        btn3 = (Button) appCompatActivity.findViewById(R.id.button3);
        btn4 = (Button) appCompatActivity.findViewById(R.id.button4);
        btn5 = (Button) appCompatActivity.findViewById(R.id.button5);
        btn6 = (Button) appCompatActivity.findViewById(R.id.button6);
        btn7 = (Button) appCompatActivity.findViewById(R.id.button7);
        btn8 = (Button) appCompatActivity.findViewById(R.id.button8);
        btn9 = (Button) appCompatActivity.findViewById(R.id.button9);
        btn0 = (Button) appCompatActivity.findViewById(R.id.button0);
        btnSt = (Button) appCompatActivity.findViewById(R.id.buttonst);
        btnHs = (Button) appCompatActivity.findViewById(R.id.buttonhs);
        btnCall = (Button) appCompatActivity.findViewById(R.id.call);
        textView = (TextView) appCompatActivity.findViewById(R.id.view);
    }

    @Override
    public void onClick(View v) {
        String s, s1;
        switch (v.getId()) {
            case R.id.backButton:
                s = textView.getText().toString();
                if (s.length() > 0)
                    s1 = s.substring(0, s.length() - 1);
                else
                    s1 = "";
                if (s1.length() > 10)
                    textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, (float) 30.00);
                else
                    textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, (float) 35.00);
                textView.setText(s1);
                break;
            case R.id.call:
                if (textView.getText().toString().length()>2) {
                    String url = "tel:" + textView.getText().toString();
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse(url));

                    if (ActivityCompat.checkSelfPermission(appCompatActivity,
                            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    appCompatActivity.startActivity(callIntent);
                    textView.setText("");
                }
                break;
            default:
                s = textView.getText().toString() + ((Button) v).getText();
                if (s.length() > 10)
                    textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, (float) 30.00);
                else
                    textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, (float) 35.00);
                textView.setText(s);
                break;
        }
    }

    void setTextView(String text) {
        if (text.length() > 10)
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, (float) 30.00);
        else
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, (float) 35.00);
        textView.setText(text);
    }
}
