package com.qf.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.qf.dao.ICustomerDao;
import com.qf.entity.Customer;
import com.qf.utils.HibernateUtil;
import com.sun.prism.paint.RadialGradient;

public class CustomerDaoImpl implements ICustomerDao {

	@Override
	public int addCustomer(Customer customer) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Serializable save = session.save(customer);
		transaction.commit();

		return (int) save;
	}

	@Override
	public int udpateCustomer(Customer customer) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.update(customer); // ? 用hql更新
		transaction.commit();
		return 0;
	}

	@Override
	public Customer getCustomerById(Integer id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Customer customer = (Customer) session.get(Customer.class, id);
		transaction.commit();
		return customer;
	}

	@Override
	public int deleteCustomer(Integer id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		// Customer customer = new Customer();
		// customer.setId(id);
		// session.delete(customer);;

		Query query = session.createQuery("delete from Customer c where c.id = :id");

		query.setInteger("id", id);

		int executeUpdate = query.executeUpdate();

		transaction.commit();
		return executeUpdate;
	}

	@Override
	public int getCustomerCount() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("select count(c) from Customer c");
		Long count = (Long)query.uniqueResult();

		transaction.commit();
		return count.intValue();
	}

	@Override
	public List<Customer> getCustomerList(Integer start, Integer size) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Customer");

		query.setFirstResult(start);
		query.setMaxResults(size);

		List<Customer> customers = query.list();

		transaction.commit();
		return customers;
	}

}
