package com.qf.entity;

public class Student {

	private Integer id;
	private String name;
	private Integer age;
	private Integer cid;
	
	private Classtab ctab;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Classtab getCtab() {
		return ctab;
	}
	public void setCtab(Classtab ctab) {
		this.ctab = ctab;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", cid=" + cid + ", ctab=" + ctab + "]";
	}
}
