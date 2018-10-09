package com.qf.service.impl;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qf.service.IUserService;

public class UserServiceImplTest {

	@Test
	public void testSpring() {

		// 1.初始化Spring容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 2.获取对象
		IUserService userService = ctx.getBean("userService3", IUserService.class);
		
		// 3.调用方法
		userService.info();
		System.out.println("测试："+userService);
	}

}
