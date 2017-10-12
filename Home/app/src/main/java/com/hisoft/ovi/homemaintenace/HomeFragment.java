package com.hisoft.ovi.homemaintenace;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;


public class HomeFragment extends Fragment {

    GridView gridView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstances) {
        View rootview = inflater.inflate(R.layout.fragment_home, container, false);


        gridView= (GridView) rootview.findViewById(R.id.gridView);
        gridView.setAdapter(new CustomAdapter(this.getActivity()));
        return rootview;

    }
}
