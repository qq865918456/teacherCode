package com.qf.oa.controller;

import com.qf.oa.entity.Caigou;
import com.qf.oa.entity.Employee;
import com.qf.oa.entity.Yijian;
import com.qf.oa.service.ICaigouService;
import com.qf.oa.service.IYijianService;
import org.activiti.engine.FormService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 处理工作流的流程的Controller与业务无关
 */
@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private IYijianService yijianService;

    @Autowired
    private ICaigouService iCaigouService;

    @Autowired
    private ProcessEngine processEngine;

    /**
     * 获得个人的可处理的任务列表
     * @return
     */
    @RequestMapping("/tasklist")
    public String taskList(Model model){
        Employee employee = (Employee) SecurityUtils.getSubject().getPrincipal();

        TaskService taskService = processEngine.getTaskService();
        List<Task> list = taskService.createTaskQuery()
                .taskCandidateOrAssigned(employee.getId() + "")
                .list();

//        list.get(0).getProcessDefinitionId()//流程部署id
//        list.get(0).getProcessInstanceId()//流程实例id

        model.addAttribute("tasks", list);
        return "tasklist";
    }

    /**
     * 办理任务
     * @return
     */
    @RequestMapping("/banli")
    public String banli(String taskid){
        //获得当前任务节点的form key - 实际要处理这个任务节点的请求
        FormService formService = processEngine.getFormService();
        String url = formService.getTaskFormData(taskid).getTask().getFormKey();
        return "redirect:" + url + "?taskid=" + taskid;
    }

    /**
     * 处理任务
     * cid - 当前处理的业务id
     * flag - 同意还是驳回
     * content - 给出的意见
     * sname - 下一个受理人
     * taskId - 任务节点id
     * @return
     */
    @RequestMapping("/chuli")
    public String chuli(Integer cid, boolean flag, String content, String sname, Integer taskId){

        Employee employee = (Employee) SecurityUtils.getSubject().getPrincipal();

        //意见实体类
        Yijian yijian = new Yijian();
        yijian.setCid(cid);
        yijian.setContent(content);
        yijian.setState(flag ? 0 : 1);
        yijian.setEid(employee.getId());

        yijianService.insert(yijian);

        Caigou caigou = iCaigouService.queryById(cid);

        //执行下一个任务节点
        TaskService taskService = processEngine.getTaskService();
        Map<String, Object> map = new HashMap<>();
        map.put("flag", flag);
        map.put("money", caigou.getMoney());
        map.put("user2", sname);
        taskService.complete(taskId + "", map);
        return "redirect:/task/tasklist";
    }

    /**
     * 再次申请
     * @return
     */
    @RequestMapping("/againshengqing")
    public String againshengqing(Caigou caigou, boolean flag, String taskId, String sname){
        //修改采购信息
        if(!flag){
            caigou.setCstate(3);//当前采购已经关闭
        }
        iCaigouService.updateById(caigou);

        //完成任务
        TaskService taskService = processEngine.getTaskService();
        Map<String, Object> map = new HashMap<>();
        map.put("flag", flag);
        map.put("user2", sname);
        taskService.complete(taskId, map);

        return "redirect:/task/tasklist";
    }
}
