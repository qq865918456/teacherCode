package com.qf.entity;

public class Account {

	private Integer id;
	
	private String inName; // 转入账户
	
	private String ouName; // 转出账户
	
	private Double moeny; // 金额

	private String name; // 账户

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInName() {
		return inName;
	}

	public void setInName(String inName) {
		this.inName = inName;
	}

	public String getOuName() {
		return ouName;
	}

	public void setOuName(String ouName) {
		this.ouName = ouName;
	}

	public Double getMoeny() {
		return moeny;
	}

	public void setMoeny(Double moeny) {
		this.moeny = moeny;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
