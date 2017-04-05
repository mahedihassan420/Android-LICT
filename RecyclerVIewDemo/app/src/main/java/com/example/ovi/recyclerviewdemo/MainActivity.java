package com.example.ovi.recyclerviewdemo;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.net.URI;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MyAdapter adapter;
    ArrayList<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<String>();
        recyclerView = (RecyclerView) findViewById(R.id.recy);
        for (int i = 0; i < 100; i++) {
            list.add("ovi:" + i);
        }

        /*tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_PICK,ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(intent,PICK_CONTACT);
            }
        });*/
        /*ContentResolver resolver=getContentResolver();
        Cursor cursor=resolver.query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);

        while (cursor.moveToNext()) {
            String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

            Cursor phoneCursor = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=?",
                    new String[]{id}, null);

            while (phoneCursor.moveToNext()) {
                String phoneNum = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            }
        }*/
        adapter = new MyAdapter(list, getLayoutInflater());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
