package com.example.ovi.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    Button add, view,show;
    DatabaseSqlite myDb;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initiateAll();
        myDb = new DatabaseSqlite(this);
        AddData();
        ViewData();
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Viewall.class));
            }
        });
    }


    public void ViewData() {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.getAllData();
                if (res.getCount() == 0) {
                    // show message
                    ShowMessage("Error", "Nothing found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("ID:" + res.getString(0) + "\n");
                    buffer.append("Name:" + res.getString(1) + "\n");
                    buffer.append("Address" + res.getString(2) + "\n\n");

                    ShowMessage("Member Data", buffer.toString());
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void ShowMessage(String data, String s) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(data);
        builder.setMessage(s);
        builder.show();
    }

    public void AddData() {
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                generateUser();
                Toast.makeText(MainActivity.this, "Data Download Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void initiateAll() {
        add = findViewById(R.id.addButton);
        view = findViewById(R.id.View);
        show=findViewById(R.id.show);
    }

    private void generateUser() {
        new AsyncTask<String, String, String>() {
            @Override
            protected String doInBackground(String... params) {
                String data = "";
                try {

                    URL url = new URL("http://192.168.2.18/test_json.php");
                    URLConnection con = url.openConnection();

                    data = new BufferedReader(new InputStreamReader(con.getInputStream())).readLine();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                return data;
            }

            @Override
            protected void onPostExecute(String s) {
                processData(s);
            }
        }.execute();
    }

    private String processData(String s) {
        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray object = jsonObject.getJSONArray("employee");
            for (int i = 0; i < object.length(); i++) {
                jsonObject = object.getJSONObject(0);
                 id = jsonObject.getString("id");
                String name = jsonObject.getString("name");
                String address = jsonObject.getString("address");
                myDb.insertData(id, name, address);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        Toast.makeText(this, ""+id, Toast.LENGTH_SHORT).show();
        return id;
    }
}
