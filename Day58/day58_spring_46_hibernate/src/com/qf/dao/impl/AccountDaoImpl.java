package com.qf.dao.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.qf.dao.IAccountDao;

public class AccountDaoImpl extends HibernateTemplate implements IAccountDao {

	@Override
	public void in(String inName, Double moeny) {
		super.bulkUpdate("update Account a set a.moeny = a.moeny +? where a.name = ?", moeny,inName);
	}

	@Override
	public void out(String outName, Double moeny) {
		super.bulkUpdate("update Account a set a.moeny = a.moeny -? where a.name = ?", moeny,outName);
	}

}
