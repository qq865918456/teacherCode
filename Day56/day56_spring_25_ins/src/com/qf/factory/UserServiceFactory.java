package com.qf.factory;

import com.qf.service.IUserService;
import com.qf.service.impl.UserServiceImpl;

/**
 * 静态工厂类中提供了一个方法，返回的是userServceImpl实例
 * @author admin
 *
 */
public class UserServiceFactory {

	public static IUserService getUserServceIml(){
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		System.out.println("静态工厂："+userServiceImpl);
		return userServiceImpl;
	}
}
