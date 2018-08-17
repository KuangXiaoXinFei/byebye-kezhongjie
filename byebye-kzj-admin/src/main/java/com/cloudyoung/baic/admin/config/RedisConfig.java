package com.cloudyoung.baic.admin.config;

import com.cloudyoung.common.enums.RedisArchModelEnum;
import com.cloudyoung.common.tools.redis.RedissonConfig;
import com.cloudyoung.common.tools.redis.RedissonTemplete;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class RedisConfig {

    @Value("${redis.model}")
    private String model;

    @Value("${redis.password}")
    private String password;

    @Value("${redis.database}")
    private int database;

    @Value("${redis.masterName}")
    private String masterName;

    @Value("${redis.singleNodes}")
    private String singleNodes;

    @Value("${redis.sentinel}")
    private String sentinel;

    @Value("${redis.slaveNode}")
    private String slaveNode;

    @Value("${redis.masterNode}")
    private String masterNode;

    @Bean
    public RedissonConfig getRedissonConfig() {
        RedissonConfig redissonConfig = null;
        if (RedisArchModelEnum.SINGLE.getModel().equals(this.model)) { //单例
            redissonConfig = new RedissonConfig(model, database, password, singleNodes);
        } else if (RedisArchModelEnum.SENTINEL.getModel().equals(this.model)) { //哨兵
            String[] sentinels = sentinel.split(",");
            Set<String> nodes = new HashSet<String>();
            CollectionUtils.addAll(nodes, sentinels);
            redissonConfig = new RedissonConfig(model, database, masterName, password, nodes);
        } else if (RedisArchModelEnum.MASTERSLAVE.getModel().equals(this.model)) { //主从
            String[] slaveNodes = slaveNode.split(",");
            Set<String> nodes = new HashSet<String>();
            CollectionUtils.addAll(nodes, slaveNodes);
            redissonConfig = new RedissonConfig(model, database, password, nodes, masterNode);
        }
        redissonConfig.init();
        return redissonConfig;
    }

    @Bean("redissonTemplete")
    public RedissonTemplete getRedissonTemplete(RedissonConfig redissonConfig) {
        RedissonTemplete redissonTemplete = new RedissonTemplete();
        redissonTemplete.setRedissonConfig(redissonConfig);
        return redissonTemplete;
    }

}
