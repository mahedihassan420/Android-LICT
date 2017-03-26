package com.example.ovi.recycler_grid_staggeredviewdemo;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by Ovi on 2/22/2017.
 */

public class MyAdapter extends BaseAdapter {
    ArrayList<Person> list;
    MyAdapter(Context context){
        list=new ArrayList<>();
        Resources resources=context.getResources();
        String[] personName=resources.getStringArray(R.array.names);
        //String[] kora jai na
        for (int i=0;i<=5;i++){
            Person person=new Person(personName[i]);
            list.add(person);
        }
    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
