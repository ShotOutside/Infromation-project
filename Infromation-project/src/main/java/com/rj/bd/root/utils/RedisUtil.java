package com.rj.bd.root.utils;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @className: RedisUtil
 * @description: TODO  Redis连接池 工具类  | pom版本 8.1 | redis 版本 3.2.1 支持最新版
 * @author: tran
 * @date: 2021/5/13
 **/

public class RedisUtil {

    private RedisUtil(){}

    // redis 连接池
    private static JedisPool jedisPool;


    static {
        try {
            // 读取配置文件
            Properties pro = new Properties();
            InputStream is = RedisUtil.class.getClassLoader().getResourceAsStream("application.yml");
            pro.load(is);


            // 创建jedis连接池配置对象
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

            jedisPoolConfig.setMaxTotal(Integer.parseInt(pro.getProperty("maxTotal")));
            jedisPoolConfig.setMaxIdle(Integer.parseInt(pro.getProperty("maxIdle")));

            // 使用jedis连接池配置对象创建jedis连接池配置对象
            jedisPool = new JedisPool(jedisPoolConfig,"127.0.0.1", 6379);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("获取redis连接失败，请查看redis是否开启");
        }
    }



    /**
     * 获取jedis连接
     */
    public static Jedis getRedisConnection() {
        return jedisPool.getResource();
    }

//    public static void main(String[] args) {
//        Jedis jedis = new Jedis("192.168.56.132", 6379);  //指定Redis服务Host和port
//    }
}
