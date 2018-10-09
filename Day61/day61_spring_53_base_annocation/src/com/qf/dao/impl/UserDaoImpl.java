package com.qf.dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.qf.dao.IUserDao;
import com.qf.entity.User;

//@Component
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {

}
