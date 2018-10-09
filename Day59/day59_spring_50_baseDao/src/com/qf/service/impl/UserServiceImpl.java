package com.qf.service.impl;


import java.util.List;

import com.qf.dao.IUserDao;
import com.qf.entity.Page;
import com.qf.entity.User;
import com.qf.service.IUserService;

public class UserServiceImpl implements IUserService {

	private IUserDao userDao;
	
	@Override
	public int addUse(User user) {
		return userDao.add(user);
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void getUserPage(Page<User> page) {
		
		Integer currentPage = page.getCurrentPage();
		Integer pageSize = page.getPageSize();
		
		int totalCount = userDao.getCount();
		
		List<User> userList = userDao.getList((currentPage-1)*pageSize,pageSize);
		
		page.setData(userList);
		page.setTotalCount(totalCount);
	}

	@Override
	public int deleteUser(Integer id) {
		return userDao.delete(id);
	}

	@Override
	public User geUserById(Integer id) {
		return userDao.getById(id);
	}

	@Override
	public int updateUser(User user) {
		return userDao.udpate(user);
	}

}
