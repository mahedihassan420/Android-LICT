package com.example.ovi.practiseanywidget;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b=(Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                android.app.Notification notify= new android.app.Notification(android.R.drawable.stat_sys_download_done,"This is important",System.currentTimeMillis());
                Context con= Notification.this;
                CharSequence title="This is notification";
                CharSequence details="Important notice ";
                Intent intent=new Intent(con,Notification.class);
                PendingIntent pendingIntent=PendingIntent.getActivity(con,0,intent,0);
                notify.setLatestEvent
                notificationManager.notify(0,notify);
            }
        });
    }
}
