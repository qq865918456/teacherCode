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
	public void testAdd() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		Transaction transaction = session.beginTransaction();

		User user = new User();
		user.setName("玛丽");
		user.setPassword("123");
		user.setSex(1);

		// 保存user
		try {
			Serializable save = session.save(user);// 返回的是主键
			System.out.println("save:" + save); 
			// 事务提交后会自动关闭session
			transaction.commit(); // 事务提交
		} catch (Exception e) {
			transaction.rollback(); // 事务回滚
			e.printStackTrace();

		} finally {
//			session.close();
			sessionFactory.close();
		}
	}
	
	
	@Test
	public void testUpdate() {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		Transaction transaction = session.beginTransaction();
		
		// 先根据id查询对象
		User user = (User)session.get(User.class, 26);
		
		user.setName("玛丽a");
		
		// 保存user
		try {
			session.update(user);
			// 事务提交后会自动关闭session
			transaction.commit(); // 事务提交
		} catch (Exception e) {
			transaction.rollback(); // 事务回滚
			e.printStackTrace();
			
		} finally {
//			session.close();
			sessionFactory.close();
		}
	}
	
	
	@Test
	public void testDelete() {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		Transaction transaction = session.beginTransaction();
		
		// 先根据id查询对象
		User user = (User)session.get(User.class, 26);
		
		
		try {
			session.delete(user);
			// 事务提交后会自动关闭session
			transaction.commit(); // 事务提交
		} catch (Exception e) {
			transaction.rollback(); // 事务回滚
			e.printStackTrace();
			
		} finally {
//			session.close();
			sessionFactory.close();
		}
	}

}
