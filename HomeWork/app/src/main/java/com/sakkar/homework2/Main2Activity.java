package com.sakkar.homework2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{

    TextView textView1,textView2,textView3;
    Button button;
    static int startCount=0,createCount=0,resumeCount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initiateAll();

        Main2Activity.createCount+=1;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Main2Activity.startCount+=1;
    }

    @Override
    protected void onResume() {
        super.onStart();
        Main2Activity.resumeCount+=1;
        showAll();
    }

    private void showAll() {
        textView1.setText(getString(R.string.oncreate_initiated)+" "+Main2Activity.createCount+"Times");
        textView2.setText(getString(R.string.onstart_initiated)+" "+Main2Activity.startCount+"Times");
        textView3.setText(getString(R.string.onresume_initiated)+" "+Main2Activity.resumeCount+"Times");
    }

    private void initiateAll() {
        textView1= (TextView) findViewById(R.id.onCreateAt2);
        textView2= (TextView) findViewById(R.id.onStartAt2);
        textView3= (TextView) findViewById(R.id.onResumeAt2);
        button= (Button) findViewById(R.id.goto1);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
