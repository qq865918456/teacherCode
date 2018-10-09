package com.qf.entity;

import java.util.HashSet;
import java.util.Set;

public class Teacher {

	private Integer id;
	
	private String name;

	private Set<Classes> classes = new HashSet<Classes>();
	
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

	public Set<Classes> getClasses() {
		return classes;
	}

	public void setClasses(Set<Classes> classes) {
		this.classes = classes;
	}
}
