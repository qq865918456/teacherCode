package com.qf.dao;

import java.util.List;

import com.qf.entity.User;

public interface IUserDao {

	public int add(User user);
	
	public List<User> getUserList();
}
