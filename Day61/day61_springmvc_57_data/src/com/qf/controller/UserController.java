package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qf.entity.User;

@Controller
public class UserController {

	@RequestMapping(value="addUser1")
	public String addUser(String username,String password) {
		System.out.println("username:"+username);
		System.out.println("password:"+password);
		return "ok";
	}
	
	@RequestMapping(value="addUser2")
	// @RequestParam把形参和表单中的属性做一个映射
	public String addUser2(@RequestParam("username")String name,String password) {
		System.out.println("username:"+name);
		System.out.println("password:"+password);
		return "ok";
	}
	
	@RequestMapping(value="addUser3")
	public String addUser3(User user) {
		System.out.println(user);
		return "ok";
	}
	
	@RequestMapping(value="addUser4")
	public String addUser4(User user) {
		System.out.println(user);
		return "ok";
	}
}
