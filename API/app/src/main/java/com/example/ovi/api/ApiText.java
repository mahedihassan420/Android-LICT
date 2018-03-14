package com.example.ovi.api;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Pranob on 3/8/2018.
 */

public class ApiText {
    RequestQueue mQueue;
    public String id;

    String url = "http://192.168.2.18/test_json.php";

    public Context contexto;

    public ApiText(Context contextoInstancia) {
        contexto = contextoInstancia;
        mQueue = Volley.newRequestQueue(contextoInstancia);
    }

    public void jsonParse(final IServiceResultListener callback) {


        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray("employee");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject employee = jsonArray.getJSONObject(i);

                                id = employee.getString("id");
                                String name = employee.getString("name");
                                String address = employee.getString("address");
                                callback.OnServiceResult(id, name, address);

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
