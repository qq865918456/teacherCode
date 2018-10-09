package com.qf.springboot_dubbo_consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.Student;
import com.qf.service.IStuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StuController {

    @Reference
    private IStuService stuService;

    @RequestMapping("/hello")
    public Student hello(){
        Student student = stuService.queryById(100);
        return student;
    }
}
