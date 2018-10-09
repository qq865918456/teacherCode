create database activitidb;

#流程部署相关的一些表
act_re_deployment #流程部署的基本信息表
act_re_procdef #流程定义表 - 每个流程对应这张表中的一条记录
act_ge_bytearray #流程图的内容信息表

#启动流程相关的一些表 - 如果一个流程执行完毕，则所有act_ru_xxx相关的表全部清空
act_ru_execution #流程执行的信息表 - 表示开始了一个请假流程
act_ru_task #流程节点信息表 - 表示当前这个流程走到哪里节点