package com.qf.dao;

import java.util.List;

import com.qf.entity.User;

public interface IUserDao {

	public int addUser(User user);

	public int updateUser(User user);

	public int deleteUser(Integer id);

	public User getUserById(Integer id);

	public List<User> getUserList(Integer index, Integer size);

	public int getUserCount();

	public User login(String username, String password);

	public void batchDel(String[] ids);

}
