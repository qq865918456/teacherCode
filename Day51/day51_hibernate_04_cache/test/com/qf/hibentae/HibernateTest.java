package com.qf.hibentae;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Test;

import com.qf.entity.User;
import com.qf.utils.HibernateUtil;

public class HibernateTest {

	@Test
	public void testCache() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		// 第一个session
		Session session = sessionFactory.openSession();
		User user = (User) session.get(User.class, 20); // 查询后是放到缓存里面
		System.out.println(user);
		
//		session.clear(); //清空缓存
		
		session.close();
		
		User user1 = (User) session.get(User.class, 20); // 查询后是放到缓存里面
		System.out.println(user1);

		System.out.println("=======================================");
		// 第二个session
		Session session2 = sessionFactory.openSession();
		User user2 = (User) session2.get(User.class, 20);

		session.close();
		session2.close();
	}
	
	@Test
	public void testCache1() {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		User user = new User(); // 
	}
	
	/**
	 * 演示把添加成功那个对象也放到缓存里面
	 */
	@Test
	public void testSave() {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		Transaction beginTransaction = session.beginTransaction();
		
		User user = new User();
		user.setName("qfAdmin");
		
		Serializable id = session.save(user); // 保存的时候也给缓存中方一份
		System.out.println("============================");
		user = (User)session.get(User.class, id); // 查询
		System.out.println(user);
		beginTransaction.commit();
		
		
		
		
	}

}
