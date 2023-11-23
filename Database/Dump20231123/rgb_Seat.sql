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
-- Table structure for table `Seat`
--

DROP TABLE IF EXISTS `Seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Seat` (
  `pk` int NOT NULL AUTO_INCREMENT COMMENT 'pk',
  `auditorium` int DEFAULT NULL COMMENT 'auditorium',
  `seat_name` varchar(4) DEFAULT NULL COMMENT 'seat_name',
  PRIMARY KEY (`pk`),
  KEY `FK_Seat_auditorium_Auditorium_pk` (`auditorium`),
  CONSTRAINT `FK_Seat_auditorium_Auditorium_pk` FOREIGN KEY (`auditorium`) REFERENCES `Auditorium` (`pk`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=277 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Seat';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Seat`
--

LOCK TABLES `Seat` WRITE;
/*!40000 ALTER TABLE `Seat` DISABLE KEYS */;
INSERT INTO `Seat` VALUES (101,25,'A1'),(102,25,'A2'),(103,25,'A3'),(104,25,'A4'),(105,25,'A5'),(106,25,'A6'),(107,25,'A7'),(108,25,'A8'),(109,25,'B1'),(110,25,'B2'),(111,25,'B3'),(112,25,'B4'),(113,25,'B5'),(114,25,'B6'),(115,25,'B7'),(116,25,'B8'),(117,25,'C1'),(118,25,'C2'),(119,25,'C3'),(120,25,'C4'),(121,25,'C5'),(122,25,'C6'),(123,25,'C7'),(124,25,'C8'),(125,25,'D1'),(126,25,'D2'),(127,25,'D3'),(128,25,'D4'),(129,25,'D5'),(130,25,'D6'),(131,25,'D7'),(132,25,'D8'),(133,25,'E1'),(134,25,'E2'),(135,25,'E3'),(136,25,'E4'),(137,25,'E5'),(138,25,'E6'),(139,25,'E7'),(140,25,'E8'),(141,25,'F1'),(142,25,'F2'),(143,25,'F3'),(144,25,'F4'),(145,25,'F5'),(146,25,'F6'),(147,25,'F7'),(148,25,'F8'),(149,25,'G1'),(150,25,'G2'),(151,25,'G3'),(152,25,'G4'),(153,25,'G5'),(154,25,'G6'),(155,25,'G7'),(156,25,'G8'),(157,25,'H1'),(158,25,'H2'),(159,25,'H3'),(160,25,'H4'),(161,25,'H5'),(162,25,'H6'),(163,25,'H7'),(164,25,'H8'),(165,25,'I1'),(166,25,'I2'),(167,25,'I3'),(168,25,'I4'),(169,25,'I5'),(170,25,'I6'),(171,25,'I7'),(172,25,'I8'),(173,25,'J1'),(174,25,'J2'),(175,25,'J3'),(176,25,'J4'),(177,25,'J5'),(178,25,'J6'),(179,25,'J7'),(180,25,'J8'),(181,26,'A1'),(182,26,'A2'),(183,26,'A3'),(184,26,'A4'),(185,26,'A5'),(186,26,'A6'),(187,26,'B1'),(188,26,'B2'),(189,26,'B3'),(190,26,'B4'),(191,26,'B5'),(192,26,'B6'),(193,26,'C1'),(194,26,'C2'),(195,26,'C3'),(196,26,'C4'),(197,26,'C5'),(198,26,'C6'),(199,26,'D1'),(200,26,'D2'),(201,26,'D3'),(202,26,'D4'),(203,26,'D5'),(204,26,'D6'),(205,26,'E1'),(206,26,'E2'),(207,26,'E3'),(208,26,'E4'),(209,26,'E5'),(210,26,'E6'),(211,26,'F1'),(212,26,'F2'),(213,26,'F3'),(214,26,'F4'),(215,26,'F5'),(216,26,'F6'),(217,27,'A1'),(218,27,'A2'),(219,27,'A3'),(220,27,'A4'),(221,27,'A5'),(222,27,'A6'),(223,27,'B1'),(224,27,'B2'),(225,27,'B3'),(226,27,'B4'),(227,27,'B5'),(228,27,'B6'),(229,27,'C1'),(230,27,'C2'),(231,27,'C3'),(232,27,'C4'),(233,27,'C5'),(234,27,'C6'),(235,27,'D1'),(236,27,'D2'),(237,27,'D3'),(238,27,'D4'),(239,27,'D5'),(240,27,'D6'),(241,27,'E1'),(242,27,'E2'),(243,27,'E3'),(244,27,'E4'),(245,27,'E5'),(246,27,'E6'),(247,28,'A1'),(248,28,'A2'),(249,28,'A3'),(250,28,'A4'),(251,28,'A5'),(252,28,'A6'),(253,28,'B1'),(254,28,'B2'),(255,28,'B3'),(256,28,'B4'),(257,28,'B5'),(258,28,'B6'),(259,28,'C1'),(260,28,'C2'),(261,28,'C3'),(262,28,'C4'),(263,28,'C5'),(264,28,'C6'),(265,28,'D1'),(266,28,'D2'),(267,28,'D3'),(268,28,'D4'),(269,28,'D5'),(270,28,'D6'),(271,28,'E1'),(272,28,'E2'),(273,28,'E3'),(274,28,'E4'),(275,28,'E5'),(276,28,'E6');
/*!40000 ALTER TABLE `Seat` ENABLE KEYS */;
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

-- Dump completed on 2023-11-23  8:35:43
