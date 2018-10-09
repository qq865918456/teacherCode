package com.qf.dao.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.qf.advices.LoggingManager;
import com.qf.advices.TransactionManager;
import com.qf.dao.IUserDao;

/**
 * 基于JDK实现动态代理
 * @author admin
 * InvocationHandler类似于目标对象的接口
 *
 */
public class HandlerProxy implements InvocationHandler {

	// 系统服务
	private TransactionManager tx;
	private LoggingManager log;
	
	// 目标对象
	private Object target;
	
	public HandlerProxy(LoggingManager loggingManager, TransactionManager tx, Object target) {
		this.tx = tx;
		this.log = loggingManager;
		this.target = target;
	}

	/**
	 * 该方法就是调用的方法
	 * method:目标方法
	 * args:目标方法的参数
	 * prox:代理对象
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		
		// 1.系统服务开启
		log.start();
		tx.begin();
		
		// 2.调用业务主体
		Object invoke = method.invoke(target, args);
		
		// 3.系统服务关闭
		tx.commit();
		log.end();
		
		return invoke;
	}

}
