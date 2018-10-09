package com.qf.factory;

import com.qf.service.IUserService;
import com.qf.service.impl.UserServiceImpl;

/**
 * 非静态工厂类中提供了一个方法，返回的是userServceImpl实例
 * @author admin
 *
 */
public class UserServiceFactory2 {

	public IUserService getUserServceIml(){
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		System.out.println("非静态工厂："+userServiceImpl);
		return userServiceImpl;
	}
}
