package com.qf.hibentae;

import java.util.Set;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.usertype.UserCollectionType;
import org.junit.Test;

import com.qf.entity.Customer;
import com.qf.entity.OrderInfo;
import com.qf.utils.HibernateUtil;

public class HibernateTest {

	
	@Test
	public void TestAddCustomer(){
		
		// 创建一个对象
		Customer customer = new Customer();
		customer.setName("张三");
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		System.out.println(session.save(customer));
		transaction.commit();
	}
	
	@Test
	public void TestAddOrderInfo(){
		
		// 创建一个对象
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setOrderName("订单A");
		
		Customer customer = new Customer();
		customer.setId(1);
		
		// 订单属于一个客户
		orderInfo.setCustomer(customer);
		
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		System.out.println(session.save(orderInfo));
		transaction.commit();
	}
	
	@Test
	public void testGetCustomer(){
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Customer customer = (Customer)session.get(Customer.class, 1);
		System.out.println(customer.getName());
		Set<OrderInfo> orderInfo = customer.getOrderInfo();
		for (OrderInfo orderInfo2 : orderInfo) {
			System.out.println(orderInfo2.getOrderName());
		}
		transaction.commit();
	}
	
	@Test
	public void testGetOrderInfo(){
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		OrderInfo orderInfo = (OrderInfo)session.get(OrderInfo.class, 6);
		System.out.println(orderInfo.getOrderName());
		Customer customer = orderInfo.getCustomer();
		System.out.println(customer.getName());
		transaction.commit();
	}
	
}