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
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `User` (
  `pk` int NOT NULL AUTO_INCREMENT COMMENT 'pk',
  `username` varchar(150) NOT NULL COMMENT 'username',
  `password` varchar(128) NOT NULL COMMENT 'password',
  `last_name` varchar(150) NOT NULL COMMENT 'last_name',
  `first_name` varchar(30) NOT NULL COMMENT 'first_name',
  `email` varchar(45) NOT NULL COMMENT 'email',
  `phone_number` varchar(20) NOT NULL COMMENT 'phone_number',
  `images` varchar(254) DEFAULT NULL,
  `enabled` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`pk`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (1,'loc123','$2a$10$5ec4/32kZhttBjssCTAUvuBaTx6Kn2YiXJN.w15cmrROOsNLOTYBS','nguyen','loc','loc@gmail.om','123456',NULL,_binary ''),(2,'loc11','$2a$10$5ec4/32kZhttBjssCTAUvuBaTx6Kn2YiXJN.w15cmrROOsNLOTYBS','ng','tnloc','loc123@gmail.com','12345',NULL,_binary ''),(3,'admin','$2a$10$gFCCNn/9aud.Ir4dy3qEh.kV018uYjMLu41ElCnVcZCGuzKDmucQK','nguyen','loc','loclongla1999@gmail.com','123456789','http://res.cloudinary.com/locnguyen2409/image/upload/v1695631594/zwuvfylxjzmhn5k8jb93.jpg',_binary ''),(21,'loc22','$2a$10$5ec4/32kZhttBjssCTAUvuBaTx6Kn2YiXJN.w15cmrROOsNLOTYBS','nguyen','loc','asd@asd.cacs','123456655','http://res.cloudinary.com/locnguyen2409/image/upload/v1695179734/w85vt1b8bfvorsdozdfo.jpg',_binary ''),(22,'cust1','$2a$10$5ec4/32kZhttBjssCTAUvuBaTx6Kn2YiXJN.w15cmrROOsNLOTYBS','nguyen','locloc','cust1@gmail.com','123456789',NULL,_binary ''),(23,'fuho','$2a$10$48T9ZbwTfD6tSA97VQQVA.roS5bDfN.CpbeykuE7wwdNOdFKRDFMS','Fuho','Loc','fuho@mail','12352353245',NULL,_binary ''),(24,'ditu','$2a$10$yzQ61sjQIIus0nEeqlYC9Od01ubuWF693hdLmJVlOfc3pDZihgCe6','Ditu','Loc','ditu@gmail','34534534534',NULL,_binary '\0'),(32,'admin123','$2a$10$1jl1QHc0Ep1i7Pw9z0GnDubyMh34tL06otJgyY1XeJnSnYzNCcR5y','Nguyen','Lộc','loclongla@outlook.com.vn','0393649927','http://res.cloudinary.com/locnguyen2409/image/upload/v1697794333/qewihqwekrguho4yz8w8.jpg',_binary ''),(35,'admin12356','$2a$10$6q9x1DjocnRGslyfezI49umWhvbPuXWs8X7Aety4M5.2oQRrOW1ES','Nguyen','Loc','loclongla@outlook.com.vn','0393649927','http://res.cloudinary.com/locnguyen2409/image/upload/v1697794434/q8gk9hz2ngypeyknogxe.jpg',_binary ''),(36,'locng','$2a$10$NtxYpoydl1jSdaP2vt0ovu1NaPGOQLa2.KVmTgnTs77XHYsJAFMCy','asdasd','nguyen','loclongla@gmail.com','0123456789',NULL,_binary ''),(37,'tai','$2a$10$Wus357Xez.cGe21fn0RyP.E2tzEJBNtfcj8LGS.OXP4p3mak4zxvi','Tai','Nguyen Phat','phattai3178@gmail.com','0000000','http://res.cloudinary.com/locnguyen2409/image/upload/v1700569475/pdnec5dfosnchek4zx2k.jpg',_binary ''),(38,'loc','$2a$10$BzCpdMkFjo/5Uvzz8CkY6.1JGY9YkL62x8kytWKlsx6qptGf1V9gi','Ditu','Loc2','ditu@gmail.com','099098979010',NULL,_binary '');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
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

-- Dump completed on 2023-11-23  8:35:51
