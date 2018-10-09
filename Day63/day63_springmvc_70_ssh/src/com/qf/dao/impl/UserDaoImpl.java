package com.qf.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
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
	public User getUserById(Integer id) {
		return super.get(User.class, id);
	}

	@Autowired
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public List<User> getUserList() {
		return super.findByExample(new User());
	}

	@Override
	public int getUserTotalCount() {
		return super.execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException, SQLException {
				Long count = (Long)session.createQuery("select count(u) from User u").uniqueResult();
				return count.intValue();
			}
		});
	}

	@Override
	public List<User> getUserList(Integer index, Integer size) {
		return super.findByExample(new User(), index, size);
	}

}
