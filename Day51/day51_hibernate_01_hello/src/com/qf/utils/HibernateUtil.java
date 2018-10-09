package com.qf.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    /**
     * 初始化sessionFactory使用
     * @return
     */
    private static SessionFactory buildSessionFactory() {
        try {
//            return new Configuration().configure().buildSessionFactory();
        	
        	// 1.创建配置对象
        	Configuration configuration = new Configuration();
        	
        	// 2.读取配置文件
        	Configuration configure = configuration.configure("hibernate.cfg1.xml");
        	
        	// 3.构建工厂
        	SessionFactory  sessionFactory = configure.buildSessionFactory();
        	
        	return sessionFactory;
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}