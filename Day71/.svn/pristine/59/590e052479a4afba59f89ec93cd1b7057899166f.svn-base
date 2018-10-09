package com.qf.oa.controller;

import com.qf.oa.entity.Student;
import com.qf.oa.interceptor.Page;
import com.qf.oa.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/stu")
public class StuController{


    @Autowired
    private IStuService stuService;


    @RequestMapping("/queryall")
    public String queryAll(Page page, Model model){

        //返回值：ctrl + alt + v
        List<Student> stus = stuService.querAll();
        model.addAttribute("stus", stus);

        return "stulist";
    }
}
