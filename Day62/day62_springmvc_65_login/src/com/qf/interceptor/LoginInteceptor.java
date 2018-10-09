package com.qf.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 判断用户是否登录
 * @author admin
 *
 */
public class LoginInteceptor implements HandlerInterceptor{

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

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {

		Object user = request.getSession().getAttribute("user");
		
		if(user != null){
			return true;
		}else{
			// xxxx/userController/add
			// xxxx/controller/userController/add
			request.setAttribute("msg", "你还没有登录，请先登录。。。");
			System.out.println(request.getContextPath()); // 获得项目的根目录
			response.sendRedirect(request.getContextPath()+"/login.jsp"); // 重定向/代表站点
			// 转发的/代表的是项目根目录
//			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return false;
		}
	}

}
