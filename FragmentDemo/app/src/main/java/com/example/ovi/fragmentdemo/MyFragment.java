package com.example.ovi.fragmentdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Ovi on 2/11/2017.
 */

public class MyFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstances){
        return inflater.inflate(R.layout.fragment_layout,container,false);
    }

}
