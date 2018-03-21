package com.example.ovi.androidvideodownload;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.view.Gravity;
import android.widget.Toast;

import java.io.File;


public class DownloadVideo {
    private DownloadManager downloadManager;
    private Context context;

    public long Image_DownloadId, Music_DownloadId;
    DownloadVideo(Context context1){
        context=context1;

        downloadManager = (DownloadManager) context1.getSystemService(Context.DOWNLOAD_SERVICE);
    }

    public long DownloadData (Uri uri) {

        File direct = new File(Environment.getExternalStorageDirectory()
                + "/Ovi_files");

        if (!direct.exists()) {
            direct.mkdirs();
        }


        Uri downloadUri = Uri.parse(String.valueOf(uri));
        DownloadManager.Request request = new DownloadManager.Request(
                downloadUri);

        request.setAllowedNetworkTypes(
                DownloadManager.Request.NETWORK_WIFI
                        | DownloadManager.Request.NETWORK_MOBILE)
                .setAllowedOverRoaming(false).setTitle("Demo")
                .setDescription("Something useful. No, really.")
                .setDestinationInExternalPublicDir("/Ovi_files", "ovi.mp4");



        long downloadReference;

        //Setting title of request
        request.setTitle("Video Download");
        request.setDescription("Android Data download using DownloadManager.");

        downloadReference=downloadManager.enqueue(request);

        return downloadReference;
    }
    public long DownloadDataImage (Uri uri) {

        File direct = new File(Environment.getExternalStorageDirectory()
                + "/Ovi_files");

        if (!direct.exists()) {
            direct.mkdirs();
        }

        //downloadManager = (DownloadManager) this.getSystemService(Context.DOWNLOAD_SERVICE);

        Uri downloadUri = Uri.parse(String.valueOf(uri));
        DownloadManager.Request request = new DownloadManager.Request(
                downloadUri);

        request.setAllowedNetworkTypes(
                DownloadManager.Request.NETWORK_WIFI
                        | DownloadManager.Request.NETWORK_MOBILE)
                .setAllowedOverRoaming(false).setTitle("Demo")
                .setDescription("Something useful. No, really.")
                .setDestinationInExternalPublicDir("/Ovi_files", "ovi.jpg");


        long downloadReference;

        //Setting title of request
        request.setTitle("Image Download");
        request.setDescription("Android Data download using DownloadManager.");

        downloadReference=downloadManager.enqueue(request);

        return downloadReference;
    }

    public BroadcastReceiver downloadReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {

            //check if the broadcast message is for our Enqueued download
            long referenceId = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);

            if(referenceId == Image_DownloadId) {

                Toast toast = Toast.makeText(context,
                        "Image Download Complete", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP, 25, 400);
                toast.show();
            }
            else if(referenceId == Music_DownloadId) {

                Toast toast = Toast.makeText(context,
                        "Music Download Complete", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP, 25, 400);
                toast.show();
            }

        }
    };

}
