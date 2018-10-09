package com.qf.demo.springboot_mybatis_demo2.dao;

import com.qf.demo.springboot_mybatis_demo2.entity.Student;

import java.util.List;

public interface IStuDao {

    List<Student> queryAll();

    int insert(Student stu);
}
