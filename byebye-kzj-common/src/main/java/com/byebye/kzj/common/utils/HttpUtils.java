package com.byebye.kzj.common.utils;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author 李美根（limg@cloud-young.com）创建
 * @date 1.0  2018/7/5 11:43
 */
public class HttpUtils {

    private static LogUtils logger = LogUtils.build(HttpUtils.class);

    /**
     * @Descpription: 简单发送Post请求
     * @author    李美根（limg@cloud-young.com）创建
     * @version 1.0  2018/7/5 11:54
     * @param
     * @return
     */
    public static String post(String url, Map<String, String> params) {
        return execute(url, params, null, null, HttpPost.METHOD_NAME);
    }

    /**
     * @Descpription: post传递参数+head头信息
     * @author    李美根（limg@cloud-young.com）创建
     * @version 1.0  2018/7/20 16:25
     * @param   
     * @return
     */ 
    public static String postHeader(String url,Map<String,String> params,Map<String,String> header){
        return execute(url, params, header, null, HttpPost.METHOD_NAME);
    }


    /**
     * @Descpription: 简单发送Get请求
     * @author    李美根（limg@cloud-young.com）创建
     * @version 1.0  2018/7/6 17:25
     * @param
     * @return
     */
    public static String get(String url, Map<String, String> params) {
        return execute(url, params, null, null, HttpGet.METHOD_NAME);
    }

    
    /**
     * @Descpription: 通过隐藏Head传递数据
     * @author    李美根（limg@cloud-young.com）创建
     * @version 1.0  2018/7/11 17:18
     * @param   
     * @return
     */ 
    public static String getByHeader(String url,Map<String,String> header){
        return execute(url,null,header,null,HttpGet.METHOD_NAME);
    }

    /**
     * @Descpription:  通过post请求隐藏HEAD变量
     * @author    李美根（limg@cloud-young.com）创建
     * @version 1.0  2018/7/17 14:41   
     * @param   
     * @return
     */ 
    public static String getPostBody(String url,Map<String,String> header,String body){
        return execute(url,null,header,body,HttpPost.METHOD_NAME);
    }


