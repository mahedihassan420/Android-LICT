package com.example.ovi.api;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements IServiceResultListener{
    Button apiButton;
    LinearLayout mainLayout;
    ApiText apiText;
    TextView textBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiText=new ApiText(getBaseContext());
        apiButton = findViewById(R.id.apiButtonId);
        mainLayout=findViewById(R.id.mainLayout);
        apiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apiText.jsonParse(MainActivity.this);

            }
        });
    }


    @Override
    public void OnServiceResult(String id, String name, String address) {

        LayoutInflater layoutInflater = (LayoutInflater) getBaseContext()
                .getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = layoutInflater.inflate(R.layout.alertdialog_text, null);
        final PopupWindow popupWindow = new PopupWindow(popupView,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        textBody=popupView.findViewById(R.id.textBodyID);
        popupWindow.showAtLocation(mainLayout, Gravity.CENTER, 0, 0);
        textBody.setText("Id:" +id + ",\nName: " + name + ",\nAddress " + address + "\n\n");
    }
}
