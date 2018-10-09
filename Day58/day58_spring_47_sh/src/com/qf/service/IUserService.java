package com.qf.service;

import com.qf.entity.Page;
import com.qf.entity.User;

public interface IUserService {

	public int addUse(User user);
	
	public void getUserPage(Page<User> page);
}
