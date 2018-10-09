package com.qf.dao;

import java.util.List;

import com.qf.entity.User;

public interface IUserDao {

	public User getUserById(Integer id);
	
	public List<User> getUserList();

	public int getUserTotalCount();

	public List<User> getUserList(Integer index, Integer size);
}
