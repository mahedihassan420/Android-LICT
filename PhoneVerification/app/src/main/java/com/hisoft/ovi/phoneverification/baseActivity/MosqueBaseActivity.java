package com.hisoft.ovi.phoneverification.baseActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.ProgressBar;

import com.hisoft.ovi.phoneverification.preference.ApplicationPreferences;
import com.hisoft.ovi.phoneverification.service.CustomAlertDialog;
import com.hisoft.ovi.phoneverification.service.MosqueService;

/**
 * Created by Invariant on 10/7/17.
 */

public class MosqueBaseActivity extends AppCompatActivity {
    protected Context context;
    protected MosqueService service;
    protected CustomAlertDialog customAlertDialog;
    protected Intent intent;
    protected Bundle bundle;
    protected ApplicationPreferences preferences;
    //protected AppGoogleApiClient appGoogleApiClient;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context=this;
        service= new MosqueService(context);
        customAlertDialog= new CustomAlertDialog(this);
        preferences= new ApplicationPreferences(this);
    }

    protected void setSupportActionBar(int id){
        Toolbar toolbar = (Toolbar) findViewById(id);
        setSupportActionBar(toolbar);
    }

    protected Button getButton(int id){
        return (Button)findViewById(id);
    }

    protected ProgressBar getProgressBar(int id){
        return (ProgressBar)findViewById(id);
    }

   /* protected CircleImageView getCircleImageView(int id){
        return (CircleImageView)findViewById(id);
    }*/
}
