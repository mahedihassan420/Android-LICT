package com.example.ovi.arits;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    TextView name,email,number,locations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateUser();
        name = (TextView) findViewById(R.id.name);
        email= (TextView) findViewById(R.id.gen);
        locations= (TextView) findViewById(R.id.loc);
        number= (TextView) findViewById(R.id.phone);
    }

    private void generateUser() {
        new AsyncTask<String, String, String>() {
            @Override
            protected String doInBackground(String... params) {
                String data = "";

                try {

                    URL url = new URL("https://randomuser.me/api/?results=1");
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

    private void processData(String s) {
        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray object=jsonObject.getJSONArray("results");
            jsonObject=object.getJSONObject(0);
            name.setText(jsonObject.getJSONObject("name").getString("first")+" "+
                    jsonObject.getJSONObject("name").getString("last"));

            email.setText("Email Address -"+jsonObject.getString("email"));
            number.setText("Phone Number -"+jsonObject.getString("phone"));
            locations.setText("Location -"+jsonObject.getJSONObject("location").getString("street")+","+
                    jsonObject.getJSONObject("location").getString("city")+","+
                    jsonObject.getJSONObject("location").getString("state")+","+
                    jsonObject.getJSONObject("location").getString("postcode"));

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}