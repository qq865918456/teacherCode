package com.qf.demo.springboot_mybatis_demo2.controller;

import com.qf.demo.springboot_mybatis_demo2.entity.Student;
import com.qf.demo.springboot_mybatis_demo2.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/stu")
public class StudentController {

    @Autowired
    private IStuService iStuService;

    @RequestMapping("/queryall")
    public String queryAll(Model model){
        List<Student> students = iStuService.queryAll();
        model.addAttribute("stus", students);
        return "stulist";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public int insert(){
        Student stu = new Student();
        stu.setName("小小明");
        stu.setAge(199);
        stu.setCid(1);
        return iStuService.insert(stu);
    }
}
