package com.qf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qf.dao.IUserDao;
import com.qf.entity.User;
import com.qf.utils.DBManager;
import com.qf.utils.DBUtils;

public class UserDaoImpl implements IUserDao {

	@Override
	public int addUser(User user) {
		String sql = "insert into t_User(username,password,sex,email,role) values(?,?,?,?,?)";
		return DBUtils.commonUpdate(sql, user.getUsername(), user.getPassword(), user.getSex(), user.getEmail(),
				user.getRole());
	}

	@Override
	public int updateUser(User user) {
		String sql = "update t_User set username = ?,password = ?,sex = ?,email = ?,role = ? where id = ?";
		return DBUtils.commonUpdate(sql, user.getUsername(), user.getPassword(), user.getSex(), user.getEmail(),
				user.getRole(), user.getId());
	}

	@Override
	public int deleteUser(Integer id) {
		String sql = "delete from t_User where id = ?";
		return DBUtils.commonUpdate(sql, id);
	}

	@Override
	public User getUserById(Integer id) {
		String sql = "select * from t_User where id = ?";
		List<User> userList = DBUtils.commonQuery(sql, User.class, id);
		if (!userList.isEmpty()) {
			return userList.get(0);
		}
		return null;
	}

	@Override
	public List<User> getUserList(Integer index, Integer size) {
		String sql = "select * from t_User limit ?,?";
		return DBUtils.commonQuery(sql, User.class, index, size);
	}

	@Override
	public int getUserCount() {
		return DBUtils.commonCount("select count(1) from t_User");
	}

	@Override
	public User login(String username, String password) {
		String sql = "select * from t_user where username = ? and password = ?";
		List<User> userList = DBUtils.commonQuery(sql, User.class, username, password);
		if (!userList.isEmpty()) {
			return userList.get(0);
		}
		return null;
	}

}
