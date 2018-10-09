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
 * resultMap - �����ӳ��
 * @author ken
 *
 */
public class Main {

	public static void main(String[] args) {
		//��ѯѧ��
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
		 * ������ѯ - ��ѯ����ѧ�� - ͬʱ������ѯ�����ѧ�����ڵİ༶��Ϣ
		 */
		Student stu = smapper.queryOne(3);
		System.out.println(stu.getName());
		System.out.println(stu.getCtab().getCname());
		
		/**
		 * ������ѯ - ��ѯ����ѧ�� - ͬʱ������ѯ��ÿ��ѧ�����ڵİ༶��Ϣ
		 */
//		List<Student> stus = smapper.queryAll();
//		for(Student stu : stus){
//			System.out.println(stu);
//		}
		
		/**
		 * ������ѯ - ��ѯ�����༶ - ͬʱ��ѯ������༶�µ�����ѧ��
		 */
//		Classtab ctab1 = cmapper.queryOne(1);
//		System.out.println(ctab1);
		
		/**
		 * ������ѯ - ��ѯ���а༶ - ͬʱ��ѯ��ÿ���༶������ѧ��
		 */
//		List<Classtab> clist = cmapper.queryAll();
//		for(Classtab ctab : clist){
//			System.out.println(ctab);
//		}
		
		session.close();
		
		
		
		//��ѯ�༶
		
	}
}
