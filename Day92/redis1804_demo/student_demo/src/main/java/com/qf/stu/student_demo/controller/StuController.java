package com.qf.stu.student_demo.controller;

import com.qf.stu.student_demo.entity.Student;
import com.qf.stu.student_demo.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/stu")
public class StuController {

    @Autowired
//    @Qualifier("")
//    @Resource(name = "stuServiceImpl")
    private IStuService iStuService;

    @RequestMapping("/stulist")
    public String stuManager(Model model){
        List<Student> students = iStuService.queryAll();
        model.addAttribute("stus", students);
        return "stulist";
    }

    @RequestMapping("/insert")
    public String insert(){

        Student stu = new Student();
        stu.setName("旺财");
        stu.setAge(6);
        stu.setCid(1);

        iStuService.insert(stu);
        return "redirect:/stu/stulist";
    }

    @RequestMapping("/deletebyid/{id}")
    public String delete(@PathVariable("id") Integer id){
        iStuService.deleteById(id);
        return "redirect:/stu/stulist";
    }

    @RequestMapping("/querybyid/{id}")
    public String queryOne(@PathVariable("id") Integer id, Model model){
        Student student = iStuService.queryOne(id);
        model.addAttribute("stu", student);

        return "stuinfo";
    }

}