package com.qf.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext-*.xml")
public class ProceeTest {

    @Autowired
    private ProcessEngine processEngine;

    /**
     * 部署流程图
     */
    @Test
    public void deployeProcess(){
        RepositoryService repositoryService = processEngine.getRepositoryService();
        repositoryService.createDeployment()
                .name("采购流程")
                .addClasspathResource("caigou.bpmn")
                .deploy();
    }

}
