package com.qf.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.qf.advices.TransactionManager;

public class MyAspectj {

	private TransactionManager tx;
	
	public MyAspectj(TransactionManager tx) {
		this.tx = tx;
	}

	public void begin(){
		tx.begin();
	}
	
	public void commit(){
		tx.commit();
	}
	
	public void around(ProceedingJoinPoint proceedingJoinPoint){  // 注入进来
		System.out.println("环绕开始");
		try {
			proceedingJoinPoint.proceed();// 往下调用，调用目标方法
			System.out.println("环绕结束。。。");
		} catch (Throwable e) {
			e.printStackTrace();
		} finally{
			System.out.println("环绕的fianlly");
		}
	}
	
	public void exeception(){
		System.out.println("抛出异常通知。。。。");
	}
	
	public void afterRetruning(){
		System.out.println("@AfterReturning");
	}
}
