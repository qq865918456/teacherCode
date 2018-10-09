package com.qf.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * ��Mybatis��SqlSession�Ļ�ȡ��ʽ�ķ�װ
 * 
 * ����ʽ - ����غ������Ƿ�Ҫʹ��SqlSession��SqlSessionFactory���ᱻ��ʼ��
 * 
 * @author ken
 *
 */
public class SqlSessionUtil {

	/**
	 * ����һ����̬���� - SqlSessionFactory Ϊ�˱�֤ȫ��Ψһ
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
	 * ���SqlSession�ķ���
	 * @return
	 */
	public static SqlSession getSqlSession(){
		return sessionFactory.openSession();
	}
}
