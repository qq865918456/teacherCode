package com.qf.utils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.tomcat.jni.User;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

public class DBUtils {

	// "insert into t_User(username,password,sex,email,role) values(?,?,?,?,?)"
	/**
	 * 共用的更新操作
	 * 
	 * @param sql
	 *            需要执行的sql语句
	 * @param args
	 *            参数
	 * @return 影响的行数
	 */
	public static int commonUpdate(String sql, Object... args) {

		Connection connection = DBManager.getConnection();
		PreparedStatement prst = null;
		try {
			prst = connection.prepareStatement(sql);

			// 占位符赋值
			for (int i = 0; i < args.length; i++) {
				prst.setObject(i + 1, args[i]);
				;
			}

			return prst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(connection, prst);
		}
		return 0;
	}

	/**
	 * 共用的查询操作
	 * @param sql 要执行的sql 
	 * @param cls 集合中的装的类型
	 * @param args 参数
	 * @return 集合
	 */
	// String sql = select * from t_user where id = ?
	// DBUtils.commonQuery(sql,12);
	public static <T> List<T> commonQuery(String sql, Class<T> cls, Object... args) {
		
		// 1.获取连接对象
		Connection connection = DBManager.getConnection();
		PreparedStatement prst = null;
		ResultSet resultSet = null;
		
		// 2.准备一个集合装对象
		List<T> list = new ArrayList<T>();
		try {
			
			// 3.获取预处理对象
			prst = connection.prepareStatement(sql);
			
			// 4.给占位符赋值
			if (args != null) {
				for (int i = 0; i < args.length; i++) {
					prst.setObject(i + 1, args[i]);
				}
			}
			
			// 5.执行查询操作
			resultSet = prst.executeQuery();
			
			// 6.把结果集放到list
			while (resultSet.next()) {
				T ins = cls.newInstance(); // 没循环一需要参加一个对象， User use = new User();
				
				// 7.获取对象所有的属性
				Field[] fields = ins.getClass().getDeclaredFields();
				for (Field field : fields) {
					field.setAccessible(true); // 私有属性需要授权
					String name = field.getName(); // 获取属性名称
					Object value =null;
					try {
						// 根据属性名从结果集对象中获取value
						value = resultSet.getObject(name); // 如果这里出现异常了，说明对象中的名称和表中的列名称不一致 
					} catch (SQLException e) {
//						e.printStackTrace();
						System.err.println("表中没有该字段:"+name);
						
//						try {
//							// 加载属性文件(最终的接解决方案)
//							Properties properties = new Properties();
//							properties.load(DBUtils.class.getClassLoader().getResourceAsStream("user.properties"));
//							String columnName = properties.getProperty(name); // 根据对象中的名称获取表单中的列名称
//							value = resultSet.getObject(columnName);
//						} catch (IOException e1) {
//							e1.printStackTrace();
//						}
					}
					
					field.set(ins, value); // 给属性赋值
				}
				
				// 8.添加集合中
				list.add(ins);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 共用的查询总条数
	 * @param sql count的sql
	 * @return 总体数
	 */
	public static int commonCount(String sql){
		Connection connection = DBManager.getConnection();
		PreparedStatement prst = null;
		ResultSet resultSet = null;
		try {
			// 2.获取预处理对象
			prst = connection.prepareStatement(sql);

			// 3.执行sql
			resultSet = prst.executeQuery();
			if (resultSet.next()) {
				return resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(connection, prst, resultSet);
		}
		return 0;
	}
}
