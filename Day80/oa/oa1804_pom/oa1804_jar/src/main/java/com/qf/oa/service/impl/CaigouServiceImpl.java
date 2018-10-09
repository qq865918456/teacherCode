package com.qf.oa.service.impl;

import com.qf.oa.dao.CaigouMapper;
import com.qf.oa.entity.Caigou;
import com.qf.oa.service.ICaigouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaigouServiceImpl implements ICaigouService {

    @Autowired
    private CaigouMapper caigouMapper;

    @Override
    public List<Caigou> queryByEid(Integer eid) {
        return caigouMapper.queryByEid(eid);
    }

    @Override
    public int insertCaigou(Caigou caigou) {
        return caigouMapper.insert(caigou);
    }

    @Override
    public Caigou queryById(Integer id) {
        return caigouMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateById(Caigou caigou) {
        return caigouMapper.updateByPrimaryKey(caigou);
    }
}
