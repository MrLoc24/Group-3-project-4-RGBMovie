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
-- Table structure for table `Theater`
--

DROP TABLE IF EXISTS `Theater`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Theater` (
  `pk` int NOT NULL AUTO_INCREMENT COMMENT 'pk',
  `location` varchar(10) DEFAULT NULL COMMENT 'location',
  `sub_location` varchar(15) DEFAULT NULL COMMENT 'sub_location',
  `address` varchar(50) DEFAULT NULL COMMENT 'address',
  PRIMARY KEY (`pk`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Theater`
--

LOCK TABLES `Theater` WRITE;
/*!40000 ALTER TABLE `Theater` DISABLE KEYS */;
INSERT INTO `Theater` VALUES (27,'Ho Chi Min','Ho Chi Minh','CT Plaza, 60A Truong Son, phuong 2, quan Tan Binh'),(28,'Ho Chi Min','Ho Chi Minh','Hung Vuong  Plaza, 126 Hung Vuong, quan 5'),(29,'Ho Chi Min','Ho Chi Minh','Cresent Mall Dai lo Nguyen Van Linh, Quan 7'),(30,'Ho Chi Min','Ho Chi Minh','Pandora City 1/1 Truong Chinh, quan Tan Phu'),(31,NULL,'Ho Chi Minh','Aeon Mall 30 bo Baoo Tan Thang, quan Tan Phu'),(32,NULL,'Ho Chi Minh','Vincom Thu Duc, 216 Vo Van Ngan, Tp Thu duc'),(33,NULL,'Dong Nai','Coopmart 121 Pham Van Thuan, phuong Tan Tien, Tp B'),(34,NULL,'Dong Nai','BigC Dong Nai, khu pho 1, phuong Long Binh Tan, Tp'),(35,NULL,'Binh Duong','Binh Duong Square, so 1 Phu Loi, phuong Phu Loi'),(36,NULL,'Binh Duong','Aeon Canary, dai lo Binh Duong, phuong Binh Hoa, T'),(37,NULL,'Ha Noi','Vincom Center, 191 Ba Trieu, quan Hai Ba Trung'),(38,NULL,'Ha Noi','Aeon Long Bien, so 27 Co Linh, quan Long Bien'),(48,'HoChiMinh','HoChiMinh','50 Nguyen Hue');
/*!40000 ALTER TABLE `Theater` ENABLE KEYS */;
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

-- Dump completed on 2023-11-23  8:36:26
