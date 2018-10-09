package com.qf.service.impl;

import java.util.logging.LogManager;

import org.junit.Test;

import com.qf.advices.LoggingManager;
import com.qf.advices.TransactionManager;
import com.qf.dao.IUserDao;
import com.qf.dao.impl.CglibInteceptor;
import com.qf.dao.impl.TeacherDaoImpl;
import com.qf.dao.impl.UserDaoImpl;

import net.sf.cglib.proxy.Enhancer;

public class UserServiceImplTest {

	@Test
	public void testUser() {

		// 1.创建系统服务
		TransactionManager tx = new TransactionManager();
		LoggingManager log = new LoggingManager();

		// 2.目标对象
		IUserDao userDao = new UserDaoImpl();

		// 3.创建目标对象
		Enhancer enhancer = new Enhancer(); // bglib通过Enhancer创建代理类
		enhancer.setSuperclass(userDao.getClass());// 设置父类(目标对象)
		enhancer.setCallback(new CglibInteceptor(tx, log)); // 设置拦截器
		IUserDao userDaoProxy = (IUserDao) enhancer.create(); // 创建代理类(子类)

		System.out.println(userDaoProxy.getClass());
		// 4.调用方法
		userDaoProxy.add();
		System.out.println("======================");
		userDaoProxy.query();
	}

	@Test
	public void testTeacher() {

		// 1.创建系统服务
		TransactionManager tx = new TransactionManager();
		LoggingManager log = new LoggingManager();

		// 2.目标对象
		TeacherDaoImpl teacherDao = new TeacherDaoImpl();

		// 3.创建目标对象
		Enhancer enhancer = new Enhancer(); // bglib通过Enhancer创建代理类
		enhancer.setSuperclass(teacherDao.getClass());// 设置父类(目标对象)
		enhancer.setCallback(new CglibInteceptor(tx, log)); // 设置拦截器
		TeacherDaoImpl teacherDaoProxy = (TeacherDaoImpl) enhancer.create(); // 创建代理类(子类)

		// 4.调用方法
		teacherDaoProxy.add("千锋");
	}

}
