package com.cloudyoung.baic.vo.api.wechat;

import java.io.Serializable;

/**
 * @author 1.0 刘风栓
 */
public class WXBaseResult implements Serializable {

    private Integer errcode;

    private String errmsg;

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
