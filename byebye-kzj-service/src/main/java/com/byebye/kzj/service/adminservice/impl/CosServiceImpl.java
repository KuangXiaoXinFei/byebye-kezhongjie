package com.byebye.kzj.service.adminservice.impl;

import com.byebye.kzj.common.utils.CosFileUtils;
import com.byebye.kzj.common.utils.LogUtils;
import com.byebye.kzj.common.utils.StringUtils;
import com.byebye.kzj.service.contants.COSProperties;
import com.byebye.kzj.service.adminservice.CosService;
import com.byebye.kzj.common.model.Result;
import com.byebye.kzj.constant.OperationConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0 2018/05/03 11:22 郗世豪（xish@cloudyoung.com）
 */
@Service("cosService")
public class CosServiceImpl implements CosService {

    private static LogUtils logger = LogUtils.build(CosServiceImpl.class);

    private CosFileUtils cosFileUtils;

    @Autowired
    COSProperties cosProperties;

    @Autowired
    CosService cosService;

    @Autowired
    public CosServiceImpl(COSProperties cosProperties) {
        cosFileUtils = new CosFileUtils(cosProperties.getAccessKey(), cosProperties.getSecretKey(), cosProperties.getBucketName(), cosProperties.getRegion());
    }

    @Override
    public Result<String> uploadFileByStream(String fileName, String contentType, String sessionId, InputStream inputStream) {

        if (inputStream == null) {
            return new Result<>(OperationConstants.NOT_NULL.getCode(), "输入流不能为空！");
        }

        byte[] data = input2byte(inputStream);
        Map<String, Object> inArgs = new HashMap<String, Object>();
        inArgs.put("fileName", fileName);
        inArgs.put("contentType", contentType);
        logger.info("uploadFile", sessionId, "文件上传开始", inArgs);

        String returnUrl = cosFileUtils.uploadFile(fileName, contentType, data, sessionId);
        if (StringUtils.isEmpty(returnUrl)) {
            //上传第一次失败
            logger.warn("uploadFile", sessionId, "文件上传第一次失败，开始进行第二次！");
            returnUrl = cosFileUtils.uploadFile(fileName, contentType, data, sessionId);
        }
        if (StringUtils.isEmpty(returnUrl)) {
            //上传第二次失败
            logger.warn("uploadFile", sessionId, "文件上传第二次失败，开始进行第三次！");
            returnUrl = cosFileUtils.uploadFile(fileName, contentType, data, sessionId);
        }
        if (StringUtils.isEmpty(returnUrl)) {
            //上传第三次失败
            logger.warn("uploadFile", sessionId, "文件上传第三次失败，提示失败！");
            return new Result(OperationConstants.UPLOAD_FILE_FAILED);
        }

        Map<String, Object> outArgs = new HashMap<String, Object>();
        outArgs.put("returnUrl", returnUrl);
        outArgs.put("fileName", fileName);
        outArgs.put("contentType", contentType);

        logger.info("uploadFile", sessionId, "文件上传结束", outArgs);
        returnUrl = getUrl(returnUrl);
        return new Result<>(returnUrl);
    }

    @Override
    public Result<String> uploadFileByBytes(String fileName, String contentType, byte[] data, String sessionId) {

        if (data == null || data.length == 0) {
            return new Result<>(OperationConstants.NOT_NULL.getCode(), "输入流不能为空！");
        }

        Map<String, Object> inArgs = new HashMap<String, Object>();
        inArgs.put("fileName", fileName);
        inArgs.put("contentType", contentType);

        logger.info("uploadFile", sessionId, "文件上传开始", inArgs);

        String returnUrl = cosFileUtils.uploadFile(fileName, contentType, data, sessionId);
        if (StringUtils.isEmpty(returnUrl)) {
            //上传第一次失败
            logger.warn("uploadFile", sessionId, "文件上传第一次失败，开始进行第二次！");
            returnUrl = cosFileUtils.uploadFile(fileName, contentType, data, sessionId);
        }
        if (StringUtils.isEmpty(returnUrl)) {
            //上传第二次失败
            logger.warn("uploadFile", sessionId, "文件上传第二次失败，开始进行第三次！");
            returnUrl = cosFileUtils.uploadFile(fileName, contentType, data, sessionId);
        }
        if (StringUtils.isEmpty(returnUrl)) {
            //上传第三次失败
            logger.warn("uploadFile", sessionId, "文件上传第三次失败，提示失败！");
            return new Result(OperationConstants.UPLOAD_FILE_FAILED);
        }

        Map<String, Object> outArgs = new HashMap<String, Object>();
        outArgs.put("returnUrl", returnUrl);
        outArgs.put("fileName", fileName);
        outArgs.put("contentType", contentType);

        logger.info("uploadFile", sessionId, "文件上传结束", outArgs);
        returnUrl = getUrl(returnUrl);
        return new Result<>(returnUrl);
    }

    public static final byte[] input2byte(InputStream inStream) {

        byte[] buff = new byte[100];
        int rc;
        byte[] in2b = null;
        try (ByteArrayOutputStream swapStream = new ByteArrayOutputStream()) {
            while ((rc = inStream.read(buff, 0, 100)) > 0) {
                swapStream.write(buff, 0, rc);
            }
            in2b = swapStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return in2b;
    }

    public String getUrl(String key) {
        return cosProperties.getUrlPrefix().endsWith("/")
                ? cosProperties.getUrlPrefix() + key
                : cosProperties.getUrlPrefix() + "/" + key;
    }
}
