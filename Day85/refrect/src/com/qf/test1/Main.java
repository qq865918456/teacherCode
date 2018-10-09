package com.qf.test1;

public class Main {
	
	public static void main(String[] args) {
		Student stu = new Student();
		stu.setId(1);
		stu.setName("小明");
		stu.setAge(18);
		stu.setAddress("广东省深圳市");
		
		System.out.println(stu);
		
		Dog dog = new Dog();
		dog.setName("旺财");
		dog.setWeight(80);
		dog.setColor("黑色");
		
		System.out.println(dog);
	}
}
