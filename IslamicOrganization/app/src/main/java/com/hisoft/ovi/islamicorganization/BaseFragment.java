package com.hisoft.ovi.islamicorganization;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

/**
 * Created by Invariant on 10/7/17.
 */

public class BaseFragment extends Fragment {
    protected Context context;
    protected Intent intent;
    protected Bundle bundle=null;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = getActivity();
    }

    protected void ToastShort(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    protected void ToastLong(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    protected String getStringResources(int id)
    {
        return getResources().getString(id);
    }
}