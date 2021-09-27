-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: 8.130.28.97    Database: db_myrule
-- ------------------------------------------------------
-- Server version	5.7.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `t_flow`
--

LOCK TABLES `t_flow` WRITE;
/*!40000 ALTER TABLE `t_flow` DISABLE KEYS */;
INSERT INTO `t_flow` VALUES (1,'test','测试用','测试用',1,1,'2021-09-15 11:22:34','2021-09-15 11:22:34');
INSERT INTO `t_flow` VALUES (2,'test2','测试流程2','测试流程2',1,1,'2021-09-15 11:22:51','2021-09-15 11:22:51');
/*!40000 ALTER TABLE `t_flow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_flow_inst`
--

LOCK TABLES `t_flow_inst` WRITE;
/*!40000 ALTER TABLE `t_flow_inst` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_flow_inst` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_flow_task`
--

LOCK TABLES `t_flow_task` WRITE;
/*!40000 ALTER TABLE `t_flow_task` DISABLE KEYS */;
INSERT INTO `t_flow_task` VALUES (1,1,0,'{\'s==12.0;\':3;\'s==13.0;\':4}',NULL,'2021-09-15 11:23:40','2021-09-26 10:49:13');
INSERT INTO `t_flow_task` VALUES (1,2,1,'{\'s==11.0;\':1}',NULL,'2021-09-15 11:24:12','2021-09-18 04:39:55');
INSERT INTO `t_flow_task` VALUES (1,3,0,NULL,NULL,'2021-09-26 10:48:35','2021-09-26 10:48:35');
INSERT INTO `t_flow_task` VALUES (1,4,0,NULL,NULL,'2021-09-27 11:29:48','2021-09-27 11:29:48');
/*!40000 ALTER TABLE `t_flow_task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_resource`
--

LOCK TABLES `t_resource` WRITE;
/*!40000 ALTER TABLE `t_resource` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_task`
--

LOCK TABLES `t_task` WRITE;
/*!40000 ALTER TABLE `t_task` DISABLE KEYS */;
INSERT INTO `t_task` VALUES (1,'测试任务1','测试任务1','测试任务1',1,1,'2021-09-15 11:23:10','2021-09-15 11:23:10');
INSERT INTO `t_task` VALUES (2,'测试任务2','测试任务2','测试任务2',1,1,'2021-09-15 11:23:21','2021-09-15 11:23:21');
INSERT INTO `t_task` VALUES (3,'测试任务3','测试任务3','测试任务3',1,1,'2021-09-15 11:23:31','2021-09-15 11:23:31');
INSERT INTO `t_task` VALUES (4,'测试任务4','测试任务4','测试任务4',1,1,'2021-09-26 10:45:19','2021-09-26 10:45:19');
INSERT INTO `t_task` VALUES (5,'测试任务5','测试任务5','测试任务5',1,1,'2021-09-26 10:45:19','2021-09-26 10:45:19');
INSERT INTO `t_task` VALUES (6,'测试任务6','测试任务6','测试任务6',1,1,'2021-09-26 10:45:19','2021-09-26 10:45:19');
INSERT INTO `t_task` VALUES (7,'测试任务7','测试任务7','测试任务7',1,1,'2021-09-26 10:45:20','2021-09-26 10:45:20');
/*!40000 ALTER TABLE `t_task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_task_inst`
--

LOCK TABLES `t_task_inst` WRITE;
/*!40000 ALTER TABLE `t_task_inst` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_task_inst` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `t_task_rule`
--

LOCK TABLES `t_task_rule` WRITE;
/*!40000 ALTER TABLE `t_task_rule` DISABLE KEYS */;
INSERT INTO `t_task_rule` VALUES (1,1,'s = 12; ',1,'2021-09-18 01:43:19','2021-09-27 13:17:15');
INSERT INTO `t_task_rule` VALUES (2,2,'s = 10 +1;',1,'2021-09-18 01:43:55','2021-09-18 02:13:33');
INSERT INTO `t_task_rule` VALUES (3,4,'f = 2 * 2;',1,'2021-09-18 01:44:21','2021-09-18 02:13:37');
/*!40000 ALTER TABLE `t_task_rule` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-27 21:26:21
