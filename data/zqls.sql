-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: zqls
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `feedback_info`
--

DROP TABLE IF EXISTS `feedback_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `feedback_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '反馈表id',
  `uid` int(11) NOT NULL COMMENT '用户id',
  `type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '反馈类型：0食物，1食堂环境，2系统改进，3其他',
  `remark` varchar(255) DEFAULT '' COMMENT '反馈描述',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态：0未查看，1已查看，2已解决',
  `is_pic` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否有图片：0无，1有',
  `pic_url` varchar(500) NOT NULL DEFAULT '' COMMENT '图片url地址',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `renew_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  CONSTRAINT `feedback_info_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `ums_user_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='反馈基本表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback_info`
--

LOCK TABLES `feedback_info` WRITE;
/*!40000 ALTER TABLE `feedback_info` DISABLE KEYS */;
INSERT INTO `feedback_info` VALUES (6,2,0,'食物太难吃了',0,0,'','2019-09-17 06:57:33','2019-09-17 06:57:33');
/*!40000 ALTER TABLE `feedback_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fms_food_consume`
--

DROP TABLE IF EXISTS `fms_food_consume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `fms_food_consume` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '食物消耗表id',
  `fid` int(11) NOT NULL COMMENT '食物id',
  `uid` char(11) NOT NULL COMMENT '用户工号',
  `food_quality` decimal(10,5) NOT NULL DEFAULT '0.00000' COMMENT '食物质量',
  `type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '类型：0早，1中，2晚',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `renew_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `fid` (`fid`),
  KEY `uid` (`uid`),
  CONSTRAINT `fms_food_consume_ibfk_1` FOREIGN KEY (`fid`) REFERENCES `fms_food_info` (`id`),
  CONSTRAINT `fms_food_consume_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `ums_user_info` (`job_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='食物消耗表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fms_food_consume`
--

LOCK TABLES `fms_food_consume` WRITE;
/*!40000 ALTER TABLE `fms_food_consume` DISABLE KEYS */;
/*!40000 ALTER TABLE `fms_food_consume` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fms_food_info`
--

DROP TABLE IF EXISTS `fms_food_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `fms_food_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '食物基本表id',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '食物名称',
  `price` bigint(20) NOT NULL DEFAULT '0' COMMENT '食物价格',
  `remark` varchar(255) NOT NULL DEFAULT '' COMMENT '食物备注',
  `taste_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '口味类型：0酸，1甜，2苦，3辣',
  `basic_features` tinyint(4) NOT NULL DEFAULT '0' COMMENT '基本特征：0葱，1蒜，2姜，3香菜',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态：0正常，1冻结',
  `pic_url` varchar(500) NOT NULL DEFAULT '' COMMENT '图片地址',
  `place` varchar(155) NOT NULL DEFAULT '' COMMENT '所在地点',
  `type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '类型：0鲁菜，1川菜，2粤菜，3闽菜，4苏菜，5浙菜，6湘菜，7徽菜',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `operate_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次操作时间',
  `operate_ip` varchar(30) NOT NULL DEFAULT '' COMMENT '操作者ip',
  `operator` varchar(50) NOT NULL DEFAULT '' COMMENT '操作者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='食物基本信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fms_food_info`
--

LOCK TABLES `fms_food_info` WRITE;
/*!40000 ALTER TABLE `fms_food_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `fms_food_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fms_food_production_recommendation`
--

DROP TABLE IF EXISTS `fms_food_production_recommendation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `fms_food_production_recommendation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '食物生产量推荐表id',
  `fid` int(11) NOT NULL COMMENT '食物id',
  `production` decimal(10,5) NOT NULL DEFAULT '0.00000' COMMENT '生产量',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `renew_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `fid` (`fid`),
  CONSTRAINT `fms_food_production_recommendation_ibfk_1` FOREIGN KEY (`fid`) REFERENCES `fms_food_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='食物生产量推荐表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fms_food_production_recommendation`
--

LOCK TABLES `fms_food_production_recommendation` WRITE;
/*!40000 ALTER TABLE `fms_food_production_recommendation` DISABLE KEYS */;
/*!40000 ALTER TABLE `fms_food_production_recommendation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fms_food_production_recommendation_parameters`
--

DROP TABLE IF EXISTS `fms_food_production_recommendation_parameters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `fms_food_production_recommendation_parameters` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '食物生产量推荐参数表id',
  `cid` int(11) NOT NULL COMMENT '食物消耗id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `renew_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `cid` (`cid`),
  CONSTRAINT `fms_food_production_recommendation_parameters_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `fms_food_consume` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='食物生产量推荐参数表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fms_food_production_recommendation_parameters`
--

LOCK TABLES `fms_food_production_recommendation_parameters` WRITE;
/*!40000 ALTER TABLE `fms_food_production_recommendation_parameters` DISABLE KEYS */;
/*!40000 ALTER TABLE `fms_food_production_recommendation_parameters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fms_food_production_recommendation_time`
--

DROP TABLE IF EXISTS `fms_food_production_recommendation_time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `fms_food_production_recommendation_time` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '时间表id',
  `date` date NOT NULL COMMENT '日期',
  `week` tinyint(4) NOT NULL DEFAULT '1' COMMENT '星期：1周一。。0周日',
  `type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '类型：0周末，1节假日',
  `remark` varchar(155) DEFAULT '' COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='食物生产量推荐时间表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fms_food_production_recommendation_time`
--

LOCK TABLES `fms_food_production_recommendation_time` WRITE;
/*!40000 ALTER TABLE `fms_food_production_recommendation_time` DISABLE KEYS */;
/*!40000 ALTER TABLE `fms_food_production_recommendation_time` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fms_food_recommend`
--

DROP TABLE IF EXISTS `fms_food_recommend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `fms_food_recommend` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '食物推荐表id',
  `uid` int(11) NOT NULL COMMENT '用户id',
  `fid` int(11) NOT NULL COMMENT '食物id',
  `type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '类型：0喜好菜品推荐，1膳食推荐',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `renew_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  KEY `fid` (`fid`),
  CONSTRAINT `fms_food_recommend_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `ums_user_info` (`id`),
  CONSTRAINT `fms_food_recommend_ibfk_2` FOREIGN KEY (`fid`) REFERENCES `fms_food_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='食物推荐表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fms_food_recommend`
--

LOCK TABLES `fms_food_recommend` WRITE;
/*!40000 ALTER TABLE `fms_food_recommend` DISABLE KEYS */;
/*!40000 ALTER TABLE `fms_food_recommend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fms_meal_recommendation_parameters`
--

DROP TABLE IF EXISTS `fms_meal_recommendation_parameters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `fms_meal_recommendation_parameters` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '膳食推荐参数表id',
  `uid` int(11) NOT NULL COMMENT '用户id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `renew_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  CONSTRAINT `fms_meal_recommendation_parameters_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `ums_user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='膳食推荐参数表（待定）';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fms_meal_recommendation_parameters`
--

LOCK TABLES `fms_meal_recommendation_parameters` WRITE;
/*!40000 ALTER TABLE `fms_meal_recommendation_parameters` DISABLE KEYS */;
/*!40000 ALTER TABLE `fms_meal_recommendation_parameters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fms_user_like`
--

DROP TABLE IF EXISTS `fms_user_like`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `fms_user_like` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户喜好表id',
  `uid` int(11) NOT NULL COMMENT '用户id',
  `nation` tinyint(4) NOT NULL DEFAULT '0' COMMENT '民族：0汉族，1其他',
  `area` tinyint(4) NOT NULL DEFAULT '0' COMMENT '地区：待定',
  `taste_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '口味：0酸，1甜，2苦，3辣',
  `diet` tinyint(4) NOT NULL DEFAULT '0' COMMENT '忌口：0葱，1蒜，2姜，3香菜',
  `favorite_dishes` tinyint(4) NOT NULL DEFAULT '0' COMMENT '喜好菜类：0鲁菜，1川菜，2粤菜，3闽菜，4苏菜，5浙菜，6湘菜，7徽菜',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `renew_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  CONSTRAINT `fms_user_like_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `ums_user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户喜好表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fms_user_like`
--

LOCK TABLES `fms_user_like` WRITE;
/*!40000 ALTER TABLE `fms_user_like` DISABLE KEYS */;
/*!40000 ALTER TABLE `fms_user_like` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log_info`
--

DROP TABLE IF EXISTS `log_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `log_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志表id',
  `type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '类型：0用户基本表，1角色表，2权限表，3用户角色表，4权限角色表，5食物表，6系统表',
  `target_id` int(11) NOT NULL COMMENT '目标表id',
  `old_value` text COMMENT '目标表之前的值',
  `new_value` text COMMENT '目标表的新值',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '状态：0为还原，1已还原',
  `operate_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次操作时间',
  `operate_ip` varchar(30) NOT NULL DEFAULT '' COMMENT '操作者ip',
  `operator` varchar(50) NOT NULL DEFAULT '' COMMENT '操作者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_info`
--

LOCK TABLES `log_info` WRITE;
/*!40000 ALTER TABLE `log_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `log_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_configuration`
--

DROP TABLE IF EXISTS `system_configuration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `system_configuration` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统配置表id',
  `name` varchar(155) NOT NULL DEFAULT '' COMMENT '配置名称',
  `value` varchar(155) NOT NULL DEFAULT '' COMMENT '配置值',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态：0有效，1失效',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `operate_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次操作时间',
  `operate_ip` varchar(30) NOT NULL DEFAULT '' COMMENT '操作者ip',
  `operator` varchar(50) NOT NULL DEFAULT '' COMMENT '操作者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统配置表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_configuration`
--

LOCK TABLES `system_configuration` WRITE;
/*!40000 ALTER TABLE `system_configuration` DISABLE KEYS */;
/*!40000 ALTER TABLE `system_configuration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ums_acl`
--

DROP TABLE IF EXISTS `ums_acl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ums_acl` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限表id',
  `code` varchar(155) NOT NULL DEFAULT '' COMMENT '权限码',
  `name` varchar(30) NOT NULL DEFAULT '' COMMENT '权限名称',
  `url` varchar(500) NOT NULL DEFAULT '' COMMENT '请求url',
  `type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '类型：0按钮，1菜单，2其他',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态：0正常，1冻结',
  `remark` varchar(255) DEFAULT '' COMMENT '权限备注',
  `operate_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次操作时间',
  `operate_ip` varchar(30) NOT NULL DEFAULT '' COMMENT '操作者ip',
  `operator` varchar(50) NOT NULL DEFAULT '' COMMENT '操作者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ums_acl`
--

LOCK TABLES `ums_acl` WRITE;
/*!40000 ALTER TABLE `ums_acl` DISABLE KEYS */;
/*!40000 ALTER TABLE `ums_acl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ums_acl_role`
--

DROP TABLE IF EXISTS `ums_acl_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ums_acl_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限角色表id',
  `aid` int(11) NOT NULL COMMENT '权限id',
  `rid` int(11) NOT NULL COMMENT '角色id',
  `operate_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次操作时间',
  `operate_ip` varchar(30) NOT NULL DEFAULT '' COMMENT '操作者ip',
  `operator` varchar(50) NOT NULL DEFAULT '' COMMENT '操作者',
  PRIMARY KEY (`id`),
  KEY `aid` (`aid`),
  KEY `rid` (`rid`),
  CONSTRAINT `ums_acl_role_ibfk_1` FOREIGN KEY (`aid`) REFERENCES `ums_acl` (`id`),
  CONSTRAINT `ums_acl_role_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `ums_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='权限角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ums_acl_role`
--

LOCK TABLES `ums_acl_role` WRITE;
/*!40000 ALTER TABLE `ums_acl_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `ums_acl_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ums_role`
--

DROP TABLE IF EXISTS `ums_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ums_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色表id',
  `name` varchar(30) NOT NULL DEFAULT '' COMMENT '角色名称',
  `type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '类型：0管理员，1其他',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态：0正常，1冻结',
  `remark` varchar(255) DEFAULT '' COMMENT '角色备注',
  `operate_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次操作时间',
  `operate_ip` varchar(30) NOT NULL DEFAULT '' COMMENT '操作者ip',
  `operator` varchar(50) NOT NULL DEFAULT '' COMMENT '操作者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ums_role`
--

LOCK TABLES `ums_role` WRITE;
/*!40000 ALTER TABLE `ums_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `ums_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ums_user_account_consume`
--

DROP TABLE IF EXISTS `ums_user_account_consume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ums_user_account_consume` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户消费id',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '消费时间',
  `place` varchar(155) NOT NULL DEFAULT '' COMMENT '消费地点',
  `price` bigint(20) NOT NULL DEFAULT '0' COMMENT '消费金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户消费表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ums_user_account_consume`
--

LOCK TABLES `ums_user_account_consume` WRITE;
/*!40000 ALTER TABLE `ums_user_account_consume` DISABLE KEYS */;
/*!40000 ALTER TABLE `ums_user_account_consume` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ums_user_account_info`
--

DROP TABLE IF EXISTS `ums_user_account_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ums_user_account_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户账户id',
  `aid` int(11) NOT NULL DEFAULT '0' COMMENT '用户帐号',
  `balance` bigint(20) NOT NULL DEFAULT '0' COMMENT '账户余额',
  `type` char(1) NOT NULL DEFAULT '' COMMENT '流水类型：0消费流水，1充值流水',
  `flow_id` int(11) NOT NULL COMMENT '流水id：消费流水对应消费表id，充值流水对应充值表id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ums_user_account_info_aid_uindex` (`aid`),
  CONSTRAINT `ums_user_account_info_ums_user_info_aid_fk` FOREIGN KEY (`aid`) REFERENCES `ums_user_info` (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户账户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ums_user_account_info`
--

LOCK TABLES `ums_user_account_info` WRITE;
/*!40000 ALTER TABLE `ums_user_account_info` DISABLE KEYS */;
INSERT INTO `ums_user_account_info` VALUES (1,100000001,10000,'0',1),(2,100000002,0,'0',2),(3,100000003,0,'0',3);
/*!40000 ALTER TABLE `ums_user_account_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ums_user_account_recharge`
--

DROP TABLE IF EXISTS `ums_user_account_recharge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ums_user_account_recharge` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户充值id',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '充值时间',
  `style` char(1) NOT NULL DEFAULT '0' COMMENT '充值方式：0支付宝支付，1微信支付，2银行卡支付',
  `amount` bigint(20) NOT NULL DEFAULT '0' COMMENT '充值金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户充值表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ums_user_account_recharge`
--

LOCK TABLES `ums_user_account_recharge` WRITE;
/*!40000 ALTER TABLE `ums_user_account_recharge` DISABLE KEYS */;
/*!40000 ALTER TABLE `ums_user_account_recharge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ums_user_info`
--

DROP TABLE IF EXISTS `ums_user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ums_user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户基本表id',
  `aid` int(11) NOT NULL DEFAULT '0' COMMENT '用户帐号',
  `job_number` char(11) NOT NULL DEFAULT '' COMMENT '用户工号',
  `user_name` varchar(50) NOT NULL DEFAULT '' COMMENT '用户名：姓名',
  `password` varchar(100) NOT NULL DEFAULT '' COMMENT '用户密码',
  `gender` char(1) NOT NULL DEFAULT '' COMMENT '性别：0男，1女',
  `head_pic` varchar(500) NOT NULL DEFAULT '' COMMENT '用户头像',
  `phone` char(11) DEFAULT '' COMMENT '用户电话号码',
  `email` varchar(255) DEFAULT '' COMMENT '用户邮箱',
  `remark` varchar(255) DEFAULT '' COMMENT '用户备注',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态：0正常，1异常',
  `type` char(1) NOT NULL DEFAULT '' COMMENT '类型：0学生，1职工',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `operate_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次操作时间',
  `operate_ip` varchar(30) NOT NULL DEFAULT '' COMMENT '操作者ip',
  `operator` varchar(50) NOT NULL DEFAULT '' COMMENT '操作者',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ums_user_info_aid_uindex` (`aid`),
  UNIQUE KEY `ums_user_info_job_number_uindex` (`job_number`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户基本信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ums_user_info`
--

LOCK TABLES `ums_user_info` WRITE;
/*!40000 ALTER TABLE `ums_user_info` DISABLE KEYS */;
INSERT INTO `ums_user_info` VALUES (2,100000001,'2030200001','张三','EA48576F30BE1669971699C09AD05C94','0','','17320202058','zhangsan@163.com','',0,'0','2019-09-17 02:12:27','2019-09-17 02:12:27','0.0.0.0','李四'),(3,100000002,'2030200002','李四','EA48576F30BE1669971699C09AD05C94','0','','14323423333','lisi@163.com','',0,'1','2019-09-20 00:53:40','2019-09-20 00:53:40','0.0.0.0','李四'),(4,100000003,'2030200003','赵六','EA48576F30BE1669971699C09AD05C94','1','','13243345555','zhaoliu@165.com','',0,'0','2019-09-20 00:55:25','2019-09-20 00:55:25','0.0.0.0','李四');
/*!40000 ALTER TABLE `ums_user_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ums_user_role`
--

DROP TABLE IF EXISTS `ums_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ums_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户角色表id',
  `uid` int(11) NOT NULL COMMENT '用户id',
  `rid` int(11) NOT NULL COMMENT '角色id',
  `operate_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次操作时间',
  `operate_ip` varchar(30) NOT NULL DEFAULT '' COMMENT '操作者ip',
  `operator` varchar(50) NOT NULL DEFAULT '' COMMENT '操作者',
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  KEY `rid` (`rid`),
  CONSTRAINT `ums_user_role_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `ums_user_info` (`id`),
  CONSTRAINT `ums_user_role_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `ums_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ums_user_role`
--

LOCK TABLES `ums_user_role` WRITE;
/*!40000 ALTER TABLE `ums_user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `ums_user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-22  9:23:55
