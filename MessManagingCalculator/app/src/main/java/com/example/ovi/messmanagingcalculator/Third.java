package com.example.ovi.messmanagingcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Third extends AppCompatActivity implements View.OnClickListener {
    EditText depositBalance, fullMealNumber, dayMealNumber, nightMealNumber, feastMealCost, snacksBill;
    TextView resultView;
    Button clearBtn, calculateBtn;
    Intent i;
    double fullMeal_Rate;
    double dayMeal_Rate;
    double nightMeal_Rate;
    double extra_charge;
    double paper_cookerBill;
    Double fuelCharge,total_MealNum,total_fuelChrg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        initAll();
        i=getIntent();
        fullMeal_Rate=Double.parseDouble(i.getStringExtra("Rate"));
        dayMeal_Rate=Double.parseDouble(i.getStringExtra("dayRate"));
        nightMeal_Rate=Double.parseDouble(i.getStringExtra("nightRate"));
        extra_charge=Double.parseDouble(i.getStringExtra("ExtraCharge"));
        paper_cookerBill=Double.parseDouble(i.getStringExtra("CookerBill"));
        total_MealNum=Double.parseDouble(i.getStringExtra("TotalMeal"));
        total_fuelChrg=Double.parseDouble(i.getStringExtra("TotalFuel"));
        clearBtn.setOnClickListener(this);
        calculateBtn.setOnClickListener(this);
    }

    public void initAll() {
        depositBalance = (EditText) findViewById(R.id.depositBalance);
        fullMealNumber = (EditText) findViewById(R.id.fullMealNumber);
        dayMealNumber = (EditText) findViewById(R.id.dayMealNumber);
        nightMealNumber = (EditText) findViewById(R.id.nightMealNumber);
        feastMealCost = (EditText) findViewById(R.id.feastMealCost);
        snacksBill = (EditText) findViewById(R.id.snacksBill);
        resultView = (TextView) findViewById(R.id.resultView);
        calculateBtn = (Button) findViewById(R.id.calculateBtn);
        clearBtn = (Button) findViewById(R.id.clearBtn);

    }

    public void onClick(View view) {
        Double deposit_Balance, fullMeal_Number, dayMeal_Number, nightMeal_Number, feastMeal_Cost, snacks_Bill;
        Double total_cost;
        fuelCharge=total_fuelChrg/total_MealNum;
        double res;

        deposit_Balance = Double.parseDouble(depositBalance.getText().toString());
        fullMeal_Number = Double.parseDouble(fullMealNumber.getText().toString());
        dayMeal_Number = Double.parseDouble(dayMealNumber.getText().toString());
        nightMeal_Number = Double.parseDouble(nightMealNumber.getText().toString());
        feastMeal_Cost = Double.parseDouble(feastMealCost.getText().toString());
        snacks_Bill = Double.parseDouble(snacksBill.getText().toString());


        switch (view.getId()) {

            case R.id.calculateBtn:
                total_cost = (fullMeal_Number * (fullMeal_Rate+fuelCharge)) +( dayMeal_Number * (dayMeal_Rate+fuelCharge) )+( nightMeal_Number * (nightMeal_Rate+fuelCharge)) + feastMeal_Cost + snacks_Bill + extra_charge + paper_cookerBill;
                if (total_cost<deposit_Balance||total_cost.equals(deposit_Balance)){
                    res=total_cost-deposit_Balance;
                    resultView.setText("Total Cost: "+total_cost+"\n Deposit Balance: "+deposit_Balance+"\nManager will pay:"+res);
                }
                else {
                    res=deposit_Balance-total_cost;
                    resultView.setText("Total Cost: "+total_cost+"\n Deposit Balance: "+deposit_Balance+"\nManager will receive:"+res);
                }
                break;
            case R.id.clearBtn:
                depositBalance.setText("");
                fullMealNumber.setText("");
                dayMealNumber.setText("");
                nightMealNumber.setText("");
                feastMealCost.setText("");
                snacksBill.setText("");
                break;
            default:
                break;
        }
    }
}
