package com.qf.oa.controller;

import com.qf.oa.entity.Role;
import com.qf.oa.interceptor.Page;
import com.qf.oa.service.IRoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @RequiresPermissions("/role/rolelist")
    @RequestMapping("/rolelist")
    public String roleManager(Model model, Page page){
        List<Role> roles = roleService.queryAll();
        model.addAttribute("roles", roles);
        return "rolelist";
    }


    @RequiresPermissions("/role/insert")
    @RequestMapping("/insert")
    public String roleInsert(Role role){
        roleService.roleInsert(role);
        return "redirect:/role/rolelist";
    }


    /**
     * ajax - 查询角色列表，并且会获得一个职工的id，根据职工的id，获得该职工所拥有的角色
     * @return
     */
    @RequestMapping("/queryall")
    @ResponseBody
    public List<Role> queryAllAjax(Integer eid){
        List<Role> roles = roleService.queryRolesByEid(eid);
        return roles;
    }

    /**
     * 选择职工的角色
     * @return
     */
    @RequiresPermissions("/emp/selectrole")
    @RequestMapping("/selectroles")
    public String selectRoles(Integer eid, Integer[] rid){
        roleService.selectRoles(eid, rid);
        return "redirect:/emp/emplist";
    }
}
