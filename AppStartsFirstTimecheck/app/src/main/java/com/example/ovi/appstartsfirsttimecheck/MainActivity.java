package com.example.ovi.appstartsfirsttimecheck;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor sharedEditor ;

    TextView ShowMsgTextView;

    public static final String PassString = "Check_App_Status";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        sharedEditor = sharedPreferences.edit();

        ShowMsgTextView = findViewById(R.id.MsgTextView);

        if(CheckAppIsOpenFirstTimeOrNot()){

            ShowMsgTextView.setText("App is Launching First Time");

        }
        else {

            ShowMsgTextView.setText("App is Open Second Time or Already Opened Previously");
        }
    }
    public boolean CheckAppIsOpenFirstTimeOrNot(){

        if(sharedPreferences.getBoolean(PassString,true)){

            sharedEditor.putBoolean(PassString,false);
            sharedEditor.commit();
            sharedEditor.apply();

            // If App open for first time then return true.
            return true;
        }else {

            // If App open second time or already opened previously then return false.
            return false;
        }
    }
}
