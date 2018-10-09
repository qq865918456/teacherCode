package com.qf.hibentae;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.jdbc.Work;
import org.junit.Test;

import com.qf.entity.Temp;
import com.qf.utils.HibernateUtil;

public class CaheTest {

	/**
	 * 演示一级缓存
	 */
	@Test
	public void testAdd() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Temp temp = new Temp();
		temp.setName("B");
		session.save(temp);
		transaction.commit(); // 刷新缓存区(隐式调用flush())
	}

	/**
	 * 7.143
	 */
	@Test
	public void testAdd1() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		for (int i = 0; i < 30000; i++) {
			Temp temp = new Temp();
			temp.setName("name_" + i);
			session.save(temp); // 把sql编写好了，放到缓存区
		}
		transaction.commit();
	}

	/**
	 * 6.961
	 */
	@Test
	public void testAdd2() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		for (int i = 0; i < 30000; i++) {
			Temp temp = new Temp();
			temp.setName("name_" + i);
			session.save(temp); //
			if (i % 100 == 0) {
				session.flush(); // 刷新缓存区
				session.clear();
			}
		}
		transaction.commit();
	}

	/**
	 * 4.9
	 */
	@Test
	public void testAdd3() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		session.doWork(new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {

				PreparedStatement prst = connection.prepareStatement("insert into t_temp(name) values(?)");
				for (int i = 0; i < 30000; i++) {
					prst.setString(1, "name_"+i);
					prst.addBatch(); // 添加缓存区
					if(i % 300 == 0){
						prst.executeBatch();
						prst.clearBatch();
					}
				}
				prst.executeBatch();
			}
		});

		transaction.commit();
	}
	
	
	@Test
	public void testDelete() {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		System.out.println(session.createQuery("delete from Temp").executeUpdate());
		transaction.commit();
	}
}
