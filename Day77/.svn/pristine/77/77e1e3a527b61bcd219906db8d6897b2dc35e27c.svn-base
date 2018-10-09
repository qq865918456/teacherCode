package com.qf.oa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexControler {

    /**
     * 页面跳转的方法
     * @param page
     * @return
     */
    // /index/xxx -> xxx.jps
    @RequestMapping("/{page}")
    public String toPage(@PathVariable("page") String page){
        return page;
    }
}
