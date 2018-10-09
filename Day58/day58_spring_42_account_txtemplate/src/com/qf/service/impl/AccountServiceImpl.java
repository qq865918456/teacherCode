package com.qf.service.impl;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.qf.dao.IAccountDao;
import com.qf.entity.Account;
import com.qf.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

	private IAccountDao accountDao;
	
	private TransactionTemplate txTemplate; // 事务模板
	
	// 事务一般是加到service层
	@Override
	public boolean transfer(final Account account) {
		
		// execute()该方法具备一个事务
		getTxTemplate().execute(new TransactionCallback<Integer>() {
			@Override
			public Integer doInTransaction(TransactionStatus arg0) {
				getAccountDao().out(account.getOuName(), account.getMoeny());
				int i=10/0;
				// 匿名内部类访问外部类属性的时候一定要加final
				getAccountDao().in(account.getInName(), account.getMoeny());
				return null;
			}
		});
		return false;
	}

	public IAccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(IAccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public TransactionTemplate getTxTemplate() {
		return txTemplate;
	}

	public void setTxTemplate(TransactionTemplate txTemplate) {
		this.txTemplate = txTemplate;
	}

}
