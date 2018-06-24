package com.bryan_alegria.androidexam.API;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpConnection {
    HttpsURLConnection urlConnection = null;
    URL url = null;
    InputStream inStream = null;
    OutputStream out = null;
    private String HttpResponse = "";

    public HttpConnection() {

    }

    protected String httpGetResponse(String SERVICE_URL) {
        this.httpsGetMethod(SERVICE_URL);
        return this.HttpResponse;
    }

    private void httpsGetMethod(String SERVICE_URL) {
        int ResponseCode = 0;
        String var4 = "";

        try {
            URL e = new URL(SERVICE_URL);
            HttpsURLConnection conn = (HttpsURLConnection)e.openConnection();
            conn.setReadTimeout(120000);
            conn.setConnectTimeout(120000);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.connect();
            ResponseCode = conn.getResponseCode();
            BufferedReader _buff = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuffer response = new StringBuffer();

            String _InputLine;
            while((_InputLine = _buff.readLine()) != null) {
                response.append(_InputLine);
            }

            this.HttpResponse = ResponseCode + "|" + response.toString();
        } catch (Exception var10) {
            this.HttpResponse = ResponseCode + "|" + var10.getMessage();
        }

    }

}
