-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: gpmanagement
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `evaluate_table`
--

DROP TABLE IF EXISTS `evaluate_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evaluate_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(8) NOT NULL,
  `student_name` varchar(50) NOT NULL,
  `subject_name` varchar(50) NOT NULL,
  `subject_id` int(11) NOT NULL,
  `attachment` varchar(300) DEFAULT NULL,
  `guide_teacher` varchar(50) NOT NULL,
  `evaluate` varchar(100) NOT NULL,
  `score` int(11) NOT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evaluate_table`
--

LOCK TABLES `evaluate_table` WRITE;
/*!40000 ALTER TABLE `evaluate_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `evaluate_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log_table`
--

DROP TABLE IF EXISTS `log_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `publisher` varchar(50) NOT NULL,
  `targetName` varchar(50) DEFAULT NULL,
  `log` varchar(300) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_table`
--

LOCK TABLES `log_table` WRITE;
/*!40000 ALTER TABLE `log_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `log_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `middle_report_table`
--

DROP TABLE IF EXISTS `middle_report_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `middle_report_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(8) NOT NULL,
  `student_name` varchar(50) NOT NULL,
  `subject_name` varchar(50) NOT NULL,
  `subject_id` int(11) DEFAULT NULL,
  `design_area` varchar(30) NOT NULL,
  `mid_conclusion` varchar(500) NOT NULL,
  `attachment` varchar(300) DEFAULT NULL,
  `guide_teacher` varchar(50) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`number`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `middle_report_table`
--

LOCK TABLES `middle_report_table` WRITE;
/*!40000 ALTER TABLE `middle_report_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `middle_report_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paper_table`
--

DROP TABLE IF EXISTS `paper_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paper_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(8) NOT NULL,
  `student_name` varchar(50) NOT NULL,
  `subject_name` varchar(50) NOT NULL,
  `subject_id` int(11) NOT NULL,
  `attachment` varchar(300) DEFAULT NULL,
  `guide_teacher` varchar(50) DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  `score` int(11) DEFAULT '0',
  `message` varchar(300) DEFAULT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paper_table`
--

LOCK TABLES `paper_table` WRITE;
/*!40000 ALTER TABLE `paper_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `paper_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `start_report_table`
--

DROP TABLE IF EXISTS `start_report_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `start_report_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(8) NOT NULL,
  `student_name` varchar(50) NOT NULL,
  `subject_name` varchar(50) NOT NULL,
  `subject_id` int(11) NOT NULL,
  `purpose` varchar(300) NOT NULL,
  `basis` varchar(300) NOT NULL,
  `problems` varchar(300) NOT NULL,
  `plan` varchar(300) NOT NULL,
  `attachment` varchar(300) DEFAULT NULL,
  `guide_teacher` varchar(50) NOT NULL,
  `opinion` varchar(100) DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`number`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `id_2` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `start_report_table`
--

LOCK TABLES `start_report_table` WRITE;
/*!40000 ALTER TABLE `start_report_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `start_report_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject_table`
--

DROP TABLE IF EXISTS `subject_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_name` varchar(50) DEFAULT NULL,
  `number` varchar(8) DEFAULT NULL,
  `subject_name` varchar(50) NOT NULL,
  `topic_source` varchar(10) NOT NULL,
  `subject_type` varchar(10) NOT NULL,
  `topic_type` varchar(10) NOT NULL,
  `topic_paper` varchar(500) NOT NULL,
  `ability` varchar(500) NOT NULL,
  `target` varchar(500) NOT NULL,
  `guide_teacher` varchar(50) NOT NULL,
  `source` int(11) NOT NULL,
  `attachment` varchar(1000) DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `number` (`number`),
  UNIQUE KEY `student_name` (`student_name`),
  UNIQUE KEY `student_name_2` (`student_name`),
  CONSTRAINT `subject_table_ibfk_1` FOREIGN KEY (`number`) REFERENCES `user_table` (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_table`
--

LOCK TABLES `subject_table` WRITE;
/*!40000 ALTER TABLE `subject_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `subject_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_message_table`
--

DROP TABLE IF EXISTS `user_message_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_message_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `targetname` varchar(50) NOT NULL,
  `message` varchar(100) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_message_table`
--

LOCK TABLES `user_message_table` WRITE;
/*!40000 ALTER TABLE `user_message_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_message_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_table`
--

DROP TABLE IF EXISTS `user_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(8) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `type` int(11) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`number`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `email_2` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_table`
--

LOCK TABLES `user_table` WRITE;
/*!40000 ALTER TABLE `user_table` DISABLE KEYS */;
INSERT INTO `user_table` VALUES (1,'04111111','张老师','E10ADC3949BA59ABBE56E057F20F883E','15688887459','teacher@126.com',1,'2018-05-12 13:21:04','2018-05-11 06:16:41'),(2,'04163209','曾帅智','96E79218965EB72C92A549DD5A330112','12345678910','updateEmail@qq.com',2,'2018-05-20 09:08:20','2018-05-20 09:08:20'),(4,'04163210','吕凯','E10ADC3949BA59ABBE56E057F20F883E','15584789547','lvkai@qq.com',2,'2018-05-20 16:51:42','2018-05-20 16:51:42'),(5,'04163211','李小强','E10ADC3949BA59ABBE56E057F20F883E','16475896587','lixiaoqiang@qq.com',2,'2018-05-20 16:51:42','2018-05-20 16:51:42'),(6,'04163212','崔可仁','E10ADC3949BA59ABBE56E057F20F883E','15478596587','cuikeren\n@qq.com',2,'2018-05-24 09:23:19','2018-05-24 09:23:19'),(7,'04163213','杨涛','E10ADC3949BA59ABBE56E057F20F883E','15478596587','yangtao\n@qq.com',2,'2018-05-24 09:23:19','2018-05-24 09:23:19'),(8,'04163214','李影','E10ADC3949BA59ABBE56E057F20F883E','15478592387','liying\n@qq.com',2,'2018-05-24 09:23:19','2018-05-24 09:23:19'),(9,'04163215','张妍','E10ADC3949BA59ABBE56E057F20F883E','15478594387','zhangyan\n@qq.com',2,'2018-05-24 09:23:19','2018-05-24 09:23:19'),(3,'04163216','江婷婷','C33367701511B4F6020EC61DED352059','13571777595','testJtt@qq.com',2,'2018-05-20 16:32:08','2018-05-20 16:32:08'),(10,'04163217','朱颖','E10ADC3949BA59ABBE56E057F20F883E','15478596687','zhuying\n@qq.com',2,'2018-05-24 09:23:19','2018-05-24 09:23:19'),(11,'04163218','徐晨苗','E10ADC3949BA59ABBE56E057F20F883E','15478236587','xuchenmiao\n@qq.com',2,'2018-05-24 09:23:19','2018-05-24 09:23:19'),(12,'04163219','周蕊','E10ADC3949BA59ABBE56E057F20F883E','15478594587','zhourui\n@qq.com',2,'2018-05-24 09:23:19','2018-05-24 09:23:19');
/*!40000 ALTER TABLE `user_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'gpmanagement'
--

--
-- Dumping routines for database 'gpmanagement'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-26 20:00:10
