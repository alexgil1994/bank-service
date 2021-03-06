--CREATE DATABASE  IF NOT EXISTS `bankdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
--USE `bankdb`;
---- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
----
---- Host: localhost    Database: bankdb
---- ------------------------------------------------------
---- Server version	8.0.15
--
--/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
--/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
--/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
-- SET NAMES utf8 ;
--/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
--/*!40103 SET TIME_ZONE='+00:00' */;
--/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
--/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
--/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
--/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
--
----
---- Table structure for table `client`
----
--
--DROP TABLE IF EXISTS `client`;
--/*!40101 SET @saved_cs_client     = @@character_set_client */;
-- SET character_set_client = utf8mb4 ;
--CREATE TABLE `client` (
--  `id` bigint(20) NOT NULL AUTO_INCREMENT,
--  `account_balance` decimal(19,2) NOT NULL,
--  `annual_income` decimal(19,2) NOT NULL,
--  `birth` datetime NOT NULL,
--  `full_name` varchar(255) NOT NULL,
--  `gender` varchar(255) NOT NULL,
--  `nationality` varchar(255) NOT NULL,
--  PRIMARY KEY (`id`)
--) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
--/*!40101 SET character_set_client = @saved_cs_client */;
--
----
---- Dumping data for table `client`
----
--
--LOCK TABLES `client` WRITE;
--/*!40000 ALTER TABLE `client` DISABLE KEYS */;
--INSERT INTO `client` VALUES (1,0.00,20000.00,'1994-12-12 00:00:00','Alex Alex','Male','Greek');
--/*!40000 ALTER TABLE `client` ENABLE KEYS */;
--UNLOCK TABLES;
--/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
--
--/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
--/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
--/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
--/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
--/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
--/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
--/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
--
--
--DROP TABLE IF EXISTS `loan`;
--/*!40101 SET @saved_cs_client     = @@character_set_client */;
-- SET character_set_client = utf8mb4 ;
--CREATE TABLE `loan` (
--  `id` bigint(20) NOT NULL AUTO_INCREMENT,
--  `authorized` bit(1) NOT NULL,
--  `loan_value` decimal(19,2) NOT NULL,
--  `pending` bit(1) NOT NULL,
--  `client_id` bigint(20) DEFAULT NULL,
--  `officer_id` bigint(20) DEFAULT NULL,
--  `uuid` varchar(255) NOT NULL,
--  PRIMARY KEY (`id`),
--  KEY `FK62s5k229ouak16t2k5pvq4n16` (`client_id`),
--  KEY `FKp3bx8dble04n8ygv9ixtx1lc1` (`officer_id`)
--) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
--/*!40101 SET character_set_client = @saved_cs_client */;
--
----
---- Dumping data for table `loan`
----
--
--LOCK TABLES `loan` WRITE;
--/*!40000 ALTER TABLE `loan` DISABLE KEYS */;
--INSERT INTO `loan` VALUES (1,_binary '\0',300.00,_binary '',1,NULL,'PslkIF5m');
--/*!40000 ALTER TABLE `loan` ENABLE KEYS */;
--UNLOCK TABLES;
--/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
--
--/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
--/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
--/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
--/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
--/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
--/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
--/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
--
--
--DROP TABLE IF EXISTS `officer`;
--/*!40101 SET @saved_cs_client     = @@character_set_client */;
-- SET character_set_client = utf8mb4 ;
--CREATE TABLE `officer` (
--  `id` bigint(20) NOT NULL AUTO_INCREMENT,
--  `full_name` varchar(255) NOT NULL,
--  PRIMARY KEY (`id`)
--) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
--/*!40101 SET character_set_client = @saved_cs_client */;
--
----
---- Dumping data for table `officer`
----
--
--LOCK TABLES `officer` WRITE;
--/*!40000 ALTER TABLE `officer` DISABLE KEYS */;
--INSERT INTO `officer` VALUES (1,'Officer Alex');
--/*!40000 ALTER TABLE `officer` ENABLE KEYS */;
--UNLOCK TABLES;
--/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
--
--/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
--/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
--/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
--/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
--/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
--/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
--/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;



-- CREATE DATABASE  IF NOT EXISTS `bankdb_testing` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;