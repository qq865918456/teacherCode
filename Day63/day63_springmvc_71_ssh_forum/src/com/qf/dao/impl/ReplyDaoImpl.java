package com.qf.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.qf.dao.IReplyDao;
import com.qf.entity.Reply;

@Repository
public class ReplyDaoImpl extends HibernateTemplate implements IReplyDao {

	@Autowired
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public int add(Reply reply) {
		return (int) super.save(reply);
	}

	@Override
	public Integer getReplyDaoCount(Integer topicId) {
		return super.execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException, SQLException {
				// 这里要根据帖子id查询回复
				Query query = session.createQuery("select count(r) from Reply r where r.replyTopic.id =:id");
				query.setInteger("id", topicId);
				Long count = (Long) query.uniqueResult();
				return count.intValue();
			}
		});

	}

	@Override
	public List<Reply> getReplyList(Integer topicId,Integer start, Integer pageSize) {
		return super.execute(new HibernateCallback<List<Reply>>() {
			@Override
			public List<Reply> doInHibernate(Session session) throws HibernateException, SQLException {
				// 这里要根据帖子id查询回复
				Query query = session.createQuery("select r from Reply r where r.replyTopic.id =:id");
				
				query.setInteger("id", topicId);
				
				query.setFirstResult(start);
				query.setMaxResults(pageSize);
				
				List<Reply> replies= query.list();
				return replies;
			}
		});
	}

}
