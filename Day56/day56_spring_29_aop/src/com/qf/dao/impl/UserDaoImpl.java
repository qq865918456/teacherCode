package com.qf.dao.impl;

import javax.xml.soap.Text;

import com.qf.advices.LoggingManager;
import com.qf.advices.TransactionManager;
import com.qf.dao.IUserDao;

public class UserDaoImpl implements IUserDao {

	private TransactionManager tx = new TransactionManager();
	private LoggingManager log = new LoggingManager();

	/**
	 * 业务操作
	 */
	@Override
	public void add() {
		
		// 1.系统服务开启
		log.start();
		tx.begin();
		
		// 2.执行真真的业务操作
		System.out.println("UserDaoImpl.info()");
		
		// 3.系统服务关闭
		tx.commit();
		log.end();
	}

}
