package com.qf.oa.service.impl;

import com.qf.oa.dao.RescMapper;
import com.qf.oa.dao.RoleMapper;
import com.qf.oa.entity.Resc;
import com.qf.oa.service.IRescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RescServiceImpl implements IRescService{

    @Autowired
    private RescMapper rescMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Resc> queryAll(Integer rid) {
        return rescMapper.queryAll(rid);
    }

    @Override
    public int insertResc(Resc resc) {
        return rescMapper.insert(resc);
    }

    @Override
    @Transactional
    public int updateRescAndRole(Integer rid, Integer[] reids) {
        //根据角色id删除中间表的关系
        roleMapper.deleteRoleRescTable(rid);
        //插入角色和权限的关系
        return rescMapper.insertRoleAndResc(rid, reids);
    }
}
