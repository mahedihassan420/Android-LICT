package com.team.speedcoders.bloodbank;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class BloodSearch extends MyActivityForConnection{
    AutoCompleteTextView bloodgroup, district, division, upazila;
    Button search;
    String link="https://mined-human.000webhostapp.com/show.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_search);

        initiateAll();
    }

    private void initiateAll() {
        search= (Button) findViewById(R.id.search);
        search.setOnClickListener(this);
        bloodgroup = (AutoCompleteTextView) findViewById(R.id.bloodGrouping);
        upazila = (AutoCompleteTextView) findViewById(R.id.inUpazila);
        district = (AutoCompleteTextView) findViewById(R.id.inDestrict);
        division = (AutoCompleteTextView) findViewById(R.id.inDevision);
        district.setEnabled(false);
        upazila.setEnabled(false);
        bloodgroup.setAdapter(ArrayAdapter.createFromResource(getApplicationContext(), R.array.bgroups,
                R.layout.auto_complete_view));
        division.setAdapter(ArrayAdapter.createFromResource(getApplicationContext(), R.array.divisions,
                R.layout.auto_complete_view));
        district.setAdapter(ArrayAdapter.createFromResource(getApplicationContext(), R.array.districts_of_rajshahi,
                R.layout.auto_complete_view));
        upazila.setAdapter(ArrayAdapter.createFromResource(getApplicationContext(), R.array.upazila_of_rajshahi,
                R.layout.auto_complete_view));
        division.setOnItemClickListener(new AutoCompleteTextViewListener(division, district, getApplicationContext()));
        district.setOnItemClickListener(new AutoCompleteTextViewListener(district, upazila, getApplicationContext()));
        upazila.setOnItemClickListener(new AutoCompleteTextViewListener(upazila, null, getApplicationContext()));
    }

    @Override
    public void onClick(View v) {
        ServerConnectionActivity sca=new ServerConnectionActivity(getApplicationContext(),this,link);
        String upozilaString=upazila.getText().toString(),destrictString=district.getText().toString();
        upozilaString=upozilaString.replace("Cox's","Coxs");
        destrictString=destrictString.replace("Cox's","Coxs");
        String data=codedData("bloodgroup",bloodgroup.getText().toString())+"&"+codedData("division",division.getText().toString())+
                "&"+ codedData("district",destrictString)+"&"+codedData("upazila",upozilaString);
        sca.execute(data);
    }

    @Override
    public void doTheTask(String... s) {
        Intent intent=new Intent(this,SearchResult.class);
        intent.putExtra("data",s);
        startActivity(intent);
    }
}
