package com.qf.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("HelloController.handleRequest()");
		
		
		// 1.创建ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		
		// 2.设置跳转的视图
		modelAndView.setViewName("ok");
		
		// reqste.setA();
		// 3.设置信息
		modelAndView.addObject("msg", "Hello World");
		
		return modelAndView;
	}

}
