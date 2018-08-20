package com.byebye.kzj.webapi.redis;

import com.byebye.kzj.model.UserToken;
import com.cloudyoung.common.tools.redis.RedissonTemplete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/12 17:01  by  侯春春（houcc@cloud-young.com）创建
 */
@Service("userTokenRedisService")
public class UserTokenRedisServiceImpl implements UserTokenRedisService {

    @Autowired
    private RedissonTemplete redissonTemplete;

    @Override
    public void setUserTokenToRedis(UserToken usertoken) {
        //redissonTemplete.set(getUserTokenRedisKey(usertoken.getToken()), usertoken, 6, TimeUnit.HOURS);
        redissonTemplete.set(getUserTokenRedisKey(usertoken.getToken()), usertoken, 7, TimeUnit.DAYS);
    }

    @Override
    public UserToken getUserTokenFromRedis(String token) {
        try {
            UserToken user = (UserToken) redissonTemplete.get(getUserTokenRedisKey(token));
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void cleanUserTokenCache(String token) {
        if (null == token) {
            return;
        }
        redissonTemplete.del(getUserTokenRedisKey(token));
    }

    private String getUserTokenRedisKey(String token) {
        return String.format("baic_user_token_%s", token);
    }
}
