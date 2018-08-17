package com.cloudyoung.baic.webapi.redis;


import com.cloudyoung.baic.model.UserInfo;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/11 16:05  by  侯春春（houcc@cloud-young.com）创建
 */
public interface UserInfoRedisService {
    UserInfo getUserFromRedis(Integer id);

    void setUserToRedis(UserInfo user);

    void cleanCache(Integer id);
}
