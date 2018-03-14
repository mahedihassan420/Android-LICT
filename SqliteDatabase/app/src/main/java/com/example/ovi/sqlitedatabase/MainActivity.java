package com.example.ovi.sqlitedatabase;

import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    EditText id,name,phnNum;
    Button add,view;
    DatabaseSqlite myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initiateAll();
        generateUser();
        myDb=new DatabaseSqlite(this);
        AddData();
        ViewData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.bookmark_menu:
                Toast.makeText(MainActivity.this,"Bookmark Menu is clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.save_menu:
                Toast.makeText(this,"Save Menu is clicked",Toast.LENGTH_LONG).show();
                break;
            case R.id.delete_menu:
                Toast.makeText(this,"Delete Menu is clicked",Toast.LENGTH_LONG).show();
                break;
            default:
                    Toast.makeText(this,"No item is clicked",Toast.LENGTH_SHORT).show();
                    break;
        }

        return true;
    }


    public void ViewData() {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res=myDb.getAllData();
                if(res.getCount() == 0) {
                    // show message
                    ShowMessage("Error","Nothing found");
                    return;
                }

                StringBuffer buffer=new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("ID:"+res.getString(0)+"\n");
                    buffer.append("Name:"+res.getString(1)+"\n");
                    buffer.append("Phone Number:"+res.getString(2)+"\n\n");

                    ShowMessage("Member Data",buffer.toString());
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void ShowMessage(String data, String s) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(data);
        builder.setMessage(s);
        builder.show();
    }

    public void AddData() {
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInsert=(myDb.insertData(id.getText().toString(),name.getText().toString(),phnNum.getText().toString()));
                if (isInsert=true){
                    Toast.makeText(MainActivity.this,"Data insert",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this,"Data not Insert",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void initiateAll(){
        id=(EditText)findViewById(R.id.id);
        name=(EditText)findViewById(R.id.name);
        phnNum=(EditText)findViewById(R.id.PhoneNumber);
        add=(Button)findViewById(R.id.addButton);
        view=(Button)findViewById(R.id.View);
    }
    private void generateUser() {
        new AsyncTask<String, String, String>() {
            @Override
            protected String doInBackground(String... params) {
                String data = "";
                try {

                    URL url = new URL("https://randomuser.me/api/?results=1");
                    URLConnection con = url.openConnection();

                    data = new BufferedReader(new InputStreamReader(con.getInputStream())).readLine();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                return data;
            }

            @Override
            protected void onPostExecute(String s) {
                processData(s);
            }
        }.execute();
    }
    private void processData(String s) {
        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray object=jsonObject.getJSONArray("results");
            for(int i=0;i<object.length();i++){
                jsonObject=object.getJSONObject(0);
                String name=jsonObject.getJSONObject("name").getString("first")+" "+
                        jsonObject.getJSONObject("name").getString("last");
                String phnNum=jsonObject.getString("phone");
                myDb.insertData(i+"",name,phnNum);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
