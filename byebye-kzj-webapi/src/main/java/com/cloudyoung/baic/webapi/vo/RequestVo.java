package com.cloudyoung.baic.webapi.vo;

import java.io.Serializable;

public class RequestVo<T> implements Serializable {
    private BaseVo base;
    private T bodyVo;

    private String token;

    public BaseVo getBase() {
        return base;
    }

    public void setBase(BaseVo base) {
        this.base = base;
    }

    public T getBodyVo() {
        return bodyVo;
    }

    public void setBodyVo(T bodyVo) {
        this.bodyVo = bodyVo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}