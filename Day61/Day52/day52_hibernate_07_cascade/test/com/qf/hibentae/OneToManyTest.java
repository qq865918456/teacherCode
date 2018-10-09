package com.qf.hibentae;

import java.util.Set;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.hql.ast.tree.SessionFactoryAwareNode;
import org.junit.Test;

import com.qf.entity.Customer;
import com.qf.entity.OrderInfo;
import com.qf.utils.HibernateUtil;

public class OneToManyTest {

	/**
	 * 级联添加
	 */
	@Test
	public void testAdd3() {

		// 创建一个客户
		Customer customer = new Customer();
		customer.setName("张三");

		// 创建两个订单
		OrderInfo o1 = new OrderInfo();
		o1.setOrderName("订单A");
		OrderInfo o2 = new OrderInfo();
		o2.setOrderName("订单B");

		// 为什么要把关系维护在订单这边？因为关联字段的维护全在订单这边
		o1.setCustomer(customer);
		o2.setCustomer(customer);

		// 为什么要把关系维护在客户这边？因为保存一的一方的时候多的一方可以自动保存
		customer.getOrderInfo().add(o1);
		customer.getOrderInfo().add(o2);

		// 入库
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();

		session.save(customer);
		// session.save(o1);
		// session.save(o2);

		transaction.commit();

	}

	/**
	 * 级联删除
	 */
	@Test
	public void testDel() {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();

		Customer customer = (Customer) session.get(Customer.class, 18);

		// 获取客户的订单,手动解除关系
//		Set<OrderInfo> orderInfo = customer.getOrderInfo();
//		for (OrderInfo orderInfo2 : orderInfo) {
//			orderInfo2.setCustomer(null); // 修改缓存中的内容
//		}

		// 直接删除时失败失败，抛出外键约束异常
		session.delete(customer); // 删除客户

		transaction.commit();

	}

	@Test
	public void testUpdate() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();

		// 1.查询出来后放到缓存里面
		Customer customer = (Customer) session.get(Customer.class, 18);

		// 2.修改缓存中的值
		customer.setName("李四"); 

		// 3.刷新缓存
		transaction.commit();
	}

}
