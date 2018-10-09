package com.qf.mapper;

import java.util.List;
import java.util.Map;

import com.qf.entity.Student;


public interface IStudentMapper {
	
	Student queryOne(Integer sid);
	
	List<Student> queryAll();
	
	List<Student> queryAllByCid(Integer cid);

}
