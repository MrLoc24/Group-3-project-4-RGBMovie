-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: rgbdatabase.czdgugcvyucn.ap-southeast-2.rds.amazonaws.com    Database: rgb
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Table structure for table `Auditorium`
--

DROP TABLE IF EXISTS `Auditorium`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Auditorium` (
  `pk` int NOT NULL AUTO_INCREMENT COMMENT 'pk',
  `au_name` varchar(50) NOT NULL COMMENT 'name',
  `au_rows` int NOT NULL,
  `theater` int NOT NULL COMMENT 'theater',
  `au_columns` int NOT NULL,
  PRIMARY KEY (`pk`),
  UNIQUE KEY `name_UNIQUE` (`au_name`),
  KEY `FK_Auditorium_theater_Theater_pk` (`theater`),
  CONSTRAINT `FK_Auditorium_theater_Theater_pk` FOREIGN KEY (`theater`) REFERENCES `Theater` (`pk`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Auditorium';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Auditorium`
--

LOCK TABLES `Auditorium` WRITE;
/*!40000 ALTER TABLE `Auditorium` DISABLE KEYS */;
INSERT INTO `Auditorium` VALUES (25,'A1_27',10,27,8),(26,'A26_27',6,27,6),(27,'A2_27',5,27,6),(28,'A1_48',5,48,6);
/*!40000 ALTER TABLE `Auditorium` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-23  8:36:00
