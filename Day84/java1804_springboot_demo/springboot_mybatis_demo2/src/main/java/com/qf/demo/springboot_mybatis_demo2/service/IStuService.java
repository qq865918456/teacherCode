package com.qf.demo.springboot_mybatis_demo2.service;

import com.qf.demo.springboot_mybatis_demo2.entity.Student;

import java.util.List;

public interface IStuService {

    List<Student> queryAll();

    int insert(Student stu);
}
