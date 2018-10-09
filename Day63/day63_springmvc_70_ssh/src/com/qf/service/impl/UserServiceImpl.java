package com.qf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qf.dao.IUserDao;
import com.qf.entity.Page;
import com.qf.entity.User;
import com.qf.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	@Override
	public User getUserById(Integer id) {
		return userDao.getUserById(id);
	}

	@Override
	public List<User> getUserList() {
		return userDao.getUserList();
	}

	@Override
	public void getUserPage(Page<User> page) {
		
		Integer currentPage = page.getCurrentPage();
		Integer pageSize = page.getPageSize();
		
		int totalCount = userDao.getUserTotalCount();
		List<User> userList= userDao.getUserList((currentPage-1)*pageSize,pageSize);
		
		
		page.setData(userList);
		page.setTotalCount(totalCount);
	}

}
