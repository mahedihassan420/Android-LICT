package com.team.speedcoders.bloodbank;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomePageActivity extends MyActivityForConnection implements View.OnClickListener,BlankFragment.Connector {
    Button searchBlood, insperation, lastDonationDate, profile;
    BlankFragment blankFragment;
    String link="https://mined-human.000webhostapp.com/profile.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        initateAll();
    }

    private void initateAll() {
        searchBlood = (Button) findViewById(R.id.blood_search);
        searchBlood.setOnClickListener(this);
        insperation = (Button) findViewById(R.id.inspiraion);
        insperation.setOnClickListener(this);
        lastDonationDate = (Button) findViewById(R.id.last_donation);
        lastDonationDate.setOnClickListener(this);
        profile = (Button) findViewById(R.id.my_profile);
        profile.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.blood_search:
                Intent intent= new Intent(this,BloodSearch.class);
                startActivity(intent);
                break;
            case R.id.inspiraion:
                break;
            case R.id.last_donation:
                blankFragment=new BlankFragment();
                blankFragment.setColler(this);
                blankFragment.show(getFragmentManager(),"datepicker");
                break;
            case R.id.my_profile:
                String s=getIntent().getStringExtra("profileOf");
                String data=codedData("number",s);
                ServerConnectionActivity serverConnectionActivity=new ServerConnectionActivity(getApplicationContext(),this,link);
                serverConnectionActivity.execute(data);
                break;
        }
    }

    @Override
    public void infoHandler(String s) {
        blankFragment.dismiss();
        Toast.makeText(this,"Data "+s,Toast.LENGTH_LONG).show();
    }
}
