package com.example.ovi.bookstore;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText bookId, bookName, price, quantity;
    Button insert, update, delete, view;
    DbHandler dbHandler;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHandler = new DbHandler(this);
        bookId= (EditText) findViewById(R.id.bookID);
        bookName= (EditText) findViewById(R.id.bookName);
        price= (EditText) findViewById(R.id.price);
        quantity= (EditText) findViewById(R.id.quantity);
        insert = (Button) findViewById(R.id.insert);
        update= (Button) findViewById(R.id.update);
        delete= (Button) findViewById(R.id.delete);
        view= (Button) findViewById(R.id.view);


        insert.setOnClickListener(this);
        update.setOnClickListener(this);
        delete.setOnClickListener(this);
        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.insert:
                dbHandler.InsertRecord(bookId.getText().toString(),bookName.getText().toString(),quantity.getInputType(),price.getInputType());
                Toast.makeText(getApplicationContext(),"Insert Successfully......",Toast.LENGTH_LONG).show();
                break;
            case R.id.update:
                dbHandler.UpdateRecord(bookId.getText().toString(),bookName.getText().toString(),quantity.getInputType(),price.getInputType());
                Toast.makeText(getApplicationContext(),"Update Successfully......",Toast.LENGTH_LONG).show();
                break;
            case R.id.delete:
                dbHandler.DeleteRecord(bookId.getText().toString());
                Toast.makeText(getApplicationContext(),"Delete Successfully......",Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }

    }

}
