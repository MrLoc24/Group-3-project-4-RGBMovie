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
-- Table structure for table `Screening`
--

DROP TABLE IF EXISTS `Screening`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Screening` (
  `pk` int NOT NULL AUTO_INCREMENT COMMENT 'pk',
  `movie` int NOT NULL COMMENT 'movie',
  `theater` int NOT NULL COMMENT 'theater',
  `auditorium` int NOT NULL COMMENT 'auditorium',
  `time` datetime NOT NULL COMMENT 'time',
  PRIMARY KEY (`pk`),
  KEY `FK_Screening_movie_Movie_pk` (`movie`),
  KEY `FK_Screening_theater_Theater_pk` (`theater`),
  KEY `FK_Screening_auditorium_Auditorium_pk` (`auditorium`),
  CONSTRAINT `FK_Screening_audi_Auditorium` FOREIGN KEY (`auditorium`) REFERENCES `Auditorium` (`pk`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Screening_movie_Movie_pk` FOREIGN KEY (`movie`) REFERENCES `Movie` (`pk`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Screening_theater_Theater_pk` FOREIGN KEY (`theater`) REFERENCES `Theater` (`pk`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Screening';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Screening`
--

LOCK TABLES `Screening` WRITE;
/*!40000 ALTER TABLE `Screening` DISABLE KEYS */;
INSERT INTO `Screening` VALUES (33,12,27,25,'2023-11-15 09:00:00'),(34,12,27,25,'2023-11-15 11:20:00'),(35,12,27,25,'2023-11-15 13:40:00'),(36,12,27,25,'2023-11-15 16:00:00'),(37,12,27,25,'2023-11-15 18:20:00'),(38,12,27,25,'2023-11-15 20:40:00'),(39,12,27,26,'2023-11-16 09:00:00'),(40,12,27,26,'2023-11-16 11:20:00'),(41,12,27,26,'2023-11-16 13:40:00'),(42,12,27,26,'2023-11-16 16:00:00'),(43,12,27,26,'2023-11-16 18:20:00'),(44,12,27,26,'2023-11-16 20:40:00'),(45,14,27,25,'2023-11-18 09:00:00'),(46,14,27,25,'2023-11-18 11:20:00'),(47,14,27,25,'2023-11-18 13:40:00'),(48,14,27,25,'2023-11-18 16:00:00'),(49,14,27,25,'2023-11-18 18:20:00'),(50,14,27,25,'2023-11-18 20:40:00'),(51,12,27,26,'2023-11-18 09:00:00'),(52,12,27,26,'2023-11-18 11:20:00'),(53,12,27,26,'2023-11-18 13:40:00'),(54,12,27,26,'2023-11-18 16:00:00'),(55,12,27,26,'2023-11-18 18:20:00'),(56,12,27,26,'2023-11-18 20:40:00'),(63,12,27,25,'2023-11-21 09:00:00'),(65,12,27,25,'2023-11-21 13:40:00'),(66,12,27,25,'2023-11-21 16:00:00'),(67,12,27,25,'2023-11-21 18:20:00'),(68,12,27,25,'2023-11-21 20:40:00'),(69,12,27,25,'2023-11-21 09:00:00'),(70,12,27,25,'2023-11-21 11:20:00'),(71,12,27,25,'2023-11-21 13:40:00'),(72,12,27,25,'2023-11-21 16:00:00'),(73,12,27,25,'2023-11-21 18:20:00'),(74,12,27,25,'2023-11-21 20:40:00'),(75,12,27,25,'2023-11-29 09:00:00'),(76,12,27,25,'2023-11-29 11:20:00'),(77,12,27,25,'2023-11-29 13:40:00'),(78,12,27,25,'2023-11-29 16:00:00'),(79,12,27,25,'2023-11-29 18:20:00'),(80,12,27,25,'2023-11-29 20:40:00'),(81,13,27,26,'2023-11-28 09:00:00'),(82,13,27,26,'2023-11-28 11:30:00'),(83,13,27,26,'2023-11-28 14:00:00'),(84,13,27,26,'2023-11-28 16:30:00'),(85,13,27,26,'2023-11-28 19:00:00'),(86,12,48,28,'2023-11-22 09:00:00'),(87,12,48,28,'2023-11-22 11:20:00'),(88,12,48,28,'2023-11-22 13:40:00'),(89,12,48,28,'2023-11-22 16:00:00'),(90,12,48,28,'2023-11-22 18:20:00'),(91,12,48,28,'2023-11-22 20:40:00'),(92,12,27,25,'2023-11-17 09:00:00'),(93,12,27,25,'2023-11-17 11:20:00'),(94,12,27,25,'2023-11-17 13:40:00'),(95,12,27,25,'2023-11-17 16:00:00'),(96,12,27,25,'2023-11-17 18:20:00'),(97,12,27,25,'2023-11-17 20:40:00'),(98,14,27,25,'2023-11-15 09:00:00'),(99,14,27,25,'2023-11-15 11:20:00'),(100,14,27,25,'2023-11-15 13:40:00'),(101,14,27,25,'2023-11-15 16:00:00'),(102,14,27,25,'2023-11-15 18:20:00'),(103,14,27,25,'2023-11-15 20:40:00'),(104,14,27,25,'2023-11-15 09:00:00'),(105,14,27,25,'2023-11-15 11:20:00'),(106,14,27,25,'2023-11-15 13:40:00'),(107,14,27,25,'2023-11-15 16:00:00'),(108,14,27,25,'2023-11-15 18:20:00'),(109,14,27,25,'2023-11-15 20:40:00'),(110,13,27,27,'2023-11-16 09:00:00'),(111,13,27,27,'2023-11-16 11:30:00'),(112,13,27,27,'2023-11-16 14:00:00'),(113,13,27,27,'2023-11-16 16:30:00'),(114,13,27,27,'2023-11-16 19:00:00');
/*!40000 ALTER TABLE `Screening` ENABLE KEYS */;
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

-- Dump completed on 2023-11-23  8:36:34
