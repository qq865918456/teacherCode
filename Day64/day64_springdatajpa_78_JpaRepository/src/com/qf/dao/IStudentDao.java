package com.qf.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.qf.entity.Student;

// JpaRepository:里面提供了批量操作的方法
public interface IStudentDao extends JpaRepository<Student, Integer> {
}
