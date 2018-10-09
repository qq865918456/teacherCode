package com.qf.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 对Mybatis的SqlSession的获取方式的封装
 * 
 * 饿汉式 - 类加载后，无论是否要使用SqlSession，SqlSessionFactory都会被初始化
 * 
 * @author ken
 *
 */
public class SqlSessionUtil {

	/**
	 * 创建一个静态属性 - SqlSessionFactory 为了保证全局唯一
	 */
	private static SqlSessionFactory sessionFactory;
	private static String configName = "mybatis-config.xml";
	
	
	static{
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream(configName);
			sessionFactory = builder.build(in);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 获得SqlSession的方法
	 * @return
	 */
	public static SqlSession getSqlSession(){
		return sessionFactory.openSession();
	}
}
