package com.qf.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Main {

	/**
	 * ����Mybatis
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		//1������һ��Mybatis���������������������ģʽ��
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		//2��ͨ������������Session���� - ��������ʾmybatis�ĺ��������ļ�
		//1)�ֶ����classpath·�� Main.class.getResource("/").getPath();
		//2)ʹ��mybatis�ṩ��һ��Resources���߷�����������ļ�
		InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = builder.build(in);
		
		//3��ͨ��SqlSessionFactory���SqlSession
		SqlSession session = sqlSessionFactory.openSession();
		
		
		
		//4��ͨ��session����ӳ��ӿ�
		UserMapper mapper = session.getMapper(UserMapper.class);
		
		//5�����÷���
		
		//ִ��queryById
//		User user = mapper.queryById(1);
//		System.out.println("��ѯ�����" + user);
		
		
		//ִ��insertUser
//		User user = new User();
//		user.setName("С��");
//		user.setAge(16);
//		int result = mapper.insertUser(user);
//		System.out.println("�����û���Ϣ��" + result);
		
		//ִ���޸�updateUser
//		User user = new User();
//		user.setId(1);
//		user.setName("С����");
//		user.setAge(1000);
//		int result = mapper.updateUser(user);
//		System.out.println("�޸��û���Ϣ��" + result);
		
		
		//ִ��ɾ��
//		int result = mapper.deleteById(1);
//		System.out.println("ɾ���û���Ϣ��" + result);
		
		
		//��ѯȫ��
		List<User> users = mapper.queryAll();
		System.out.println("��ѯ�����û���Ϣ��" + users);
		
		//6���ر�session
		session.commit();//�������ɾ�ı����ύ����
		session.close();
	}
}
