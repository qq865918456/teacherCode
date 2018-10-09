package com.qf.dao;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Test;

import com.qf.entity.Customer;
import com.qf.utils.HibernateUtil;

public class HibernateTest {
	@Test
	public void test() {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Customer customer = new Customer();
		customer.setName("千锋");
		session.save(customer);
		transaction.commit();
	}

}
