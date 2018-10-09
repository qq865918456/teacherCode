package com.qf.service.impl;

import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qf.advices.LoggingManager;
import com.qf.advices.TransactionManager;
import com.qf.aspectj.MyAspectj;
import com.qf.dao.IUserDao;
import com.qf.dao.impl.UserDaoImpl;

public class UserServiceImplTest {

	@Test
	public void testUser() {

		// 1.初始化Spring容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 2.获取目标对象起始是个代理对象
		IUserDao userDao = ctx.getBean("userDao",IUserDao.class);
		
		userDao.add();

		System.out.println(userDao.getClass());
		
	}

}
