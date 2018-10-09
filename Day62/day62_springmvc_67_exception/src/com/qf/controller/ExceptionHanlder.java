package com.qf.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Component
public class ExceptionHanlder implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object object,
			Exception exception) {
		System.out.println("ExceptionHanlder.resolveException()");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error"); // 默认页面
		modelAndView.addObject("ex", exception);
		if(exception instanceof RuntimeException){
			modelAndView.setViewName("error1");
		}
		return modelAndView;
	}

}
