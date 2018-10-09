package com.qf.service.impl;

import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;

import com.qf.advices.LoggingManager;
import com.qf.advices.MyMethodBeforeAdvice;
import com.qf.advices.MyMethodInterceptor;
import com.qf.advices.MyThrowsAdvice;
import com.qf.advices.TransactionManager;
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
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(userDao); // 设置目标对象
		proxyFactory.addAdvice(new MyMethodInterceptor());// 添加环绕通知
		proxyFactory.addAdvice(new MyMethodBeforeAdvice(tx,log));// 添加前置，后置通知
		proxyFactory.addAdvice(new MyThrowsAdvice());// 添加异常通知
		IUserDao userDaoProxy = (IUserDao)proxyFactory.getProxy(); // 创建代理类
		
		// 4.调用方法
		userDaoProxy.add();
		
		System.out.println(userDaoProxy.getClass());
		System.out.println("========================");
		userDaoProxy.query();
		
	}

}
