package com.qf.activiti;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * activiti工作流的开发流程：
 * 1、编写流程图（编写流程图的插件eclipse、idea（编码的问题））
 * 2、根据配置获取流程引擎（后面的一切操作都是基于这个流程引擎的）
 * 3、根据流程引擎部署流程图 - 流程部署对象（每个流程部署对象对应一个流程）
 * 4、根据部署的流程，启动该流程 - 流程实例对象（一个流程可以对应多个流程实例）
 * 5、根据流程图走流程
 */
public class Main {


    /**
     * 创建流程引擎
     */
    public ProcessEngine createProcessEngine(){
        //创建流程引擎的配置对象
        ProcessEngineConfiguration configuration =
                ProcessEngineConfiguration.createStandaloneInMemProcessEngineConfiguration();

        //
        configuration.setJdbcUrl("jdbc:mysql:///activitidb");
        configuration.setJdbcUsername("root");
        configuration.setJdbcPassword("root");
        configuration.setJdbcDriver("com.mysql.jdbc.Driver");
        //配置数据库表是否自动创建 - 自动会创建20+张表
        configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        //根据流程引擎配置获得流程引擎对象
        ProcessEngine processEngine = configuration.buildProcessEngine();
        return processEngine;
    }

    /**
     * 根据流程引擎部署流程图
     */
    @Test
    public void deployProcess(){
        //
        ProcessEngine processEngine = createProcessEngine();

        //获得部署流程图的服务对象
        RepositoryService repositoryService = processEngine.getRepositoryService();

        //部署流程图 - 返回值就是一个流程部署对象
        Deployment deploy = repositoryService.createDeployment()
                .name("请假流程")
                .addClasspathResource("qingjia.bpmn")
                .deploy();

        System.out.println("流程部署的id-->" + deploy.getId());
        System.out.println("流程部署的名称-->" + deploy.getName());
    }


    /**
     * 开启流程 - 有人开始走流程（开始请假）
     */
    @Test
    public void startProcess(){
        //
        ProcessEngine processEngine = createProcessEngine();
        //获得开启流程的服务
        RuntimeService runtimeService = processEngine.getRuntimeService();

        //根据key启动一个流程 - 创建流程实例
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess");

        System.out.println("流程部署id--->" + processInstance.getDeploymentId());
        System.out.println("流程名称--->" + processInstance.getName());
    }


    /**
     * 查询节点任务 - 查看当前有哪些任务
     */
    @Test
    public void queryTask(){
        //
        ProcessEngine processEngine = createProcessEngine();

        TaskService taskService = processEngine.getTaskService();
        List<Task> list = taskService.createTaskQuery()
                .taskCandidateOrAssigned("小刚")
                .list();
        for (Task task : list) {
            System.out.println("-------------------");
            System.out.println("任务id--->" + task.getId());
            System.out.println("流程部署的id--->" + task.getProcessDefinitionId());
            System.out.println("流程实例的id--->" + task.getProcessInstanceId());
            System.out.println("任务节点名称--->" + task.getName());
        }
    }


    /**
     * 执行任务节点
     */
    @Test
    public void exeTask(){
        //
        ProcessEngine processEngine = createProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        //完成任务
        Map map = new HashMap();
        map.put("flag", "true");
        taskService.complete("15003", map);
        System.out.println("任务完成");
    }
}
