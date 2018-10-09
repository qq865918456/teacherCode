package com.qf.main;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

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
		
		
		IStudentMapper smapper = session.getMapper(IStudentMapper.class);
		IClasstabMapper cmapper = session.getMapper(IClasstabMapper.class);
		
//		Student stu = new Student();
//		stu.setAge(18);
//		List<Student> stus = smapper.queryStuInfoByEntity(stu);
//		System.out.println(stus);
		
//		Student stu = new Student();
//		stu.setId(2);
//		stu.setName(null);
//		stu.setAge(4);
//		smapper.updateStudent(stu);
		
//		int result = smapper.deleteByIds(2,4);
//		System.out.println(result);
//		
//		List<Student> list = new ArrayList();
//		Student stu1 = new Student();
//		stu1.setName("小黄");
//		stu1.setAge(2);
//		stu1.setCid(3);
//		Student stu2 = new Student();
//		stu2.setName("小绿");
//		stu2.setAge(3);
//		stu2.setCid(3);
//		Student stu3 = new Student();
//		stu3.setName("小兰");
//		stu3.setAge(4);
//		stu3.setCid(3);
//		list.add(stu1);
//		list.add(stu2);
//		list.add(stu3);
//		
//		int result = smapper.insertStudents(list);
//		System.out.println(result);
		
//		Student stu = smapper.queryOne(6);
//		System.out.println(stu);
		
		
		//调用存储过程
//		Student stu = new Student();
//		stu.setName("小灰");
//		stu.setAge(20);
//		stu.setCid(3);
//		int result = smapper.callProcedure1(stu);
//		System.out.println(result);
		
		Map<String, Object> map = new HashMap<>();
		map.put("id", 6);
		smapper.callProcedure2(map);
		System.out.println("存储过程的返回值：" + map.get("name"));
		
		session.commit();
		session.close();
		
		
//		SqlSession session2 = SqlSessionUtil.getSqlSession();
//		IStudentMapper smapper2 = session2.getMapper(IStudentMapper.class);
//		Student stu2 = smapper2.queryOne(6);
//		System.out.println(stu2);
//		session2.commit();
//		session2.close();
	}
}
