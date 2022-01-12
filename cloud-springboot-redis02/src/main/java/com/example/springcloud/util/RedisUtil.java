package com.example.springcloud.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author Wang Yuran
 * @create 2022-01-12 22:22
 */
public class RedisUtil {
    private static JedisPool jedisPool;
    static {
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(20);
        jedisPoolConfig.setMaxIdle(10);
        jedisPool=new JedisPool(jedisPoolConfig,"localhost",6739);
    }
    public static Jedis getJedis() throws Exception {
        if(null!=jedisPool){
            return jedisPool.getResource();

        }
        throw new Exception("JedisPool is not ok");
    }
}
