package com.qf.dao;

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qf.entity.Page;
import com.qf.entity.User;
import com.qf.service.IUserService;

public class InitTest {

	private ApplicationContext ctx;
	private IUserService userService;

	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		userService = ctx.getBean("userService", IUserService.class);
	}

	@Test
	public void testDataSource() {
		Object dataSource = ctx.getBean("dataSource");
		System.out.println(dataSource);
	}

	@Test
	public void testSessionFactory() {
		// 根据类型获取
		SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);

		System.out.println(sessionFactory);
	}

	@Test
	public void testAddUser() {
		User user = new User();
		user.setUsername("qf123");
		user.setPassword("xxxx");
		System.out.println(userService.addUse(user));
	}
	
	@Test
	public void testGetUserPage() {
		Page<User> page = new Page<User>();
		userService.getUserPage(page);
		System.out.println(page);
	}

}
