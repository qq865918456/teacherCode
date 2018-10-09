package com.qf.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qf.entity.User;
import com.qf.service.IUserService;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class TopicServiceImplTest {

	@Autowired
	private IUserService userService;
	
	@Test
	public void testLogin(){
		User user = userService.login("admin", "admin");
		System.out.println(user);
	}
}
