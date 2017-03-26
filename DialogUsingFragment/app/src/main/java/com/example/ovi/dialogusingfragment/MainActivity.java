package com.example.ovi.dialogusingfragment;

import android.app.Activity;
import android.app.FragmentManager;import android.os.Bundle;
import android.view.View;

public class MainActivity extends  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void showDialogue(View v){
        android.app.FragmentManager manager=getFragmentManager();
    }
}
