package com.qf.hibentae;

import java.util.List;

import javax.xml.bind.helpers.ValidationEventImpl;

import org.apache.commons.collections.buffer.CircularFifoBuffer;
import org.apache.commons.collections.set.SynchronizedSet;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.usertype.CompositeUserType;
import org.junit.Test;
import org.omg.CORBA.INTERNAL;

import com.qf.entity.Customer;
import com.qf.utils.HibernateUtil;

public class QBCQueryTest {

	/**
	 * 查询集合
	 */
	@Test
	public void testQueryAll() {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		// Criteria 条件查询对象
		Criteria criteria = session.createCriteria(Customer.class);

		List<Customer> customers= criteria.list();
		
//		criteria.uniqueResult(); // 返回单个对象
		for (Customer customer : customers) {
			System.out.println(customer.getName());
		}

		transaction.commit();
	}
	
	
	@Test
	public void testQueryPage() {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		// Criteria 条件查询对象
		Criteria criteria = session.createCriteria(Customer.class);
		
		criteria.setFirstResult(0);// 起始的行数
		criteria.setMaxResults(3); // 显示的条数
		
		List<Customer> customers= criteria.list();
		for (Customer customer : customers) {
			System.out.println(customer.getName());
		}
		
		transaction.commit();
	}
	
	/**
	 * 排序
	 */
	@Test
	public void testOrderBy() {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		// Criteria 条件查询对象
		Criteria criteria = session.createCriteria(Customer.class);
		
		criteria.addOrder(Order.desc("id")); // order by id desc
		
		List<Customer> customers= criteria.list();
		for (Customer customer : customers) {
			System.out.println(customer.getId()+":"+customer.getName());
		}
		
		transaction.commit();
	}
	
	
	/**
	 * 条件查询
	 */
	@Test
	public void testGetById() {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		// Criteria 条件查询对象
		Criteria criteria = session.createCriteria(Customer.class);
		
//		criteria.add(Restrictions.eq("id", 19)); // where id = 1
		criteria.add(Restrictions.gt("id", 20)); // where id > 20
		criteria.add(Restrictions.like("name", "赵%"));
		List<Customer> list = criteria.list();
		for (Customer customer2 : list) {
			System.out.println(customer2);
		}
		
		transaction.commit();
	}
	
	/**
	 * 离线查询
	 */
	@Test
	public void testNoLine() {
		
		
		// 在没有和数据库建立连接之前先把条件组好了
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
		detachedCriteria.add(Restrictions.like("name", "%张%"));
		detachedCriteria.add(Restrictions.gt("id", 10));

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		// 获取到session后直接查询
		Criteria criteria = detachedCriteria.getExecutableCriteria(session);
		
		List<Customer> list = criteria.list();
		for (Customer customer2 : list) {
			System.out.println(customer2);
		}
		
		transaction.commit();
	}


}
