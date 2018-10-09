package com.qf.oa.service;

import com.qf.oa.entity.Caigou;

import java.util.List;

public interface ICaigouService {

    List<Caigou> queryByEid(Integer eid);

    int insertCaigou(Caigou caigou);

    Caigou queryById(Integer id);

    int updateById(Caigou caigou);
}
