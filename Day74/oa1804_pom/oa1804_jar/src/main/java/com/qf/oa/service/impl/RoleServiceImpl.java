package com.qf.oa.service.impl;

import com.qf.oa.dao.EmployeeMapper;
import com.qf.oa.dao.RoleMapper;
import com.qf.oa.entity.Role;
import com.qf.oa.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Role> queryAll() {
        return roleMapper.queryAll();
    }

    @Override
    public List<Role> queryRolesByEid(Integer eid) {
        return roleMapper.queryRolesByEid(eid);
    }

    @Override
    public int roleInsert(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    @Transactional
    public int selectRoles(Integer eid, Integer[] rid) {
        //根据职工的id删除职工的所有角色的关联
        employeeMapper.deleteRolsByEid(eid);
        //新增该职工的角色关联信息
        roleMapper.insertRolesAndEmp(eid, rid);
        return 1;
    }
}
