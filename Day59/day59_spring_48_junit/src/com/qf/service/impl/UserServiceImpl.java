package com.qf.service.impl;


import java.util.List;

import com.qf.dao.IUserDao;
import com.qf.entity.Page;
import com.qf.entity.User;
import com.qf.service.IUserService;

public class UserServiceImpl implements IUserService {

	private IUserDao userDao;
	
	public UserServiceImpl(){
		System.out.println("+===============================");
		
	}
	
	@Override
	public int addUse(User user) {
		return userDao.addUser(user);
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
		
		int totalCount = userDao.getUserCount();
		
		List<User> userList = userDao.getUserList((currentPage-1)*pageSize,pageSize);
		
		page.setData(userList);
		page.setTotalCount(totalCount);
	}

}
