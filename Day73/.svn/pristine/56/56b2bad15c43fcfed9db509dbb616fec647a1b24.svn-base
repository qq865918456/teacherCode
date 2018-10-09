package com.qf.oa.controller;

import com.qf.oa.entity.Employee;
import com.qf.oa.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private IEmpService empService;
    
    /**
     * 职工管理
     * @return
     */
    @RequestMapping("/emplist")
    public String empManager(Model model){

        List<Employee> emps = empService.queryAll();
        model.addAttribute("emps", emps);

        return "emplist";
    }

    /**
     * 新增职工
     * @param employee
     * @return
     */
    @RequestMapping("/insert")
    public String insertEmp(Employee employee){
        empService.insertOrUpdateEmp(employee);
        return  "redirect:/emp/emplist";
    }


    /**
     * 根据id查询单个用户信息
     * @param eid
     * @return
     */
    @RequestMapping("/queryById")
    @ResponseBody
    public Employee queryOneAjax(Integer eid){
        Employee emp = empService.queryOne(eid);
        return emp;
    }
    
    
}
