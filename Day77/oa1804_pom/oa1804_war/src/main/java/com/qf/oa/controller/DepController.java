package com.qf.oa.controller;

import com.qf.oa.entity.Department;
import com.qf.oa.interceptor.Page;
import com.qf.oa.service.IDepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/dep")
public class DepController {

    @Autowired
    private IDepService depService;
    
    @RequestMapping("/deplist")
    public String depManager(Model model, Page page){
        //分页查询所有部门
        List<Department> deps = depService.queryAllByPage();
        model.addAttribute("deps", deps);
        return "deplist";
    }

    @RequestMapping("/insert")
    public String insertDep(Department department){
        depService.insertDep(department);
        return "redirect:/dep/deplist";
    }

    /**
     * Object -> jsonObject {}
     * List<student>/Set -> jsonArray [{},{},{}]
     * Map -> jsonObject {key:value,key:value}
     * @return
     */
    @RequestMapping("/queryall")
    @ResponseBody//将方法的返回值直接放入的响应体中，不经过springmvc的视图解析器
    public List<Department> queryAllAjax(){
        //查询所有的部门
        List<Department> deps = depService.queryAllByPage();
        return deps;
    }

    /**
     * 根据id删除部门
     * @return
     */
    @RequestMapping("/delete/{did}")
    public String deleteById(@PathVariable("did") Integer did){
        //调用删除的业务
        depService.deleteDeps(did);
        return "redirect:/dep/deplist";
    }
}
