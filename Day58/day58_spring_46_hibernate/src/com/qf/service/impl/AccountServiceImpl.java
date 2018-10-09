package com.qf.service.impl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.qf.dao.IAccountDao;
import com.qf.entity.Account;
import com.qf.service.IAccountService;

@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
public class AccountServiceImpl implements IAccountService {

	private IAccountDao accountDao;

//	@Transactional
	@Override
	public boolean transfer(Account account) {

		getAccountDao().out(account.getOuName(), account.getMoeny());
//		int i = 10 / 0;
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
