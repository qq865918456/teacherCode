package com.qf.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.qf.dao.impl.UserDaoImpl;
import com.qf.entity.Page;
import com.qf.entity.User;
import com.qf.service.IUserService;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		// 1.获取Spring容器对象
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
		
		// 2.在容器中后去userServiec对象
		IUserService userService = webApplicationContext.getBean(IUserService.class);
		
		if("getUserPage".equals(action)){
			
			String currentPage = request.getParameter("currentPage");
			String pageSize = request.getParameter("pageSize");
			
			Page<User> page = new Page<User>();
			
			if(currentPage != null && !"".equals(currentPage)){
				page.setCurrentPage(Integer.parseInt(currentPage));
				page.setPageSize(Integer.parseInt(pageSize));
			}
			userService.getUserPage(page);
			
			page.setUrl("UserServlet?action=getUserPage");
			request.setAttribute("page", page);
			request.getRequestDispatcher("userList.jsp").forward(request, response);
			
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
