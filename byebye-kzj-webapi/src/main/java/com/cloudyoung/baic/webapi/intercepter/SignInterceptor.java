package com.cloudyoung.baic.webapi.intercepter;

import com.alibaba.fastjson.JSON;
import com.cloudyoung.baic.common.utils.JsonUtils;
import com.cloudyoung.baic.common.utils.LogUtils;
import com.cloudyoung.baic.service.apiservice.UserTokenService;
import com.cloudyoung.baic.model.UserToken;
import com.cloudyoung.baic.webapi.config.InterceptorConfig;
import com.cloudyoung.baic.webapi.redis.UserTokenRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SignInterceptor implements HandlerInterceptor {

    private static LogUtils log = LogUtils.build(InterceptorConfig.class);

    @Autowired
    private UserTokenService userTokenService;

    @Autowired
    private UserTokenRedisService userTokenRedisService;

    /**
     * 进入controller层之前拦截请求
     *
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            String baseJson = request.getHeader("UA");
            String token = request.getHeader("token");
            String sign = request.getHeader("sign");
            log.info("SignInterceptor.preHandle",request.getRequestedSessionId(),"签名验证拦截",baseJson,token, sign);
            token = token == null ? "" : token;
            sign = sign == null ? "" : sign;

            if (baseJson == null || baseJson.isEmpty()) {
                //缺少参数
                request.getRequestDispatcher("/baic/v1/error/parameter").forward(request, response);
                return false;
            }
            HashMap baseParam = JsonUtils.parseObject(baseJson, HashMap.class);
            if (baseParam == null || baseParam.isEmpty()) {
                //缺少参数
                request.getRequestDispatcher("/baic/v1/error/parameter").forward(request, response);
                return false;
            }
            ////token 是否过期
//            if (token != null && !token.isEmpty()) {
//                boolean isExpired = this.isExpiredForToken(token);
//                if (isExpired) {
//                    //缺少参数
//                    request.getRequestDispatcher("/baic/v1/error/token").forward(
//                            request, response);
//                    return false;
//                }
//            }

            Map bodyMap = getParameterMap(request);
            log.info("SignInterceptor.preHandle","请求参数body", JSON.toJSON(bodyMap));
            //TODO server_token 这里如果登陆用户则拿登陆用户的token，若未登陆用户则直接拿前端给的时间戳
            if (bodyMap != null && !bodyMap.isEmpty()) {
                // HashMap bodyParam = JsonUtils.parseObject(bodyJson, HashMap.class);
                baseParam.putAll(bodyMap);
                // return true;
            }
            //TODO 临时不验签
            if (SignValidator.verify(baseParam, sign, token)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            //缺少参数
            request.getRequestDispatcher("/baic/v1/error/net").forward(request, response);
            return false;
        }
        request.getRequestDispatcher("/baic/v1/error/sign").forward(request, response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        log.info("postHandle", httpServletRequest.getRequestedSessionId(), "--------------处理请求完成后视图渲染之前的处理操作---------------");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        log.info("afterCompletion", httpServletRequest.getRequestedSessionId(), "---------------视图渲染之后的操作-------------------------0");
    }

    private Map<String, String> getParameterMap(HttpServletRequest request) {
        // 参数Map
        Map<String, String[]> properties = request.getParameterMap();
        // 返回值Map
        Map<String, String> returnMap = new HashMap<String, String>();
        Iterator entries = properties.entrySet().iterator();
        Map.Entry entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if (null == valueObj) {
                value = "";
            } else if (valueObj instanceof String[]) {
                String[] values = (String[]) valueObj;
                value = String.join(",", values);
            } else {
                value = valueObj.toString();
            }
            returnMap.put(name, value);
        }
        return returnMap;
    }

    ////判定用户token 是否过期
    private boolean isExpiredForToken(String token) {
        UserToken userToken = null;
        //region userToken缓存、数据库查询
        userToken = userTokenRedisService.getUserTokenFromRedis(token);
        if (userToken != null) {
            if (userToken.getExpireTime().getTime() > System.currentTimeMillis()) {
                userTokenRedisService.cleanUserTokenCache(token);
                return true;
            } else {
                return false;
            }
        }
        userToken = userTokenService.getByToken(token);
        if (userToken == null) {
            return true;
        }
        if (userToken.getExpireTime().getTime() > System.currentTimeMillis()) {
            return true;
        }

        userTokenRedisService.setUserTokenToRedis(userToken);
        return false;
    }
}