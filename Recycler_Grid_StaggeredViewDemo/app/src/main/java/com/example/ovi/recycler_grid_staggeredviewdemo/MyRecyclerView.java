package com.example.ovi.recycler_grid_staggeredviewdemo;

import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerView extends AppCompatActivity {
    private List<Student> studentList=new ArrayList<>();
    android.support.v7.widget.RecyclerView recyclerView;
    private StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // Recycler view ase na kno casting e

        studentAdapter = new StudentAdapter(studentList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(studentAdapter);

        prepareMovieData();
    }

    private void prepareMovieData() {
        Student student = new Student("Ovi", "ICE", "2012");
        studentList.add(student);

        student = new Student("Sumon", "ICE", "2012");
        studentList.add(student);

        student = new Student("Nibesh", "ICE", "2013");
        studentList.add(student);
        student = new Student("Asfaque", "CSE", "2014");
        studentList.add(student);
        student = new Student("Sumon", "ICE", "20");
        studentList.add(student);
        studentAdapter.notifyDataSetChanged();
    }
}