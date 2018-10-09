package com.qf.service.impl;

import java.util.List;

import com.qf.dao.IUserDao;
import com.qf.entity.User;
import com.qf.service.IUserService;

public class UserServiceImpl implements IUserService {

	private IUserDao userDao; // 由容器注入进来
	
	@Override
	public int add(User user) {
		return getUserDao().add(user);
	}

	@Override
	public List<User> getUserList() {
		return getUserDao().getUserList();
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

}
