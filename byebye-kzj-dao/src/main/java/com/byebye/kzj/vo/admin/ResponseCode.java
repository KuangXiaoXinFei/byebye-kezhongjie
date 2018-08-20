//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.byebye.kzj.vo.admin;

public enum ResponseCode {
    OK(200, "OK"),
    ERROR(-1, "ERROR"),
    MISS_PARAM(1001, "缺少必要参数"),
    TOKEN_ERROR(1002, "请重新登录"),
    FAIL_NETWORK(9000, "网络繁忙请稍后再试");


    private String msg;
    private int code;

    private ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getCode() {
        return this.code;
    }

    public ResponseCode setMsg(String msg) {
        this.msg = msg;
        return this;
    }
    }
