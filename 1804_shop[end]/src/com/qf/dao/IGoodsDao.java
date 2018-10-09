package com.qf.dao;

import java.util.List;

import com.qf.entity.Goods;

public interface IGoodsDao extends IBaseDao<Goods> {

	List<Goods> getParentGoodsList();

	List<Goods> getGoodsListByParentId(Integer id);

	List<Goods> getGoodsList();

}
