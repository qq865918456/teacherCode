package com.qf.oa.service.impl;

import com.qf.oa.dao.EmployeeMapper;
import com.qf.oa.entity.Employee;
import com.qf.oa.service.IEmpService;
import com.qf.oa.util.IMUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpServiceImpl implements IEmpService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> queryAll() {
        return employeeMapper.queryAll();
    }

    @Override
    @Transactional
    public int insertOrUpdateEmp(Employee employee) {
        if(employee.getId() == null){
            int result = employeeMapper.insert(employee);
            //新增职工
            String token = IMUtils.registerToken(employee);
            //更新token
            employee.setToken(token);
            employeeMapper.updateByPrimaryKey(employee);
            return result;
        } else {
            return employeeMapper.updateByPrimaryKey(employee);
        }

    }

    @Override
    public Employee queryOne(Integer id) {
        return employeeMapper.selectByPrimaryKey(id);
    }


    @Override
    public Employee queryByEmail(String email){
        return employeeMapper.queryByEmail(email);
    }

    @Override
    public List<Employee> queryAllNoMySelf(Integer id) {
        return employeeMapper.queryAllNoMySelf(id);
    }
}
