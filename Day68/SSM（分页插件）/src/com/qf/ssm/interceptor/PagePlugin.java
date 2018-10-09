package com.qf.ssm.interceptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

/**
 * ��ҳ��� 
 * 
 * ThreadLocal - ��ǰ�߳����õĲ�����ֻ���ٵ�ǰ�̻߳�ȡ
 * 
 * @author ken
 *
 */
@Intercepts(@Signature(
		type = StatementHandler.class, 
		method = "prepare", 
		args = { Connection.class, Integer.class }
		))
public class PagePlugin implements Interceptor {

	//ThreadLocal
	private static ThreadLocal<Page> threadLocal = new ThreadLocal<Page>();
	
	public static void startPage(Page page){
		threadLocal.set(page);
	}
	
	/**
	 * ���ع���
	 */
	public Object intercept(Invocation invocation) throws Throwable {
		// 1�����Ŀ�����
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		MetaObject metaObject = getNoProxy(statementHandler);
		
		//2�����sql���
		BoundSql boundSql = (BoundSql) metaObject.getValue("delegate.boundSql");
		String sql = boundSql.getSql().toLowerCase().trim();
		
		//3���ж��Ƿ���Ҫ��ҳ  select * from student
		if(!sql.startsWith("select")){
			return invocation.proceed();
		}
		
		if(sql.indexOf("limit") != -1){
			return invocation.proceed();
		}
		
		Page page = threadLocal.get();
		if(page == null){
			return invocation.proceed();
		} else {
			threadLocal.set(null);
		}
		
		//4��˵����Ҫ��ҳ��sql��� 
		//�����������  select count(*) from student where sex = ?
		Integer pageCount = getCount(sql, invocation, metaObject);
		
		//���ù��ж�������¼
		page.setPageCount(pageCount);
		
		//5����ʼ���з�ҳ��ѯ sql + " limit ?,?"
		if(sql.endsWith(";")){
			sql = sql.substring(0, sql.indexOf(";"));
		}
		
		sql += " limit ?,?";
		System.out.println("����Ҫִ�з�ҳ��sql��䣺" + sql);
		
		//�ı�mybatis��Ҫִ�е�sql���
		metaObject.setValue("delegate.boundSql.sql", sql);
		
		//���� - prepare
		PreparedStatement ps = (PreparedStatement) invocation.proceed();
		int pcount = ps.getParameterMetaData().getParameterCount();
		ps.setInt(pcount - 1, (page.getPage() - 1) * page.getPageSize());
		ps.setInt(pcount, page.getPageSize());
		
		return ps;
	}

	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {

	}

	/**
	 * ���������� - ���������Ŀ�����
	 * 
	 * @param statementHandler
	 * @return
	 */
	private MetaObject getNoProxy(StatementHandler statementHandler) {
		// ������ - �п������Ŀ�������һ�������Ҫ���������ҵ�������Ŀ�������� -
		// MetaObject - mybatis�ṩ��һ���������ǻ��Ŀ������е�ĳ������ֵ�Ĺ�����
		MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
		while (metaObject.hasGetter("h")) {
			Object object =  metaObject.getValue("h");
			metaObject = SystemMetaObject.forObject(object);
		}
		
		// ���յ�Ŀ����� - RoutingStatementHandler
		if (metaObject.hasGetter("target")) {
			statementHandler = (StatementHandler) metaObject.getValue("target");
		}
		metaObject = SystemMetaObject.forObject(statementHandler);
		return metaObject;
	}
	
	/**
	 * �����ѯ��������
	 * @return
	 */
	private Integer getCount(String sql, Invocation invocation, MetaObject metaObject){
		String countSql = "select count(*) " + sql.substring(sql.indexOf("from"));
		System.out.println("������������sql��䣺" + countSql);
		
		//������ݵ����� ִ����������sql���
		Connection conn = (Connection) invocation.getArgs()[0];
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			
			ps = conn.prepareStatement(countSql);
			
			//���ò��� - paramentHandler
			ParameterHandler parameterHandler = (ParameterHandler) metaObject.getValue("delegate.parameterHandler");
			parameterHandler.setParameters(ps);
			
			Integer pageCount = 0;
			resultSet = ps.executeQuery();
			if(resultSet.next()){
				pageCount = resultSet.getInt(1);
			}
			
			return pageCount;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(resultSet != null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(ps != null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return 0;
	}
}
