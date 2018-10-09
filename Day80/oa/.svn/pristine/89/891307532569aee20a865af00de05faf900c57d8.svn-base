package com.qf.oa.controller;

import com.qf.oa.entity.Caigou;
import com.qf.oa.entity.Employee;
import com.qf.oa.entity.Yijian;
import com.qf.oa.service.ICaigouService;
import com.qf.oa.service.IYijianService;
import org.activiti.engine.FormService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/caigou")
public class CaigouController {

    @Autowired
    private ICaigouService caigouService;

    @Autowired
    private ProcessEngine processEngine;

    @Autowired
    private IYijianService yijianService;


    @RequestMapping("/caigoulist")
    public String caigouManager(Model model){
        Employee employee = (Employee) SecurityUtils.getSubject().getPrincipal();
        List<Caigou> caigouList = caigouService.queryByEid(employee.getId());
        model.addAttribute("clist",caigouList);
        return "caigoulist";
    }

    /**
     * 申请采购
     * @param caigou
     * @return
     */
    @RequestMapping("/insert")
    public String caigouInsert(Caigou caigou, String sname){
        Employee employee = (Employee) SecurityUtils.getSubject().getPrincipal();
        caigou.setEid(employee.getId());
        caigouService.insertCaigou(caigou);

        //开启流程
        RuntimeService runtimeService = processEngine.getRuntimeService();

        Map<String, Object> map = new HashMap<>();
        map.put("user1", employee.getId() + "");//申请人是谁? - id
        map.put("user2", sname);//下一个任务的受理人是谁？ - id
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("caigou", caigou.getId() + "", map);


        return "redirect:/caigou/caigoulist";
    }


    /**
     * 采购审核
     *
     * 流程部署 - 多个流程实例 - 多个流程任务
     *
     *
     * @return
     */
    @RequestMapping("/shenghe")
    public String shenghe(String taskid, Model model){

        FormService formService = processEngine.getFormService();
        RuntimeService runtimeService = processEngine.getRuntimeService();

        // - 采购id
        //获得流程实例 - 业务主键
        //通过任务id获得任务节点对象
        Task task = formService.getTaskFormData(taskid).getTask();
        //通过任务节点对象获得流程实例id
        String processInstanceId = task.getProcessInstanceId();
        //通过流程实例id获得流程实例对象
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
        //通过流程实例对象获得业务主键
        Integer cid = Integer.parseInt(processInstance.getBusinessKey());

        //查询采购信息
        Caigou caigou = caigouService.queryById(cid);
        model.addAttribute("caigou", caigou);
        model.addAttribute("taskId", taskid);
        return "shenghe";
    }

    /**
     * 重新申请采购
     * @return
     */
    @RequestMapping("/againshengqing")
    public String againshengqing(String taskid, Model model){
        FormService formService = processEngine.getFormService();
        RuntimeService runtimeService = processEngine.getRuntimeService();

        // - 采购id
        //获得流程实例 - 业务主键
        //通过任务id获得任务节点对象
        Task task = formService.getTaskFormData(taskid).getTask();
        //通过任务节点对象获得流程实例id
        String processInstanceId = task.getProcessInstanceId();
        //通过流程实例id获得流程实例对象
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
        //通过流程实例对象获得业务主键
        Integer cid = Integer.parseInt(processInstance.getBusinessKey());

        //查询采购信息
        Caigou caigou = caigouService.queryById(cid);
        model.addAttribute("caigou", caigou);
        model.addAttribute("taskId", taskid);

        //所有意见
        List<Yijian> yijians = yijianService.queryByCid(cid);
        model.addAttribute("yijians", yijians);

        return "againshengqing";
    }
}
