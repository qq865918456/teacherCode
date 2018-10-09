package com.qf.stu.student_demo.service;

import com.qf.stu.student_demo.entity.Student;

import java.util.List;

public interface IStuService {

    List<Student> queryAll();

    Student insert(Student student);
}
