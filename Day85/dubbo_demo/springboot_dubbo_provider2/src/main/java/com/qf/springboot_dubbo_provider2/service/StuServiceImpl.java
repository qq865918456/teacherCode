package com.qf.springboot_dubbo_provider2.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.entity.Student;
import com.qf.service.IStuService;

@Service
public class StuServiceImpl implements IStuService {

    @Override
    public Student queryById(Integer id) {
        System.out.println("第二个提供者-服务层根据id查询学生：" + id);

        Student student = new Student();
        student.setId(10);
        student.setName("小明 - 第二个提供者");
        student.setAge(18);
        return student;
    }
}
