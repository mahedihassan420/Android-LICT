package com.hisoft.ovi.appdesign;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView city2;
    String dhaka,khulna,rajshahi,chittagong;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction transaction=fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    transaction.replace(R.id.fram,new BlankFragment()).commit();
                    return true;
                case R.id.navigation_dashboard:
                    return true;
                case R.id.navigation_notifications:
                    return true;
            }
            return false;
        }
    };

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation =  findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.add(R.id.fram,new BlankFragment()).commit();

        city2=findViewById(R.id.poi);

        Intent iin= getIntent();

        if(iin!=null)
        {

            dhaka=iin.getStringExtra("dhaka");
            khulna=iin.getStringExtra("khulna");
            rajshahi=iin.getStringExtra("rajshahi");
            chittagong=iin.getStringExtra("chittagong");
            if(dhaka!=null){city2.setText(dhaka);}
            else if(khulna!=null){city2.setText(khulna);}
            else if(rajshahi!=null){city2.setText(rajshahi);}
            else if(chittagong!=null){city2.setText(chittagong);}
        }
        city2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,City.class));
            }
        });

    }

}
