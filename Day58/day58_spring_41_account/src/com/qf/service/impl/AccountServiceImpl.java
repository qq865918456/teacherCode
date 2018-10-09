package com.qf.service.impl;

import com.qf.dao.IAccountDao;
import com.qf.entity.Account;
import com.qf.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

	private IAccountDao accountDao;
	
	// 事务一般是加到service层
	@Override
	public boolean transfer(Account account) {
		
		getAccountDao().out(account.getOuName(), account.getMoeny());
		int i=10/0;
		getAccountDao().in(account.getInName(), account.getMoeny());
		return false;
	}

	public IAccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(IAccountDao accountDao) {
		this.accountDao = accountDao;
	}

}
