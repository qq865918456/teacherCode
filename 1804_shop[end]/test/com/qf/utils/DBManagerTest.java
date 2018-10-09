package com.qf.utils;

import java.sql.Connection;

import org.junit.Test;

public class DBManagerTest {

	@Test
	public void testGetConnection() {
		for(int i =0;i<100;i++){
			Connection connection = DBManager.getConnection();
			System.out.println(connection);
			DBManager.close(connection);
		}
	}

}
