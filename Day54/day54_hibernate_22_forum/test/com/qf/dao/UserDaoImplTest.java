package com.qf.dao;

import java.util.Date;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Test;

import com.qf.entity.Reply;
import com.qf.entity.Topic;
import com.qf.entity.User;
import com.qf.utils.HibernateUtil;

public class UserDaoImplTest {

	@Test
	public void testUserAdd() {
		User user = new User();
		user.setUsername("admin");
		user.setPassword("admin");
		user.setSex(1);

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
	}

	@Test
	public void testTopicAdd() {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		User user = (User) session.get(User.class, 1);

		for (int i = 0; i < 10; i++) {
			Topic topic = new Topic();
			topic.setTitle("这是第" + (i + 1) + "篇帖子。。。。。");
			topic.setContent("第" + (i + 1) + "篇帖子的内容");
			topic.setCreateDate(new Date());
			topic.setUser(user); // 设置发帖人

			session.save(topic); // 保存帖子
		}
		transaction.commit();

	}

	@Test
	public void testReplyAdd() {

		Reply reply = new Reply();
		reply.setContent("撸代码");
		reply.setCreateDate(new Date());
		// reply.setReplyUser(replyUser); // 从session中获取
		// reply.setReplyTopic(replyTopic); // 贴子id

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();

		User user = (User) session.get(User.class, 1);
		reply.setReplyUser(user);

		Topic topic = (Topic) session.get(Topic.class, 1);
		reply.setReplyTopic(topic);

		session.save(reply);

		transaction.commit();
	}

}
