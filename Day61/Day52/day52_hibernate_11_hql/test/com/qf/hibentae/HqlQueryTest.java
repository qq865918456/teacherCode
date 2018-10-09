package com.qf.hibentae;

import java.util.List;

import javax.xml.bind.helpers.ValidationEventImpl;

import org.apache.commons.collections.set.SynchronizedSet;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.usertype.CompositeUserType;
import org.junit.Test;
import org.omg.CORBA.INTERNAL;

import com.qf.entity.Customer;
import com.qf.utils.HibernateUtil;

public class HqlQueryTest {

	/**
	 * 查询集合
	 */
	@Test
	public void testQueryAll() {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from Customer");

		List<Customer> customers = query.list();

		for (Customer customer : customers) {
			System.out.println(customer.getName() + ":" + customer.getOrderInfo().size());
		}

		transaction.commit();
	}

	/**
	 * 单个对象的查询
	 */
	@Test
	public void testQueryById() {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();

		// Query query = session.createQuery("from Customer where id = 19");
		// Query query = session.createQuery("from Customer where id = ?");
		Query query = session.createQuery("from Customer where id = :id"); // 可读性强
		// 给占位符赋值
		// query.setParameter(arg0, arg1); // setObject();
		// query.setInteger(0, 19); // 从0开始
		query.setInteger("id", 19);

		Customer customer = (Customer) query.uniqueResult(); // 返回单个对象

		System.out.println(customer.getName());

		transaction.commit();
	}

	/**
	 * 演示投影
	 */
	@Test
	public void testQueryList2() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();

		// 如果只显示一个字段返回的该字段类型的集合
		// Query query = session.createQuery("select c.id from Customer c");

		// 如果显示多列返回的是个Object数组
		// Query query = session.createQuery("select c.id,c.name from Customer
		// c");

		// 直接构造器返回的是对象类型
		Query query = session.createQuery("select new Customer(c.id,c.name) from Customer c");

		List<Customer> ids = query.list();

		for (Customer customer : ids) {
			System.out.println(customer.getName());
		}

		transaction.commit();
	}

	/**
	 * 演示排序
	 */
	@Test
	public void testOrderBy() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from Customer c order by c.id desc");

		List<Customer> ids = query.list();

		for (Customer customer : ids) {
			System.out.println(customer);
		}

		transaction.commit();
	}

	/**
	 * 演示分页
	 */
	@Test
	public void testPage() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from Customer");

		// 设置分页参数
		query.setFirstResult(0);// 起始的函数
		query.setMaxResults(3); // 每页显示的条数

		List<Customer> customers = query.list();
		for (Customer customer : customers) {
			System.out.println(customer);
		}

		transaction.commit();
	}

	@Test
	public void testQueryByName() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();

//		Query query = session.createQuery("from Customer c where c. name like ?");
		Query query = session.createQuery("from Customer c where c. name like :name");

//		query.setParameter(0, "张%");
		query.setParameter("name", "张%");

		List<Customer> customers = query.list();
		
		for (Customer customer : customers) {
			System.out.println(customer);
		}
		transaction.commit();
	}
	
	/**
	 * 演示聚合函数
	 */
	@Test
	public void testFucntion() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		// count()返回的是long类型
//		Query query = session.createQuery("select count(c) from Customer c");
		
		// 返回的是那个字段类型
		Query query = session.createQuery("select max(c.name) from Customer c");
		
		Long  count = (Long)query.uniqueResult(); 
		
		System.out.println(count);
		
		transaction.commit();
	}
	
	/**
	 * 连接查询
	 */
	@Test
	public void testJoin() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		// 会产生笛卡尔积
//		Query query = session.createQuery("select c from Customer c,OrderInfo o");
		
		// 下面这两种写法结果是一样的
//		Query query = session.createQuery("select c from Customer c,OrderInfo o where c.id = o.customer.id");
//		Query query = session.createQuery("select c from Customer c,OrderInfo o where o.customer = c");
		
		// 分组的目的去重
//		Query query = session.createQuery("select c from Customer c,OrderInfo o where o.customer = c group by c.id");
		
		// 连接的写法
		Query query = session.createQuery("select c from Customer c left join fetch c.orderInfo");
		
		List<Customer> list = query.list(); // 用什么类型来结束取决于select后面要显示什么
		for (Customer customer : list) {
			System.out.println(customer.getId()+":"+customer.getName());
		}
		transaction.commit();
	}
	
	/**
	 * 命名查询
	 */
	@Test
	public void testNameQuery() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		// 调用局部命名查询
//		Query query = session.getNamedQuery("com.qf.entity.Customer.query2");
		
		// 调用全局的命名查询
		Query query = session.getNamedQuery("query1");
		query.setInteger("id", 16);
		
		List<Customer> list = query.list(); // 用什么类型来结束取决于select后面要显示什么
		for (Customer customer : list) {
			System.out.println(customer.getId()+":"+customer.getName());
		}
		transaction.commit();
	}
	
	/**
	 * 利用HQL更新(update,insert,delete)
	 */
	@Test
	public void testHqlUpdate() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("delete from Customer c where c.id = :id");
		
		// 赋值
		query.setInteger("id", 23);
		
		// 执行
//		query.list();
//		query.uniqueResult();
		
		int executeUpdate = query.executeUpdate();

		System.out.println(executeUpdate);
		
		transaction.commit();
	}

	
}
