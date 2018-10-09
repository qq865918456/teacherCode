package com.qf.dao.impl;

import com.qf.advices.LoggingManager;
import com.qf.advices.TransactionManager;
import com.qf.dao.IUserDao;

/**
 * 真真的业务主体
 * 
 * @author admin
 *
 */
public class UserDaoImpl implements IUserDao {

	/**
	 * 业务操作
	 */
	@Override
	public void add() {
		System.out.println("UserDaoImpl.info()");
//		int i = 10 / 0;
	}

	@Override
	public void query() {
		System.out.println("UserDaoImpl.query()");
	}

}
