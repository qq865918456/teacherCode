package com.qf.service;

import org.apache.catalina.deploy.LoginConfig;

import com.qf.entity.User;

public interface IUserService {

	public User login(String username,String password);
}
