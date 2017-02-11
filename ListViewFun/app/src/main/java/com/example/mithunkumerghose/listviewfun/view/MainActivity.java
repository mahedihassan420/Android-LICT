package com.example.mithunkumerghose.listviewfun.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.mithunkumerghose.listviewfun.R;
import com.example.mithunkumerghose.listviewfun.model.ListItemModel;
import com.example.mithunkumerghose.listviewfun.util.CustomAdaptor;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<ListItemModel> models = createListItems();
        final CustomAdaptor cuAd = new CustomAdaptor(models,this);
        ListView listView = (ListView) findViewById(R.id.list_viewTest);
        listView.setAdapter(cuAd);

        final EditText editText = (EditText) findViewById(R.id.idxEt);

        Button btn = (Button) findViewById(R.id.deletBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idx = Integer.parseInt(editText.getText().toString());
                cuAd.removeItemByIndex(idx);
            }
        });

        Button btnAdd = (Button) findViewById(R.id.addBtn);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListItemModel model = new ListItemModel();
                model.name = "Imran";
                model.id = "Android";
                cuAd.addItem(model);
            }
        });
    }

    public ArrayList<ListItemModel> createListItems() {
        ArrayList<ListItemModel> listItemModels = new ArrayList<>();
        for(int i = 0; i<10; i++) {
            ListItemModel model = new ListItemModel();
            model.id = "Test Id : " + i;
            model.name = "Simple name " + i;

            listItemModels.add(model);
        }

        return listItemModels;
    }
}
