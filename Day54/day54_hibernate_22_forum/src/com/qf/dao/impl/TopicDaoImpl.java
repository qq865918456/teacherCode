package com.qf.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.classic.Session;

import com.qf.dao.ITopicDao;
import com.qf.entity.Topic;
import com.qf.utils.HibernateUtil;

public class TopicDaoImpl implements ITopicDao {

	@Override
	public int getTopicCount() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Long count = (Long)session.createQuery("select count(t) from Topic t").uniqueResult(); 
		return count.intValue();
	}

	@SuppressWarnings(value="all")
	@Override
	public List<Topic> getTopicList(Integer start, Integer size) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("select t from Topic t"); 
		query.setFirstResult(start);
		query.setMaxResults(size);
		List<Topic> list = query.list();
		return list;
	}

	@Override
	public Topic getTopicById(Integer id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("select t from Topic t where t.id = :id"); 
		query.setInteger("id", id);
		return (Topic)query.uniqueResult();
	}

}
