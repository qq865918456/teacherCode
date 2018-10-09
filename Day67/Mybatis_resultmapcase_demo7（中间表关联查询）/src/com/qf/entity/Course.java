package com.qf.entity;

import java.util.List;

public class Course {

	private Integer id;
	private String courseName;
	
//	private List<Student> stus;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + "]";
	}
}
