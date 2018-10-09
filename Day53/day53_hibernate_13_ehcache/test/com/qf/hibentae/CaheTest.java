package com.qf.hibentae;

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
		
		// 2.第一次查询会发送sql查询
		Customer customer = (Customer)session.get(Customer.class, 19);
		System.out.println("---------------------------------------");
		
		// 3.第二次查询不会发送
		Customer customer2 = (Customer)session.get(Customer.class, 19);
		System.out.println(customer2.getName()+":"+customer2.getOrderInfo().size());
		// 4.开启第二个session
		Session session2 = sessionFactory.openSession();
		Transaction transaction = session2.beginTransaction();
		System.out.println("===================新的session=============================");
		Customer customer3 = (Customer)session2.get(Customer.class, 19);
		System.out.println(customer3.getName()+":"+customer3.getOrderInfo().size());
//		customer3.setName("AA"); // 修改缓存中的数据
		transaction.commit();// 会刷新缓存区
		
	}
	
	@Test
	public void testQueryAll1() {
		// 临时路径
		String path = System.getProperty("java.io.tmpdir");
		System.out.println(path);
	}
}
	
