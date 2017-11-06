package com.hisoft.ovi.islamicorganization;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;



public class BaseService {
    private Context context;
    private IServiceResultListener serviceResultListener;
    private String response;
    private CustomAlertDialog alertDialog;

    public BaseService(Context context) {
        this(context, ((context instanceof IServiceResultListener) ? (IServiceResultListener) context : null));

    }

    public BaseService(Context context, IServiceResultListener serviceResultListener) {
        this.context = context;
        this.serviceResultListener = serviceResultListener;
        alertDialog= new CustomAlertDialog(context);
    }

    protected void setPostRequest(final String url, final String request, final DTOBase dtoBase, final String method, final boolean progress, final String requestMethod, final Boolean tryAgain) {
        new AsyncTask<Void, Void, String>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected String doInBackground(Void... voids) {
                try {
                    Log.i("Request Body",request);
                    response = new HttpRequest().getRequest(url,request,requestMethod);
                    Log.i("Response Body",response);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    return "err";
                }
                return "Done";
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);

                if(result.equals("Done")){
                    try {
                        if(dtoBase!=null){
                            Gson gson = new Gson();
                            DTOBase dtoBaseResult = gson.fromJson(new String(response), dtoBase.getClass());
                            if(serviceResultListener!=null){
                                serviceResultListener.OnServiceResult(method, dtoBaseResult, true);
                            }

                        }
                    }catch (Exception ex) {
                        ex.printStackTrace();
                        if(serviceResultListener!=null){
                            serviceResultListener.OnServiceResult(method, null, false);
                        }

                    }
                }else if(result.equals("err")){
                    if(tryAgain){
                        alertDialog.showDialogWithYesNo("Connection unsuccessful", "Confirm that the network signal (3G, 4G or Wi-Fi ) is strong. Try to access from an area where there is a strong signal.", new ButtonClick() {
                            @Override
                            public void Do() {
                                setPostRequest(url,request,dtoBase,method,progress,requestMethod,tryAgain);
                            }
                        }, new ButtonClick() {
                            @Override
                            public void Do() {
                                if(serviceResultListener!=null){
                                    serviceResultListener.OnServiceResult(method, null, false);
                                }

                            }
                        });

                    }

                }
            }
        }.execute();
    }


}
