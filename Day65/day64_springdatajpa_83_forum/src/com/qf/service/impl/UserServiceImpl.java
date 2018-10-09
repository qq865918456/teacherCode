package com.qf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qf.dao.IUserDao;
import com.qf.entity.User;
import com.qf.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao userDao;

	@Override
	public User login(String username, String password) {
		return userDao.getUserByUsernameAndPassword(username, password);
	}

}
