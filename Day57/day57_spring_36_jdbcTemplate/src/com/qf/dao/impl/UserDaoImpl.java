package com.qf.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.qf.dao.IUserDao;
import com.qf.entity.User;

public class UserDaoImpl extends JdbcTemplate implements IUserDao {

	@Override
	public int add(User user) {
		return super.update("insert into t_user(username,password) values(?,?)", user.getUsername(),
				user.getPassword());
	}

	@Override
	public List<User> getUserList() {
		return super.query("select * from t_user", new RowMapper<User>() {
			// 该方法多次调用
			/**
			 * resultSet:结果集 arg1:遍历的索引
			 */
			@Override
			public User mapRow(ResultSet resultSet, int arg1) throws SQLException {
				// 1.先获取值
				int id = resultSet.getInt("id");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				System.out.println("arg1:" + arg1);
				// 2.封装
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				user.setId(id);
				return user;
			}
		});
	}

}
