package com.hisoft.ovi.phoneverification.service;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;


public class HttpRequest {
    private HttpURLConnection urlConnection;
    private DataOutputStream outputStream;

    public String getRequest(String url, String request,String requestMethod) throws IOException {
        if(requestMethod.equals("GET")){
            urlConnection = httpGETURLConnection(url);
        }else{
            urlConnection = getHttpURLConnection(url,request,requestMethod);
        }

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
            byte[] postData = request.getBytes( StandardCharsets.UTF_8 );
            int postDataLength = postData.length;
            urlConnection = (HttpURLConnection) (new URL(url).openConnection());
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod(requestMethod);
            urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            urlConnection.setRequestProperty("charset", "utf-8");
        urlConnection.setRequestProperty("Content-Length", Integer.toString(postDataLength ));
            urlConnection.setReadTimeout(40000);
            urlConnection.setConnectTimeout(45000);
            urlConnection.connect();
            outputStream = new DataOutputStream(urlConnection.getOutputStream());
            outputStream.writeBytes(request);
            outputStream.flush();
            outputStream.close();
            return urlConnection;
    }

    protected HttpURLConnection httpGETURLConnection(String url) throws IOException {
        urlConnection = (HttpURLConnection) (new URL(url).openConnection());
        return urlConnection;
    }

}
