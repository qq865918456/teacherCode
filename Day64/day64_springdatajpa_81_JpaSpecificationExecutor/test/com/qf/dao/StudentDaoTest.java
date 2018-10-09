package com.qf.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mchange.v2.sql.filter.SynchronizedFilterCallableStatement;
import com.qf.entity.Address;
import com.qf.entity.Student;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class StudentDaoTest {

	@Autowired
	private IStudentDao studentDao;
	
	@Autowired
	private IAddressDao addressDao;
	

	/**
	 * 查询id=33的对象
	 */
	@Test
	public void testQuery1(){
	
		// 1.接收分页信息
		Pageable pageable  = new PageRequest(0, 5);
		
		// 2.条件查询对象
		Specification<Student> spec = new Specification<Student>() {
			/**
			 * root:代表查询的实体类
			 * query:查询条件
			 * cb:用于创建 Criteria 相关对象的工厂,可以从中获取到 Predicate 对象
			 */
			@Override
			public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				// 获取条件查询的属性
				Path<Object> path = root.get("id");
				
				// 给条件赋值
				Predicate predicate = cb.equal(path,25);
				
				return predicate;
			}
			
		};
		
		// 3.得到分页对象
		Page<Student> page = studentDao.findAll(spec, pageable);
		List<Student> students = page.getContent();
		for (Student student : students) {
			System.out.println(student);
		}
	}
	
	
	/**
	 * 多个条件查询
	 */
	@Test
	public void testQuery2(){
		
		// 1.接收分页信息
		Pageable pageable  = new PageRequest(0, 5);
		
		// 2.条件查询对象
		Specification<Student> spec = new Specification<Student>() {
			/**
			 * root:代表查询的实体类
			 * query:查询条件
			 * cb:用于创建 Criteria 相关对象的工厂,可以从中获取到 Predicate 对象
			 */
			@Override
			public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				// 获取条件查询的属性
				Path<Object> pathName = root.get("name");
				Path<Object> pathPassword = root.get("password");
				
				// 给条件赋值
				Predicate p1 = cb.equal(pathName, "qf_9");
				Predicate p2 = cb.equal(pathPassword, "pw_9");
				
//				Predicate predicate = cb.and(p1,p2);
				Predicate predicate = cb.or(p1,p2);
				
				return predicate;
			}
			
		};
		// 3.得到分页对象
		Page<Student> page = studentDao.findAll(spec, pageable);
		List<Student> students = page.getContent();
		for (Student student : students) {
			System.out.println(student);
		}
	}
	
	/**
	 * 级联查询
	 * 给一个用户id查询地址
	 */
	@Test
	public void testQuery3(){
		
		// 1.接收分页信息
		Pageable pageable  = new PageRequest(0, 5);
		
		// 2.条件查询对象
		Specification<Address> spec = new Specification<Address>() {
			/**
			 * root:代表查询的实体类
			 * query:查询条件
			 * cb:用于创建 Criteria 相关对象的工厂,可以从中获取到 Predicate 对象
			 */
			@Override
			public Predicate toPredicate(Root<Address> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
//				Path<Object> path = root.get("student.id");
				// 级联查询
				Path<Object> path = root.get("student").get("id");
//				Path<Object> path = root.get("name");

				Predicate predicate = cb.equal(path, 33);
				
				return predicate;
			}
			
		};
		// 3.得到分页对象
		Page<Address> findAll = addressDao.findAll(spec, pageable);
		List<Address> content = findAll.getContent();
		for (Address address : content) {
			System.out.println(address);
		}
	}
}
