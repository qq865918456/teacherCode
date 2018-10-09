package com.qf.dao.impl;

import org.hibernate.Query;
import org.hibernate.classic.Session;

import com.qf.dao.IUserDao;
import com.qf.entity.User;
import com.qf.utils.HibernateUtil;

public class UserDaoImpl implements IUserDao {

	@Override
	public User login(String username, String password) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from User u where u.username = :username and u.password = :password");
		query.setString("username", username);
		query.setString("password", password);
		return (User)query.uniqueResult();
	}

}
