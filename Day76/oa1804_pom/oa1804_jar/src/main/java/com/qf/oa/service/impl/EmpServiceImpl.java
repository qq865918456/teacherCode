package com.qf.oa.service.impl;

import com.qf.oa.dao.EmployeeMapper;
import com.qf.oa.entity.Employee;
import com.qf.oa.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public int insertOrUpdateEmp(Employee employee) {
        if(employee.getId() == null){
            return employeeMapper.insert(employee);
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
}
