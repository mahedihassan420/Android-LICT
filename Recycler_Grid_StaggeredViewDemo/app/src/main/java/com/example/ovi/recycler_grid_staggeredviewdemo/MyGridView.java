package com.example.ovi.recycler_grid_staggeredviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

public class MyGridView extends AppCompatActivity {
    GridView myGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        myGrid=(GridView) findViewById(R.id.gridView);
    }
}
