package com.qf.service.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.logging.LogManager;

import org.junit.Test;

import com.qf.advices.LoggingManager;
import com.qf.advices.TransactionManager;
import com.qf.dao.ITeacherDao;
import com.qf.dao.IUserDao;
import com.qf.dao.impl.UserDaoImpl;
import com.qf.dao.impl.HandlerProxy;
import com.qf.dao.impl.TeacherDaoImpl;

public class UserServiceImplTest {

	@Test
	public void testUser() {

		// 1.业务主体
		IUserDao userDao =new UserDaoImpl();
		
		// 2.系统服务
		LoggingManager loggingManager = new LoggingManager();
		TransactionManager tx = new TransactionManager();
		
		ClassLoader loader = userDao.getClass().getClassLoader(); // 目标对象的类加载器
		Class<?>[] interfaces = userDao.getClass().getInterfaces();// 目标对象的接口
		InvocationHandler h = new HandlerProxy(loggingManager,tx,userDao); //hadler
		
		// 3.实例代理对象
		IUserDao userDaoProxy = (IUserDao)Proxy.newProxyInstance(loader, interfaces, h);
		
		// 4.调用
		userDaoProxy.add();
		
	}
	
	
	@Test
	public void testTeacher() {
		
		// 1.业务主体
		TeacherDaoImpl teacherDao =new TeacherDaoImpl();
		
		// 2.系统服务
		LoggingManager loggingManager = new LoggingManager();
		TransactionManager tx = new TransactionManager();
		
		ClassLoader loader = teacherDao.getClass().getClassLoader(); // 目标对象的类加载器
		Class<?>[] interfaces = teacherDao.getClass().getInterfaces();// 目标对象的接口
		InvocationHandler h = new HandlerProxy(loggingManager,tx,teacherDao); //hadler
		
		// 3.实例代理对象
		TeacherDaoImpl teacherDaoProxy = (TeacherDaoImpl)Proxy.newProxyInstance(loader, interfaces, h);
		
		// 4.调用
		teacherDaoProxy.add("qf");
		
	}

}
