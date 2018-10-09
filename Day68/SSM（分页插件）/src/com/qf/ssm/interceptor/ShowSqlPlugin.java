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
 * ��ʾMybatis��sql���Ĳ��
 * 
 * type:��ʾ��������Ҫ���ص��Ĵ�����е���һ����
 * method:���ص��Ĵ�����е�ĳ������
 * args:���ط����Ĳ�������
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
	 * ���ط���
	 */
	public Object intercept(Invocation invocation) throws Throwable {
		
		//���Ŀ�����
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		
		//������ - �п������Ŀ�������һ�������Ҫ���������ҵ�������Ŀ�������� - 
		//MetaObject - mybatis�ṩ��һ���������ǻ��Ŀ������е�ĳ������ֵ�Ĺ�����
		MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
		while(metaObject.hasGetter("h")){
			StatementHandler statement = (StatementHandler) metaObject.getValue("h");
			metaObject = SystemMetaObject.forObject(statement);
		}
		//���յ�Ŀ����� - RoutingStatementHandler
		if(metaObject.hasGetter("target")){
			statementHandler = (StatementHandler) metaObject.getValue("target");
		}
		
		if(isShowSql){
			//�����յ�statmenthandler��װ��MetaObject
			metaObject = SystemMetaObject.forObject(statementHandler);
			String sql = (String) metaObject.getValue("delegate.boundSql.sql");
			Object params = metaObject.getValue("delegate.boundSql.parameterObject");
			
			System.out.println("ִ�е�sql��䣺" + sql);
			System.out.println("����Ϊ��" + params);
		}
		
		
		//����
		return invocation.proceed();
	}

	/**
	 * ����Ĵ������
	 */
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	/**
	 * ���ò���
	 */
	public void setProperties(Properties properties) {
		isShowSql = Boolean.parseBoolean(properties.getProperty("showsql", "true"));
	}
}
