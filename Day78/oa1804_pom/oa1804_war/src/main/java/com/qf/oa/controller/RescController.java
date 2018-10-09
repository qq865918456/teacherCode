package com.qf.oa.controller;

import com.qf.oa.entity.Resc;
import com.qf.oa.interceptor.Page;
import com.qf.oa.service.IRescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @RestController 和 @Controller的区别
 * @RestController下的所有方法会默认添加@ResponseBody注解
 *
 * 通常来说@RestController多用于接口设计
 * 前后端分离 - 开发模式
 *
 * 后台 - json - 前端
 * 前台（html、android、ios）
 *
 */
@Controller
@RequestMapping("/resc")
public class RescController {

    @Autowired
    private IRescService rescService;


    @RequestMapping("/resclist")
    public String rescManager(Model model, Page page){
        List<Resc> rescs = rescService.queryAll(null);
        model.addAttribute("rescs", rescs);
        return "resclist";
    }


    @RequestMapping("/queryall")
    @ResponseBody
    public List<Resc> queryAllAjax(Integer rid){
        List<Resc> rescs = rescService.queryAll(rid);
        return rescs;
    }

    @RequestMapping("/insert")
    public String insertResc(Resc resc){
        rescService.insertResc(resc);
        return "redirect:/resc/resclist";
    }

    @RequestMapping("/selectresc")
    @ResponseBody
    public Integer selectResc(Integer rid, Integer[] reids){
        int result = rescService.updateRescAndRole(rid, reids);
        return result;
    }
}
