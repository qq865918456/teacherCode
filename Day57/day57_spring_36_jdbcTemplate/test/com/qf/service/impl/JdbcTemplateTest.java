package com.qf.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.qf.entity.User;

public class JdbcTemplateTest {

	@Test
	public void testJDbcTemplateAdd() throws Exception {
		
		// 1.创建JdbcTemplate
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		
		// 2.设置数据源
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/1804_mysql");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		
		jdbcTemplate.setDataSource(dataSource);
		
		// 3.操作数据库
		int update = jdbcTemplate.update("insert into t_user(username,password) values(?,?)", "qfAdmin","123");
		System.out.println(update);
		
	}
	
	@Test
	public void testJDbcTemplateQuery() throws Exception {
		
		// 1.创建JdbcTemplate
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		
		// 2.设置数据源
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/1804_mysql");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		
		jdbcTemplate.setDataSource(dataSource);
		
		// 3.操作数据库
		List<User> userList = jdbcTemplate.query("select * from t_user", new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet resultSet, int arg1) throws SQLException {
				// 1.先获取值
				int id = resultSet.getInt("id");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				System.out.println("arg1:"+arg1);
				// 2.封装
				User user  = new User();
				user.setUsername(username);
				user.setPassword(password);
				user.setId(id);
				return user;
			}
		});
		
		for (User user : userList) {
			System.out.println(user);
		}
	}
	
}
