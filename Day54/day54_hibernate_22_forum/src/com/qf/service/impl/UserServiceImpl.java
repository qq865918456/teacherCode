package com.qf.service.impl;

import com.qf.dao.IUserDao;
import com.qf.dao.UserDaoImplTest;
import com.qf.dao.impl.UserDaoImpl;
import com.qf.entity.User;
import com.qf.service.IUserService;

public class UserServiceImpl implements IUserService {
	
	private IUserDao userDao = new UserDaoImpl();

	@Override
	public User login(String username, String password) {
		return userDao.login(username, password);
	}

}
