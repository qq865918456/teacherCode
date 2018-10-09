package com.qf.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.qf.entity.Goods;
import com.qf.entity.Page;
import com.qf.service.IGoodsService;

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
		fail("Not yet implemented");
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
