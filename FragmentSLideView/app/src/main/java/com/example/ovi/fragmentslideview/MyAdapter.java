package com.example.ovi.fragmentslideview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Ovi on 2/12/2017.
 */

public class MyAdapter extends FragmentPagerAdapter {
    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        if (position==0){
            fragment=new FragmentA();
        }
        else         if (position==1){
            fragment=new FragmentB();
        }
        if (position==2){
            fragment=new FragmentC();
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
