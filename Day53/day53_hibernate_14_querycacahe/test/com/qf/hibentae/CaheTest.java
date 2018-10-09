package com.qf.hibentae;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Test;

import com.qf.entity.Customer;
import com.qf.utils.HibernateUtil;

public class CaheTest {

	/**
	 * 演示一级缓存
	 */
	@Test
	public void testQueryAll() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		// 1.创建第一个Session
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("from Customer c where c.id = 19");
		query.setCacheable(true);// 开启查询缓存
		Customer customer = (Customer)query.uniqueResult();
		System.out.println("---------------------------------------");
		
		// 3.第二次查询不会发送
		Query query2 = session.createQuery("from Customer c where c.id = 19");
		query2.setCacheable(true);
		Customer customer2 = (Customer)query2.uniqueResult();
		System.out.println(customer2.getName()+":"+customer2.getOrderInfo().size());
		
		// 4.开启第二个session
		Session session2 = sessionFactory.openSession();
		
		System.out.println("===================新的session=============================");
		Query query3 = session2.createQuery("from Customer c where c.id = 19");
		query3.setCacheable(true);
		Customer customer3 = (Customer)query3.uniqueResult();
		System.out.println(customer3.getName()+":"+customer3.getOrderInfo().size());
	}
}
	
