package com.example.mithunkumerghose.listviewfun.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mithunkumerghose.listviewfun.R;
import com.example.mithunkumerghose.listviewfun.model.ListItemModel;

import java.util.ArrayList;

/**
 * @author Mithun Kumer Ghose.
 */

public class CustomAdaptor extends BaseAdapter {

    private ArrayList<ListItemModel> allItems;
//    private Context context;
    private LayoutInflater inflater;

    public CustomAdaptor() {
        allItems = new ArrayList<>();
    }
    public CustomAdaptor(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public CustomAdaptor(ArrayList<ListItemModel> allItems, Context context) {
        this(context);
        this.allItems = allItems;
    }


    @Override
    public int getCount() {
        return allItems.size();
    }

    @Override
    public Object getItem(int position) {
        return allItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public void removeItem(ListItemModel model) {
        allItems.remove(model);
        notifyDataSetChanged();
    }

    public void removeItemByIndex(int index){
        allItems.remove(index);
        notifyDataSetChanged();
    }

    public void addItem(ListItemModel model) {
        allItems.add(model);
        notifyDataSetChanged();
    }

    public void addAllItems(ArrayList<ListItemModel> all) {
        allItems.addAll(all);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        ListItemModel listItemModel = (ListItemModel) getItem(position);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.single_item_view, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.name.setText(listItemModel.name);
        viewHolder.id.setText(listItemModel.id);
        return convertView;
    }

    private static class ViewHolder {

        TextView name;
        TextView id;

        ViewHolder(View item) {
            name = (TextView) item.findViewById(R.id.tv_name);
            id = (TextView) item.findViewById(R.id.tv_id);
        }
    }
}
