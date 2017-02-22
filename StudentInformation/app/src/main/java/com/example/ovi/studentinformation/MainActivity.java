package com.example.ovi.studentinformation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;




public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    Button button;
    ArrayList<String> arrayList=new ArrayList<>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        arrayList.add("Ovi");
        arrayList.add("Asfaque");
        arrayList.add("Shuvo");
        arrayList.add("Sumon");

        listView= (ListView) findViewById(R.id.list_item);
        button= (Button) findViewById(R.id.btn);
        adapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        registerForContextMenu(listView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getApplicationContext(),i+" "+view,Toast.LENGTH_LONG).show();
    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuinfo) {
        menu.setHeaderTitle("Select The Action");
        menu.add(0, 1123, 0, "View Details");
        menu.add(0, 1124, 0, "Delete");
    }

    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        if (item.getItemId() == 1123) {
            Toast.makeText(getApplicationContext(), "" + arrayList.get(info.position), Toast.LENGTH_LONG).show();
        } else if (item.getItemId() == 1124) {
            Toast.makeText(getApplicationContext(), arrayList.get(info.position) + " deleted", Toast.LENGTH_LONG).show();
            arrayList.remove(info.position);
            adapter.notifyDataSetChanged();
        } else {
            return false;
        }
        return true;
    }
}

