package com.example.hankomin.wikiapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpHelper{
    public static String sendGet(String url) throws MalformedURLException, IOException {
        String  result="";
        URL obj =new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent","Java Http Client");
        int responseCode = con.getResponseCode();
        if (responseCode>199 && responseCode<300){
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while((line=in.readLine())!=null){
                result+=line + "\n";
            }
            in.close();
        }
        else{
            System.out.println("Not connected to server");
        }
        return result;
    }
}
