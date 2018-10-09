package com.qf.oa.service;

import com.qf.oa.entity.Resc;

import java.util.List;

public interface IRescService {

    List<Resc> queryAll(Integer rid);

    int insertResc(Resc resc);

    int updateRescAndRole(Integer rid, Integer[] reids);

}
