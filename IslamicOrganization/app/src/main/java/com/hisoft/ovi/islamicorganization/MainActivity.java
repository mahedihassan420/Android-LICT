package com.hisoft.ovi.islamicorganization;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity implements IServiceResultListener {

    private MosqueService service;
    Context context;
    private RecyclerView organizationsRecyclerView;
    private IslamicOrganizationsAdapter organizationsAdapter;
    private GoogleApiClient googleApiClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        service=new MosqueService(context,(IServiceResultListener)this);
        organizationsRecyclerView = (RecyclerView)findViewById(R.id.organizationsRecyclerView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        organizationsRecyclerView.setLayoutManager(mLayoutManager);
        organizationsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        googleApiClient=new AppGoogleApiClient().getGoogleApiClient(context, new CurrentLocation() {
            @Override
            public void handleNewLocation(Location location) {
                Log.i("Location",location.getLatitude()+"--"+location.getLongitude());
                service.LoadIslamicOrganizations(String.valueOf(location.getLatitude()),String.valueOf(location.getLongitude()));
            }
        });
        googleApiClient.connect();
    }

    @Override
    public void OnServiceResult(String method, DTOBase dtoBase, boolean success) {
        if(success){
            if(method.equals("MOSQUE")){
                GooglePlace googlePlace = (GooglePlace) dtoBase;
                if(googlePlace.getStatus().equals("OK")){
                    organizationsAdapter = new IslamicOrganizationsAdapter(getApplicationContext(),googlePlace.getResults());
                    organizationsRecyclerView.setAdapter(organizationsAdapter);
                }
            }
        }
    }
}
