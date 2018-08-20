package com.byebye.kzj.common.utils;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/**
 * 腾讯云上传工具类
 */
public class CosFileUtils implements Closeable {


    private String bucketName;
    COSClient cosClient;

    public CosFileUtils(String accessKey, String secretKey, String bucketName) {
        this(accessKey, secretKey, bucketName, "ap-beijing");
    }

    public CosFileUtils(String accessKey, String secretKey, String bucketName, String region) {
        this(accessKey, secretKey, bucketName, region, 1024, 120000);
    }

    public CosFileUtils(String accessKey, String secretKey, String bucketName, String region, Integer maxConnections,
                        Integer socketTimeout) {
        this.bucketName = bucketName;
        initCosClient(accessKey, secretKey, region, maxConnections, socketTimeout);
    }

    private static LogUtils logger = LogUtils.build(CosFileUtils.class);

    /**
     * 从url下载，并将文件上传到腾讯云
     *
     * @param url       网络文件地址
     * @param sessionId
     * @return
     */
    public String uploadFile(String url, String sessionId) {

        return uploadFile(url, sessionId, key -> {

            HttpGet httpGet = new HttpGet(url);
            HttpClient client = HttpClients.createDefault();
            HttpResponse response = client.execute(httpGet);
            HttpEntity httpEntity = response.getEntity();

            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(httpEntity.getContentLength());
            metadata.setContentType(httpEntity.getContentType().getValue());
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, httpEntity.getContent(), metadata);

            return putObjectRequest;
        });
    }

    /**
     * 从 byte[] 上传文件到腾讯云
     *
     * @param fileName    文件名
     * @param contentType 类型
     * @param data        上传数据
     * @param sessionId
     * @return
     */
    public String uploadFile(String fileName, String contentType, byte[] data, String sessionId) {

        return uploadFile(fileName, sessionId, key -> {

            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(contentType);
            metadata.setContentLength(data.length);

            // 防止上传失败后流被关闭,无法重试
            InputStream stream = new ByteArrayInputStream(data);
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, stream, metadata);

            return putObjectRequest;
        });
    }




    /**
     * 上传文件
     *
     * @param fileName  文件名
     * @param sessionId
     * @param function
     * @return
     */
    private String uploadFile(String fileName, String sessionId, CustomFunction<String, PutObjectRequest> function) {

        try {
            long start = System.currentTimeMillis();
            // 指定要上传到 COS 上的路径
            String key = java.util.UUID.randomUUID().toString() + getSuffix(fileName);
            PutObjectRequest putObjectRequest = function.apply(key);
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);

            long end = System.currentTimeMillis();
            return key;
        } catch (Exception e) {
            logger.error("uploadFile", sessionId, "文件上传异常", e);
        }
        return null;
    }

    private void initCosClient(String accessKey, String secretKey, String region, int maxConnections, int socketTimeout) {

        // 1 初始化用户身份信息(secretId, CosConfig.getSecretKey())
        COSCredentials cred = new BasicCOSCredentials(accessKey, secretKey);
        // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(new Region(region));
        clientConfig.setMaxConnectionsCount(maxConnections);
        clientConfig.setSocketTimeout(socketTimeout);
        // 3 生成cos客户端
        cosClient = new COSClient(cred, clientConfig);
    }

    /**
     * 获取后缀名
     *
     * @param url
     * @return
     */
    private String getSuffix(String url) {
        String path = url.split("\\?")[0];
        String[] pathSplit = path.split("\\\\|/");
        path = pathSplit[pathSplit.length - 1];
        int lastIndex;
        if ((lastIndex = path.lastIndexOf('.')) == -1) {
            return "";
        }
        String suffix = path.substring(lastIndex);
        return suffix;
    }

    @Override
    public void close() throws IOException {
        if (cosClient != null) {
            cosClient.shutdown();
        }
    }
}

