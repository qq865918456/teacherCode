/**
 * 
 */
package com.qf.service.impl;

import com.qf.dao.IUserDao;
import com.qf.service.IUserService;

/**
 * @author admin
 *
 */
public class UserServiceImpl implements IUserService {
	
	private IUserDao userDao; // 让Spring来注入
	
	@Override
	public void info() {
		System.out.println("UserServiceImpl.info()");
		userDao.info();
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

}
