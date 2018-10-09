package com.qf.main;

import org.apache.ibatis.session.SqlSession;

import com.qf.entity.User;
import com.qf.mapper.IUserMapper;
import com.qf.util.SqlSessionUtil;
import com.qf.util.SqlSessionUtil2;

public class Main {

	public static void main(String[] args) {
		
		SqlSession sqlSession = SqlSessionUtil2.getSqlSession();
		IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);
		User user = userMapper.queryUserById(3);
		System.out.println(user);
		sqlSession.close();
	}
}
