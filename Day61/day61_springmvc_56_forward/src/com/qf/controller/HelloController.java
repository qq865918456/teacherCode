package com.qf.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.lookup.ReductionResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sun.media.sound.ModelInstrumentComparator;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.swing.internal.plaf.metal.resources.metal_zh_TW;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

@Controller
public class HelloController {


	/**
	 * 演示Controller中方法ServetAPI
	 * @param request
	 * @param response
	 */
	// 方法上面定义结束对象，SpringMVC容器会自动注入进来
	@RequestMapping(value = "/getRequest")
	public void getRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("req:" + request);
		System.out.println("resp:" + response);
		request.setAttribute("msg", "req作用域中的内容");
		try {
//			request.getRequestDispatcher("ok.jsp").forward(request, response);
			response.sendRedirect("ok.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 演示SpringMVC中的转发
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/testForward1")
	public String testForward1(ModelMap map) {
		map.put("msg", "利用SpringMVC的方法转发");
//		return "ok";
		return "forward:ok.jsp"; // 这里一定要加视图的后缀
	}
	
	@RequestMapping(value = "/testRedirect")
	public String testRedirect(ModelMap map) {
		String msg = "利用SpringMVC的方法重定向";
		try {
			map.put("msg",new String (msg.getBytes("utf-8"),"iso-8859-1"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} // 放到地址栏里面了
		return "redirect:ok.jsp"; // 这里一定要加视图的后缀
	}
}
