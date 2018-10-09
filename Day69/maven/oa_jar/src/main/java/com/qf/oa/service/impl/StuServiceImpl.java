package com.qf.oa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qf.oa.dao.IStuDao;
import com.qf.oa.entity.Student;
import com.qf.oa.service.IStuService;

@Service
public class StuServiceImpl implements IStuService {

	@Autowired
	private IStuDao stuDao;
	
	public List<Student> queryAll() {
		System.out.println("调用了service！！！！");
		return stuDao.queryAll();
	}
}
