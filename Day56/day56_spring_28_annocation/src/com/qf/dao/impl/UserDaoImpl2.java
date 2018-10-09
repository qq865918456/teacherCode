package com.qf.dao.impl;

import org.springframework.stereotype.Component;

import com.qf.dao.IUserDao;

//@Component
public class UserDaoImpl2 implements IUserDao {

	@Override
	public void info() {
		System.out.println("UserDaoImpl2.info()");
	}

}
