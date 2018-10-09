package com.qf.hibentae;

import java.util.List;

import javax.xml.bind.helpers.ValidationEventImpl;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Test;

import com.qf.entity.Customer;
import com.qf.utils.HibernateUtil;

public class BatchQueryTest {
	
	
	@Test
	public void testQuery(){
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Customer");
		
		List<Customer> customers = query.list();
		
		for (Customer customer : customers) {
			System.out.println(customer.getName()+":"+customer.getOrderInfo().size());
		}
		
		transaction.commit();
	}
	
}
