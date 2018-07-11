package com.example.master.myappstu.utils;

import android.os.Handler;
import android.os.Message;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by master on 2017/11/4.
 */

public class HttpUtil {

    public void doPost(final String url, final Handler handler, final String jsondata) {


        new Thread(new Runnable() {
            @Override
            public void run() {
                String ip = "http://10.16.112.186/" + url;
                try {
                    //打开链接
                    HttpURLConnection conn = (HttpURLConnection) new URL(ip).openConnection();
                    //设置响应时间
                    conn.setReadTimeout(5000);
                    //设置请求的方法
                    conn.setRequestMethod("POST");
                    //设置连接时间
                    conn.setConnectTimeout(5000);
                    //设置输入流
                    conn.setDoInput(true);
                    conn.setDoOutput(true);
                    //设置不允许缓存
                    conn.setAllowUserInteraction(false);
                    conn.setRequestProperty("Content-Type", "application/json");
                    //传输请求的参数
                    OutputStream out = conn.getOutputStream();
                    out.write(jsondata.getBytes());
                    if (conn.getResponseCode() == 200) {
                        InputStream is = conn.getInputStream();
                        ByteArrayOutputStream message = new ByteArrayOutputStream();
                        int len = 0;
                        byte buffer[] = new byte[1024];
                        while ((len = is.read(buffer)) != -1) {
                            message.write(buffer, 0, len);
                        }
                        is.close();
                        message.close();
                        String Msgis = new String(message.toByteArray());
                        Message msg = Message.obtain();
                        msg.obj = Msgis;
                        handler.sendMessage(msg);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public void doGet(final String url, final Handler handler) {
        new Thread(new Runnable() {
            String ip = "http://10.16.112.186/" + url;

            @Override
            public void run() {
                try {
                    //打开链接
                    HttpURLConnection conn = (HttpURLConnection) new URL(ip).openConnection();
                    //设置响应时间
                    conn.setReadTimeout(5000);
                    //设置请求的方法
                    conn.setRequestMethod("GET");
                    //设置连接时间
                    conn.setConnectTimeout(5000);
                    //设置输入流
                    conn.setDoInput(true);
                    conn.setDoOutput(true);
                    //设置不允许缓存
                    conn.setAllowUserInteraction(false);
                    conn.setRequestProperty("Content-Type", "application/json");
                    //传输请求的参数

                    if (conn.getResponseCode() == 200) {
                        InputStream is = conn.getInputStream();
                        ByteArrayOutputStream message = new ByteArrayOutputStream();
                        int len = 0;
                        byte buffer[] = new byte[1024];
                        while ((len = is.read(buffer)) != -1) {
                            message.write(buffer, 0, len);
                        }
                        is.close();
                        message.close();
                        String Msgis = new String(message.toByteArray());
                        Message msg = Message.obtain();
                        msg.obj = Msgis;
                        handler.sendMessage(msg);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }).start();
    }

    public void Post(final String url,  final String jsondata) {


        new Thread(new Runnable() {
            @Override
            public void run() {
                String ip = "http://10.16.112.186/" + url;
                try {
                    //打开链接
                    HttpURLConnection conn = (HttpURLConnection) new URL(ip).openConnection();
                    //设置响应时间
                    conn.setReadTimeout(5000);
                    //设置请求的方法
                    conn.setRequestMethod("POST");
                    //设置连接时间
                    conn.setConnectTimeout(5000);
                    //设置输入流
                    conn.setDoInput(true);
                    conn.setDoOutput(true);
                    //设置不允许缓存
                    conn.setAllowUserInteraction(false);
                    conn.setRequestProperty("Content-Type", "application/json");
                    //传输请求的参数
                    OutputStream out = conn.getOutputStream();
                    out.write(jsondata.getBytes());
                    if (conn.getResponseCode() == 200) {

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

}
