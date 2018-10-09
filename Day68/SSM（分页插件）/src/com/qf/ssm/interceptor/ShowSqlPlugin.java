package com.qf.ssm.interceptor;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

/**
 * 显示Mybatis的sql语句的插件
 * 
 * type:表示拦截器需要拦截的四大对象中的哪一个？
 * method:拦截的四大对象中的某个方法
 * args:拦截方法的参数类型
 * 
 * @author ken
 *
 */
@Intercepts(
		@Signature(
				type = StatementHandler.class,
				method = "prepare",
				args = {Connection.class, Integer.class}
		))
public class ShowSqlPlugin implements Interceptor{

	private boolean isShowSql;
	
	/**
	 * 拦截方法
	 */
	public Object intercept(Invocation invocation) throws Throwable {
		
		//获得目标对象
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		
		//剥离插件 - 有可能这个目标对象还是一个插件，要继续往下找到真正的目标对象操作 - 
		//MetaObject - mybatis提供的一个帮助我们获得目标对象中的某个属性值的工具类
		MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
		while(metaObject.hasGetter("h")){
			StatementHandler statement = (StatementHandler) metaObject.getValue("h");
			metaObject = SystemMetaObject.forObject(statement);
		}
		//最终的目标对象 - RoutingStatementHandler
		if(metaObject.hasGetter("target")){
			statementHandler = (StatementHandler) metaObject.getValue("target");
		}
		
		if(isShowSql){
			//将最终的statmenthandler包装成MetaObject
			metaObject = SystemMetaObject.forObject(statementHandler);
			String sql = (String) metaObject.getValue("delegate.boundSql.sql");
			Object params = metaObject.getValue("delegate.boundSql.parameterObject");
			
			System.out.println("执行的sql语句：" + sql);
			System.out.println("参数为：" + params);
		}
		
		
		//放行
		return invocation.proceed();
	}

	/**
	 * 插件的代理过程
	 */
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	/**
	 * 设置参数
	 */
	public void setProperties(Properties properties) {
		isShowSql = Boolean.parseBoolean(properties.getProperty("showsql", "true"));
	}
}
