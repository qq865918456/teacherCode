package com.qf.hibentae;

import static org.junit.Assert.*;

import java.security.KeyStore.CallbackHandlerProtection;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.After;
import org.junit.Test;

import com.qf.entity.Classes;
import com.qf.entity.Teacher;
import com.qf.utils.HibernateUtil;

public class MnayToManyTest {

	@Test
	public void testAddTeacher() {
		Teacher teacher = new Teacher();
		teacher.setName("达老师");

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		System.out.println(session.save(teacher));
		transaction.commit();
	}

	@Test
	public void testAddClasses() {
		Classes classes = new Classes();
		classes.setName("JavaEE1804");

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		System.out.println(session.save(classes));
		transaction.commit();
	}
	
	/**
	 * 没有维护关系
	 */
	@Test
	public void testAdd1() {
		
		// 创建一个两个老师
		Teacher t1 = new Teacher();
		t1.setName("达老师");
		
		Teacher t2 = new Teacher();
		t2.setName("候老师");
		
		
		// 创建两个班级
		Classes c1 =new Classes();
		c1.setName("JavaEE1802");
		
		Classes c2 =new Classes();
		c2.setName("JavaEE1804");
		
		
		// 入库
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(t1);
		session.save(t2);
		
		session.save(c1);
		session.save(c2);
		
		transaction.commit();
	}
	
	/**
	 * 两边都维护关系
	 */
	@Test
	public void testAdd2() {
		
		// 创建一个两个老师
		Teacher t1 = new Teacher();
		t1.setName("达老师");
		
		Teacher t2 = new Teacher();
		t2.setName("候老师");
		
		
		// 创建两个班级
		Classes c1 =new Classes();
		c1.setName("JavaEE1802");
		
		Classes c2 =new Classes();
		c2.setName("JavaEE1804");
		
		// 关系维护在老师这边
		t1.getClasses().add(c1);
		t1.getClasses().add(c2);
		
		t2.getClasses().add(c1);
		t2.getClasses().add(c2);
		
		
		// 关系维护在班级这边
		c1.getTeachers().add(t1);
		c1.getTeachers().add(t2);
		
		c2.getTeachers().add(t1);
		c2.getTeachers().add(t2);
		
		// 入库
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(t1);
		session.save(t2);
		
		session.save(c1);
		session.save(c2);
		
		transaction.commit();
	}
	
	/**
	 * 维系设置在teacher维护，所以一定要给teacher建立关系
	 */
	@Test
	public void testAdd3() {
		
		// 创建一个两个老师
		Teacher t1 = new Teacher();
		t1.setName("达老师");
		
		Teacher t2 = new Teacher();
		t2.setName("候老师");
		
		
		// 创建两个班级
		Classes c1 =new Classes();
		c1.setName("JavaEE1802");
		
		Classes c2 =new Classes();
		c2.setName("JavaEE1804");
		
		// 关系维护在老师这边
		t1.getClasses().add(c1);
		t1.getClasses().add(c2);
		
		t2.getClasses().add(c1);
		t2.getClasses().add(c2);
		
		// 入库
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(t1);
		session.save(t2);
		
//		session.save(c1);
//		session.save(c2);
		
		transaction.commit();
	}

}
