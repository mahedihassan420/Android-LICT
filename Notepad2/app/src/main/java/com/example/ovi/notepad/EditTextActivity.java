package com.example.ovi.notepad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditTextActivity extends AppCompatActivity implements View.OnClickListener{
    EditText editText;
    Button save,cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        editText= (EditText) findViewById(R.id.edit);
        save= (Button) findViewById(R.id.button);
        cancel= (Button) findViewById(R.id.button2);

        save.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                    editText.getText();
                break;
            case R.id.button2:
                startActivity(new Intent(EditTextActivity.this,MainActivity.class));
                break;
            default:
                break;
        }
    }
}
