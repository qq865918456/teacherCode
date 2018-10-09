package com.qf.entity;

import java.util.HashSet;
import java.util.Set;

public class Classes {

	private Integer id;
	
	private String name;
	
	private Set<Teacher> teachers =new HashSet<Teacher>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
}
