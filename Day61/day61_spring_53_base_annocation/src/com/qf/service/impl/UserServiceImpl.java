package com.qf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.qf.dao.IBaseDao;
import com.qf.dao.IUserDao;
import com.qf.entity.User;
import com.qf.service.IUserService;

//@Component // <bean>
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {

//	@Autowired
	private IUserDao userDao ;
	
	public IUserDao getUserDao() {
		return userDao;
	}

	@Autowired // 可以加到属性上面也可以set方法上面
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	protected IBaseDao<User> getBaseDao() {
		return userDao;
	}
}
