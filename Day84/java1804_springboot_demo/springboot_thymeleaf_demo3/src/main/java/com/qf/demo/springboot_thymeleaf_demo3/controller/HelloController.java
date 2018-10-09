package com.qf.demo.springboot_thymeleaf_demo3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * "hello" -> 视图解析器 -> /WEB-INF/jsp/ hello .jsp
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("name", "小明");
        model.addAttribute("age", 17);
        model.addAttribute("address", "广东省深圳市");

        List<String> strs = new ArrayList<>();
        strs.add("足球");
        strs.add("篮球");
        strs.add("排球");
        strs.add("乒乓球");
        model.addAttribute("datas", strs);

        model.addAttribute("birthday", new Date());
        return "hello";
    }
}
