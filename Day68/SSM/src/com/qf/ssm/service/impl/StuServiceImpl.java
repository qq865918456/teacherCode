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
		System.out.println("调用了查询学生的业务层！！！");
		return stuMapper.queryAll();
	}
}
