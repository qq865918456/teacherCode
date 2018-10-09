package com.qf.hibentae;

import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.loader.custom.CustomLoader.ScalarResultColumnProcessor;
import org.junit.Test;

import com.qf.entity.KeyOpetion;
import com.qf.entity.Temp;
import com.qf.utils.HibernateUtil;

public class CaheTest {

	/**
	 * 演示悲观锁
	 */
	@Test
	public void testLock1() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Temp temp = (Temp) session.get(Temp.class, 117646, LockOptions.UPGRADE);
		System.out.println(temp.getName());
		transaction.commit();
	}
	
	/**
	 * 演示乐观锁
	 */
	@Test
	public void testLock2() {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Temp temp = (Temp) session.get(Temp.class, 117647);
		temp.setName("a11");
		transaction.commit();
	}

	@Test
	public void testAdd() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Temp temp = new Temp();
		temp.setName("qf");
		session.save(temp);
		transaction.commit();
	}

	/**
	 * 演示表单重复提交
	 */
	@Test
	public void testFrom() {

		// 1.key的实例
		KeyOpetion keyOpetion = new KeyOpetion();

		// 2.获取key
		String key = keyOpetion.createKey();

		// 3.提交
		submit(key, keyOpetion);
		submit(key, keyOpetion);
		submit(key, keyOpetion);

	}

	/**
	 * 服务端处理
	 * 
	 * @param key
	 * @param keyOpetion
	 */
	private void submit(String key, KeyOpetion keyOpetion) {

		// 1.先判断key是否有效
		if (keyOpetion.isToken(key)) {
			System.out.println("第一提交");

			// 2.删除key
			keyOpetion.del(key);
		} else {
			System.out.println("重复提交");
		}

	}

}
