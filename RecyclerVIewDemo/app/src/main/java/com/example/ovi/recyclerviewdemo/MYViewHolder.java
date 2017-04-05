package com.example.ovi.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by ovi on 3/31/17.
 */

public class MYViewHolder extends RecyclerView.ViewHolder {
    TextView textView;
    public MYViewHolder(View itemView) {
        super(itemView);
        textView= (TextView) itemView.findViewById(R.id.content);
    }
    void setContent(String s){
        textView.setText(s);
    }
}
