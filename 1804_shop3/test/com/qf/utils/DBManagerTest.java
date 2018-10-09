package com.qf.utils;

import java.sql.Connection;

import org.junit.Test;

public class DBManagerTest {

	@Test
	public void testGetConnection() {
		Connection connection = DBManager.getConnection();
		System.out.println(connection);
	}

}
