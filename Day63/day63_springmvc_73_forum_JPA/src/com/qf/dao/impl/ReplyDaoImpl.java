package com.qf.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.classic.Session;

import com.qf.dao.IReplyDao;
import com.qf.entity.Reply;
import com.qf.utils.HibernateUtil;

import javafx.geometry.Side;

public class ReplyDaoImpl implements IReplyDao {

	@Override
	public int add(Reply reply) {
		return (int)HibernateUtil.getSessionFactory().getCurrentSession().save(reply);
	}

	@Override
	public Integer getReplyDaoCount(Integer topicId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// 这里要根据帖子id查询回复
		Query query = session.createQuery("select count(r) from Reply r where r.replyTopic.id =:id");
		query.setInteger("id", topicId);
		Long count = (Long)query.uniqueResult();
		return count.intValue();
	}

	@Override
	public List<Reply> getReplyList(Integer topicId,Integer start, Integer pageSize) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		// 这里要根据帖子id查询回复
		Query query = session.createQuery("select r from Reply r where r.replyTopic.id =:id");
		query.setInteger("id", topicId);
		
		query.setFirstResult(start);
		query.setMaxResults(pageSize);
		
		List<Reply> replies= query.list();

		return replies;
	}

}
