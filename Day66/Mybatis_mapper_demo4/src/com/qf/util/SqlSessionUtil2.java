package com.qf.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 懒汉式 - 当真正需要使用SqlSession的时候，才去初始化SqlSessionFactory（第一次）
 * 
 * @author ken
 *
 */
public class SqlSessionUtil2 {

	private static SqlSessionFactory sqlSessionFactory;
	private static String configName = "mybatis-config.xml";
	
	/**
	 * 初始化session工厂
	 * 线程1
	 */
	private static synchronized void createSqlSessionFactory() {
		if(sqlSessionFactory != null){
			return;
		}
		
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream(configName);
			sqlSessionFactory = builder.build(in);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 获得sqlsession
	 * @return
	 */
	public static SqlSession getSqlSession() {
		if(sqlSessionFactory == null){
			createSqlSessionFactory();
		}
		return sqlSessionFactory.openSession();
	}
}
