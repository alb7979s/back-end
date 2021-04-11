-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: happyhouse
-- ------------------------------------------------------
-- Server version	8.0.23

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

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `id` varchar(16) NOT NULL,
  `pwd` varchar(16) NOT NULL,
  `dpt` varchar(16) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `joindate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
--INSERT INTO `member` VALUES ('11','11','11','11@naver.com','2021-04-09 12:30:06'),('111asdasdasd','asd','test','test@naver.com','2021-04-02 13:25:49'),('12','12','12','12@naver.com','2021-04-09 12:37:00'),('123','321','123','123@naver.com','2021-04-02 15:09:36'),('12345','12345','12345','12345@naver.com','2021-04-02 15:24:05'),('22','22','22','22@naver.com','2021-04-09 12:30:39'),('33','33','33','33@naver.com','2021-04-09 12:36:11'),('ee','ee','ee','ee@naver.com','2021-04-09 12:50:22'),('ewq','ewq','ewq','ewq@naver.com','2021-04-09 12:39:57'),('qa','qa','qa','qa@naver.com','2021-04-09 12:40:38'),('qq','qq','qq','qq@naver.com','2021-04-09 12:37:52'),('qwe','qwe','1','1@naver.com','2021-04-09 10:34:12'),('regsergrsegse','123','1','1@naver.com','2021-04-02 13:27:46'),('sdafsfdasdf','1','1','1@naver.com','2021-04-02 13:27:59'),('sdfsdafasfd','asd','tset','test@naver.com','2021-04-02 13:34:46'),('ssafy','ssafy','ho','ssafy@ssafy.com','2021-04-02 13:13:08'),('test','123','test','test','2021-04-02 12:04:02'),('test123','123','test','test@naver.com','2021-04-02 15:18:42'),('test123123','test','test','test@naver.com','2021-04-09 02:33:04'),('testse','test','test','tset@naver.com','2021-04-02 15:09:30'),('ww','ww','ww','ww@naver.com','2021-04-09 12:46:20'),('zxc','zxc','zxc','zxc@naver.com','2021-04-09 12:41:38');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-09 22:01:31
