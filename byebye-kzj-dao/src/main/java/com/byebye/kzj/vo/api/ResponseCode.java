//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.byebye.kzj.vo.api;

public enum ResponseCode {
    OK(200, "OK"),
    ERROR(-1, "ERROR"),
    SIGN_ERROR(1000, "签名错误"),
    MISS_PARAM(1001, "缺少必要参数"),
    TOKEN_ERROR(1002, "请重新登录"),
    PARAM_ERROR(1003,"参数传递有误"),
    UPLOAD_QQCLOUD(1004,"上传腾讯云错误"),
    FAIL_NETWORK(6000, "网络繁忙请稍后再试"),
    NOT_EXIST(6001, "内容不存在"),
    NO_TALK(6002, "已禁言"),
    MOBILE_USED(6003, "手机号已使用过"),
    OPENID_USED(6004, "微信号已使用"),
    USERNAME_USED(6005, "用户名已使用过"),
    MOBILE_CHANGE_SAME(6006, "变更后手机号和之前相同"),
    VIN_SCAN_ERROR(6007, "VIN码没有识别出来"),
    VIN_CARINFO_ERROR(6008,"获取不到车的信息"),
    VIN_VIALIDATE_ERROR(6009,"VIN验证错误"),
    NO_COORDINATE(6010,"未获取到坐标"),
    VIN_NOTEXIT_ERROR(6011,"VIN码不存在"),
    SMS_VIALIDATE_TIMEOUT(6012,"验证码过期"),
    SMS_SEND_ERROR(6013,"短信发送失败"),
    SYSTEM_ERROR(6014,"系统错误，请稍后重试"),
    SMS_VIALIDATE_ERROR(6015,"验证码输入有误");

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
