package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

@Controller // 控制层 ，把bean添加SpringMVC容器中
public class HelloController {

	// "/"代表项目的根目录
	// value和method都设置，需要同时满足才能调用
	@RequestMapping(value = "/getUserPage",method=RequestMethod.GET)
	public ModelAndView getUserPage() {
		System.out.println("HelloController.getUserPage()");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("ok"); // 转发获取的
		modelAndView.addObject("msg", "通过注解试下，方法返回ModelAndView");
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/getUserPage1")
	public String getUserPage1(ModelMap map) {
		map.put("msg", "方法返回字符串"); // 这是放到requset作用域中的
		return "ok"; // 转发过去的
	}
}
