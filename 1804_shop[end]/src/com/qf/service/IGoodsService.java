package com.qf.service;

import java.util.List;

import com.qf.entity.Goods;

public interface IGoodsService extends IBaseService<Goods>{

	List<Goods> getParentGoodsList();

	List<Goods> getGoodsListByParentId(Integer id);

	List<Goods> getGoodsList();
	
}
