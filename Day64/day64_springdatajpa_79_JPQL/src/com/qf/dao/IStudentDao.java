package com.qf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.qf.entity.Student;

public interface IStudentDao extends JpaRepository<Student, Integer> {
	
	// 加了@Query后直接执行里面的JQPL语句，不会在根据方法名称生成JPQL
	@Query("select s1 from Student s1 where s1.age =(select max(s.age)from Student s)")
	public Student findStudetnMaxAge();
	
	// nativeQuery=true:代表是原生的sql
	@Query(value="select * from t_student where age = (select max(age) from t_student)",nativeQuery=true)
	public Student findStudetnMaxAge1();
	
	// 按照顺序赋值，?1代表方法的第一个参数
	@Query("select s from Student s where s.name =?1 and s.password= ?2")
	public Student login(String username,String password);
	
	// 按照名称赋值
	@Query("select s from Student s where s.name = :name and s.password = :password")
	public Student login2(@Param("name")String name,@Param("password")String password);
	
	@Query("select s from Student s where s.name like %:name%")
	public List<Student> findStudent(@Param("name")String name);
}
