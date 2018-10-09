package com.qf.oa.controller;

import com.qf.oa.entity.Employee;
import com.qf.oa.service.IEmpService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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
    @RequiresPermissions("/emp/emplist")
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
    @RequiresPermissions("/emp/insert")
    @RequestMapping("/insert")
    public String insertEmp(Employee employee){
        empService.insertOrUpdateEmp(employee);
        return  "redirect:/emp/emplist";
    }


    @RequestMapping("/queryall")
    @ResponseBody
    public List<Employee> queryAllAjax(){
        List<Employee> employees = empService.queryAll();
        return employees;
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

    /**
     * 查询除了自己的所有同事信息
     * @return
     */
    @RequestMapping("/queryAllNoMyself")
    @ResponseBody
    public List<Employee> queryAllNoMySelf(){
        Employee employee = (Employee) SecurityUtils.getSubject().getPrincipal();
        List<Employee> employees = empService.queryAllNoMySelf(employee.getId());
        return employees;
    }

    /**
     * 根据关键字查询职工的信息
     * @param keyword
     * @return
     */
    @RequestMapping("/querybykeyword")
    @ResponseBody
    public List<String> querybykeyword(String keyword){
        System.out.println(keyword);
        List<Employee> employees = empService.queryByKeyWord(keyword);

        List<String> array = new ArrayList<>();
        for (Employee employee : employees) {
            array.add(employee.getName() + "(" + employee.getEmail() + ")");
        }
        return array;
    }

}
