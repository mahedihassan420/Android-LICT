package com.example.ovi.volleydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private TextView mTextViewResult;
    private RequestQueue mQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewResult = findViewById(R.id.text_view_result);
        Button buttonParse = findViewById(R.id.button_parse);

        mQueue = Volley.newRequestQueue(this);

        buttonParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });
    }

    private void jsonParse() {

        String url = "https://restcountries.eu/rest/v2/all";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            //JSONArray jsonArray = response.getJSONArray("employee");

                            for (int i = 0; i < response.length(); i++) {
                                JSONObject employee = response.getJSONObject(i);

                                //int id = employee.getInt("id");
                                String name = employee.getString("name");
                                String address = employee.getString("region");
                                String capital=employee.getString("capital");
                                String code=employee.getString("callingCodes");
                                String borders=employee.getString("borders");

                                mTextViewResult.append(i + ",\nName: " + name + ",\nRegion: " + address +",\nCapital: " + capital +",\nCalling Code: " + code +",\n Borders: " + borders + "\n\n");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);
    }
}
