package com.qf.demo.springboot_mybatis_demo2.service.impl;

import com.qf.demo.springboot_mybatis_demo2.dao.IStuDao;
import com.qf.demo.springboot_mybatis_demo2.entity.Student;
import com.qf.demo.springboot_mybatis_demo2.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StuServiceImpl implements IStuService {

    @Autowired
    private IStuDao iStuDao;

    @Override
    public List<Student> queryAll() {
        return iStuDao.queryAll();
    }

    @Override
    @Transactional
    public int insert(Student stu) {
        int result = iStuDao.insert(stu);
        System.out.println(1/0);
        return result;
    }
}
