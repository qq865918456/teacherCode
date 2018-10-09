package com.qf.service.impl;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.events.StartElement;

import org.junit.Before;
import org.junit.Test;

import com.qf.entity.GoodsInfo;
import com.qf.entity.Page;
import com.qf.service.IGoodsInfoService;
import com.qf.utils.DBManager;

public class GoodsInfoServiceImplTest {

	private IGoodsInfoService goodsInfoService = null;

	@Before
	public void init() {
		goodsInfoService = new GoodsInfoServiceImpl();
	}

	@Test
	public void testAdd() {
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");

		String remove = "B";

		// 在编辑集合的时候不能改变结构
		for (String string : list) {
			if (string.equals(remove)) {
				list.remove(string);
				break;
			}
		}
		System.out.println(list);

	}

	@Test
	public void testUpdate() {
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetById() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPage() {
		Page<GoodsInfo> page = new Page<GoodsInfo>();
		goodsInfoService.getPage(page);
		;
		System.out.println(page);
	}
}
