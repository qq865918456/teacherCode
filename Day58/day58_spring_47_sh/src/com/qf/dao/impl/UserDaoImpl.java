package com.qf.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.qf.dao.IUserDao;
import com.qf.entity.User;

public class UserDaoImpl extends HibernateTemplate implements IUserDao {

	@Override
	public int addUser(User user) {
		return (int)super.save(user);
	}

	@Override
	public int getUserCount() {
		return super.execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException, SQLException {
				Long count = (Long)session.createQuery("select count(u) from User u").uniqueResult();
				return count.intValue();
			}
		});
	}

	@Override
	public List<User> getUserList(Integer index, Integer pageSize) {
		// ?细节
		List<User> userList = super.findByExample(new User(), index, pageSize);
		return userList;
	}

	@Override
	public User getUserById(Integer id) {
		return get(User.class, id);
	}

	@Override
	public int udpate(User user) {
		// 返回的就是影响的函数
		return bulkUpdate("update User u set u.name = ? where u.id = ?", user.getUsername(),user.getId());
	}

	@Override
	public int delete(Integer id) {
		return 0;
	}

}
