package com.hisoft.ovi.imagedemo;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.toolbox.ImageRequest;

public class MainActivity extends AppCompatActivity {
    Button button;
    ImageView imageView;
    String server_url="http://theopentutorials.com/totwp331/wp-content/uploads/totlogo.png";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button);
        imageView=findViewById(R.id.image);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageRequest imageRequest=new ImageRequest(server_url, new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {

                    },0,0, ImageView.ScaleType.CENTER_CROP,null
                });
            }
        });
    }
}
