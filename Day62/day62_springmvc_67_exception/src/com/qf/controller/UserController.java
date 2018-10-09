package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping(value = "/addUser")
	public String deleteUser() {
		System.out.println("UserController.deleteUser()");
		int i = 10 / 0;
		return "ok";
	}

}
