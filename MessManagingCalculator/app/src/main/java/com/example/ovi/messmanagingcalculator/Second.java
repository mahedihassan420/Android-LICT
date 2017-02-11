package com.example.ovi.messmanagingcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Second extends AppCompatActivity {
    EditText totalMeal,totalFuel,extraCharge,cooker_PaperBill,fullMealRate,dayMealRate,nightMealRate;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);



        initAll();

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(Second.this,Third.class);
                i2.putExtra("Rate",fullMealRate.getText().toString());
                i2.putExtra("dayRate",dayMealRate.getText().toString());
                i2.putExtra("nightRate",nightMealRate.getText().toString());
                i2.putExtra("ExtraCharge",extraCharge.getText().toString());
                i2.putExtra("CookerBill",cooker_PaperBill.getText().toString());
                i2.putExtra("TotalMeal",totalMeal.getText().toString());
                i2.putExtra("TotalFuel",totalFuel.getText().toString());
                startActivity(i2);
            }
        });
    }
    public void initAll(){
        totalMeal= (EditText) findViewById(R.id.totalMeal);
        totalFuel=(EditText) findViewById(R.id.totalFuel);
        extraCharge=(EditText) findViewById(R.id.extraCharge);
        cooker_PaperBill=(EditText) findViewById(R.id.cooker_PaperBill);
        fullMealRate=(EditText) findViewById(R.id.fullMealRate);
        dayMealRate=(EditText) findViewById(R.id.DayMealRate);
        nightMealRate=(EditText) findViewById(R.id.NightMealRate);
        submitBtn=(Button) findViewById(R.id.submitBtn);
    }
}
