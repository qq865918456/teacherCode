package com.qf.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mchange.v2.sql.filter.SynchronizedFilterCallableStatement;
import com.qf.entity.Student;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class StudentDaoTest {

	@Autowired
	private IStudentDao studentDao;
	
	/**
	 * 演示排序
	 */
	@Test
	public void testBatchAdd() {
		List<Student> students = new ArrayList<Student>();
		for(int i =0;i<10;i++){
			Student student = new Student();
			student.setName("qf_"+i);
			student.setPassword("pw_"+i);
			student.setEmail("qf_"+i+"@1000phone.com");
			student.setAge(i*2);
			student.setSex(i % 2);
			
			students.add(student);
		}
		
		
		List<Student> save = studentDao.save(students);
		
	}
	
	
	@Test
	public void testBatchDel() {
//		studentDao.deleteAllInBatch();// 清空表
		studentDao.deleteAll();
	}
}
