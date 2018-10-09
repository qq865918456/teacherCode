package com.qf.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qf.dao.IUserDao;
import com.qf.entity.User;

public class UserDaoImplTest {
	private ApplicationContext ctx = null;

	private IUserDao userDao = null;

	@Before
	public void init() {
		// 2.初始化容器
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		// 3.获取bean
		userDao = ctx.getBean("userDao", IUserDao.class);
	}

	@Test
	public void testAdd() {

		// 1.创建对象
		User user = new User();
		user.setUsername("小张三");
		user.setPassword("abc");

		System.out.println(userDao.add(user));

	}

	@Test
	public void testGetUserList() {
		List<User> userList = userDao.getUserList();
		for (User user : userList) {
			System.out.println(user);
		}
	}

}
