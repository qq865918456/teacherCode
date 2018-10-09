package com.qf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qf.dao.IStudentDao;
import com.qf.entity.Page;
import com.qf.entity.Student;
import com.qf.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentDao stuDao;
	
	@Override
	public int addStudent(Student student) {
		Student save = stuDao.save(student);
		return save == null ?0:1;
	}

	@Override
	public int updateStudent(Student student) {
		return this.addStudent(student);
	}

	@Override
	public Student getStudentById(Integer id) {
		return stuDao.findOne(id);
	}

	@Transactional
	@Override
	public int deleteStudent(Integer id) {
		return stuDao.deleteUser(id);
	}

	@Override
	public org.springframework.data.domain.Page<Student> getStudentPage(Page<Student> page) {
		
		Integer currentPage = page.getCurrentPage();
		Integer pageSize = page.getPageSize();
		
		// 从0开始
		Pageable pageable = new PageRequest(currentPage-1, pageSize, Direction.DESC,"id");
		return stuDao.findAll(pageable);
	}

}
