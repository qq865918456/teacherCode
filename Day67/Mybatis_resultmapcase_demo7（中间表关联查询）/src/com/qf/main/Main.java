package com.qf.main;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.qf.entity.Classtab;
import com.qf.entity.Course;
import com.qf.entity.Student;
import com.qf.mapper.IClasstabMapper;
import com.qf.mapper.IStudentMapper;
import com.qf.util.SqlSessionUtil;

/**
 * resultMap - 结果集映射
 * @author ken
 *
 */
public class Main {

	public static void main(String[] args) {
		//查询学生
		SqlSession session = SqlSessionUtil.getSqlSession();
		
//		IStudentMapper mapper = session.getMapper(IStudentMapper.class);
//		//查询单个学生 - 同时查询出这个学生对应的班级
//		Student stu = mapper.queryOne(3);
//		System.out.println(stu);
		
		//查询所有班级 - 关联查询每个班级的所有学生信息
		IClasstabMapper mapper = session.getMapper(IClasstabMapper.class);
		List<Classtab> ctabs = mapper.queryAll();
		for(Classtab tab : ctabs){
			System.out.println("=============================================");
			System.out.println("班级的名称：" + tab.getCname());
			for(Student stu : tab.getStus()){
				System.out.println("--学生的姓名：" + stu.getName());
				for(Course course : stu.getCourses()){
					System.out.println("----学生的选课：" + course.getCourseName());
				}
			}
		}
		
		session.close();
		
	}
}
