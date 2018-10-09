package com.qf.service;

import com.qf.entity.Account;

public interface IAccountService {

	/**
	 * 转账
	 * @param account
	 * @return
	 */
	public boolean transfer(Account account);
}
