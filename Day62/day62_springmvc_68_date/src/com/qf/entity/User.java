package com.qf.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class User {

	private Integer id;
	
	private String username;
	
	private String password;
	
	private Integer age;
	
	private Double heigh;
	
	private Boolean flag;
	
	// 需要开启注解驱动
//	@DateTimeFormat(pattern="yyyy-MM-dd")// 格式化参数
	private Date brithday;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Date getBrithday() {
		return brithday;
	}

	public void setBrithday(Date brithday) {
		this.brithday = brithday;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public Double getHeigh() {
		return heigh;
	}

	public void setHeigh(Double heigh) {
		this.heigh = heigh;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", age=" + age + ", heigh="
				+ heigh + ", flag=" + flag + ", brithday=" + brithday + "]";
	}
	
}
