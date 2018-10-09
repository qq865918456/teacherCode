package com.qf.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.qf.entity.User;
import com.qf.mapper.IUserMapper;
import com.qf.util.SqlSessionUtil2;

public class Main {

	public static void main(String[] args) {
		
		SqlSession sqlSession = SqlSessionUtil2.getSqlSession();
		IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);
		
//		User user = userMapper.queryUserById(5);
//		List<User> users = userMapper.queryUserByParams("愤怒的-张三", 15);
		
//		Map<String, Object> map = new HashMap<>();
//		map.put("name", "愤怒的-张三");
//		map.put("age", 15);
//		List<User> users = userMapper.queryUserByParams(map);
		
		
//		User user1 = new User();
//		user1.setName("愤怒的-张三");
//		
//		User user2 = new User();
//		user2.setAge(15);
//		List<User> users = userMapper.queryUserByParams(user1, user2);
		
//		List<User> users = userMapper.queryLikeByName("张");
		
//		List<User> users = userMapper.queryAll(0, 2);
//		List<User> users = userMapper.queryAll2(new RowBounds(0, 2));
		
//		User user = new User();
//		user.setName("小王八");
//		user.setAge(20);
//		int result = userMapper.insertUser(user);
		
//		Map<String, Object> map = new HashMap<>();
//		map.put("name", "小黑");
//		map.put("age", 18);
//		int result = userMapper.insertUser2(map);
//		
//		System.out.println(map.get("id"));
//		System.out.println("回填的主键：" + user.getId());
		
		/**
		 * mybatis中的#和$的区别
		 * $ - 直接引入的过程，直接将参数替换到sql语句中的位置
		 * # - 会以预编译的方式设置该参数
		 * 
		 */
		User user = userMapper.queryById(3, "id,name,age");
		System.out.println(user);
		
		sqlSession.commit();
		sqlSession.close();
	}
}
