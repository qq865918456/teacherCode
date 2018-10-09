package com.qf.dao;

import java.util.List;

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
	
	/**
	 * 演示调用统计函数
	 */
	@Test
	public void testBatchAdd() {
		Student student = studentDao.findStudetnMaxAge();
		System.out.println(student);
	}
	
	/**
	 * 演示@Query注解中写原生的sql
	 */
	@Test
	public void testFindStudetnMaxAge1() {
		Student student = studentDao.findStudetnMaxAge1();
		System.out.println(student);
	}
	
	@Test
	public void testLogin() {
		Student student = studentDao.login2("qf_9", "pw_9");
		System.out.println(student);
	}
	
	@Test
	public void testFindStudent() {
		List<Student> findStudent = studentDao.findStudent("qxxxx");
		for (Student student : findStudent) {
			System.out.println(student);
		}
	}
}
