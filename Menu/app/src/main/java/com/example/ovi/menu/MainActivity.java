package com.example.ovi.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button view= (Button) findViewById(R.id.button);
        registerForContextMenu(view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.Save:
                Toast.makeText(getApplicationContext(),"save",Toast.LENGTH_LONG).show();
                break;
            case R.id.delete:
                Toast.makeText(getApplicationContext(),"delete",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
