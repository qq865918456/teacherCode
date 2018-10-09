package com.qf.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.qf.entity.Student;

public interface IStudentDao extends JpaRepository<Student, Integer>{

	@Modifying
	@Query(value="delete from Student s where s.id = :id")
	public int deleteUser(@Param("id")Integer id);
	
}
