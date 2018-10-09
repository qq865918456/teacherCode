package com.qf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="t_student")
@Entity
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	/**
	 * name:列名称
	 * unique:唯一
	 * length:30
	 */
	@Column(name="username",unique=true,length=30,nullable=false)
	private String name;
	
	private Integer age;
	
	private String email;
	
	private Integer sex;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
}

