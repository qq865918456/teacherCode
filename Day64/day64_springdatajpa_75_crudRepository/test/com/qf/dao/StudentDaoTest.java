package com.qf.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qf.entity.Address;
import com.qf.entity.Student;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class StudentDaoTest {

	@Autowired
	private IStudentDao studentDao;
	
	@Autowired
	private IAddressDao addressDao;

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
	public void testGetById() {
		System.out.println(studentDao.getStudentById(1));
	}

	@Test
	public void testGetByName() {
		System.out.println(studentDao.getByName("qf1"));
	}

	@Test
	public void testAnd() {
		System.out.println(studentDao.getByNameAndPassword("q1f", "qf"));
	}

	@Test
	public void testAfter() {
		List<Student> byAgeAfter = studentDao.getByAgeAfter(3);
		for (Student student : byAgeAfter) {
			System.out.println(student);
		}
	}
	
	@Test
	public void testGetByNameStartingWith() {
		List<Student> byAgeAfter = studentDao.getByNameStartingWith("a");
		for (Student student : byAgeAfter) {
			System.out.println(student);
		}
	}
	
	@Test
	public void testOrderBy() {
		List<Student> byAgeAfter = studentDao.getByNameStartingWithOrderByIdAsc("q");
		for (Student student : byAgeAfter) {
			System.out.println(student);
		}
	}
	
	@Test
	public void testGetAddressById() {
		System.out.println(addressDao.getAddressById(1));
	}
	
	@Test
	public void testgetAddressByStudentId() {
		System.out.println(addressDao.getAddressByStudent_Id(1));
	}

}
