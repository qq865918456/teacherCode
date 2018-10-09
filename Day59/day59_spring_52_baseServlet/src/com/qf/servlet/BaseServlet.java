package com.qf.servlet;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BaseServlet
 */
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BaseServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// action的名字和方法的名字保持一致

		// 1.获取action
		String action = request.getParameter("action");

		// this就是当前的servlet
		if (action != null && !"".equals(action)) {
			try {
				// 2.得到当前调用的方法
				Method[] methods = this.getClass().getMethods();
				for (Method method : methods) {
					// 找到调用的方法
					if (method.getName().equals(action)) {
						InvokeMethod(request, response, method);// 调用
						break; // 结束循环
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	private void InvokeMethod(HttpServletRequest request, HttpServletResponse response, Method method)
			throws InstantiationException, IllegalAccessException, InvocationTargetException {
		// 给方法形参赋值
		Object[] paramIns = setMethodParam(request, method);
		// 调用方法
		Object invoke = method.invoke(this, paramIns);
		// 4.响应客户端
		responseClient(invoke, request, response);
	}

	private Object[] setMethodParam(HttpServletRequest request, Method method)
			throws InstantiationException, IllegalAccessException {
		Parameter[] parameters = method.getParameters(); // 得到方法的参数
		// 数组用来装方法参数
		Object[] paramIns = new Object[parameters.length];
		for (int i = 0; i < parameters.length; i++) {
			// 获取方法参数的对象属性
			Class<?> paramType = parameters[i].getType();
			Object paramTypeIns = paramType.newInstance(); // 实例化参数类型
			Field[] paramFields = paramType.getDeclaredFields();
			for (Field field : paramFields) {
				field.setAccessible(true); // 授权
				// 根据参数对象的属性名称获取值
				String value = request.getParameter(field.getName());
				try {
					Object val = null;
					if (value != null && !"".equals(value)) {
						val = changeParamType(value, field.getType());
					}
					field.set(paramTypeIns, val);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			paramIns[i] = paramTypeIns;
		}
		return paramIns;
	}

	/**
	 * 把字符串转成对应的类型
	 * 
	 * @param value
	 * @param type
	 * @return
	 */
	private Object changeParamType(String value, Class<?> type) {
		Object val = null;

		// 1.获取字段类型名称
		String typeSimpleName = type.getSimpleName();
		if (typeSimpleName.equals("String")) {
			val = value;
		} else if (typeSimpleName.equals("Double")) {
			val = Double.parseDouble(value);
		} else if (typeSimpleName.equals("Integer")) {
			val = Integer.parseInt(value);
		}
		return val;
	}

	private void responseClient(Object invoke, HttpServletRequest request, HttpServletResponse response) {
		// 1.解析action的返回值
		Map<String, String> map = parserAction(invoke);

		// 2.判断是重定向还是转发
		if (map.containsKey("forward")) {
			try {
				request.getRequestDispatcher(map.get("forward")).forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (map.containsKey("redirect")) {
			try {
				response.sendRedirect(map.get("redirect"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 把action的返回值放到Map中
	 * 
	 * @param invoke
	 * @return
	 */
	private Map<String, String> parserAction(Object invoke) {
		String[] split = invoke.toString().split(":");
		Map<String, String> map = new HashMap<String, String>();
		map.put(split[0], split[1]);
		return map;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
