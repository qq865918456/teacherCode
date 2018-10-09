package com.qf.service.impl;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.Test;

import com.qf.entity.Goods;
import com.qf.entity.Page;
import com.qf.service.IGoodsService;
import com.qf.utils.DBManager;

import javafx.css.PseudoClass;

public class GoodsServiceImplTest {

	private IGoodsService goodsService = new GoodsServiceImpl();

	@Test
	public void testAdd() {
		Goods t = new Goods();
		t.setGoodsname("蛋糕类");
		t.setGoodsparentid(0);
		System.out.println(goodsService.add(t));
	}

	@Test
	public void testUpdate() {
		List<Goods> parentGoodsList = goodsService.getParentGoodsList();
		for (Goods goods : parentGoodsList) {
			System.out.println(goods);
		}
	}

	@Test
	public void testDelete() {
		String string  = "1";
		Integer role = 1;
		System.out.println(string.equals(role.toString()));
	}

	@Test
	public void testGetById() {
		Connection connection = DBManager.getConnection();
		PreparedStatement prst = null;
		try {
//			prst = connection.prepareStatement("insert into t_User(username) values(?)");
			
			// 设置插入的时候需要主键回填
			prst =connection.prepareStatement("insert into t_User(username) values(?)", Statement.RETURN_GENERATED_KEYS);

			prst.setString(1, "AAAA");

			System.out.println("影响的行数:"+prst.executeUpdate());
			
			// 主键信息都在ResultSet
			ResultSet resultSet = prst.getGeneratedKeys();
			
			resultSet.next();
			
			// 获取主键
			System.out.println("id:"+resultSet.getInt(1));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(connection, prst);
		}
	}

	@Test
	public void testGetPage() {
		Page<Goods> page = new Page<Goods>();
		page.setCurrentPage(4);
		goodsService.getPage(page);
		;
		System.out.println(page);
	}

}
