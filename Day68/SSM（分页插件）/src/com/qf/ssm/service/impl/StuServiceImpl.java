package com.qf.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qf.ssm.entity.Student;
import com.qf.ssm.mapper.IStuMapper;
import com.qf.ssm.service.IStuService;

@Service
public class StuServiceImpl implements IStuService {

	@Autowired
	private IStuMapper stuMapper;
	
	public List<Student> queryAll() {
		
//		Student stu = new Student();
//		stu.setName("ะกวเ");
//		stu.setAge(9999);
//		stu.setCid(1);
//		
//		stuMapper.insertStu(stu);
		
		return stuMapper.queryAll();
	}
}
