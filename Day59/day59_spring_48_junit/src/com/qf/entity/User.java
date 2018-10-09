package com.qf.entity;

import org.omg.CORBA.INTERNAL;

public class User {

	private Integer id;
	
	private String username;
	
	private String password;

	// 基本类型的默认值是0.0
	// 包装类型的默认值是null
	private Double balance; // 0.0
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
}
