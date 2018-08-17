package com.cloudyoung.baic.service.adminservice;



import com.cloudyoung.baic.common.model.Result;

import java.io.InputStream;

public interface CosService {

    /**
     * 上传文件到腾讯云
     *
     * @param fileName
     * @param contentType
     * @param sessionId
     * @param inputStream
     * @return
     * @author 郗世豪（xish@cloudyoung.com）
     * @date 04/27/2018
     * @version 1.0
     */
    Result<String> uploadFileByStream(String fileName, String contentType, String sessionId, InputStream inputStream);

    /**
     * 上传文件到腾讯云
     *
     * @param fileName
     * @param contentType
     * @param data
     * @param sessionId
     * @return
     * @author 郗世豪（xish@cloudyoung.com）
     * @date 04/27/2018
     * @version 1.0
     */
    Result<String> uploadFileByBytes(String fileName, String contentType, byte[] data, String sessionId);
}
