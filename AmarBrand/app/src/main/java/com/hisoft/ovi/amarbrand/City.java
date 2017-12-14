package com.hisoft.ovi.amarbrand;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class City extends AppCompatActivity implements View.OnClickListener {

    TextView dhaka, khulna, rajshahi, chittagong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        dhaka = findViewById(R.id.dha);
        khulna = findViewById(R.id.khu);
        rajshahi = findViewById(R.id.raj);
        chittagong = findViewById(R.id.chi);
        dhaka.setOnClickListener(this);
        khulna.setOnClickListener(this);
        rajshahi.setOnClickListener(this);
        chittagong.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dha:
                Intent dha = new Intent(City.this, MainActivity.class);
                dha.putExtra("dhaka", dhaka.getText().toString());
                startActivity(dha);
                break;
            case R.id.khu:
                Intent khu = new Intent(City.this, MainActivity.class);
                khu.putExtra("khulna", khulna.getText().toString());
                startActivity(khu);
                break;
            case R.id.raj:
                Intent raj = new Intent(City.this, MainActivity.class);
                raj.putExtra("rajshahi", rajshahi.getText().toString());
                startActivity(raj);
                break;
            case R.id.chi:
                Intent chit = new Intent(City.this, MainActivity.class);
                chit.putExtra("chittagong", chittagong.getText().toString());
                startActivity(chit);
                break;
            default:
                break;
        }
    }
}
