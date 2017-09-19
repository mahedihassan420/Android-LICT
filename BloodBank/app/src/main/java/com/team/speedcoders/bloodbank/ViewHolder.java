package com.team.speedcoders.bloodbank;

import android.view.View;
import android.widget.TextView;

class ViewHolder {
    private TextView name,address,phone;
    public ViewHolder(View view) {
        name= (TextView) view.findViewById(R.id.listUserName);
        address= (TextView) view.findViewById(R.id.adderss);
        phone= (TextView) view.findViewById(R.id.userPhone);
    }

    public TextView getAddress() {
        return address;
    }

    public TextView getName() {
        return name;
    }
    public TextView getPhone() {
        return phone;
    }
}
