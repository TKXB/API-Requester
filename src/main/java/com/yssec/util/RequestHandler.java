package com.yssec.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RequestHandler{
    private String url;
    private String params;
    private String cookies;
    private Map<String, String> headers;

    public String getUrl() throws Exception{
        if(!params.isEmpty()){
            this.url = url + "?" + params;
        }
        URL ojb = new URL(this.url);
        HttpURLConnection con = (HttpURLConnection) ojb.openConnection();
        con.setRequestMethod("GET");
        if (!headers.isEmpty()) {
            Iterator iter = headers.entrySet().iterator();
            while(iter.hasNext()){
                Map.Entry entry = (Map.Entry) iter.next();
                String key = (String) entry.getKey();
                String value = (String) entry.getValue();
                con.setRequestProperty(key, value);
            }
        }
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    public String postUrl() throws Exception{
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");

        //set http headers
        if (!headers.isEmpty()) {
            Iterator iter = headers.entrySet().iterator();
            while(iter.hasNext()){
                Map.Entry entry = (Map.Entry) iter.next();
                String key = (String) entry.getKey();
                String value = (String) entry.getValue();
                con.setRequestProperty(key, value);
            }
        }

        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(this.params);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + this.params);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return  response.toString();
    }

    public void setCookies(String cookies){
        this.cookies = cookies;
    }

    public void setHeaders(Map headers){
        this.headers = headers;
    }

    public RequestHandler(String url, String params){
        this.url = url;
        this.params = params;
    }
}
