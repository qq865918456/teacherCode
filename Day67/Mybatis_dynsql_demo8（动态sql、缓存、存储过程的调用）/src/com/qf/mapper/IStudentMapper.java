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

	int updateStudent(Student stu);//只需要传入需要修改的字段，其他无需修改的字段为空就OK
	
	int deleteByIds(@Param("ids") Integer...ids);
	
	int insertStudents(@Param("slist") List<Student> slist);
	
	//调用存储过程 - 只有输入参数的存储过程 - 
	int callProcedure1(Student stu);
	
	//调用存储过程 - 即有输入又有输出类型的参数 
	void callProcedure2(Map<String, Object> map);
	
}
