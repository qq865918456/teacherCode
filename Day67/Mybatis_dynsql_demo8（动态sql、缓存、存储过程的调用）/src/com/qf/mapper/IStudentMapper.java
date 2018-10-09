package com.qf.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.qf.entity.Student;


public interface IStudentMapper {
	
	Student queryOne(Integer sid);
	
	List<Student> queryAll();
	
	List<Student> queryAllByCid(Integer cid);
	
	List<Student> queryStuInfoByEntity(Student stu);//name=xiaoming age=18

	int updateStudent(Student stu);//ֻ��Ҫ������Ҫ�޸ĵ��ֶΣ����������޸ĵ��ֶ�Ϊ�վ�OK
	
	int deleteByIds(@Param("ids") Integer...ids);
	
	int insertStudents(@Param("slist") List<Student> slist);
	
	//���ô洢���� - ֻ����������Ĵ洢���� - 
	int callProcedure1(Student stu);
	
	//���ô洢���� - ������������������͵Ĳ��� 
	void callProcedure2(Map<String, Object> map);
	
}
