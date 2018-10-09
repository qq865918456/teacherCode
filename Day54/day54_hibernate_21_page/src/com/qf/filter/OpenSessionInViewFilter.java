package com.qf.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.qf.utils.HibernateUtil;

import javafx.scene.control.Tab;

/**
 * 控制session关闭时机
 * Servlet Filter implementation class OpenSessionInViewFilter
 */
public class OpenSessionInViewFilter implements Filter {

    /**
     * Default constructor. 
     */
    public OpenSessionInViewFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		// 1.开启session
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		// 2.开启事务
		Transaction transaction = session.beginTransaction();
		
		try {
			// 3.往下调用
			chain.doFilter(request, response); // servlet执行完了，jsp编译完了
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
