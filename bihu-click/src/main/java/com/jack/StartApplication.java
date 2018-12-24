package com.jack;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Set;

public class StartApplication {

    public static void main(String[] args) {
        try {
            String strData = getIndexPageData();
            System.out.println(strData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getIndexPageData() throws IOException {
        InputStream in = null;
        StringBuilder builder = new StringBuilder();
        try {
            URL url = new URL("https://bihu.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Host", "bihu.com");
            connection.setRequestProperty("Connection", "keep-alive");
            connection.setRequestProperty("Upgrade-Insecure-Requests", "1");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
            connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
            connection.setRequestProperty("Accept-Encoding", "deflate, br");
            connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
            connection.setRequestProperty("Cookie", "UM_distinctid=16772718b90284-0dff01b27c1916-3a3a5d0c-100200-16772718b91400; _bl_uid=5qjFgpd87yzu0ekn8w9yxn17pqgy; CNZZDATA1263920413=1001691711-1543811505-https%253A%252F%252Fwww.baidu.com%252F%7C1545621511; aliyungf_tc=AQAAAPdlxynz1QYAJO9ydpdgFsM35qWz");
            connection.setRequestProperty("If-None-Match", "W/\"5c1b6446-79b\"");
            connection.setRequestProperty("If-Modified-Since", "Thu, 20 Dec 2018 11:39:34 GMT");
            Map headers = connection.getHeaderFields();
            Set<String> keys = headers.keySet();
            for (String key : keys) {
                String val = connection.getHeaderField(key);
                System.out.println(key + "    " + val);
              }
            in = connection.getInputStream();
            BufferedInputStream ins = new BufferedInputStream(in);
            Reader reader = new InputStreamReader(ins);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String data = "";
            while ((data = bufferedReader.readLine()) != null) {
                builder.append(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (in != null){
                in.close();
            }
        }

        return builder.toString();
    }

//    public static void getLoginPageData() {
//        try {
//            URL url = new URL("http://bihu.com/login");
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            InputStream in = connection.getInputStream();
//            BufferedInputStream ins = new BufferedInputStream(in);
//            Reader reader = new InputStreamReader(ins);
//            BufferedReader bufferedReader = new BufferedReader(reader);
//            int length = 0;
//            String data = "";
//            while ((data = bufferedReader.readLine()) != null) {
//                System.err.print(data + "\n");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    public static void postLoginData() {
//        try {
//            String postData = "{\"phone\":\"18108084869\",\"password\":\"f9a9bfc3cae2f1075b69f8ea15c6eaaa574c167c479bce6352656472e40ebcc4\",\"crash\":1,\"challenge\":\"b7425438f5afc3df73c73a4c1b0af77a\"}";
//            URL url = new URL("https://be02.bihu.com/bihube-pc/api/user/loginViaPassword");
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("POST");
//            connection.setRequestProperty("Host", "be02.bihu.com");
//            connection.setRequestProperty("Connection", "keep-alive");
//            connection.setRequestProperty("Origin", "https://bihu.com");
//            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
//            connection.setRequestProperty("Accept", "*/*");
//            connection.setRequestProperty("Content-Type", "application/json");
//            connection.setRequestProperty("Referer", "https://bihu.com/login");
//            connection.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
//            connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
//            connection.setRequestProperty("Content-Length", "158");
//            connection.setDoOutput(true);
//            OutputStream out = connection.getOutputStream();
//            out.write(postData.getBytes());
//            System.err.println(connection.getResponseCode());
//            System.err.println(connection.getResponseMessage());
//            Map headers = connection.getHeaderFields();
//            Set<String> keys = headers.keySet();
//            for (String key : keys) {
//                String val = connection.getHeaderField(key);
//                System.out.println(key + "    " + val);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public void checkUrl(){

    }
}


