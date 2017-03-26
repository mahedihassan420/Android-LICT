package com.example.ovi.recycler_grid_staggeredviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button grid,recylcer, stagger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grid= (Button) findViewById(R.id.grid);
        recylcer= (Button) findViewById(R.id.recycler);
        stagger= (Button) findViewById(R.id.stagger);
        grid.setOnClickListener(this);
        recylcer.setOnClickListener(this);
        stagger.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.grid:
                Intent i=new Intent(MainActivity.this,MyGridView.class);
                startActivity(i);
                break;
            case R.id.recycler:
                Intent i2=new Intent(MainActivity.this,MyRecyclerView.class);
                startActivity(i2);
                break;
            default:
                break;
        }
    }
}
