package com.jack;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Set;

public class BihuApplication {
    public static void main(String[] args) {
        getIndexPageData();
//        getLoginPageData();
//        postLoginData();
    }

    public static void getIndexPageData() {
        try {
            URL url = new URL("http://bihu.com/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream in = connection.getInputStream();
            BufferedInputStream ins = new BufferedInputStream(in);
            Reader reader = new InputStreamReader(ins);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String data = "";
            while ((data = bufferedReader.readLine()) != null) {
                System.err.print(data + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getLoginPageData() {
        try {
            URL url = new URL("https://bihu.com/login");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream in = connection.getInputStream();
            BufferedInputStream ins = new BufferedInputStream(in);
            Reader reader = new InputStreamReader(ins);
            BufferedReader bufferedReader = new BufferedReader(reader);
            int length = 0;
            String data = "";
            while ((data = bufferedReader.readLine()) != null) {
                System.err.print(data + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void postLoginData() {
        try {
            String postData = "{\"phone\":\"18108084869\",\"password\":\"f9a9bfc3cae2f1075b69f8ea15c6eaaa574c167c479bce6352656472e40ebcc4\",\"crash\":1,\"challenge\":\"b7425438f5afc3df73c73a4c1b0af77a\"}";
            URL url = new URL("https://be02.bihu.com/bihube-pc/api/user/loginViaPassword");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Host", "be02.bihu.com");
            connection.setRequestProperty("Connection", "keep-alive");
            connection.setRequestProperty("Origin", "https://bihu.com");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
            connection.setRequestProperty("Accept", "*/*");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Referer", "https://bihu.com/login");
            connection.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
            connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
            connection.setRequestProperty("Content-Length", "158");
            connection.setDoOutput(true);
            OutputStream out = connection.getOutputStream();
            out.write(postData.getBytes());
            System.err.println(connection.getResponseCode());
            System.err.println(connection.getResponseMessage());
            Map headers = connection.getHeaderFields();
            Set<String> keys = headers.keySet();
            for (String key : keys) {
                String val = connection.getHeaderField(key);
                System.out.println(key + "    " + val);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


