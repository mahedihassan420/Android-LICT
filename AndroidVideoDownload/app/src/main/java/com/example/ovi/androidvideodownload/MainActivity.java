package com.example.ovi.androidvideodownload;

import android.app.DownloadManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    DownloadVideo downloadVideo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Download Image from URL
        Button DownloadImage = findViewById(R.id.DownloadImage);
        downloadVideo = new DownloadVideo(MainActivity.this);
        DownloadImage.setOnClickListener(this);

        //Download Music from URL
        Button DownloadMusic = findViewById(R.id.DownloadMusic);
        DownloadMusic.setOnClickListener(this);


        //set filter to only when download is complete and register broadcast receiver
        IntentFilter filter = new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
        registerReceiver(downloadVideo.downloadReceiver, filter);

        try {
            Thread timer = new Thread() {
                public void run() {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        startActivity(new Intent(MainActivity.this,VideoPlayer.class));
                    }
                }
            };
            timer.start();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            //Download Image
            case R.id.DownloadImage:
                Uri image_uri = Uri.parse("http://www.androidtutorialpoint.com/wp-content/uploads/2016/09/Beauty.jpg");
                downloadVideo.DownloadDataImage(image_uri);
                break;

            //Download Music
            case R.id.DownloadMusic:
                Uri music_uri = Uri.parse("http://techslides.com/demos/sample-videos/small.mp4");
                downloadVideo.DownloadData(music_uri);
                break;

            default:
                break;

        }
    }


}
