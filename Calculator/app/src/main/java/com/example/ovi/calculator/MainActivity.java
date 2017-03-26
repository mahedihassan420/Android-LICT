package com.example.ovi.calculator;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText inputValue, divideValue;
    Button divide,mPlus,mMinus,mr;
    TextView textView;
    private static String PREFS_NAME = "memory";
    private String currentDisplayedInput = "";
    private String inputToBeParsed = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputValue = (EditText) findViewById(R.id.input);
        divideValue = (EditText) findViewById(R.id.valueDivided);
        divide = (Button) findViewById(R.id.divide);
        mr = (Button) findViewById(R.id.mr);
        mPlus = (Button) findViewById(R.id.mPlus);
        mMinus = (Button) findViewById(R.id.mMinus);
        textView=(TextView) findViewById(R.id.text);
        divide.setOnClickListener(this);
        mr.setOnClickListener(this);
        mPlus.setOnClickListener(this);
        mMinus.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int number1, number2, result;
        number1 = Integer.parseInt(inputValue.getText().toString());
        number2 = Integer.parseInt(divideValue.getText().toString());
        switch (view.getId()){
            case R.id.divide:
                result=number1/number2;
                textView.setText(number1+ "/"+ number2 +"="+result);
                break;
            case R.id.mr:
                String mValue = getStoredPreferenceValue(MainActivity.this);
                String result = removeTrailingZero(mValue);
                if(!result.equals("0")){
                    currentDisplayedInput += result;
                    inputToBeParsed += result;
                }
                break;
        }


        }
    }

    private String removeTrailingZero(String formattingInput) {
        if(!formattingInput.contains(".")){
            return formattingInput;
        }
        int dotPosition = formattingInput.indexOf(".");
        String newValue = formattingInput.substring(dotPosition, formattingInput.length());
        if(newValue.equals(".0")){
            return formattingInput.substring(0, dotPosition);
        }
        return formattingInput;
    }

    private String getStoredPreferenceValue(Context context) {
        float returnedValue = getPreference(context);
        return String.valueOf(returnedValue);
    }

    private float getPreference(Context c) {
        SharedPreferences settings = c.getSharedPreferences(PREFS_NAME, 0);
        float value = settings.getFloat("key", 0);
        return value;
    }
}
