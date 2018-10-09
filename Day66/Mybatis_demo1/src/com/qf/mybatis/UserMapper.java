package com.qf.mybatis;

import java.util.List;

/**
 * mybatis的映射接口
 * @author ken
 *
 */
public interface UserMapper {

	/**
	 * 查询单个
	 * @param id
	 * @return
	 */
	User queryById(Integer id);
	
	/**
	 * 添加用户
	 */
	int insertUser(User user);
	
	/**
	 * 修改用户
	 */
	int updateUser(User user);
	
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	int deleteById(Integer id);
	
	/**
	 * 查询全部
	 * @return
	 */
	List<User> queryAll();
}
