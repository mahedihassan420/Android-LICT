package com.example.ovi.mybroadcastreceiver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button button1,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button= (Button) findViewById(R.id.btn);
        button1= (Button) findViewById(R.id.start);
        button2= (Button) findViewById(R.id.stop);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent();
                i.setAction("com.ovi");
                sendBroadcast(i);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.start:
                Intent i1=new Intent(this,MyService.class);
                startService(i1);

                break;
            case R.id.stop:
                Intent i2=new Intent(this,MyService.class);
                stopService(i2);
                break;
            default:
                break;
        }
    }
}
