package com.qf.dao;

import org.springframework.context.annotation.EnableLoadTimeWeaving;

import com.qf.entity.User;

public class Demo {

	public static void main(String[] args) {
		User user = new User();
		System.out.println(user.getClass().getName());

		System.out.println(user.getClass().getSimpleName());
	}
}
