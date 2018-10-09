package com.qf.dao;

import com.qf.entity.User;

public interface IUserDao {

	public User login(String username,String password);
}
