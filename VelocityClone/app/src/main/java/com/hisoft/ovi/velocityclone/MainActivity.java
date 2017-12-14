package com.hisoft.ovi.velocityclone;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,AdapterView.OnItemClickListener {

    RecyclerView recyclerView;
    Button city2;
    String dhaka,khulna,rajshahi,chittagong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView=findViewById(R.id.rvMain);
        city2=findViewById(R.id.poi);

        Intent iin= getIntent();

        if(iin!=null)
        {

            dhaka=iin.getStringExtra("dhaka");
            khulna=iin.getStringExtra("khulna");
            rajshahi=iin.getStringExtra("rajshahi");
            chittagong=iin.getStringExtra("chittagong");
            if(dhaka!=null){city2.setText(dhaka);}
            else if(khulna!=null){city2.setText(khulna);}
            else if(rajshahi!=null){city2.setText(rajshahi);}
            else if(chittagong!=null){city2.setText(chittagong);}
        }

        int[] ids = new int[6];
        ids[0] = R.drawable.restaurant;
        ids[1] =  R.drawable.hospital;
        ids[2] =  R.drawable.hotel;
        ids[3] = R.drawable.fashion;
        ids[4] =R.drawable.image;
        ids[5] =R.drawable.other;
        Resources resources=getResources();

        MainActivity.MyAdapter adapter = new MainActivity.MyAdapter(resources.getStringArray(R.array.company_list),ids);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        recyclerView.setAdapter(adapter);

        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        city2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,City.class));
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    private class MyAdapter extends RecyclerView.Adapter<MainActivity.MyViewHolder> {

        String[] companyList;
        int[] logoList;

        private MyAdapter(String[] companyList,int[] logoList) {
            this.companyList = companyList;
            this.logoList=logoList;
        }


        @Override
        public MainActivity.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_single, parent, false);
            MainActivity.MyViewHolder viewHolder = new MainActivity.MyViewHolder(v);
            return viewHolder;
        }

        @SuppressLint("NewApi")
        @Override
        public void onBindViewHolder(MainActivity.MyViewHolder holder, final int position) {
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
        LinearLayout layout;

        private MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvCompany);
            layout=itemView.findViewById(R.id.ivLogo);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
