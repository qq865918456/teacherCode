package com.qf.dao.impl;

import org.springframework.stereotype.Component;

import com.qf.dao.IUserDao;

//@Component
public class UserDaoImpl implements IUserDao {

	@Override
	public void info() {
		System.out.println("UserDaoImpl.info()");
	}

}
