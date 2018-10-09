package com.qf.hibentae;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Test;

import com.qf.entity.Customer;
import com.qf.entity.OrderInfo;
import com.qf.utils.HibernateUtil;

public class FetchingTest {

	/**
	 * 类级别的检索
	 */
	@Test
	public void testLoad() {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		// load:懒加载是默认值,通过修饰lazy属性可以修改
		Customer customer = (Customer) session.load(Customer.class, 16);
		transaction.commit();

	}
	
	/**
	 * 关联级别的检索,默认机制使用就查询，不使用就查询
	 */
	@Test
	public void testLoad2() {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		Customer customer = (Customer) session.get(Customer.class, 16);
		System.out.println("========================");
		
		System.out.println(customer.getName()+":"+customer.getOrderInfo().size());
//		System.out.println(customer.getName());
		
//		Set<OrderInfo> orderInfo = customer.getOrderInfo();
//		for (OrderInfo orderInfo2 : orderInfo) {
//			System.out.println(orderInfo2.getOrderName());
//		}
		transaction.commit();
		
	}
	
	/**
	 * 查询一个list
	 */
	@Test
	public void testGetList() {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		// select * from t_User u -->sql
		// select * from User -- >hql
		// 这里不支持*的写法
		Query query = session.createQuery("select c from Customer c"); // hql(面向对象的)-->sql
		
		List<Customer> customers = query.list();
		
		for (Customer customer : customers) {
			System.out.println(customer.getId()+":"+customer.getName());
		}
		
		transaction.commit();
	}
	
	
	/**
	 * 对比select和subselect区别
	 */
	@Test
	public void testGetList1() {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("select c from Customer c"); // hql(面向对象的)-->sql
		
		List<Customer> customers = query.list();
		
		for (Customer customer : customers) {
			System.out.println(customer.getName()+":"+customer.getOrderInfo().size());
		}
		
		transaction.commit();
	}

}
