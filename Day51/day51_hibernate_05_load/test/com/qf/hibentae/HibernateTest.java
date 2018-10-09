package com.qf.hibentae;

import java.nio.channels.SeekableByteChannel;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Test;

import com.qf.entity.User;
import com.qf.utils.HibernateUtil;

public class HibernateTest {

	/**
	 * get很积极，调用后立马发送语句查询
	 * 返回是个真实对象
	 * 如果查询不存在的数据，返回null
	 */
	@Test
	public void testGet() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		User user = (User) session.get(User.class, 211);
		System.out.println(user);
		transaction.commit();
	}

	/**
	 * load是懒加载机制
	 * 	返回的是代理对象，这个代理对象中只有id有值，其他属性都是没有值
	 * 查询一个不存在的数据抛出异常
	 */
	@Test
	public void testLoad() {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		User user = (User) session.load(User.class, 211);
		System.out.println(user.getClass());
		System.out.println(user.getId()+user.getName());
		transaction.commit();
	}

}
