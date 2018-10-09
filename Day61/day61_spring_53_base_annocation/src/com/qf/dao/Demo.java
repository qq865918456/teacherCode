package com.qf.dao;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;

import com.qf.entity.User;

public class Demo<T> {

	private List<?> list;
	
	private Set<T> set;
	
	public static void main(String[] args) throws Exception, SecurityException {
		User user = new User();

		Field field = user.getClass().getDeclaredField("username");
		field.setAccessible(true);
		field.set(user, "admin"); // 反射赋值不会调用set方法

		user.getClass().getMethod("setUsername");
		
		System.out.println(user);
		
		
		 List<?> list2 = new Demo().getList();

		 Set<User> set2 = new Demo<User>().getSet();
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public Set<T> getSet() {
		return set;
	}

	public void setSet(Set<T> set) {
		this.set = set;
	}
	
	
}
