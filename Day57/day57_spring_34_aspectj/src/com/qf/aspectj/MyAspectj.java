package com.qf.aspectj;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.qf.advices.TransactionManager;

// 切面中包含了增强
@Aspect // 用该注修饰的标识一个切面
public class MyAspectj {

	private TransactionManager tx;
	
	public MyAspectj(TransactionManager tx) {
		this.tx = tx;
	}

	// public [static] 返回值 包.类.方法名称(参数)
	// 只有目标对象中的目方法匹配到表达式了才会执行
//	@Before(value="execution(public * com.qf.dao.impl.UserDaoImpl.add(..))")// 在目标方法之前走
	// public 不写默认是public
	// 第一个*代理表任意返回值(从左往右)
	// 第二个*代理任意接口(从左往右)
	// 第三个*代理表接口中的任意方法(从左往右)
	// ..代表任意参数
	@Before(value="execution(* com.qf.dao.*.*(..))")// 在目标方法之前走
	public void begin(){
		tx.begin();
	}
	
//	@After(value="execution(public * com.qf.dao.impl.UserDaoImpl.add(..))")
	@After(value="execution(* com.qf.dao.*.*(..))")
	public void commit(){
		tx.commit();
	}
	
}
