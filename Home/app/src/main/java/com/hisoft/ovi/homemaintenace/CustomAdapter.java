package com.hisoft.ovi.homemaintenace;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ovi on 1/29/2017.
 */
class SingleRow{
    int images;
    SingleRow( int images){
        this.images=images;
    }
}

public class CustomAdapter extends BaseAdapter {
    ArrayList<SingleRow> list;
    Context context;
    CustomAdapter(Context c){
        context=c;
        list=new ArrayList<SingleRow>();
        int[] images={R.drawable.ac,R.drawable.ew,R.drawable.pd,R.drawable.pw,R.drawable.ca,R.drawable.ed,
                R.drawable.chm,R.drawable.st,R.drawable.pc,R.drawable.ac,R.drawable.ew,R.drawable.pd,R.drawable.pw,R.drawable.ca,R.drawable.ed,};
        for (int i=0;i<100;i++){
            try{
            SingleRow s=new SingleRow(images[i]);
            list.add(s);
        }
        catch (Exception e){}
        }
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.single_row,viewGroup,false);
        ImageView imageView= (ImageView) row.findViewById(R.id.imageView);

        SingleRow temp=list.get(i);
        imageView.setImageResource(temp.images);
        return row;
    }
}
