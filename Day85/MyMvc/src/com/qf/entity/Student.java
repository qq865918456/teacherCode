package com.qf.entity;

import com.qf.annotation.Entity;

@Entity
public class Student {

	private String username;
	private String password;
	private String name;
	private String age;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [username=" + username + ", password=" + password + ", name=" + name + ", age=" + age + "]";
	}
	public Student(String username, String password, String name, String age) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.age = age;
	}
	public Student() {
		super();
	}
}
