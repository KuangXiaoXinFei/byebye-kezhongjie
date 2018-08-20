package com.byebye.kzj.webapi.redis;

import com.byebye.kzj.model.UserInfo;
import com.cloudyoung.common.tools.redis.RedissonTemplete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/11 16:06  by  侯春春（houcc@cloud-young.com）创建
 */
@Service("userInfoRedisService")
public class UserInfoRedisServiceImpl implements UserInfoRedisService {
    @Autowired
    private RedissonTemplete redissonTemplete;

    @Override
    public UserInfo getUserFromRedis(Integer id) {
        try {
            UserInfo user = (UserInfo) redissonTemplete.get(getUserInfoRedisKey(id));
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void setUserToRedis(UserInfo user) {
        redissonTemplete.set(getUserInfoRedisKey(user.getUserId()), user, 6, TimeUnit.HOURS);
    }

    @Override
    public void cleanCache(Integer id) {
        if (null == id) {
            return;
        }
        redissonTemplete.del(getUserInfoRedisKey(id));
    }

    private String getUserInfoRedisKey(Integer id) {
        return String.format("baic_user_info_%s", id);
    }
}
