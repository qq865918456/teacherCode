package com.qf.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.qf.entity.Student;

// PagingAndSortingRepository:里面提供了排序和分页的方法
public interface IStudentDao extends PagingAndSortingRepository<Student, Integer> {
}
