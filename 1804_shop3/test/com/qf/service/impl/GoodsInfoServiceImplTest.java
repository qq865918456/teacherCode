package com.qf.service.impl;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.qf.entity.GoodsInfo;
import com.qf.entity.Page;
import com.qf.service.IGoodsInfoService;

public class GoodsInfoServiceImplTest {

	private IGoodsInfoService goodsInfoService = null;
	
	@Before
	public void init(){
		goodsInfoService = new GoodsInfoServiceImpl();
	}
	
	@Test
	public void testAdd() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
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
		goodsInfoService.getPage(page);;
		System.out.println(page);
	}
}
