package com.qf.advices;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyMethodInterceptor implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		System.out.println("环绕开始。。。。");
		Object proceed = methodInvocation.proceed();
		System.out.println("环绕结束。。。。");
		return proceed;
	}

}
