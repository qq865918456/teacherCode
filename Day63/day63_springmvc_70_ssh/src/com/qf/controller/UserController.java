package com.qf.controller;

import javax.rmi.ssl.SslRMIClientSocketFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qf.entity.Page;
import com.qf.entity.User;
import com.qf.service.IUserService;

@Controller
@RequestMapping(value="/userController")
public class UserController {

	public UserController() {
		System.out.println("UserController.UserController()");
	}
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="/getUserList")
	public String getUserList(ModelMap map){
		map.put("userList",userService.getUserList());
		return "userList";
	}
	
	@RequestMapping(value="/getUserPage")
	public String getUserPage(Page<User> page,ModelMap map){
		userService.getUserPage(page);
		page.setUrl("userController/getUserPage?");
		map.put("page", page);
		return "userList";
	}
	
}
