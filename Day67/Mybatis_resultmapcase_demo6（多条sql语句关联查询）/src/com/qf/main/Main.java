package com.qf.main;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.qf.entity.Classtab;
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
		
//		IStudentMapper smapper = session.getMapper(IStudentMapper.class);
//		Student stu = smapper.queryOne(1);
//		System.out.println(stu);
		
//		IClasstabMapper cmapper = session.getMapper(IClasstabMapper.class);
//		Classtab ctab = cmapper.queryOne(1);
//		System.out.println(ctab);
		
		
		IStudentMapper smapper = session.getMapper(IStudentMapper.class);
		IClasstabMapper cmapper = session.getMapper(IClasstabMapper.class);
		/**
		 * 级联查询 - 查询单个学生 - 同时级联查询出这个学生所在的班级信息
		 */
		Student stu = smapper.queryOne(3);
		System.out.println(stu.getName());
		System.out.println(stu.getCtab().getCname());
		
		/**
		 * 级联查询 - 查询所有学生 - 同时级联查询出每个学生所在的班级信息
		 */
//		List<Student> stus = smapper.queryAll();
//		for(Student stu : stus){
//			System.out.println(stu);
//		}
		
		/**
		 * 级联查询 - 查询单个班级 - 同时查询出这个班级下的所有学生
		 */
//		Classtab ctab1 = cmapper.queryOne(1);
//		System.out.println(ctab1);
		
		/**
		 * 级联查询 - 查询所有班级 - 同时查询出每个班级的所有学生
		 */
//		List<Classtab> clist = cmapper.queryAll();
//		for(Classtab ctab : clist){
//			System.out.println(ctab);
//		}
		
		session.close();
		
		
		
		//查询班级
		
	}
}
