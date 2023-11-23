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
-- Table structure for table `ReservedSeat`
--

DROP TABLE IF EXISTS `ReservedSeat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ReservedSeat` (
  `pk` int NOT NULL AUTO_INCREMENT COMMENT 'pk',
  `screening` int DEFAULT NULL COMMENT 'screening',
  `seat` int DEFAULT NULL COMMENT 'seat',
  `reservation` int DEFAULT NULL COMMENT 'reservation',
  PRIMARY KEY (`pk`),
  KEY `FK_ReservedSeat_screening_Screening_pk` (`screening`),
  KEY `FK_ReservedSeat_seat_Seat_pk` (`seat`),
  KEY `FK_ReservedSeat_reservation_Reservation_pk` (`reservation`),
  CONSTRAINT `FK_ReservedSeat_reservation_Reservation_pk` FOREIGN KEY (`reservation`) REFERENCES `Reservation` (`pk`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_ReservedSeat_screening_Screening_pk` FOREIGN KEY (`screening`) REFERENCES `Screening` (`pk`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_ReservedSeat_seat_Seat_pk` FOREIGN KEY (`seat`) REFERENCES `Seat` (`pk`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='ReservedSeat';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ReservedSeat`
--

LOCK TABLES `ReservedSeat` WRITE;
/*!40000 ALTER TABLE `ReservedSeat` DISABLE KEYS */;
INSERT INTO `ReservedSeat` VALUES (23,51,183,16),(24,51,182,16),(25,51,181,16),(26,51,184,16),(27,76,128,17),(28,76,129,17),(29,76,137,17),(30,76,136,17),(35,78,136,19),(36,78,137,19);
/*!40000 ALTER TABLE `ReservedSeat` ENABLE KEYS */;
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

-- Dump completed on 2023-11-23  8:36:05
