package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/userController")
public class UserController {

	// 11/12/14
	@RequestMapping(value = "/deleteUser/{id}/{a}/{b}",method=RequestMethod.DELETE)
	public String deleteUser(@PathVariable("id")Integer id,@PathVariable("a")Integer a,@PathVariable("b")Integer b) {
		System.out.println("id:"+id);
		System.out.println("a:"+a);
		System.out.println("b:"+b);
		return "ok";
	}
	
}
