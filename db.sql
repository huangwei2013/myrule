
CREATE DATABASE `db_myrule`;
USE `db_myrule`;

CREATE TABLE IF NOT EXISTS `t_flow`(
    `id` INT(10) NOT NULL AUTO_INCREMENT COMMENT '流程ID',
    `name` VARCHAR(40) NOT NULL COMMENT '流程名称',
    `alias` VARCHAR(40) NOT NULL COMMENT '流程名称，显示用',
    `note` VARCHAR(255) NOT NULL COMMENT '流程说明',
    `version` INT(10) NOT NULL DEFAULT '1' COMMENT '资源，版本必须递增',
    `status` TINYINT(4) NOT NULL DEFAULT '1' COMMENT '流程状态, 1-无效;2-有效',  
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',    
    PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='流程表';


CREATE TABLE IF NOT EXISTS `t_task`(
    `id` INT(10) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
    `name` VARCHAR(40) NOT NULL COMMENT '任务名称',
    `alias` VARCHAR(40) NOT NULL COMMENT '任务名称，显示用',
    `note` VARCHAR(255) NOT NULL COMMENT '任务说明',
    `version` INT(10) NOT NULL DEFAULT '1' COMMENT '资源，版本必须递增',
    `status` TINYINT(4) NOT NULL DEFAULT '1' COMMENT '流程状态, 1-无效;2-有效',  
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',    
    PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='任务表';


CREATE TABLE IF NOT EXISTS `t_flow_task`(
    `flowId` INT(10) NOT NULL  COMMENT '流程ID',
    `taskId` INT(10) NOT NULL  COMMENT '任务ID',
    `type` INT(10) NOT NULL  COMMENT '任务类型，{startTask, commonTask}',
    `next` TEXT COMMENT '下一个task的跳转规则',
    `pre`  TEXT COMMENT '本task开启的前提，为前置节点执行+结果之间逻辑表达式',
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',    
    UNIQUE KEY `key_flow_task` (`flowId`,`taskId`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='流程任务关系表';


CREATE TABLE IF NOT EXISTS `t_task_rule`(
    `id` INT(10) NOT NULL AUTO_INCREMENT COMMENT '规则ID',
    `taskId` INT(10) NOT NULL  COMMENT '任务ID',
    `content` VARCHAR(255) NOT NULL COMMENT '规则内容',
    `status` TINYINT(4) NOT NULL DEFAULT '1' COMMENT '规则状态, 1-无效;2-有效',  
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',    
    PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='任务规则表';


CREATE TABLE IF NOT EXISTS `t_flow_inst`(
    `id` INT(10) NOT NULL AUTO_INCREMENT COMMENT '规则ID',
    `flowId` INT(10) NOT NULL  COMMENT '流程ID',
    `ret` TINYINT(2) DEFAULT 0 COMMENT '执行结果：0-未执行完;1-成功; >1-错误(码)',
    `taskSet` TEXT COMMENT '任务集',
    `facts` TEXT COMMENT '事实/数据',
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',    
    PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='流程实例表';


CREATE TABLE IF NOT EXISTS `t_task_inst`(
    `id` INT(10) NOT NULL AUTO_INCREMENT COMMENT '规则ID',
    `flowInstId` INT(10) NOT NULL  COMMENT '流程实例ID',
    `flowId` INT(10) NOT NULL  COMMENT '流程ID',
    `taskId` INT(10) NOT NULL  COMMENT '任务ID',
    `ret` TINYINT(2) DEFAULT 0 COMMENT '执行结果：0-未执行完;1-成功; >1-错误(码)',
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',    
    PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='任务实例表';
