package com.qf.service.impl;

import com.qf.service.IStuService;
import org.springframework.stereotype.Service;

@Service
public class StuServiceImpl implements IStuService {

    @Override
    public String hello(Integer id) {
        System.out.println("调用了提供者的方法：" + id);
        return "OK!!!!";
    }
}
