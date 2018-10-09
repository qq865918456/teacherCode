package com.qf.oa.service.impl;

import com.qf.oa.dao.DepartmentMapper;
import com.qf.oa.entity.Department;
import com.qf.oa.service.IDepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepServiceImpl implements IDepService{

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> queryAllByPage() {
        return departmentMapper.queryAll();
    }

    @Override
    public int insertDep(Department department) {
        return departmentMapper.insert(department);
    }

    @Override
    public int deleteDeps(int did) {
        departmentMapper.deleteDeps(did);
        return 1;
    }
}
