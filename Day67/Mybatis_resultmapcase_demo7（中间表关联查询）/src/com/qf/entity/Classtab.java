package com.qf.entity;

import java.util.List;

public class Classtab {

	private Integer id;
	private String cname;
	private Integer cnumber;
	
	private List<Student> stus;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Integer getCnumber() {
		return cnumber;
	}
	public void setCnumber(Integer cnumber) {
		this.cnumber = cnumber;
	}
	public List<Student> getStus() {
		return stus;
	}
	public void setStus(List<Student> stus) {
		this.stus = stus;
	}
	@Override
	public String toString() {
		return "Classtab [id=" + id + ", cname=" + cname + ", cnumber=" + cnumber + ", stus=" + stus + "]";
	}
}
