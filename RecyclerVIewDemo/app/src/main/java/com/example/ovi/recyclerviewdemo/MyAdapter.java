package com.example.ovi.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by ovi on 3/31/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MYViewHolder> {
    ArrayList<String> list;
    LayoutInflater inflater;

    MyAdapter(ArrayList<String> list,LayoutInflater inflater){
        this.list=list;
        this.inflater=inflater;
    }

    @Override
    public MYViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MYViewHolder(inflater.inflate(R.layout.row,parent,false));
    }

    @Override
    public void onBindViewHolder(MYViewHolder holder, int position) {
        holder.setContent(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
