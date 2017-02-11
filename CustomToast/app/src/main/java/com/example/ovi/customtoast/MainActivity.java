package com.example.ovi.customtoast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button customToastBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customToastBtn= (Button) findViewById(R.id.CustomToastButton);
        customToastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast=new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER,0,0);

                LayoutInflater inflater=getLayoutInflater();
                View ap=inflater.inflate(R.layout.layout_toast, (ViewGroup) findViewById(R.id.root));
                toast.setView(ap);
                toast.show();
            }
        });
    }
}
