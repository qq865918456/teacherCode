package com.qf.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qf.annotation.Entity;
import com.qf.entity.Student;

public abstract class BaseServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得需要调用的方法名称
		String method = request.getParameter("method");
		
		if(method == null){
			throw new RuntimeException("骚瑞，你没有遵循和我之间的约定!");
		}
		
		//获得当前Servlet的所有方法
		Class cls = this.getClass();
		
		//获得当前servlet的所有方法
		Method[] methods = cls.getMethods();
		
		//循环所有方法
		for(Method met : methods){
			if(met.getName().equals(method)){
				//说明已经找到需要调用的方法了！！！！
				try {
					List<Object> params = setParaments(met, request, response);
					
					String obj = (String) met.invoke(this, params.toArray());
					
					if(obj != null){
						if(obj.startsWith("redirect:")){
							response.sendRedirect(obj.split(":")[1]);
						} else {
							request.getRequestDispatcher(obj).forward(request, response);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				} 
				return;
			}
		}
	}
	
	/**
	 * 设置servlet方法的参数值
	 * @param method
	 * @param request
	 * @throws IOException 
	 */
	private List<Object> setParaments(Method method, HttpServletRequest request, HttpServletResponse resp) throws Exception{
		//存放实参的集合
		List<Object> params = new ArrayList<>();
		
		//获得当前方法的所有形参类型
		Class<?>[] parameterTypes = method.getParameterTypes();
		for(Class c : parameterTypes){
			Entity entity = (Entity) c.getAnnotation(Entity.class);
			
			if(c == HttpServletRequest.class){
				params.add(request);
			} else if(c == HttpServletResponse.class){
				params.add(resp);
			} else if(c == HttpSession.class){
				params.add(request.getSession());
			} else if(c == PrintWriter.class){
				params.add(resp.getWriter());
			} else if(entity != null){
				//当前的参数是一个实体类
				Object obj = c.newInstance();
				Field[] fields = c.getDeclaredFields();
				for(Field field : fields){
					field.setAccessible(true);
					String value = request.getParameter(field.getName());
					field.set(obj, value);
				}
				params.add(obj);
			} else {
				params.add(null);
			}
		}
		
		return params;
	}
}
