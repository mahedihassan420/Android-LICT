package com.team.speedcoders.bloodbank;


import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;


public class BlankFragment extends DialogFragment implements View.OnClickListener{

    Button buttonOk,buttonCancel;
    DatePicker datePicker;
    HomePageActivity appCompatActivity;
    public BlankFragment() {
        setCancelable(false);
    }

    public void setColler(HomePageActivity appCompatActivity){
        this.appCompatActivity=appCompatActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_blank, container, false);
        buttonOk= (Button) view.findViewById(R.id.button);
        buttonCancel= (Button) view.findViewById(R.id.button1);
        datePicker= (DatePicker) view.findViewById(R.id.datePicker);
        buttonOk.setOnClickListener(this);
        buttonCancel.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                dismiss();
                break;
            case R.id.button1:
                String s=datePicker.getDayOfMonth()+"/"+datePicker.getMonth()+"/"+datePicker.getYear();
                Connector c=((Connector)appCompatActivity);
                c.infoHandler(s);
                break;
        }
    }

    interface Connector{
        public void infoHandler(String s);
    }
}
