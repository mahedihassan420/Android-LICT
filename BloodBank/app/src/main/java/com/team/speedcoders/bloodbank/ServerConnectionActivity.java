package com.team.speedcoders.bloodbank;

import android.app.FragmentManager;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

class ServerConnectionActivity extends AsyncTask<String,String,String> {

    private FragmentManager fragmentManager;
    private MyFragmentDialoge myFragmentDialoge;
    private Context context;
    private String link ;
    private MyActivityForConnection myActivityForConnection;

    ServerConnectionActivity(Context context, MyActivityForConnection myActivityForConnection, String link) {
        this(myActivityForConnection.getFragmentManager());
        this.context = context;
        this.link=link;
        this.myActivityForConnection = myActivityForConnection;
    }

    private ServerConnectionActivity(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
        myFragmentDialoge=new MyFragmentDialoge();
    }

    @Override
    protected void onPostExecute(String string) {
        String[] s=string.split( "&" );
        switch (s[0]){
            case "Matched":
                myFragmentDialoge.dismiss();
                myActivityForConnection.doTheTask();
                break;
            case "Successful":
                myFragmentDialoge.dismiss();
                Toast.makeText(context,"Thank you for registration",Toast.LENGTH_LONG).show();
                myActivityForConnection.doTheTask();
                break;
            case "Obtained":
                myFragmentDialoge.dismiss();
                String[] str=string.replace("Obtained&","").split("&");
                myActivityForConnection.doTheTask(str);
                break;
            case "profile":
                ProfileDialogFragment profileDialogFragment=new ProfileDialogFragment();
                Bundle bundle=new Bundle();
                String[] strings=string.replace("profile&","").split("&");
                bundle.putStringArray("info",strings);
                myFragmentDialoge.dismiss();
                profileDialogFragment.setArguments(bundle);
                profileDialogFragment.show(fragmentManager,"prpfileDialog");
                break;
            default:
                myFragmentDialoge.dismiss();
                Toast.makeText(context," "+ string,Toast.LENGTH_LONG).show();
                break;
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        myFragmentDialoge.show(fragmentManager,"dialog");
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected String doInBackground(String... params) {
        String data=params[0];
        OutputStreamWriter wr;
        URLConnection conn;
        try {
            URL url = new URL(link);
            conn = url.openConnection();
            conn.setDoOutput(true);
            wr = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            wr.write( data );
            wr.flush();
            wr.close();
            BufferedReader reader = new BufferedReader(new
                    InputStreamReader(conn.getInputStream()));

            String line = null;

            // Read Server Response
            line = reader.readLine();
            Log.w("Sakkar",line);
            reader.close();
            return line;
        } catch (Exception e) {
            Log.w("Sakkar",e);
        }
        return null;
    }

    interface TaskDefiner{
        public abstract void doTheTask(String ... s);
    }
}
