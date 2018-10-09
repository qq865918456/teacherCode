package com.qf.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-redis.xml")
public class Main {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testRedis(){
//        redisTemplate.opsForValue().set("name", "xiaoming");

//        String name = (String) redisTemplate.opsForValue().get("name");
//        System.out.println("--->" + name);

        redisTemplate.opsForValue().set("age", 10);

        int age = (int) redisTemplate.opsForValue().get("age");
        System.out.println(age);
    }
}
