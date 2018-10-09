package com.qf.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class BackLoginFilter 后台的登录拦截
 */
public class BackLoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public BackLoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		System.out.println(req.getRequestURL());
		
		// 1.获取当前用户
		Object user = req.getSession().getAttribute("user");
		String action = req.getParameter("action");

		// 2.判断用户是否登录
		if (user != null || "backLogin".equals(action)) {
			chain.doFilter(request, resp);
		}else{
			// 转发和重定向都会参考当前路径
			// http://localhost:8080/1804_shop/back/main.jsp
			// http://localhost:8080/1804_shop/back/backLogin.jsp
//			req.getRequestDispatcher("../backLogin.jsp").forward(req, response); // ../往上跳一层
//			req.getRequestDispatcher("/backLogin.jsp").forward(req, response); // /代表根目录开始
			
			// http://localhost:8080/1804_shop/back/backLogin.jsp
			// http://localhost:8080/1804_shop/UserServlet?action=xxxxx
			System.out.println(req.getContextPath());// 获取上下文路径
			resp.getWriter().write("<script>window.open('"+req.getContextPath()+"/backLogin.jsp','_parent')</script>");
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
