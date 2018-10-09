package com.qf.oa.service;

import com.qf.oa.entity.Employee;

import java.util.List;

public interface IEmpService {

    List<Employee> queryAll();

    int insertOrUpdateEmp(Employee employee);

    Employee queryOne(Integer id);
}
