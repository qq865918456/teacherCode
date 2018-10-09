package com.qf.hibentae;

import static org.junit.Assert.*;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Test;

import com.qf.entity.Customer;
import com.qf.entity.OrderInfo;
import com.qf.utils.HibernateUtil;

public class OneToManyTest {

	/**
	 * 插入了三天记录，但是订单表中没有客户id
	 */
	@Test
	public void testAdd1() {
		
		// 创建一个客户
		Customer customer = new Customer();
		customer.setName("李四");
		
		// 创建两个订单
		OrderInfo o1 = new OrderInfo();
		o1.setOrderName("订单A");
		OrderInfo o2 = new OrderInfo();
		o2.setOrderName("订单B");
		
		
		// 入库
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(customer);
		session.save(o1);
		session.save(o2);
		
		transaction.commit();
		
	}
	
	/**
	 * 解决了add1()添加是遗留的问题
	 */
	@Test
	public void testAdd2() {
		
		// 创建一个客户
		Customer customer = new Customer();
		customer.setName("李四");
		
		
		// 创建两个订单
		OrderInfo o1 = new OrderInfo();
		o1.setOrderName("订单A");
		OrderInfo o2 = new OrderInfo();
		o2.setOrderName("订单B");
		
		// 建立关系
//		customer.getOrderInfo().add(o1);
//		customer.getOrderInfo().add(o2);
		
		o1.setCustomer(customer);
		o2.setCustomer(customer);
		
		
		// 入库
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(customer);
		session.save(o1);
		session.save(o2);
		
		transaction.commit();
		
	}
	
	@Test
	public void testAdd3() {
		
		// 创建一个客户
		Customer customer = new Customer();
		customer.setName("李四");
		
		// 创建两个订单
		OrderInfo o1 = new OrderInfo();
		o1.setOrderName("订单A");
		OrderInfo o2 = new OrderInfo();
		o2.setOrderName("订单B");
		
		// 建立关系
//		customer.getOrderInfo().add(o1);
//		customer.getOrderInfo().add(o2);
		
		o1.setCustomer(customer);
		o2.setCustomer(customer);
		
		
		// 入库
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(customer);
		session.save(o1);
		session.save(o2);
		
		transaction.commit();
		
	}
}
