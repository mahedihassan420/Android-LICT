package com.team.speedcoders.bloodbank;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class SearchResult extends AppCompatActivity {

    Intent intent;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        intent=getIntent();
        listView= (ListView) findViewById(R.id.donnerList);
        new MyListAddepter();
    }

    class MyListAddepter extends Thread{
        MyListAddepter() {
            start();
        }

        @Override
        public void run() {
            String [] s=intent.getStringArrayExtra("data");
            listView.setAdapter(new MyListAddapter(getApplicationContext(),s));
        }
    }
}
