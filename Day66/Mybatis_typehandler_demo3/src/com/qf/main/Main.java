package com.qf.main;

import org.apache.ibatis.session.SqlSession;

import com.qf.entity.User;
import com.qf.mapper.IUserMapper;
import com.qf.util.SqlSessionUtil;
import com.qf.util.SqlSessionUtil2;

/**
 * ����ת����
 * Class{
 *  String[] name; {'��ŭ��', '����'}
 *  int age;
 *  Date birthday;
 * }
 * 
 * table(
 *  name varchar '��ŭ��-����'
 *  age int
 *  birthday datetime
 * )
 * 
 * 
 * @author ken
 *
 */
public class Main {

	public static void main(String[] args) {
		SqlSession sqlSession = SqlSessionUtil2.getSqlSession();
		IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);
		User user = userMapper.queryUserById(6);
		System.out.println(user);
		sqlSession.close();
		
		
//		SqlSession session = SqlSessionUtil2.getSqlSession();
//		IUserMapper mapper = session.getMapper(IUserMapper.class);
//		
//		User user = new User();
//		user.setName(new String[]{"��ŭ��","����"});
//		user.setAge(19);
//		int result = mapper.insertUser(user);
//		System.out.println(result);
//		
//		session.commit();
//		session.close();
		
		
	}
}
