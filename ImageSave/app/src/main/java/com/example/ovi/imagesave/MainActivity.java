package com.example.ovi.imagesave;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Bitmap anImage;
    Button save;
    int n;
    DatabaseSqlite myDb;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random generator = new Random();
         n= 1000;
        n = generator.nextInt(n);

        save=findViewById(R.id.save);
        myDb=new DatabaseSqlite(MainActivity.this);
        Drawable myDrawable=getResources().getDrawable(R.drawable.download);
        anImage=((BitmapDrawable) myDrawable).getBitmap();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveImageToExternalStorage(anImage);
                myDb.insertData("ovi","ovi House","/sdcard/MyPhotos/Image-"+n+".jpg");
                Cursor cursor=myDb.getAllData();
                Toast.makeText(MainActivity.this, cursor.getString(2), Toast.LENGTH_SHORT).show();

                File imgFile = new  File(""+cursor.getString(3));
                if(imgFile.exists()){
                    Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
                    ImageView myImage =  findViewById(R.id.imageviewTest);
                    myImage.setImageBitmap(myBitmap);
                }
                else {
                    Toast.makeText(MainActivity.this, "Image not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void saveImageToExternalStorage(Bitmap finalBitmap) {
        // String root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString();
        File myDir = new File("/sdcard/MyPhotos/");
        myDir.mkdirs();

        String fname = "Image-" + n + ".jpg";
        File file = new File(myDir, fname);
        if (file.exists())
            file.delete();
        try {
            FileOutputStream out = new FileOutputStream(file);
            finalBitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }


        // Tell the media scanner about the new file so that it is
        // immediately available to the user.
        MediaScannerConnection.scanFile(this, new String[]{file.toString()}, null,
                new MediaScannerConnection.OnScanCompletedListener() {
                    public void onScanCompleted(String path, Uri uri) {
                        Log.i("ExternalStorage", "Scanned " + path + ":");
                        Log.i("ExternalStorage", "-> uri=" + uri);
                    }
                });

    }

}
