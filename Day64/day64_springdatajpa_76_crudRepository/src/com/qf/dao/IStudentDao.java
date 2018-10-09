package com.qf.dao;

import org.springframework.data.repository.CrudRepository;

import com.qf.entity.Student;

public interface IStudentDao extends CrudRepository<Student, Integer> {
}
