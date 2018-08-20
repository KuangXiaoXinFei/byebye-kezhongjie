package com.byebye.kzj.webapi.vo.wechat;

/**
 * @author 1.0 刘风栓
 */
public class WeChatConstant {

    public static final String CACHE_WX_ACCESS_TOKEN = "WX_ACCESS_TOKEN_";

    public static final String CACHE_WX_JSAPI_TICKET = "WX_JSAPI_TICKET_";

    public static final String GET_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";

    public static final String GET_JSAPI_TICKET = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=";

    public static final String POST_WXACODE_UNLIMIT = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=";

    public static final String POST_MSG_SEC_CHECK = "https://api.weixin.qq.com/wxa/msg_sec_check?access_token=";

}
