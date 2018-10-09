package com.qf.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.qf.entity.Student;

public interface IStudentDao extends JpaRepository<Student, Integer> {

	@Transactional(readOnly=false)
	@Modifying // 添加该注解就代表这是一个更新操作
	@Query("update Student s set s.name = :name where id = :id")
	public int updateStuent(@Param("name")String name,@Param("id")Integer id);
	
	@Transactional(readOnly=false)
	@Modifying // 添加该注解就代表这是一个更新操作
	@Query("delete from Student where id = :id")
	public int deleteStuent(@Param("id")Integer id);
	
}
