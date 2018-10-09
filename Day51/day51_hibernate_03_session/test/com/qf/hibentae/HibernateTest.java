package com.qf.hibentae;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Test;

import com.qf.entity.User;
import com.qf.utils.HibernateUtil;

public class HibernateTest {

	/**
	 * 第一种方式来获取session 1.session的操作必须要开启事务
	 * 2.调用getCurrentSession先当前线程中去找，如果没有就创建，如果有就使用，事务提交后或session关闭这个session就没有了
	 * 需要在配置文件配置
	 */
	@Test
	public void testSession1() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.getCurrentSession(); // 第一次创建session

		Session session2 = sessionFactory.getCurrentSession(); // 从当前线程中获取的

		System.out.println(session == session2);

		Transaction transaction = session.beginTransaction();

		User user = (User) session.get(User.class, 20);
		System.out.println("user:" + user);

		transaction.commit(); // 事务提交后会自动关闭session

		Session session3 = sessionFactory.getCurrentSession(); // 新建session

		System.out.println(session3 == session);

		// session.close();
		sessionFactory.close();

	}

	/**
	 * 第二种创建session的方式 1.在没有开启事务的情况下也可以操作
	 * 2.每次都会创建一个新的session,事务提交后session不会关闭，需要说动关闭
	 */
	@Test
	public void testSession2() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		// 第一次创建session
		Session session = sessionFactory.openSession();

		// 第二次创建session
		// Session session2 = sessionFactory.openSession();

		// System.out.println(session == session2);

		Transaction transaction = session.beginTransaction();

		User user = (User) session.get(User.class, 20);
		System.out.println(user);

		transaction.commit();

		session.close();

		sessionFactory.close();

	}

	/**
	 * 缓存
	 * 事务提交后会把缓存中的数据刷新到数据库
	 */
	@Test
	public void testCache() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		User user = (User) session.get(User.class, 20); // 查询后是放到缓存里面
//		User user2 = (User) session.get(User.class, 21);
		user.setName("李四a3"); // 修改的是缓存中的数据
		System.out.println(user);
//		System.out.println(user2);
		transaction.commit();
		sessionFactory.close();
	}

}
