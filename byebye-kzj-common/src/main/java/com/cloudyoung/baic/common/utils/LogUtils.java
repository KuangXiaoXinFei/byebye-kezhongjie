package com.cloudyoung.baic.common.utils;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public class LogUtils {

    private Logger logger;

    public static LogUtils build(Class clazz) {
        return new LogUtils(clazz);
    }

    private LogUtils(Class clazz) {
        logger = LoggerFactory.getLogger(clazz);
    }


    public void debug(String method, String message, Map<String, Object> namedArgs) {
        debug(method, null, message, namedArgs);
    }

    public void debug(String method, String message, Object... args) {
        debug(method, null, message, args);
    }

    public void debug(String method, String sessionId, String message, Map<String, Object> namedArgs) {

        if (logger.isDebugEnabled()) {
            JSONObject msgJson = getMsgJson(method, sessionId, message, namedArgs);
            logger.debug(msgJson.toJSONString());
        }
    }

    public void debug(String method, String sessionId, String message, Object... args) {

        if (logger.isDebugEnabled()) {
            JSONObject msgJson = getMsgJson(method, sessionId, message, args);
            logger.debug(msgJson.toJSONString());
        }
    }


    public void info(String method, String message, Map<String, Object> namedArgs) {
        info(method, null, message, namedArgs);
    }

    public void info(String method, String message, Object... args) {
        info(method, null, message, args);
    }

    public void info(String method, String sessionId, String message, Map<String, Object> namedArgs) {

        if (logger.isInfoEnabled()) {
            JSONObject msgJson = getMsgJson(method, sessionId, message, namedArgs);
            logger.info(msgJson.toJSONString());
        }
    }

    public void info(String method, String sessionId, String message, Object... args) {

        if (logger.isInfoEnabled()) {
            JSONObject msgJson = getMsgJson(method, sessionId, message, args);
            logger.info(msgJson.toJSONString());
        }
    }


    public void warn(String method, String message, Map<String, Object> namedArgs) {
        warn(method, null, message, namedArgs);
    }

    public void warn(String method, String message, Object... args) {
        warn(method, null, message, args);
    }

    public void warn(String method, String sessionId, String message, Map<String, Object> namedArgs) {

        if (logger.isWarnEnabled()) {
            JSONObject msgJson = getMsgJson(method, sessionId, message, namedArgs);
            logger.warn(msgJson.toJSONString());
        }
    }

    public void warn(String method, String sessionId, String message, Object... args) {

        if (logger.isWarnEnabled()) {
            JSONObject msgJson = getMsgJson(method, sessionId, message, args);
            logger.warn(msgJson.toJSONString());
        }
    }


    public void error(String method, String message, Throwable e) {
        error(method, null, message, e);
    }

    public void error(String method, String message, Map<String, Object> namedArgs) {
        error(method, null, message, namedArgs);
    }

    public void error(String method, String message, Object... args) {
        error(method, null, message, args);
    }

    public void error(String method, String sessionId, String message, Throwable e) {
        if (logger.isErrorEnabled()) {
            JSONObject msgJson = getMsgJson(method, sessionId, message);
            logger.error(msgJson.toJSONString(), e);
        }
    }

    public void error(String method, String sessionId, String message, Map<String, Object> namedArgs) {

        if (logger.isErrorEnabled()) {
            JSONObject msgJson = getMsgJson(method, sessionId, message, namedArgs);
            logger.error(msgJson.toJSONString());
        }
    }

    public void error(String method, String sessionId, String message, Object... args) {

        if (logger.isErrorEnabled()) {
            JSONObject msgJson = getMsgJson(method, sessionId, message, args);
            logger.error(msgJson.toJSONString());
        }
    }


    private JSONObject getMsgJson(String method, String sessionId, String message, Map<String, Object> namedArgs) {

        JSONObject msgJson = getMsgJson(method, sessionId, message);
        if (namedArgs != null && !namedArgs.isEmpty()) {
            msgJson.putAll(namedArgs);
        }
        return msgJson;
    }

    private JSONObject getMsgJson(String method, String sessionId, String message, Object... args) {

        JSONObject msgJson = getMsgJson(method, sessionId, message);
        if (args.length > 0) {
            msgJson.put("args", args);
        }
        return msgJson;
    }

    private JSONObject getMsgJson(String method, String sessionId, String message) {

        JSONObject msgJson = new JSONObject(new LinkedHashMap());

        if (!this.isEmpty(sessionId)) {
            msgJson.put("sessionId", sessionId);
        }
        if (!this.isEmpty(method)) {
            msgJson.put("method", method);
        }
        if (!this.isEmpty(message)) {
            msgJson.put("message", message);
        }

        return msgJson;
    }

    private boolean isEmpty(String cs) {
        return cs == null || cs.length() == 0;
    }

    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }

    public boolean isWarnEnabled() {
        return logger.isWarnEnabled();
    }

    public boolean isErrorEnabled() {
        return logger.isErrorEnabled();
    }
}