package com.qf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qf.entity.User;

public interface IUserDao extends JpaRepository<User, Integer>{

	public User getUserByUsernameAndPassword(String username,String password);
}
