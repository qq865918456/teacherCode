package com.qf.service.impl;

import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.aop.framework.ProxyFactory;

import com.qf.advices.LoggingManager;
import com.qf.advices.TransactionManager;
import com.qf.aspectj.MyAspectj;
import com.qf.dao.IUserDao;
import com.qf.dao.impl.UserDaoImpl;

public class UserServiceImplTest {

	@Test
	public void testUser() {

		// 1.目标对象
		IUserDao userDao =new UserDaoImpl();
		
		// 2.增强
		TransactionManager tx = new TransactionManager();
		LoggingManager log = new LoggingManager();
		
		// 3.创建代理类
		AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory();
		aspectJProxyFactory.setTarget(userDao);// 目标对象
		aspectJProxyFactory.addAspect(new MyAspectj(tx));// 添加切面
		IUserDao userDaoProxy = (IUserDao)aspectJProxyFactory.getProxy();// 获取代理类
		
		// 4.调用方法
		userDaoProxy.add();
		System.out.println("======================");
		userDaoProxy.query();
		
		
	}

}
