package com.qf.service.impl;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qf.service.IUserService;

public class UserServiceImplTest {

	/**
	 * 用之前的方式调用方法
	 */
	@Test
	public void test() {

		// 1.实例化对象
		IUserService userService = new UserServiceImpl();

		// 2.调用方法
		userService.info();
	}
	
	/**
	 * 用Spring的方式调用方法
	 * 	Spring的特点：
	 * 		1)管理对象创建和生命周期
	 * 		2)它是一个巨大的工厂
	 */
	@Test
	public void testSpring() {
		
		// 1.初始化Spring容器(工厂)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 2.通过工厂获取bean
		IUserService userService1 = (IUserService)ctx.getBean("userService");
		// 避免强转
		IUserService userService = ctx.getBean("userService", IUserService.class);
		
		// 3.调用方法
		userService.info();
		
		System.out.println(userService.getClass());
		System.out.println(userService1.getClass());
	}

}
