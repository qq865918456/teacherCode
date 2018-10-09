package com.qf.dao;

import java.util.List;

import com.qf.entity.User;

public interface IUserDao {

	public int addUser(User user);

	public int getUserCount();

	public List<User> getUserList(Integer i, Integer pageSize);
	
	public User getUserById(Integer id);
	
	public int udpate(User user);
	
	public int delete(Integer id);
}