    private static String execute(String url, Map<String, String> params, Map<String, String> headers, String body, String method) {
        CloseableHttpClient httpClient = null;
        httpClient = HttpClients.createDefault();
        try {
            RequestBuilder builder = null;
            if (HttpGet.METHOD_NAME.equals(method)) {
                builder = RequestBuilder.get();
            } else if (HttpPost.METHOD_NAME.equals(method)) {
                builder = RequestBuilder.post();
            } else if (HttpDelete.METHOD_NAME.equals(method)) {
                builder = RequestBuilder.delete();
            } else if (HttpPut.METHOD_NAME.equals(method)) {
                builder = RequestBuilder.put();
            }
            builder.setUri(url);
            if (null != headers && !headers.isEmpty()) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    builder.addHeader(entry.getKey(), entry.getValue());
                }
            }
            if (null != params && !params.isEmpty()) {
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    builder.addParameter(entry.getKey(), entry.getValue());
                }
            }
            if (null != body) {
                builder.setEntity(new StringEntity(body, "UTF-8"));
            }
            CloseableHttpResponse response = httpClient.execute(builder.build());
            int statusCode = response.getStatusLine().getStatusCode();
            if (HttpStatus.SC_OK == statusCode) {
                HttpEntity entity = response.getEntity();
                String result = EntityUtils.toString(entity);
                return result;
            } else {
                logger.error("httpUitls execute url:{}, 出现问题：{}", url, response.getStatusLine().toString());
            }
        } catch (Exception e) {
            logger.error("httpUitls execute 出现异常 ","",e);
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
            }
        }
        return null;
    }


    /**
     * Post String
     *
     * @param host
     * @param path
     * @param method
     * @param headers
     * @param querys
     * @param body
     * @return
     * @throws Exception
     */
    public static HttpResponse doPost(String host, String path, String method,
                                      Map<String, String> headers,
                                      Map<String, String> querys,
                                      String body)
            throws Exception {
        HttpClient httpClient = wrapClient(host);
        HttpPost request = new HttpPost(buildUrl(host, path, querys));
        for (Map.Entry<String, String> e : headers.entrySet()) {
            request.addHeader(e.getKey(), e.getValue());
        }
        if (!StringUtils.isBlank(body)) {
            request.setEntity(new StringEntity(body, "utf-8"));
        }
        return httpClient.execute(request);
    }


    /**
     * post form
     *
     * @param host
     * @param path
     * @param method
     * @param headers
     * @param querys
     * @param bodys
     * @return
     * @throws Exception
     */
    public static HttpResponse doPost(String host, String path, String method,
                                      Map<String, String> headers,
                                      Map<String, String> querys,
                                      Map<String, String> bodys)
            throws Exception {
        HttpClient httpClient = wrapClient(host);

        HttpPost request = new HttpPost(buildUrl(host, path, querys));
        for (Map.Entry<String, String> e : headers.entrySet()) {
            request.addHeader(e.getKey(), e.getValue());
        }
        if (bodys != null) {
            List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>();

            for (String key : bodys.keySet()) {
                nameValuePairList.add(new BasicNameValuePair(key, bodys.get(key)));
            }
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(nameValuePairList, "utf-8");
            formEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
            request.setEntity(formEntity);
        }
        return httpClient.execute(request);
    }

    private static HttpClient wrapClient(String host) {
        HttpClient httpClient = new DefaultHttpClient();
        if (host.startsWith("https://")) {
            sslClient(httpClient);
        }
        return httpClient;
    }

    private static void sslClient(HttpClient httpClient) {
        try {
            SSLContext ctx = SSLContext.getInstance("TLS");
            X509TrustManager tm = new X509TrustManager() {
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
                @Override
                public void checkClientTrusted(X509Certificate[] xcs, String str) {

                }
                @Override
                public void checkServerTrusted(X509Certificate[] xcs, String str) {

                }
            };
            ctx.init(null, new TrustManager[] { tm }, null);
            SSLSocketFactory ssf = new SSLSocketFactory(ctx);
            ssf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            ClientConnectionManager ccm = httpClient.getConnectionManager();
            SchemeRegistry registry = ccm.getSchemeRegistry();
            registry.register(new Scheme("https", 443, ssf));
        } catch (KeyManagementException ex) {
            throw new RuntimeException(ex);
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }


    private static String buildUrl(String url, Map<String, String> querys) throws UnsupportedEncodingException {
        StringBuilder sbUrl = new StringBuilder();
        sbUrl.append(url);
        if (null != querys) {
            StringBuilder sbQuery = new StringBuilder();
            for (Map.Entry<String, String> query : querys.entrySet()) {
                if (0 < sbQuery.length()) {
                    sbQuery.append("&");
                }
                if (StringUtils.isBlank(query.getKey()) && !StringUtils.isBlank(query.getValue())) {
                    sbQuery.append(query.getValue());
                }
                if (!StringUtils.isBlank(query.getKey())) {
                    sbQuery.append(query.getKey());
                    if (!StringUtils.isBlank(query.getValue())) {
                        sbQuery.append("=");
                        sbQuery.append(java.net.URLEncoder.encode(query.getValue(), "utf-8"));
                    }
                }
            }
            if (0 < sbQuery.length()) {
                sbUrl.append("?").append(sbQuery);
            }
        }
        return sbUrl.toString();
    }



    private static String buildUrl(String host, String path, Map<String, String> querys) throws UnsupportedEncodingException {
        StringBuilder sbUrl = new StringBuilder();
        sbUrl.append(host);
        if (!StringUtils.isBlank(path)) {
            sbUrl.append(path);
        }
        return buildUrl(sbUrl.toString(),querys);
    }


}
