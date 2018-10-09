package com.qf.dao;

import java.util.List;

import com.qf.entity.GoodsInfo;

public interface IGoodsInfoDao extends IBaseDao<GoodsInfo> {

	List<GoodsInfo> getGoodsInfoList();

}
