package com.sakkar.dialer;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Initiator initiator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiator=new Initiator(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode== AppCompatActivity.RESULT_OK){
            if(requestCode==Initiator.REQUEST_CODE){
                Uri dataUri=data.getData();
                int idx;
                try {
                    Cursor cursor = getContentResolver().query(dataUri,new String[]{ ContactsContract.CommonDataKinds.Phone.NUMBER}, null, null, null);
                    if (cursor.moveToFirst()) {
                        idx = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                        String s=cursor.getString(idx);
                        initiator.setTextView(s);
                        cursor.close();
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Error:"+e,Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
