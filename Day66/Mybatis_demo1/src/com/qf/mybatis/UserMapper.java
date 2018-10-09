package com.qf.mybatis;

import java.util.List;

/**
 * mybatis��ӳ��ӿ�
 * @author ken
 *
 */
public interface UserMapper {

	/**
	 * ��ѯ����
	 * @param id
	 * @return
	 */
	User queryById(Integer id);
	
	/**
	 * ����û�
	 */
	int insertUser(User user);
	
	/**
	 * �޸��û�
	 */
	int updateUser(User user);
	
	/**
	 * ɾ���û�
	 * @param id
	 * @return
	 */
	int deleteById(Integer id);
	
	/**
	 * ��ѯȫ��
	 * @return
	 */
	List<User> queryAll();
}
