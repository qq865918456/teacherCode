package com.qf.stu.student_demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.ReturnType;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class LockUtil {

    @Autowired
    private RedisTemplate redisTemplate;
    private RedisConnection redisConnection;

    private String luaScript = "--参数获得分布式锁\n" +
            "local index = redis.call('setnx', KEYS[1], ARGV[1])\n" +
            "\n" +
            "--判断是否获得分布式锁\n" +
            "if index == 1 then \n" +
            "  --说明获得了分布式锁机制，设置锁的超时时间\n" +
            "  redis.call('expire', KEYS[1], ARGV[2])\n" +
            "  return 1\n" +
            "end\n" +
            "\n" +
            "--说明没有拿到锁\n" +
            "return 0";

    private String sha1;


    @PostConstruct
    public void init(){
        redisConnection = redisTemplate.getConnectionFactory().getConnection();
    }

    /**
     * 获得分布式锁
     * @return
     */
    public boolean lock(String name, String value){

        System.out.println("获得分布式锁");
        if(sha1 == null){
            sha1 = redisConnection.scriptLoad(luaScript.getBytes());
        }

        Long index = redisConnection.evalSha(sha1, ReturnType.INTEGER, 1, name.getBytes(), value.getBytes(), "5000".getBytes());
        return index == 1 ? true : false;
    }

    /**
     * 释放分布式锁
     * @return
     */
    public boolean unlock(String name, String value){
        System.out.println("释放分布式锁");
        byte[] values = redisConnection.get(name.getBytes());
        if(value.equals(new String(values))){
            redisConnection.del(name.getBytes());
            return true;
        }
        return false;
    }
}
