package com.hisoft.ovi.velocitydemo;

import android.content.res.Resources;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView=findViewById(R.id.rvMain);

        int[] ids = new int[12];
        ids[0] = R.drawable.restaurant;
        ids[1] =  R.drawable.hospital;
        ids[2] =  R.drawable.hotel;
        ids[3] = R.drawable.fashion;
        ids[4] =R.drawable.image;
        Resources resources=getResources();

        Main2Activity.MyAdapter adapter = new Main2Activity.MyAdapter(resources.getStringArray(R.array.company_list),ids);
        recyclerView.setLayoutManager(new GridLayoutManager(Main2Activity.this, 2));
        recyclerView.setAdapter(adapter);
    }

    private class MyAdapter extends RecyclerView.Adapter<Main2Activity.MyViewHolder> {

        String[] companyList;
        int[] logoList;

        public MyAdapter(String[] companyList,int[] logoList) {
            this.companyList = companyList;
            this.logoList=logoList;
        }


        @Override
        public Main2Activity.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_single, parent, false);
            Main2Activity.MyViewHolder viewHolder = new Main2Activity.MyViewHolder(v);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(Main2Activity.MyViewHolder holder, final int position) {
            holder.layout.setBackground(getApplicationContext().getDrawable(logoList[position]));
            holder.name.setText(companyList[position]);
        }

        @Override
        public int getItemCount() {
            return companyList.length;
        }
    }
    private class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView name;
        ConstraintLayout layout;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvCompany);
            layout=itemView.findViewById(R.id.ivLogo);
        }
    }
}
