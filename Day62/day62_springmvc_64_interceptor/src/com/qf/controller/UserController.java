package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/userController")
public class UserController {

	@RequestMapping(value = "/add")
	public String add() {
		System.out.println("UserController.add()");
		return "ok";
	}
	
	// /UserController/login
	@RequestMapping(value = "/login")
	public String login() {
		System.out.println("UserController.login()");
		return "ok";
	}

}
