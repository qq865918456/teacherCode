package com.qf.dao.impl;

import java.lang.reflect.Method;
import java.util.concurrent.SynchronousQueue;
import java.util.logging.LogManager;

import com.qf.advices.LoggingManager;
import com.qf.advices.TransactionManager;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * cglis的拦截器
 * 
 * @author admin
 *
 */
public class CglibInteceptor implements MethodInterceptor {

	private TransactionManager tx;

	private LoggingManager log;

	public CglibInteceptor(TransactionManager tx, LoggingManager log) {
		this.tx = tx;
		this.log = log;
	}

	/**
	 * obj:代理类(子类) method:被拦截的方法 args:方法形参 proxy：方法的代理对象
	 */
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

		String name = method.getName();

		Object result = null;
		if (name.equals("query")) {
			result = proxy.invokeSuper(obj, args);
		} else {
			// 1.系统服务开启
			tx.begin();
			log.start();

			// 2.调用真实业务主体
			// 为什么父类的方法？
			result = proxy.invokeSuper(obj, args);

			// 3.关闭系统服务
			tx.commit();
			log.end();
		}

		return result;
	}

}
