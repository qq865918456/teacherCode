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
	 * 演示使用JPQL更新操作
	 */
	@Test
	public void testUpdateStudent() {
		System.out.println(studentDao.updateStuent("admin", 24));
	}
	@Test
	public void testDeleteStudent() {
		System.out.println(studentDao.deleteStuent(24));
	}
	
}
