package com.cloudyoung.baic.webapi.redis;

import org.springframework.stereotype.Service;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/7/12 16:49  by  侯春春（houcc@cloud-young.com）创建
 */
@Service("wxUserRedisService")
public class WxUserRedisServiceImpl implements WxUserRedisService{
//    //通过token获取
//
//    @Autowired
//    private RedissonTemplete redissonTemplete;
//
//    @Override
//    public void setToRedis(WxUserLogin user) {
//        redissonTemplete.set(getWxUserRedisKey(user.getacc()), user, 6, TimeUnit.HOURS);
//    }
//
//    private String getWxUserRedisKey(Integer id) {
//        return String.format("baic_wxuser_%s", id);
//    }
}
