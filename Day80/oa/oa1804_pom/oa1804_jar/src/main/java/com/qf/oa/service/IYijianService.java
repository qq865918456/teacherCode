package com.qf.oa.service;

import com.qf.oa.entity.Yijian;

import java.util.List;

public interface IYijianService {

    int insert(Yijian yijian);

    List<Yijian> queryByCid(Integer cid);
}
