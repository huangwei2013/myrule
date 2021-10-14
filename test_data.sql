--
-- Database: db_myrule
-- ------------------------------------------------------
-- Server version	5.7.35

--
-- Test data for flow1
--
INSERT INTO `t_flow` VALUES (1,'test','测试用','测试用',1,1,,NOW(), NOW());

INSERT INTO `t_flow_task` VALUES (1,1,0,'{\'s==12.0;\':3;\'s==13.0;\':4}',NULL,NOW(), NOW());
INSERT INTO `t_flow_task` VALUES (1,2,1,'{\'s==11.0;\':1}',NULL,NOW(), NOW());
INSERT INTO `t_flow_task` VALUES (1,3,0,NULL,NULL,NOW(), NOW());
INSERT INTO `t_flow_task` VALUES (1,4,0,NULL,NULL,NOW(), NOW());

INSERT INTO `t_task` VALUES (1,'测试任务1','测试任务1','测试任务1',1,1,NOW(), NOW());
INSERT INTO `t_task` VALUES (2,'测试任务2','测试任务2','测试任务2',1,1,NOW(), NOW());
INSERT INTO `t_task` VALUES (3,'测试任务3','测试任务3','测试任务3',1,1,NOW(), NOW());
INSERT INTO `t_task` VALUES (4,'测试任务4','测试任务4','测试任务4',1,1,NOW(), NOW());
INSERT INTO `t_task` VALUES (5,'测试任务5','测试任务5','测试任务5',1,1,NOW(), NOW());
INSERT INTO `t_task` VALUES (6,'测试任务6','测试任务6','测试任务6',1,1,NOW(), NOW());
INSERT INTO `t_task` VALUES (7,'测试任务7','测试任务7','测试任务7',1,1,NOW(), NOW());

INSERT INTO `t_task_rule` VALUES (1,1,'s = 12; ',1,NOW(), NOW());
INSERT INTO `t_task_rule` VALUES (2,2,'s = 10 +1;',1,NOW(), NOW());
INSERT INTO `t_task_rule` VALUES (3,4,'f = 2 * 2;',1,NOW(), NOW());



--
-- Test data for flow2
--
INSERT INTO `t_flow` VALUES (2,'flow2_demo','测试流程2','测试流程2',1,1,NOW(), NOW());

INSERT INTO `t_task` VALUES (101,'节点1','节点1','节点1',1,1, NOW(), NOW());
INSERT INTO `t_task` VALUES (102,'节点1','节点1','节点1',1,1, NOW(), NOW());
INSERT INTO `t_task` VALUES (103,'节点1','节点1','节点1',1,1, NOW(), NOW());
INSERT INTO `t_task` VALUES (104,'节点1','节点1','节点1',1,1, NOW(), NOW());
INSERT INTO `t_task` VALUES (105,'节点1','节点1','节点1',1,1, NOW(), NOW());
INSERT INTO `t_task` VALUES (106,'节点1','节点1','节点1',1,1, NOW(), NOW());
INSERT INTO `t_task` VALUES (107,'节点1','节点1','节点1',1,1, NOW(), NOW());
INSERT INTO `t_task` VALUES (108,'节点1','节点1','节点1',1,1, NOW(), NOW());
INSERT INTO `t_task` VALUES (109,'节点1','节点1','节点1',1,1, NOW(), NOW());
INSERT INTO `t_task` VALUES (110,'节点1','节点1','节点1',1,1, NOW(), NOW());
INSERT INTO `t_task` VALUES (111,'节点1','节点1','节点1',1,1, NOW(), NOW());

INSERT INTO `t_flow_task` VALUES (2,101,1,102,NULL, NOW(), NOW());
INSERT INTO `t_flow_task` VALUES (2,102,0,'{\'cond1==1.0;\':103;\'cond1==2.0;\':104}',NULL, NOW(), NOW());
INSERT INTO `t_flow_task` VALUES (2,103,0,105,NULL, NOW(), NOW());
INSERT INTO `t_flow_task` VALUES (2,104,0,'{\'cond2==1.0;\':106}',NULL, NOW(), NOW());
INSERT INTO `t_flow_task` VALUES (2,105,0,111,NULL, NOW(), NOW());
INSERT INTO `t_flow_task` VALUES (2,106,0,'{\'cond3==1.0;\':107;\'cond3==2.0;\':108;\'cond3==3.0;\':109}',NULL, NOW(), NOW());
INSERT INTO `t_flow_task` VALUES (2,107,0,'{\'cond4==1.0;\':110;\'cond4==2.0;\':111}',NULL, NOW(), NOW());
INSERT INTO `t_flow_task` VALUES (2,108,0,'{\'cond5==1.0;\':116}',NULL, NOW(), NOW());
INSERT INTO `t_flow_task` VALUES (2,109,0,NULL,NULL, NOW(), NOW());
INSERT INTO `t_flow_task` VALUES (2,110,0,NULL,NULL, NOW(), NOW());
INSERT INTO `t_flow_task` VALUES (2,111,0,NULL,NULL, NOW(), NOW());

INSERT INTO `t_task_rule` VALUES (101,101,'number = 12; ',1,  NOW(), NOW());
INSERT INTO `t_task_rule` VALUES (102,101,'cond1 = 1; ',1,  NOW(), NOW());



