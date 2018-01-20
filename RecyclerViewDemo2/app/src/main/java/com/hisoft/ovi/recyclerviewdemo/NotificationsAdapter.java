package com.hisoft.ovi.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import bd.com.hisoft.NotificationsClassFile.OrganizationsSuggestList;
import bd.com.hisoft.mymosque.R;

/**
 * Created by Ovi on 1/9/2018.
 */

public class NotificationsAdapter extends RecyclerView.Adapter<NotificationsAdapter.MyViewHolder> {

    private List<OrganizationsSuggestList> organizationsSuggestListss;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        private MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.orgNotf);
        }
    }

    public NotificationsAdapter(List<OrganizationsSuggestList> organizationsSuggestListss) {
        this.organizationsSuggestListss = organizationsSuggestListss;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.suggest_org_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        OrganizationsSuggestList movie = organizationsSuggestListss.get(position);
        holder.title.setText(movie.getTitle());

    }

    @Override
    public int getItemCount() {
        return organizationsSuggestListss.size();
    }


}
