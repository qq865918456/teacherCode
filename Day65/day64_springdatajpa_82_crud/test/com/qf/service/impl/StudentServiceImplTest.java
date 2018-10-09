package com.qf.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mchange.v2.sql.filter.SynchronizedFilterCallableStatement;
import com.qf.entity.Page;
import com.qf.entity.Student;
import com.qf.service.IStudentService;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class StudentServiceImplTest {

	@Autowired
	private IStudentService studentService;

	@Test
	public void testAddStudent() {
		Student student = new Student();
		student.setName("张三");
		student.setPassword("123");
		student.setEmail("zhagnsan@1000phone.com");
		student.setAge(33);
		student.setSex(0);
		System.out.println(studentService.addStudent(student));
	}

	@Test
	public void testUpdateStudent() {
		Student student = new Student();
		student.setId(34);
		student.setName("张三1");
		student.setPassword("1231");
		student.setEmail("zhagnsan1@1000phone.com");
		student.setAge(331);
		student.setSex(1);
		System.out.println(studentService.updateStudent(student));
	}

	@Test
	public void testGetStudentById() {
		System.out.println(studentService.getStudentById(314));
	}

	@Test
	public void testDeleteStudent() {
		System.out.println(studentService.deleteStudent(32));
	}

	@Test
	public void testGetStudentPage() {
		Page<Student> page = new Page<Student>();
		org.springframework.data.domain.Page<Student> page2 = studentService.getStudentPage(page);
		System.out.println(page2.getNumber()+1);
		System.out.println(page2.getTotalPages());
		System.out.println(page2.getSize());
		System.out.println(page2.getTotalElements());
		List<Student> content = page2.getContent();
		for (Student student : content) {
			System.out.println(student);
		}
	}

}
