package com.byebye.kzj.webapi.util;

import com.alibaba.fastjson.JSON;
import com.byebye.kzj.common.utils.HttpUtils;
import com.byebye.kzj.common.utils.LogUtils;
import com.byebye.kzj.webapi.vo.wechat.AccessTokenResult;
import com.byebye.kzj.webapi.vo.wechat.WeChatConstant;
import com.byebye.kzj.webapi.vo.wechat.WxJsApiTicketResult;
import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Description:
 *
 * @author 1.0  17/12/8 刘风栓（liufs@cloud-young.com）
 */
public class WechatUtil {

    private static final LogUtils logUtil = LogUtils.build(WechatUtil.class);

    public static AccessTokenResult getAccessTokenByAppId(String appId, String appSecret) {
        String url = new StringBuilder(WeChatConstant.GET_ACCESS_TOKEN)
                .append("&appid=").append(appId).append("&secret=").append(appSecret).toString();
        String responseResult = HttpUtils.get(url, null);
        logUtil.info("WechatUtil.getAccessTokenByAppId", null, "获取Token", responseResult, appId, appSecret);
        if (StringUtils.isNotEmpty(responseResult)) {
            AccessTokenResult accessTokenResult = JSON.parseObject(responseResult, AccessTokenResult.class);
            if (null != accessTokenResult) {
                return accessTokenResult;
            }
        }
        return null;
    }

    public static WxJsApiTicketResult getJsApiTicketByAccessToken(String accessToken) {
        String url = new StringBuilder(WeChatConstant.GET_JSAPI_TICKET).append(accessToken).append("&type=jsapi").toString();
        String responseResult = HttpUtils.get(url, null);
        logUtil.info("WechatUtil.getJsApiTicketByAccessToken", null, "获取jsapi_ticket", responseResult, accessToken);
        if (StringUtils.isNotEmpty(responseResult)) {
            WxJsApiTicketResult jsApiTicketResult = JSON.parseObject(responseResult, WxJsApiTicketResult.class);
            if (null != jsApiTicketResult) {
                return jsApiTicketResult;
            }
        }
        return null;
    }


    /**
     * JS-SDK使用权限签名
     * 返回map map的keys:url,jsapi_ticket,nonceStr,timestamp,signature
     *
     * @return map
     * @author 2017-12-08 下午3:44 by 刘风栓(liufs@cloud-young.com)
     */
    public static Map<String, String> getJsSdkSign(String jsapiTicket, String url) {
        Map<String, String> ret = new HashMap<String, String>();
        String nonce_str = create_nonce_str();
        String timestamp = create_timestamp();
        String string1;
        String signature = "";

        //注意这里参数名必须全部小写，且必须有序
        string1 = "jsapi_ticket=" + jsapiTicket +
                "&noncestr=" + nonce_str +
                "&timestamp=" + timestamp +
                "&url=" + url;
        System.out.println(string1);

        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        ret.put("url", url);
        ret.put("jsapi_ticket", jsapiTicket);
        ret.put("nonceStr", nonce_str);
        ret.put("timestamp", timestamp);
        ret.put("signature", signature);

        return ret;
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    private static String create_nonce_str() {
        return UUID.randomUUID().toString();
    }

    private static String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }
}