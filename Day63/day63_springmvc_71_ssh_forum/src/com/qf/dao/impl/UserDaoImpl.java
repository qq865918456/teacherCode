package com.qf.dao.impl;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.qf.dao.IUserDao;
import com.qf.entity.User;

@Repository
public class UserDaoImpl extends HibernateTemplate implements IUserDao {

	@Override
	public User login(String username, String password) {
		return super.execute(new HibernateCallback<User>() {
			@Override
			public User doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("from User u where u.username = :username and u.password = :password");
				query.setString("username", username);
				query.setString("password", password);
				return (User)query.uniqueResult();
			}
		});
	}
	
	@Autowired
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

}
