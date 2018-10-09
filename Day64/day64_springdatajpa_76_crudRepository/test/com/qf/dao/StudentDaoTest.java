package com.qf.dao;

import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qf.entity.Student;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class StudentDaoTest {

	@Autowired
	private IStudentDao studentDao;
	
	@Test
	public void testAdd() {
		Student student = new Student();
		student.setName("qf");
		student.setEmail("qf@1000phone.com");
		student.setSex(1);
		student.setAge(6);
		// Student student2 = studentDao.save(student);
		// System.out.println(student2);
	}
	
	@Test
	public void testUpate() {
		Student student = new Student();
		student.setId(3);
		student.setName("qf3");
		student.setPassword("123x");
		student.setEmail("qf3@1000phone.com");
		student.setSex(1);
		student.setAge(6);
		
		//save:有id就更新，没有id就插入
		Student student2 = studentDao.save(student);
		System.out.println(student2);
	}
	@Test
	public void testGetById() {
		Student student = studentDao.findOne(3);
		System.out.println(student);
	}
	
	@Test
	public void testExists() {
		System.out.println(studentDao.exists(31));
	}
	
	@Test
	public void testFindAll() {
		Iterable<Student> sIterable = studentDao.findAll();
		Iterator<Student> iterator = sIterable.iterator();
		while (iterator.hasNext()) {
			Student student = (Student) iterator.next();
			System.out.println(student);
		}
	}
	
	@Test
	public void testCount() {
		System.out.println(studentDao.count());
	}
	
	@Test
	public void testDelete() {
		studentDao.delete(31);
	}

}
