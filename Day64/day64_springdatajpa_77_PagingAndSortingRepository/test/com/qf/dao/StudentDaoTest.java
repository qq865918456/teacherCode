package com.qf.dao;

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
	public void testOrdrBy() {
		// 1.创建排序对象
		Sort sort = new Sort(Direction.DESC, "id") ;
		// 2.查询
		Iterable<Student> iterable = studentDao.findAll(sort );
		
		// 3.获得迭代对象
		Iterator<Student> iterator = iterable.iterator();
		while (iterator.hasNext()) {
			Student student = (Student) iterator.next();
			System.out.println(student);
		}
	}
	
	@Test
	public void testPage() {
	
		Integer currentPage = 1;
		
		// 1.设置分页参数和排序规则,从0开始
		Pageable pageable = new PageRequest(currentPage-1, 5, Direction.ASC, "id");
//		Pageable pageable = new PageRequest(1, 5);
		Page<Student> page = studentDao.findAll(pageable);
		System.out.println("页码:"+(page.getNumber()+1));
		System.out.println("每页显示的条数:"+page.getSize());
		System.out.println("总页数:"+page.getTotalPages());
		System.out.println("总条数:"+page.getTotalElements());
		List<Student> list = page.getContent();
		for (Student student : list) {
			System.out.println(student);
		}
		
	}
}
