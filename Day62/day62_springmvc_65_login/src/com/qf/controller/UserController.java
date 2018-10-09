package com.qf.controller;

import javax.servlet.http.HttpServletRequest;

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
	
	@RequestMapping(value = "/login")
	public String login(String username,String password,HttpServletRequest request) {
		if("admin".equals(username) && "admin".equals(password)){
			request.setAttribute("msg", "你登录成功");
			request.getSession().setAttribute("user", username);
			return "ok";
		}else{
			request.setAttribute("msg", "登录失败");
			return "login";
		}
	}

}
