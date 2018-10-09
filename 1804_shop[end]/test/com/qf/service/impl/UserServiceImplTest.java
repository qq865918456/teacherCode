package com.qf.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qf.entity.Page;
import com.qf.entity.User;
import com.qf.service.IUserService;
import com.qf.utils.DBManager;
import com.qf.utils.DBUtils;

public class UserServiceImplTest {

	private IUserService userService = new UserServiceImpl();

	@Test
	public void testAddUser() {

		for (int i = 11; i < 12; i++) {
			User user = new User();
			user.setUsername("admin_" + i);
			user.setPassword("admin_" + i);
			user.setEmail("admin_" + i + "@1000phone.com");
			user.setSex(i % 2 == 0 ? 1 : 0);// 1:男；0：女
			user.setRole(i % 2 == 0 ? 1 : 0); // 1:管理员，0：普通用户
			userService.addUser(user);
		}
	}

	@Test
	public void testUpdateUser() {
		User user = new User();
		user.setUsername("admin1");
		user.setPassword("admin1");
		user.setEmail("admin1@1000phone.com");
		user.setSex(1);// 1:男；0：女
		user.setRole(1); // 1:管理员，0：普通用户
		user.setId(16);
		userService.updateUser(user);
	}

	@Test
	public void testDeleteUser() {
		int deleteUser = userService.deleteUser(161);
		System.out.println(deleteUser);
	}

	@Test
	public void testGetUserById() {
		System.out.println(userService.getUserById(15));
	}

	@Test
	public void testGetUserPage() {
		Page page = new Page();
		page.setCurrentPage(5);
		userService.getUserPage(page);
		System.out.println(page);
	}

	@Test
	public void testSql() {
		int[] ids = new int[4];
		ids[0]= 1;
		ids[1]= 2;
		ids[2]= 3;
		ids[3]= 4;
		
		String sql = str(ids);
		System.out.println(sql);
		
		DBUtils.commonUpdate(sql, ids);
	}

	public String str(int[] ids) {
		if (ids != null) {
			StringBuffer buffer = new StringBuffer("delete from t_User where id in (");
			for (int i = 0; i < ids.length; i++) {
				if (i == ids.length - 1) {
					// 进入说明是最后一个
					buffer.append("?)");
				} else {
					buffer.append("?,");
				}
			}
			return buffer.toString();
		}
		return null;
	}

}
