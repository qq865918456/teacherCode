package com.qf.oa.service.impl;

import com.qf.oa.dao.YijianMapper;
import com.qf.oa.entity.Yijian;
import com.qf.oa.service.IYijianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YijianServiceImpl implements IYijianService {

    @Autowired
    private YijianMapper yijianMapper;

    @Override
    public int insert(Yijian yijian) {
        return yijianMapper.insert(yijian);
    }

    @Override
    public List<Yijian> queryByCid(Integer cid) {
        return yijianMapper.queryByCid(cid);
    }
}
