package com.qf.oa.service.impl;

import com.qf.oa.dao.IStuDao;
import com.qf.oa.entity.Student;
import com.qf.oa.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//万能键：alt+回车
@Service
public class StuServiceImpl implements IStuService {

    @Autowired
    private IStuDao stuDao;

    @Transactional
    public List<Student> querAll() {
        return stuDao.queryAll();
    }
}
