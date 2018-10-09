package com.qf.service.impl;

import java.util.List;

import com.qf.dao.IUserDao;
import com.qf.dao.impl.UserDaoImpl;
import com.qf.dao.impl.UserDaoImpl_temp;
import com.qf.entity.Page;
import com.qf.entity.User;
import com.qf.service.IUserService;

public class UserServiceImpl implements IUserService {

	private IUserDao userDao = new UserDaoImpl();
	
	@Override
	public int addUser(User user) {
		return userDao.addUser(user);
	}

	@Override
	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public int deleteUser(Integer id) {
		return userDao.deleteUser(id);
	}

	@Override
	public User getUserById(Integer id) {
		return userDao.getUserById(id);
	}

	@Override
	public void getUserPage(Page<User> page) {
		
		// 1.获取当前页和每页显示的size
		Integer currentPage = page.getCurrentPage();
		Integer pageSize = page.getPageSize();
		
		// 2.求出总条数
		int userCount = userDao.getUserCount();
		
//		// 3.根据总条数和每页显示的条数算出总页数
//		Integer totalPage = null;
//		if( userCount % pageSize == 0){
//			totalPage = userCount/pageSize;
//		}else{
//			totalPage = (userCount/pageSize)+1;
//		}
		
		// 4.求出当前页要显示数据
		List<User> userList = userDao.getUserList((currentPage-1)*pageSize, pageSize);
		
		// 5.封装
		page.setTotalCount(userCount);
		page.setData(userList);
//		page.setTotalPage(totalPage);
		
		
	}

	@Override
	public User login(String username, String password) {
		return userDao.login(username,password);
	}
}
