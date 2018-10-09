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
import java.util.Set;

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


	/**
	 * redis的字符串类型的操作
	 */
	@Test
	public void stringType(){
//		//set key value
//		redisTemplate.opsForValue().set("name", "张三");
//		//get key
//		String name = (String) redisTemplate.opsForValue().get("name");
//		System.out.println("name:" + name);

//		//mset key value key value.....
//		Map map = new HashMap<>();
//		map.put("age", 18);
//		map.put("address", "深圳市");
//		redisTemplate.opsForValue().multiSet(map);
//
//		//mget key key key....
//		List list = new ArrayList<>();
//		list.add("name");
//		list.add("age");
//		list.add("address");
//		List list1 = redisTemplate.opsForValue().multiGet(list);
//		for (Object o : list1) {
//			System.out.println(o);
//		}
//
//		//del key
//		redisTemplate.delete("name");
//
//		//strlen key - 如果使用spring提供的序列化方法存放数据，则可能导致某个命令出现结果不一致的情况
//		redisTemplate.opsForValue().set("sex", "man");
//		Long len = redisTemplate.opsForValue().size("sex");
//		System.out.println(len);
//
//		//getset key value
//		String oldValue = (String) redisTemplate.opsForValue().getAndSet("name", "李四");
//		System.out.println(oldValue);
//
//		//getrange key start end - 如果使用spring提供的序列化方法存放数据，则可能导致某个命令出现结果不一致的情况
//		String value = (String) redisTemplate.opsForValue().get("address");
//		System.out.println("address:" + value);
//		String value2 = redisTemplate.opsForValue().get("address", 0, 1);
//		System.out.println("address-range:" + value2);
//
//		redisTemplate.opsForValue().append("name", "王五");
//		String name = (String) redisTemplate.opsForValue().get("name");
//		System.out.println("name:" + name);
//
//		//incr key
//		//incrby key n
//		//incrbyfloag key m
//		String age = (String) redisTemplate.opsForValue().get("age");
//		System.out.println("age:" + age);
//		redisTemplate.opsForValue().increment("age", 1);
//
//		String age2 = (String) redisTemplate.opsForValue().get("age");
//		System.out.println("age:" + age2);
//
//		//decr key - 没有和decr相关的操作方法，因为reditemple模板没有封装和decr相关的操作
//		RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
//		connection.decr("age".getBytes());

	}


	/**
	 * 哈希的数据结构
	 */
	@Test
	public void hashType(){
//		//hset key field value
//		redisTemplate.opsForHash().put("person", "name", "张三");
//		//hget key field
//		String name = (String) redisTemplate.opsForHash().get("person", "name");
//		System.out.println("name:" + name);

		//hmset key field1 value1 field2 value2....
//		redisTemplate.opsForHash().putAll("student", Map);

		//hmget key field1 field2
//		redisTemplate.opsForHash().multiGet("key", List);

		//hdel key field1
//		redisTemplate.opsForHash().delete("key", field1, field2...)

		//hexists key field
//		Boolean flag = redisTemplate.opsForHash().hasKey("key", "field");

		//hkeys key - 查询所有的field
//		Set person = redisTemplate.opsForHash().keys("person");

		//hvals key
//		List person1 = redisTemplate.opsForHash().values("person");

		//hgetall key
//		Map map = redisTemplate.opsForHash().entries("person");
	}

	@Test
	public void listType(){
//		//lpush key value value value...
//		redisTemplate.opsForList().leftPushAll("books", "Java", "C++", "Mysql");
//		//rpush key value value...
//		redisTemplate.opsForList().rightPushAll("books", "C", "JS", "Ajax");
//
//		//lrange key start end
//		List range = redisTemplate.opsForList().range("books", 0, redisTemplate.opsForList().size("books") - 1);
//		System.out.println("链表的内容" + range);
//
//		redisTemplate.opsForList().leftPop("books");
//		redisTemplate.opsForList().rightPop("books");
//
//		redisTemplate.opsForList().leftPop("books", 10, TimeUnit.DAYS);
//
//		redisTemplate.opsForList().trim("books", 1, 5);
	}

	/**
	 * 集合的数据结构
	 */
	@Test
	public void setType(){
		//sadd keys value value...
		Long value = redisTemplate.opsForSet().add("books", "java", "c", "sqlserver", "db2", "java");
		System.out.println(value);


		//rembers keys
		Set boosks = redisTemplate.opsForSet().members("books");
		System.out.println("boosks:" + boosks);

	}

	/**
	 * 有序集合的操作
	 */
	@Test
	public void zsetType(){
		redisTemplate.opsForZSet().add("books", "java", 100);
		redisTemplate.opsForZSet().add("books", "c", 10);
		redisTemplate.opsForZSet().add("books", "c++", 120);
		redisTemplate.opsForZSet().add("books", "sql", 70);
		Set range = redisTemplate.opsForZSet().range("books", 0, redisTemplate.opsForZSet().size("books"));
		System.out.println(range);
	}

}
