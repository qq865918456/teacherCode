package com.qf.service;

import java.util.List;

import com.qf.entity.GoodsInfo;
import com.qf.service.IBaseService;

public interface IGoodsInfoService extends IBaseService<GoodsInfo>{

	List<GoodsInfo> getGoodsInfoList();

}
