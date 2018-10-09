package com.qf.dao.impl;

import com.qf.dao.IUserDao;

public class UserDaoImpl implements IUserDao {

	public UserDaoImpl(String name,Integer age,Integer sex) {
		System.out.println("有惨构造器");
		System.out.println("name:"+name+",age:"+age+",sex:"+sex);
		
	}
	public UserDaoImpl() {
		System.out.println("无惨构造器");
	}
	
	@Override
	public void info() {
		System.out.println("UserDaoImpl.info()");
	}

}
