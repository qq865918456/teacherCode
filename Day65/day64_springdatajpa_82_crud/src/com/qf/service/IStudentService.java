package com.qf.service;

import com.qf.entity.Page;
import com.qf.entity.Student;

public interface IStudentService {

	public int addStudent(Student student);
	
	public int updateStudent(Student student);
	
	public Student getStudentById(Integer id);
	
	public int deleteStudent(Integer id);
	
	public org.springframework.data.domain.Page<Student> getStudentPage(Page<Student> page);
	
}
