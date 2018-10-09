package com.qf.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.CTX_RESTRICT_SCOPE;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.qf.entity.User;
import com.qf.service.IUserService;

public class UserServiceImplTest {

	private ApplicationContext context;
	private IUserService userService;

	@Before
	public void init() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		userService = context.getBean("userService", IUserService.class);
	}

	@Test
	public void testGetUserList() {
		List<User> userList = userService.getUserList();
		for (User user : userList) {
			System.out.println(user);
		}
	}

}
