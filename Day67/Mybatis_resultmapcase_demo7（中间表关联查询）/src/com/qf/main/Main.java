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
 * resultMap - �����ӳ��
 * @author ken
 *
 */
public class Main {

	public static void main(String[] args) {
		//��ѯѧ��
		SqlSession session = SqlSessionUtil.getSqlSession();
		
//		IStudentMapper mapper = session.getMapper(IStudentMapper.class);
//		//��ѯ����ѧ�� - ͬʱ��ѯ�����ѧ����Ӧ�İ༶
//		Student stu = mapper.queryOne(3);
//		System.out.println(stu);
		
		//��ѯ���а༶ - ������ѯÿ���༶������ѧ����Ϣ
		IClasstabMapper mapper = session.getMapper(IClasstabMapper.class);
		List<Classtab> ctabs = mapper.queryAll();
		for(Classtab tab : ctabs){
			System.out.println("=============================================");
			System.out.println("�༶�����ƣ�" + tab.getCname());
			for(Student stu : tab.getStus()){
				System.out.println("--ѧ����������" + stu.getName());
				for(Course course : stu.getCourses()){
					System.out.println("----ѧ����ѡ�Σ�" + course.getCourseName());
				}
			}
		}
		
		session.close();
		
	}
}
