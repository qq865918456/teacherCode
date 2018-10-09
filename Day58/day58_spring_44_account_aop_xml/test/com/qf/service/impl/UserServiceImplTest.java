package com.qf.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qf.entity.Account;
import com.qf.service.IAccountService;

public class UserServiceImplTest {

	private ApplicationContext context;

	@Before
	public void init() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@Test
	public void testGetUserList() {
		IAccountService accountService = context.getBean("accountService", IAccountService.class);

		Account account = new Account();
		account.setInName("张三");
		account.setOuName("李四");
		account.setMoeny(1000.0);
		accountService.transfer(account);
		
		System.out.println(accountService.getClass());
	}

}
