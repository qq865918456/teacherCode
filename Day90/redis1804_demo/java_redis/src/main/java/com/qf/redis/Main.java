package com.qf.redis;

import redis.clients.jedis.Jedis;

public class Main {

    public static void main(String[] args) {

        //1、创建jedis对象，连接redis服务器
        Jedis jedis = new Jedis("192.168.226.130", 6379);
//        jedis.auth("root");//设置密码

        //2、操作redis
//        jedis.set("name", "lisi");
//        String name = jedis.get("name");
//        System.out.println("redis的value：" + name);

        int i = 1;

        long begin = System.currentTimeMillis();
        while(true){
            long end = System.currentTimeMillis();

            if(end - begin >= 1000){
                break;
            }

            jedis.set("name" + i, "zhangsan" + i);
            i++;
        }

        System.out.println("1秒写入数据的个数：" + i);


        //3、关闭连接
        jedis.close();
    }
}
