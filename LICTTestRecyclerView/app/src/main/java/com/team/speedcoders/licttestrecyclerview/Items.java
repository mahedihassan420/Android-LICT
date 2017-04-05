package com.team.speedcoders.licttestrecyclerview;

/**
 * Created by Sakkar on 2/20/2017.
 */

class Items {
    int imageRes;
    String name,depertment;

    public Items(String depertment, int imageRes, String name) {
        this.depertment = depertment;
        this.imageRes = imageRes;
        this.name = name;
    }

    public String getDepertment() {
        return depertment;
    }

    public int getImageRes() {
        return imageRes;
    }

    public String getName() {
        return name;
    }
}
