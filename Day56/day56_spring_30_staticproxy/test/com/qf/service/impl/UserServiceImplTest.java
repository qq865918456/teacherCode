package com.qf.service.impl;

import java.util.logging.LogManager;

import org.junit.Test;

import com.qf.advices.LoggingManager;
import com.qf.advices.TransactionManager;
import com.qf.dao.IUserDao;
import com.qf.dao.impl.UserDaoImpl;
import com.qf.dao.impl.UserDaoImplProxy;

public class UserServiceImplTest {

	@Test
	public void testSpring() {

		// 1.业务主体
		IUserDao userDao =new UserDaoImpl();
		
		// 2.系统服务
		LoggingManager loggingManager = new LoggingManager();
		TransactionManager tx = new TransactionManager();
		
		// 3.实例代理对象
		UserDaoImplProxy userDaoImplProxy = new UserDaoImplProxy(loggingManager,tx,userDao);
		
		// 4.调用
		userDaoImplProxy.add();
		
	}

}
