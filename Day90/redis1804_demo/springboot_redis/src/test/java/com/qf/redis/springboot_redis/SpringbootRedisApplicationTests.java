package com.qf.redis.springboot_redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {

	@Autowired
	private RedisTemplate redisTemplate;

	@PostConstruct
	public void init(){
		redisTemplate.setKeySerializer(new JdkSerializationRedisSerializer());
		redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
	}

	@Test
	public void contextLoads() {

		//两个连接
//		redisTemplate.opsForValue().set("money", 10000);
//		redisTemplate.opsForValue().set("age", 18);


		//一个连接
		String value = (String) redisTemplate.execute(new SessionCallback() {
				@Override
				public Object execute(RedisOperations redisOperations) throws DataAccessException {
					redisOperations.opsForValue().set("name","zhangsan");
					redisOperations.opsForValue().get("name");
					return "ok";
				}
		});

	}


}
