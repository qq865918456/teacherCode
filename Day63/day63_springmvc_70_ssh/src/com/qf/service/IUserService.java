package com.qf.service;

import java.util.List;

import com.qf.entity.Page;
import com.qf.entity.User;

public interface IUserService {
	public User getUserById(Integer id);
	
	public List<User> getUserList();

	public void getUserPage(Page<User> page);
}
