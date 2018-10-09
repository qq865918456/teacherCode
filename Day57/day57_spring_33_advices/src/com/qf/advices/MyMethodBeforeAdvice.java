package com.qf.advices;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * MethodBeforeAdvice:前置通知
 * @author admin
 *
 */
public class MyMethodBeforeAdvice implements MethodBeforeAdvice,AfterReturningAdvice/*,MethodInterceptor*/ {

	private TransactionManager tx;
	private LoggingManager log;

	public MyMethodBeforeAdvice(TransactionManager tx, LoggingManager log) {
		this.tx = tx;
		this.log = log;
	}

	/**
	 *前置通知
	 */
	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		tx.begin();
		log.start();
	}

	/**
	 * 后置通知
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 * @throws Throwable
	 */
	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		tx.commit();
		log.end();
	}

//	@Override
//	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
//		System.out.println("环绕开始。。。");
//		Object proceed = methodInvocation.proceed();// 往下掉
//		System.out.println("环绕结束。。。");
//		return proceed;
//	}

}
