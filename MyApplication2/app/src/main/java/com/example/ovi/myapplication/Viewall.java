package com.example.ovi.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;



public class Viewall extends Activity {

     Button show;
    DatabaseSqlite database;
    RecyclerView recyclerView;
    RecycleAdapter recycler;
    List<DataModel> datamodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view);
        show =  findViewById(R.id.view);
        datamodel =new ArrayList<>();
        recyclerView =  findViewById(R.id.recycle);


        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = new DatabaseSqlite(Viewall.this);
                datamodel=  database.getdata();
                recycler =new RecycleAdapter(datamodel);


                Log.i("ovi",""+datamodel);
                RecyclerView.LayoutManager reLayoutManager =new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(reLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(recycler);


            }
        });

    }
}
