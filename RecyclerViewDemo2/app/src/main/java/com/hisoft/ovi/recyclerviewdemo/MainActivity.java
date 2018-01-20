package com.hisoft.ovi.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<OrganizationsSuggestList> organizationsSuggestLists = new ArrayList<>();
    private RecyclerView recyclerView;
    private NotificationsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView =findViewById(R.id.rec_suggest);
        mAdapter = new NotificationsAdapter(organizationsSuggestLists);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();
    }
    private void prepareMovieData() {
        OrganizationsSuggestList one = new OrganizationsSuggestList("Islamic Center of Raieleigh");
        organizationsSuggestLists.add(one);
        OrganizationsSuggestList two = new OrganizationsSuggestList("Cary Masjid");
        organizationsSuggestLists.add(two);
        OrganizationsSuggestList three = new OrganizationsSuggestList("Apex Mosque");
        organizationsSuggestLists.add(three);



        mAdapter.notifyDataSetChanged();
    }
}
