package com.byebye.kzj.vo.api.wechat;

import java.io.Serializable;

/**
 * @author 1.0 刘风栓
 */
public class WxJsApiTicketResult extends WXBaseResult implements Serializable {

    private String ticket;

    private Integer expires_in;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }
}
