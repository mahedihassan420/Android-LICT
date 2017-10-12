package com.hisoft.ovi.homemaintenace;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MyOrderFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstances) {
        return inflater.inflate(R.layout.fragment_my_order, container, false);
    }
}
