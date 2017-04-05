package com.team.speedcoders.licttestrecyclerview;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Sakkar on 2/20/2017.
 */

class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomViewHolder>  {

    MainActivity context;
    ArrayList<Items> items;

    public CustomRecyclerViewAdapter(MainActivity context, ArrayList<Items> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_design, parent, false);
        return new CustomViewHolder(v,context);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.setName(items.get(position).getName());
        holder.setDepertment(items.get(position).getDepertment());
        holder.setImageView(items.get(position).getImageRes());
        holder.setPos(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
