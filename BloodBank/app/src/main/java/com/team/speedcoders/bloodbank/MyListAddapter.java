package com.team.speedcoders.bloodbank;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.List;


class MyListAddapter extends ArrayAdapter<String> {
    public MyListAddapter(Context context, String[] objects) {
        super(context, R.layout.custom_listview, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=convertView;
        ViewHolder viewHolder;
        if(view==null){
            view=LayoutInflater.from(getContext()).inflate(R.layout.custom_listview,parent,false);
            viewHolder=new ViewHolder(view);
            view.setTag(viewHolder);
        }
        else{
            viewHolder= (ViewHolder) view.getTag();
        }
        try {
            String [] s=getItem(position).split("xx");
            viewHolder.getName().setText(s[0]);
            viewHolder.getAddress().setText(s[1]);
        }catch (Exception e){
            Toast.makeText(getContext(),"Error: "+e,Toast.LENGTH_LONG).show();
        }
        if (position==0)
            view.setBackgroundColor(Color.GRAY);
        return view;
    }
}
