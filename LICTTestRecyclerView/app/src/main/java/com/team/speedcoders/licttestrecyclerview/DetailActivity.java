package com.team.speedcoders.licttestrecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent=getIntent();
        ((ImageView)findViewById(R.id.imageOfPerson)).setImageResource(intent.getIntExtra("image",R.drawable.image1));
        ((TextView)findViewById(R.id.detail_name)).setText(intent.getStringExtra("name"));
        ((TextView)findViewById(R.id.detail_depertment)).setText(intent.getStringExtra("dept"));
    }
}
