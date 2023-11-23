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
-- Table structure for table `Movie`
--

DROP TABLE IF EXISTS `Movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Movie` (
  `pk` int NOT NULL AUTO_INCREMENT COMMENT 'pk',
  `title` varchar(50) DEFAULT NULL COMMENT 'title',
  `eng_title` varchar(50) DEFAULT NULL COMMENT 'eng_title',
  `duration_min` int DEFAULT NULL COMMENT 'duration_min',
  `age` varchar(32) DEFAULT NULL COMMENT 'age',
  `opening_date` date DEFAULT NULL COMMENT 'opening_date',
  `genre` varchar(32) DEFAULT NULL COMMENT 'genre',
  `description` text COMMENT 'description',
  `trailer` text COMMENT 'trailer',
  `reservation_score` float DEFAULT NULL COMMENT 'reservation_score',
  `main_img` varchar(254) DEFAULT NULL COMMENT 'main_img',
  `thumbnail_img` varchar(254) DEFAULT NULL COMMENT 'thumbnail_img',
  `price` float DEFAULT NULL,
  PRIMARY KEY (`pk`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Movie';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Movie`
--

LOCK TABLES `Movie` WRITE;
/*!40000 ALTER TABLE `Movie` DISABLE KEYS */;
INSERT INTO `Movie` VALUES (12,'Raven','Raven',125,'r','2023-10-04','mystery','Lorem ipsum dolor sit amet consectetur adipisicing elit. Amet, deserunt! Consequatur architecto doloribus quibusdam accusantium Lorem ipsum dolor sit amet consectetur adipisicing elit. Amet, deserunt! Consequatur architecto doloribus quibusdam accusantium','dasdsa',NULL,'http://res.cloudinary.com/locnguyen2409/image/upload/v1700574466/pwjlboo9klndeyjjb5q4.png','http://res.cloudinary.com/locnguyen2409/image/upload/v1700574473/enho7qogmsc7zrvkrpah.png',8),(13,'Animus','Animus',138,'r','2023-10-05','mystery','Lorem ipsum dolor sit amet consectetur adipisicing elit. Amet, deserunt! Consequatur architecto doloribus quibusdam accusantium. Lorem ipsum dolor sit amet consectetur adipisicing elit. Amet, deserunt! Consequatur architecto doloribus quibusdam accusantium. Lorem ipsum dolor sit amet consectetur adipisicing elit. Amet, deserunt! Consequatur architecto doloribus quibusdam accusantium','dasdsa',NULL,'https://res.cloudinary.com/dlv6zjsif/image/upload/v1694071213/cinemas/poster/Animus_mp66wi.png','https://res.cloudinary.com/dlv6zjsif/image/upload/v1694071213/cinemas/poster/Animus_mp66wi.png',8),(14,'Faith','Faith',126,'pg-13','2023-10-03','action','Lorem ipsum dolor sit amet consectetur adipisicing elit. Aperiam possimus, nisi voluptatum, nemo consectetur minus vero molestias dolores sit exercitationem debitis adipisci repellendus reiciendis? A dolorum sed alias sint cumque','dasdsa',NULL,'https://res.cloudinary.com/dlv6zjsif/image/upload/v1694071219/cinemas/poster/Faith_wcgvn9.png','https://res.cloudinary.com/dlv6zjsif/image/upload/v1694071219/cinemas/poster/Faith_wcgvn9.png',8),(15,'Highway','Highway',137,'g','2023-10-06','comedy','Lorem ipsum dolor sit amet consectetur adipisicing elit. Amet, deserunt! Consequatur architecto doloribus quibusdam accusantium. Lorem ipsum dolor sit amet consectetur adipisicing elit. Amet, deserunt! Consequatur architecto','dasdsa',NULL,'https://res.cloudinary.com/dlv6zjsif/image/upload/v1694071343/cinemas/poster/Highway_akssin.png','https://res.cloudinary.com/dlv6zjsif/image/upload/v1694071343/cinemas/poster/Highway_akssin.png',7),(16,'Monster','Monster',146,'nc-17','2023-10-05','horror','Lorem ipsum dolor sit amet consectetur adipisicing elit. Amet, deserunt! Consequatur architecto doloribus quibusdam accusantium. Lorem ipsum dolor sit amet consectetur adipisicing elit. Amet, deserunt! Consequatur architecto doloribus quibusdam accusantium. Lorem ipsum dolor sit amet consectetur adipisicing elit. Amet, deserunt! Consequatur architecto doloribus quibusdam accusantium','dasdsa',NULL,'https://res.cloudinary.com/dlv6zjsif/image/upload/v1694071348/cinemas/poster/Monster_l6a7yj.png','https://res.cloudinary.com/dlv6zjsif/image/upload/v1694071348/cinemas/poster/Monster_l6a7yj.png',8);
/*!40000 ALTER TABLE `Movie` ENABLE KEYS */;
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

-- Dump completed on 2023-11-23  8:35:26
