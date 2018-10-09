package com.qf.service.impl;
/**
 * 
 */


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.qf.dao.IUserDao;
import com.qf.service.IUserService;

/**
 * @author admin
 *
 */
@Component(value="userService") // 相当于配置文件了配置了<bean clas>，默认id类名首字母小写
public class UserServiceImpl implements IUserService {
	
	// 注解注入不需要set/get方法
	//required:默认是true，必须要注入，如果注入失败导致容器初始化失败
	//  false:如果有注入，没有不注入
	@Autowired(required=false) // 自动注入,默认类型注入
//	@Qualifier(value="userDaoImpl2") // 如果匹配到了多个就可以使用@Qualifier指定要注入那个
	
//	@Resource(name="userDaoImpl2") // 自动注入，默认按照类型注入,如果有多个可以通过name属性指定注入那个
	private IUserDao userDao; // 让Spring来注入
	
	@Override
	public void info() {
		System.out.println("UserServiceImpl.info()");
		userDao.info();
	}

}
