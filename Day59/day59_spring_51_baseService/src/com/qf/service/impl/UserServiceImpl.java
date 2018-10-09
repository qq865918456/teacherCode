package com.qf.service.impl;

import com.qf.dao.IBaseDao;
import com.qf.dao.IUserDao;
import com.qf.entity.User;
import com.qf.service.IUserService;

public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {

	private IUserDao userDao;
	
	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	protected IBaseDao<User> getBaseDao() {
		return userDao;
	}
}
