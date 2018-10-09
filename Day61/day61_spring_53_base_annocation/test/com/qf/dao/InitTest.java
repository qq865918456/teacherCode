package com.qf.dao;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qf.entity.Page;
import com.qf.entity.User;
import com.qf.service.IUserService;
import com.qf.service.impl.UserServiceImpl;

@RunWith(value = SpringJUnit4ClassRunner.class) // 在运行测试的环境上
@ContextConfiguration(value = "classpath:applicationContext.xml") // 指定配置文件的名称
public class InitTest {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private IUserService userService;

	@Test
	public void testDataSource() {
		System.out.println(dataSource);
	}

	@Test
	public void testUpdate() {
		User user = new User();
		user.setId(7);
		user.setUsername("abc");
		user.setPassword("123");
		System.out.println(userService.update(user));
	}

	@Test
	public void testAddUser() {
		User user = new User();
		user.setUsername("qf123");
		user.setPassword("xxxx");
	}

	@Test
	public void testGetUserPage() {
		Page<User> page = new Page<User>();
		userService.getPage(page);
		;
		System.out.println(page);
	}

}
