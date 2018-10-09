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
import com.qf.utils.DBManagerTest;

public class UserDaoImpl_temp implements IUserDao {

	@Override
	public int addUser(User user) {

		// 1.获取连接对象
		Connection connection = DBManager.getConnection();
		PreparedStatement prst = null;

		try {
			// 2.获取预处理对象
			prst = connection
					.prepareStatement("insert into t_User(username,password,sex,email,role) values(?,?,?,?,?)");

			// 3.给占位符赋值
			prst.setString(1, user.getUsername());
			prst.setString(2, user.getPassword());
			prst.setInt(3, user.getSex());
			prst.setString(4, user.getEmail());
			prst.setInt(5, user.getRole());

			// 5.执行sql
			return prst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(connection, prst);
		}
		return 0;
	}

	@Override
	public int updateUser(User user) {

		// 1.获取连接对象
		Connection connection = DBManager.getConnection();
		PreparedStatement prst = null;

		try {
			// 2.获取预处理对象
			prst = connection.prepareStatement(
					"update t_User set username = ?,password = ?,sex = ?,email = ?,role = ? where id = ?");

			// 3.给占位符赋值
			prst.setString(1, user.getUsername());
			prst.setString(2, user.getPassword());
			prst.setInt(3, user.getSex());
			prst.setString(4, user.getEmail());
			prst.setInt(5, user.getRole());
			prst.setInt(6, user.getId());

			// 5.执行sql
			return prst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(connection, prst);
		}
		return 0;
	}

	@Override
	public int deleteUser(Integer id) {
		// 1.获取连接对象
		Connection connection = DBManager.getConnection();
		PreparedStatement prst = null;

		try {
			// 2.获取预处理对象
			prst = connection.prepareStatement("delete from t_User where id = ?");

			// 3.给占位符赋值
			prst.setInt(1, id);

			// 5.执行sql
			return prst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(connection, prst);
		}
		return 0;
	}

	@Override
	public User getUserById(Integer id) {
		// 1.获取连接对象
		Connection connection = DBManager.getConnection();
		PreparedStatement prst = null;
		ResultSet resultSet = null;
		User user = null;
		try {
			// 2.获取预处理对象
			prst = connection.prepareStatement("select * from t_User where id = ?");

			// 3.给占位符赋值
			prst.setInt(1, id);

			// 5.执行sql
			resultSet = prst.executeQuery();

			if (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setSex(resultSet.getInt("sex"));
				user.setEmail(resultSet.getString("email"));
				user.setRole(resultSet.getInt("role"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(connection, prst, resultSet);
		}
		return user;
	}

	@Override
	public List<User> getUserList(Integer index, Integer size) {
		Connection connection = DBManager.getConnection();
		PreparedStatement prst = null;
		ResultSet resultSet = null;
		List<User> userList = new ArrayList<User>();
		try {
			// 2.获取预处理对象
			prst = connection.prepareStatement("select * from t_User limit ?,?");

			// 3.给占位符赋值
			prst.setInt(1, index);
			prst.setInt(2, size);

			// 5.执行sql
			resultSet = prst.executeQuery();
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setSex(resultSet.getInt("sex"));
				user.setEmail(resultSet.getString("email"));
				user.setRole(resultSet.getInt("role"));

				userList.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(connection, prst, resultSet);
		}
		return userList;
	}

	@Override
	public int getUserCount() {
		Connection connection = DBManager.getConnection();
		PreparedStatement prst = null;
		ResultSet resultSet = null;
		try {
			// 2.获取预处理对象
			prst = connection.prepareStatement("select count(1) from t_User");

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

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
