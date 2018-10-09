package com.qf.advices;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

/**
 * 抛出异常增强,方法需要自定义
 * 
 * @author admin
 *
 */
public class MyThrowsAdvice implements ThrowsAdvice {

	public void afterThrowing(Method method, Object[] args, Object target, Exception e) throws Throwable {
		System.out.println("method=" + method.getName());
		System.out.println("抛出异常：" + e.getMessage());
		System.out.println("成功回滚事务");
	}

}
