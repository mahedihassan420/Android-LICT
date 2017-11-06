package com.hisoft.ovi.sqldatabase;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Ovi on 11/4/2017.
 */

public class MySingleton {
    static MySingleton mInstance;
    RequestQueue requestQueue;
    Context mCtx;

    private MySingleton(Context context){
        mCtx=context;
        requestQueue=getRequestQueue();
    }
    public static synchronized MySingleton getInstance(Context context){
        if (mInstance==null){
            mInstance=new MySingleton(context);
        }
        return mInstance;
    }
    RequestQueue getRequestQueue(){
        if (requestQueue==null){
            requestQueue= Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return requestQueue;
    }

    public void addTorequestQueue(Request request){
        requestQueue.add(request);
    }
}
