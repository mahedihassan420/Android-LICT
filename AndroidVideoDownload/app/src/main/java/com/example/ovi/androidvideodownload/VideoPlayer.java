package com.example.ovi.androidvideodownload;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayer extends AppCompatActivity {
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);


        videoView = findViewById(R.id.videoViewId);
        videoView.setVideoPath(Environment.getExternalStorageDirectory()
                + "/Ovi_files/" + "ovi.mp4");
        videoView.start();

        MediaController mediacontroller = new MediaController(
                VideoPlayer.this);
        mediacontroller.setAnchorView(videoView);
        videoView.setMediaController(mediacontroller);
    }
}
