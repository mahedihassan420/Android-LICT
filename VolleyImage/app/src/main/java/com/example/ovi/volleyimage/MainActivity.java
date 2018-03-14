package com.example.ovi.volleyimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private NetworkImageView mNetworkImageView;
    private ImageLoader mImageLoader;
    RequestQueue mQueue;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNetworkImageView = findViewById(R.id.networkImageView);
        name=findViewById(R.id.name);
        mQueue = Volley.newRequestQueue(this);
        mImageLoader = CustomVolleyRequest.getInstance(this.getApplicationContext())
                .getImageLoader();
        //Image URL - This can point to any image file supported by Android
        jsonParse();

    }

    private void jsonParse() {

        final String url = "https://randomuser.me/api";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("results");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject employee = jsonArray.getJSONObject(i);

                               //name.setText(employee.getString("name"));
                                name.setText("Name: "+employee.getJSONObject("name").getString("first")+" "+
                                        employee.getJSONObject("name").getString("last")+"\n"+"Phone Number -"+employee.getString("phone"));

                               mImageLoader.get(employee.getJSONObject("picture").getString("large"), ImageLoader.getImageListener(mNetworkImageView,
                                        R.drawable.image, android.R.drawable
                                                .ic_dialog_alert));
                                mNetworkImageView.setImageUrl(employee.getJSONObject("picture").getString("large"), mImageLoader);

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
