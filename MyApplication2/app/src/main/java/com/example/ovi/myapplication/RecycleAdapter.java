package com.example.ovi.myapplication;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.Myholder> {
    private List<DataModel> dataModelArrayList;

    RecycleAdapter(List<DataModel> dataModelArrayList) {
        this.dataModelArrayList = dataModelArrayList;
    }

    class Myholder extends RecyclerView.ViewHolder{
        TextView name,id,address;

        Myholder(View itemView) {
            super(itemView);

            name =  itemView.findViewById(R.id.name1);
            id =  itemView.findViewById(R.id.id);
            address =  itemView.findViewById(R.id.address);
        }
    }


    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
         @SuppressLint("InflateParams") View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview,null);
         return new Myholder(view);

    }

    @Override
    public void onBindViewHolder(Myholder holder, int position) {
        DataModel dataModel=dataModelArrayList.get(position);
        holder.name.setText(dataModel.getName());
        holder.id.setText(dataModel.getId());
        holder.address.setText(dataModel.getAddress());

    }

    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }
}
