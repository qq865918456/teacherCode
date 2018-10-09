package com.qf.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 定义一个拦截器
 * @author admin
 *
 */
public class InteceptorDemo implements HandlerInterceptor{

	/**
	 * 视图解析之后运行
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("InteceptorDemo.afterCompletion()");
	}

	/**
	 * 视图解析之前运行
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("InteceptorDemo.postHandle()");
	}

	/**
	 * Controller调用之前走
	 * object
	 * 		1)开启注解驱动是HandlerMethod
	 * 		2)没有开启注解驱动ControllerBean
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		
		HandlerMethod method = (HandlerMethod)object;
		
		System.out.println("Controller是 属于那个bean："+method.getBean());
		System.out.println("method对象："+method.getMethod());
		System.out.println("Controller返回的类型："+method.getReturnType());
		
		System.out.println("InteceptorDemo.preHandle()");
		return true; // true:代表放行，false：b不往下走
	}

}
