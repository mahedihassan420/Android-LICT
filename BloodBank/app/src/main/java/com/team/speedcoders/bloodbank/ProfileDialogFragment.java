package com.team.speedcoders.bloodbank;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ProfileDialogFragment extends DialogFragment {

    TextView profileName,number,emailAddress,bloodgroup;
    String[] strings;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle=getArguments();
        strings=bundle.getStringArray("info");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.profile_dialog,container,false);
        profileName= (TextView) view.findViewById(R.id.profileName);
        number= (TextView) view.findViewById(R.id.profilePhone);
        emailAddress= (TextView) view.findViewById(R.id.profileEmail);
        bloodgroup= (TextView) view.findViewById(R.id.profileBloodgroup);
        String name=profileName.getText().toString()+" "+strings[0];
        profileName.setText(name);
        String numberPhone=number.getText().toString()+" "+strings[1];
        number.setText(numberPhone);
        String email=emailAddress.getText().toString()+" "+strings[2];
        emailAddress.setText(email);
        String blood=bloodgroup.getText().toString()+" "+strings[3];
        bloodgroup.setText(blood);
        return view;
    }

}
