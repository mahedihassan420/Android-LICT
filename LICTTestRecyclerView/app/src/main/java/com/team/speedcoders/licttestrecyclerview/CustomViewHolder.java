package com.team.speedcoders.licttestrecyclerview;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sakkar on 2/20/2017.
 */

class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView name, depertment;
    ImageView imageView;
    int pos;
    MainActivity mainActivity;

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {

        this.pos = pos;
    }

    public CustomViewHolder(View itemView, MainActivity mainActivity) {
        super(itemView);
        this.mainActivity = mainActivity;
        itemView.setOnClickListener(this);
        name = (TextView) itemView.findViewById(R.id.name);
        depertment = (TextView) itemView.findViewById(R.id.dept);
        imageView = (ImageView) itemView.findViewById(R.id.image);
    }

    public void setDepertment(String depertment) {
        this.depertment.setText(depertment);
    }

    public void setImageView(int imageView) {
        this.imageView.setImageResource(imageView);
    }

    public void setName(String name) {
        this.name.setText(name);
    }


    @Override
    public void onClick(View v) {
        mainActivity.odIt(imageView,getAdapterPosition());
    }

}
