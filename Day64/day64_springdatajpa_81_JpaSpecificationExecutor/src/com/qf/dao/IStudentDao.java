package com.qf.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.qf.entity.Student;

public interface IStudentDao extends JpaRepository<Student, Integer>,JpaSpecificationExecutor<Student> {

}
