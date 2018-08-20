//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.byebye.kzj.vo.admin;

import java.io.Serializable;

public class ResponseVo<T> implements Serializable {
    protected int code = 200;
    protected String msg = "OK";
    protected T data;

    public ResponseVo() {
    }


    public static ResponseVo getInstance() {
        return new ResponseVo();
    }

    public static <T> ResponseVo<T> getInstance(ResponseCode resCode) {
        ResponseVo vo = new ResponseVo();
        vo.code = resCode.getCode();
        vo.msg = resCode.getMsg();
        return vo;
    }

    public static <T> ResponseVo<T> getInstanceForOk(T data) {
        ResponseVo vo = new ResponseVo();
        vo.data = data;
        return vo;
    }

    public static <T> ResponseVo<T> getInstanceForError(int code, String message) {
        return getInstance(code, message, null);
    }

    public static <T> ResponseVo<T> getInstanceForError(String codeStr, String message) {
        int code = -1;

        try {
            code = Integer.valueOf(codeStr).intValue();
        } catch (NumberFormatException var4) {
            ;
        }

        return getInstance(code, message, null);
    }

    public static <T> ResponseVo<T> getInstanceForError(String message) {
        return getInstance(ResponseCode.ERROR.setMsg(message));
    }

    public static <T> ResponseVo<T> getInstanceForError(String message, T data) {
        return getInstance(ResponseCode.ERROR.setMsg(message), data);
    }

    public static <T> ResponseVo<T> getInstance(ResponseCode resCode, T data) {
        return getInstance(resCode.getCode(), resCode.getMsg(), data);
    }

    public static <T> ResponseVo<T> getInstance(String codeStr, String msg, T data) {
        int code = -1;

        try {
            code = Integer.valueOf(codeStr).intValue();
        } catch (NumberFormatException var5) {
            ;
        }

        return getInstance(code, msg, data);
    }

    public static <T> ResponseVo<T> getInstance(int code, String msg, T data) {
        ResponseVo vo = new ResponseVo();
        vo.code = code;
        vo.msg = msg;
        vo.data = data;
        return vo;
    }

    public void setResCode(ResponseCode resCode) {
        this.code = resCode.getCode();
        this.msg = resCode.getMsg();
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
