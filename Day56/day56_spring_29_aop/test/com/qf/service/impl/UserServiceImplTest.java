package com.qf.service.impl;

import org.junit.Test;

import com.qf.dao.IUserDao;
import com.qf.dao.impl.UserDaoImpl;

public class UserServiceImplTest {

	@Test
	public void testSpring() {

		IUserDao userDao = new UserDaoImpl();
		
		userDao.add();
	}

}
