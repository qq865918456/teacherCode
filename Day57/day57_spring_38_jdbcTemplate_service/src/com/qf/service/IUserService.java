package com.qf.service;

import java.util.List;

import com.qf.entity.User;

public interface IUserService {
	public int add(User user);

	public List<User> getUserList();
}
