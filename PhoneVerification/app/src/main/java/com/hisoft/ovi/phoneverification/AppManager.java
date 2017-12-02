package com.hisoft.ovi.phoneverification;

import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Log;


public class AppManager {

    public static boolean hasInternetConnection(Context context) {

        try {
            ConnectivityManager cm = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);

            return cm.getActiveNetworkInfo().isConnectedOrConnecting();

        } catch (Exception e) {
            System.out.println("CheckConnectivity Exception: " + e.getMessage());
            Log.v("connectivity", e.toString());
            return false;
        }
    }



}
