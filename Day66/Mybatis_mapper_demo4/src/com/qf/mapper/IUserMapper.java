package com.qf.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.qf.entity.User;

public interface IUserMapper {

	User queryUserById(Integer id);
	
//	List<User> queryUserByParams(@Param("name") String name, @Param("age") int age);
//	List<User> queryUserByParams(Map<String, Object> maps);
//	List<User> queryUserByParams(User user);
//	List<User> queryUserByParams(@Param("user1") User user1, @Param("user2") User user2);
//	List<User> queryLikeByName(String name);
	
	//��ҳ��ʽ1-ֱ�Ӵ���limit����Ĳ��� - ȱ���װ�Ժܲ�
//	List<User> queryAll(@Param("a") int x, @Param("b") int y);
	
	//��ҳ����2-RowBounds - ȱ�������ѯ���������ܴ��Ƚ����н����ȫ����������ٶԽ�������з�ҳ����
//	List<User> queryAll2(RowBounds rowBounds);
	
	//��ҳ����3-��ҳ���
	
	
	//��������
//	int insertUser(User user);
//	
//	int insertUser2(Map<String, Object> map);
	
	
	User queryById(@Param("id")Integer id, @Param("columns") String columns);
}
