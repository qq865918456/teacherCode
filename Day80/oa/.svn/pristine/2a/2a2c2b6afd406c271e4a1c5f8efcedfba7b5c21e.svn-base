package com.qf.oa.controller;

import com.qf.oa.entity.Employee;
import com.qf.oa.util.IMUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/im")
public class IMController {


    @RequestMapping("/sendmsg")
    @ResponseBody
    public void sendMsg(Integer toid, String content){
        Employee employee = (Employee) SecurityUtils.getSubject().getPrincipal();

        //将消息放入数据表中 - from to content state 0 - 未读 1 - 已读

        //发送消息
        IMUtils.sendMsg(employee.getId() + "", content, toid + "");
    }
}
