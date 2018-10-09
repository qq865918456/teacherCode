package com.qf.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import com.qf.dao.IAccountDao;

public class AccountDaoImpl extends JdbcTemplate implements IAccountDao {

	@Override
	public void in(String inName, Double moeny) {
		super.update("update t_account c set c.balance = c.balance + ? where c.name = ?",moeny,inName);
	}

	@Override
	public void out(String outName, Double moeny) {
		super.update("update t_account c set c.balance = c.balance - ? where c.name = ?",moeny,outName);
	}

}
