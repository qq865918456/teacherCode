package com.qf.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qf.service.IUserService;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class UserServiceImplTest {

	@Autowired
	private IUserService userService;
	
	@Test
	public void testGetUserById() {
		System.out.println(userService.getUserById(7));
	}

}
