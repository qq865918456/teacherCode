package com.qf.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.eclipse.jdt.internal.compiler.lookup.ReductionResult;

/**
 * 负责数据库的打开和关闭
 * 
 * @author admin
 *
 */
public class DBManager {

	private static final String URL = "jdbc:mysql://localhost:3306/1804_shop";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

	public static Connection getConnection() {

		try {
			// 1.加载驱动
			Class.forName(DRIVER_CLASS);

			// 2.连接数据库
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // 打印异常信息
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void close(AutoCloseable... autoCloseable) {
		for (AutoCloseable autoCloseable2 : autoCloseable) {
			if (autoCloseable2 != null) {
				try {
					autoCloseable2.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
