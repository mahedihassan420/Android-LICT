package com.example.ovi.fragmentslideview;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends FragmentActivity {

    ViewPager viewPager=null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager= (ViewPager) findViewById(R.id.activity_main);
        FragmentManager manager=getSupportFragmentManager();
        viewPager.setAdapter(new MyAdapter(manager));
    }
}
