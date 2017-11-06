package com.hisoft.ovi.islamicorganization;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpRequest {
    private HttpURLConnection urlConnection;
    private DataOutputStream outputStream;

    public String getRequest(String url, String request,String requestMethod) throws IOException {
        urlConnection = getHttpURLConnection(url,request,requestMethod);
        if(urlConnection!=null){
            if(urlConnection.getResponseCode()== 200){
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                StringBuilder result = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
                return result.toString();
            }else if(urlConnection.getResponseCode() >=400){
                throw new IOException("Server returned HTTP" + " response code: " + urlConnection.getResponseCode() + " for URL: " + url.toString());
            }else{
                throw new IOException("Server returned HTTP" + " response code: " + urlConnection.getResponseCode() + " for URL: " + url.toString());
            }
        }else{
            throw new RuntimeException("Stub!");
        }
    }

    protected HttpURLConnection getHttpURLConnection(String url, String request,String requestMethod) throws IOException {
            urlConnection = (HttpURLConnection) (new URL(url).openConnection());
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod(requestMethod);
            urlConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            urlConnection.setReadTimeout(40000);
            urlConnection.setConnectTimeout(45000);
            urlConnection.connect();
            outputStream = new DataOutputStream(urlConnection.getOutputStream());
            outputStream.writeBytes(request);
            outputStream.flush();
            outputStream.close();
            return urlConnection;
    }
}
