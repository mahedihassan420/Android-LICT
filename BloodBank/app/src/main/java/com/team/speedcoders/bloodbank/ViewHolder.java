package com.team.speedcoders.bloodbank;

import android.view.View;
import android.widget.TextView;

class ViewHolder {
    private TextView name,address;
    public ViewHolder(View view) {
        name= (TextView) view.findViewById(R.id.listUserName);
        address= (TextView) view.findViewById(R.id.adderss);
    }

    public TextView getAddress() {
        return address;
    }

    public TextView getName() {
        return name;
    }
}
