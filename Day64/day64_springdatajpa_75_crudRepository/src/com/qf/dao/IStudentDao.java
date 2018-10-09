package com.qf.dao;

import java.util.List;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;

import com.qf.entity.Student;

// CrudRepository<实体类,主键类型>
@RepositoryDefinition(domainClass=Student.class,idClass=Integer.class)
public interface IStudentDao  /*extends Repository<T, Serializable>*/ {

	public Student getStudentById(Integer id);
	
	public Student getByName(String name);
	
	public Student getByNameAndPassword(String name,String password);
	
	public List<Student> getByAgeAfter(Integer age);
	
	public List<Student> getByNameStartingWith(String name);
	
	public List<Student> getByNameStartingWithOrderByIdAsc(String name);
	
	
}
