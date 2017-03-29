package com.team.speedcoders.bloodbank;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by ovi on 1/9/2017.
 */

public class MyActivityForConnection extends AppCompatActivity implements View.OnClickListener ,ServerConnectionActivity.TaskDefiner {
    @Override
    public void onClick(View v) {

    }

    @Override
    public void doTheTask(String ... s) {

    }

    public String codedData(String key,String value){
        try {
            return URLEncoder.encode(key, "UTF-8") + "=" + URLEncoder.encode(value, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
