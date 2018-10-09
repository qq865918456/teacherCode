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

import com.qf.dao.ITopicDao;
import com.qf.entity.Topic;

@Repository
public class TopicDaoImpl extends HibernateTemplate implements ITopicDao {

	@Override
	public int getTopicCount() {
		return super.execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException, SQLException {
				Long count = (Long)session.createQuery("select count(t) from Topic t").uniqueResult(); 
				return count.intValue();
			}
		});
	}

	@Override
	public List<Topic> getTopicList(Integer start, Integer size) {
		return super.findByExample(new Topic(), start, size);
	}

	@Override
	public Topic getTopicById(Integer id) {
		return super.get(Topic.class, id);
	}
	
	@Autowired
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

}
