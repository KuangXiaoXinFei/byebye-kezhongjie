package com.byebye.kzj.webapi.redis;


import com.byebye.kzj.model.UserToken;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/12 17:01  by  侯春春（houcc@cloud-young.com）创建
 */
public interface UserTokenRedisService {
    void setUserTokenToRedis(UserToken usertoken);

    UserToken getUserTokenFromRedis(String token);

    void cleanUserTokenCache(String token);
}
