package com.qf.stu.student_demo.dao;

import com.qf.stu.student_demo.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IStuDao {

    List<Student> queryAll();

    int insert(Student student);
}
