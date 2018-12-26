package com.jack.utils.http;

import com.jack.BihuException;
import com.jack.url.Urls;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Jack
 */

public class BiHuUrlUtils implements UrlUtils {

    private static BiHuUrlUtils biHuUrlUtils = null;

    private static Map<String,Object> result = new HashMap<>();

    private BiHuUrlUtils() {

    }

    public static BiHuUrlUtils newInstance() {
        if (biHuUrlUtils == null) {
            biHuUrlUtils = new BiHuUrlUtils();
        }
        return biHuUrlUtils;
    }

    public boolean login() {
        InputStream in = null;
        OutputStream out = null;
        StringBuilder builder = new StringBuilder();
        try {
            String postData = "{\"phone\":\"18108084869\",\"password\":\"f9a9bfc3cae2f1075b69f8ea15c6eaaa574c167c479bce6352656472e40ebcc4\",\"crash\":1,\"challenge\":\"b7425438f5afc3df73c73a4c1b0af77a\"}";
            URL url = new URL(Urls.BIHU_LOGIN_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Host", "be02.bihu.com");
            connection.setRequestProperty("Connection", "keep-alive");
            connection.setRequestProperty("Origin", "https://bihu.com");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
            connection.setRequestProperty("Accept", "*/*");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Referer", "https://bihu.com/login");
            connection.setRequestProperty("Accept-Encoding", "deflate, br");
            connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
            connection.setRequestProperty("Content-Length", "158");
            connection.setDoOutput(true);
            out = connection.getOutputStream();
            out.write(postData.getBytes());
            Map headers = connection.getHeaderFields();
            result.put("loginHeader",headers);
            result.put("loginHeaderFields",headers.keySet());
            in = connection.getInputStream();
            BufferedInputStream ins = new BufferedInputStream(in);
            Reader reader = new InputStreamReader(ins);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String data = "";
            while ((data = bufferedReader.readLine()) != null) {
                builder.append(data);
            }
            result.put("loginResponseJson",builder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    public void getPersonalInfo(String securityToken){
        InputStream in = null;
        OutputStream out = null;
        StringBuilder builder = new StringBuilder();
        try {
            URL url = new URL(Urls.BIHU_PERSONAL_INFO);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Host", "be02.bihu.com");
            connection.setRequestProperty("Connection", "keep-alive");
            connection.setRequestProperty("Authorization"," token "+securityToken);
            connection.setRequestProperty("Origin", "https://bihu.com");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
            connection.setRequestProperty("Accept", "*/*");
            connection.setRequestProperty("Referer", "https://bihu.com/login");
            connection.setRequestProperty("Accept-Encoding", "deflate, br");
            connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
            connection.setRequestProperty("Content-Length", "0");
            Map headers = connection.getHeaderFields();
            result.put("PersonalInfoHeader",headers);
            result.put("PersonalInfoHeaderFields",headers.keySet());
            in = connection.getInputStream();
            BufferedInputStream ins = new BufferedInputStream(in);
            Reader reader = new InputStreamReader(ins);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String data = "";
            while ((data = bufferedReader.readLine()) != null) {
                builder.append(data);
            }
            result.put("PersonalInfoResponseJson",builder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String getUrlData(String path) {
        return null;
    }

    public Map<String,Object> getResult(){
        try {
            return result;
        }catch (BihuException e){
            throw new BihuException("返回结果空");
        }

    }
}
