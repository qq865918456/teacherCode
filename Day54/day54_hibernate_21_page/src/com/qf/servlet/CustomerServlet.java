package com.qf.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.entity.Customer;
import com.qf.entity.Page;
import com.qf.service.ICustomerService;
import com.qf.service.impl.CustomerServiceImpl;

/**
 * Servlet implementation class CustomerServlet
 */
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ICustomerService customerSerivce = new CustomerServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if("getCustomerPage".equals(action)){
			
			// 1.设置分页参数
			String currentPage = request.getParameter("currentPage");
			String pageSize = request.getParameter("pageSize");
			Page<Customer>  page = new Page<Customer>();
			if(currentPage != null && !"".equals(currentPage)){
				page.setCurrentPage(Integer.parseInt(currentPage));
				page.setPageSize(Integer.parseInt(pageSize));
			}
			
			// 2.封装分页对象
			customerSerivce.getCustomerPage(page);
			page.setUrl("CustomerServlet?action=getCustomerPage");
			request.setAttribute("page", page);
			request.getRequestDispatcher("customerList.jsp").forward(request, response);
			
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
