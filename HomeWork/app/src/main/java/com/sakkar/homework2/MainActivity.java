package com.sakkar.homework2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView textView1,textView2,textView3;
    Button button;
    static int startCount=0,createCount=0,resumeCount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiateAll();

        MainActivity.createCount+=1;
    }

    @Override
    protected void onStart() {
        super.onStart();
        MainActivity.startCount+=1;
    }

    @Override
    protected void onResume() {
        super.onStart();
        MainActivity.resumeCount+=1;
        showAll();
    }

    private void showAll() {
        textView1.setText(getString(R.string.oncreate_initiated)+" "+MainActivity.createCount+"Times");
        textView2.setText(getString(R.string.onstart_initiated)+" "+MainActivity.startCount+"Times");
        textView3.setText(getString(R.string.onresume_initiated)+" "+MainActivity.resumeCount+"Times");
    }

    private void initiateAll() {
        textView1= (TextView) findViewById(R.id.onCreate);
        textView2= (TextView) findViewById(R.id.onStart);
        textView3= (TextView) findViewById(R.id.onResume);
        button= (Button) findViewById(R.id.goto2);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this,Main2Activity.class);
        startActivity(intent);
    }
}
