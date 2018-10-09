package com.qf.hibentae;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Test;

import com.qf.entity.User;
import com.qf.utils.HibernateUtil;

public class HibernateTest {

	@Test
	public void test() {
		
		// 1.先获得session工厂
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		// 2.通过session获取session
		Session session = sessionFactory.getCurrentSession();
		
		// 开启事务
		Transaction transaction = session.beginTransaction(); 
		
		// 3.根据id查询对象
		User user = (User)session.get(User.class, 2);
		
		System.out.println(user);
		
		// 4.session关闭
		session.close(); 
		
		// 5关闭工厂
		sessionFactory.close();
	}
	
}
