package com.example.ovi.recycler_grid_staggeredviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder> {

    private List<Student> studentList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, year, group;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            group = (TextView) view.findViewById(R.id.group);
            year = (TextView) view.findViewById(R.id.year);
        }
    }


    public StudentAdapter(List<Student> studentLists) {
        this.studentList = studentLists;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.name.setText(student.getName());
        holder.group.setText(student.getGroup());
        holder.year.setText(student.getYear());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }
}