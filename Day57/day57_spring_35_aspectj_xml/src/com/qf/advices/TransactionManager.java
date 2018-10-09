package com.qf.advices;

/**
 * 事务管理器
 * @author admin
 *
 */
public class TransactionManager {

	public void begin(){
		System.out.println("开启事务");
	}
	
	public void commit(){
		System.out.println("事务提交");
	}
}
