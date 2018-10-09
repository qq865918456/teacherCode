/**
 * 
 */
package com.qf.service.impl;

import com.qf.service.IUserService;

/**
 * @author admin
 *
 */
public class UserServiceImpl implements IUserService {

	public UserServiceImpl(){
		System.err.println("构造器");
	}
	
	@Override
	public void info() {
		System.out.println("UserServiceImpl.info()");
	}

}
