package com.example.ovi.listview;

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
    String titles;
    String description;
    int images;
    SingleRow(String titles, String description, int images){
        this.titles=titles;
        this.description=description;
        this.images=images;
    }
}
public class CustomAdapter extends BaseAdapter {
    ArrayList<SingleRow> list;
    Context context;
    CustomAdapter(Context c){
        context=c;
        list=new ArrayList<SingleRow>();
        Resources res=c.getResources();
        String[] titles=res.getStringArray(R.array.titles);
        String[] description=res.getStringArray(R.array.description);
        int[] images={R.mipmap.ic_launcher,R.drawable.ovi,R.mipmap.ic_launcher};
        for (int i=0;i<5;i++){
            try{
            SingleRow s=new SingleRow(titles[i],description[i],images[i]);
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
        TextView title= (TextView) row.findViewById(R.id.name);
        TextView description= (TextView) row.findViewById(R.id.description);
        ImageView imageView= (ImageView) row.findViewById(R.id.imageView);

        SingleRow temp=list.get(i);
        title.setText(temp.titles);
        description.setText(temp.description);
        imageView.setImageResource(temp.images);
        return row;
    }
}
