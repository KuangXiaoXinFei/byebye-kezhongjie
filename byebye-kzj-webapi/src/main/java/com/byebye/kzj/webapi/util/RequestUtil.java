package com.byebye.kzj.webapi.util;


import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2017/9/27 15:03  by  侯春春（houcc@cloud-young.com）创建
 */
public class RequestUtil {
    /**
     * Description: paraMap中可放String 数字类型。Date类型转成字符串再放入，否则请求时格式不能保证。
     * All Rights Reserved.
     */
    public static <X, Y> String downloadString(String uri, String encoding, int timeout, String httpActionType, Map<X, Y> paraMap) {
        StringBuilder paramBuilder = new StringBuilder();
        int tag = 0;
        for (Map.Entry<X, Y> entry : paraMap.entrySet()) {
            X x = entry.getKey();
            Y y = entry.getValue();
            if (tag == 0) {
                paramBuilder.append(x + "=" + y);
            } else {
                paramBuilder.append("&" + x + "=" + y);
            }
            tag++;
        }
        return downloadString(uri, encoding, timeout, httpActionType, paramBuilder.toString());
    }

    public static String downloadString(String uri, String encoding, int timeout, String httpActionType, String postParameter) {
        encoding = encoding == null ? "UTF-8" : encoding;
        HttpURLConnection httpURLConnection = null;
        try {
            URL url = new URL(uri);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(timeout);
            httpURLConnection.setReadTimeout(timeout);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.addRequestProperty("cache-control", "no-cache");

            if (httpActionType.toUpperCase().equals("GET")) {
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.connect();
            } else {
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.addRequestProperty("Content-type", "application/x-www-form-urlencoded");

                if (postParameter != null) {
                    try (PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), encoding))) {
                        printWriter.print(postParameter);
                        printWriter.flush();
                    }
                }
            }

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), encoding));

            String line = null;
            StringBuilder stringBuilder = new StringBuilder();
            try (BufferedReader b = bufferedReader;) {
                while ((line = b.readLine()) != null) {
                    stringBuilder.append(line);
                }
            }


            return stringBuilder.toString();

        } catch (Exception err) {
            throw new RuntimeException(err);
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }

    public static String getRequestString(HttpServletRequest request) {
        Map<String, String> requestMap = null;

        StringBuffer total = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                total.append(line);
            }
        } catch (Exception err) {
            throw new RuntimeException(err);
        }

        return total.toString();
    }
}
