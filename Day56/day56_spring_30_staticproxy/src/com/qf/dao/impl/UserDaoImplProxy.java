package com.qf.dao.impl;

import com.qf.advices.LoggingManager;
import com.qf.advices.TransactionManager;
import com.qf.dao.IUserDao;

/**
 * 代理类
 * @author admin
 *
 */
public class UserDaoImplProxy implements IUserDao {

	// 系统服务
	private TransactionManager tx;
	private LoggingManager log;
	
	// 目标对象
	private IUserDao userDao;
	
	public UserDaoImplProxy(LoggingManager loggingManager, TransactionManager tx, IUserDao userDao) {
		this.tx = tx;
		this.log = loggingManager;
		this.userDao = userDao;
	}

	@Override
	public void add() {
		// 1.系统服务开启
		log.start();
		tx.begin();
		
		// 2.调用真真业务主体
		userDao.add();
		
		// 3.系统服务关闭
		tx.commit();
		log.end();
	}

}
