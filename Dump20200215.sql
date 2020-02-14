CREATE DATABASE  IF NOT EXISTS `novogold` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `novogold`;
-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: novogold
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `crops`
--

DROP TABLE IF EXISTS `crops`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `crops` (
  `crops_id` int(11) NOT NULL,
  `crops_type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`crops_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crops`
--

LOCK TABLES `crops` WRITE;
/*!40000 ALTER TABLE `crops` DISABLE KEYS */;
INSERT INTO `crops` VALUES (11,'field crops'),(22,'fodder crops'),(33,'vegetable crops');
/*!40000 ALTER TABLE `crops` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dealers`
--

DROP TABLE IF EXISTS `dealers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `dealers` (
  `dealer_id` int(11) NOT NULL,
  `dealer_name` varchar(20) DEFAULT NULL,
  `region_id` int(11) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`dealer_id`),
  KEY `region_id` (`region_id`),
  CONSTRAINT `dealers_ibfk_1` FOREIGN KEY (`region_id`) REFERENCES `region` (`region_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dealers`
--

LOCK TABLES `dealers` WRITE;
/*!40000 ALTER TABLE `dealers` DISABLE KEYS */;
INSERT INTO `dealers` VALUES (101,'AgroStar',202,'survey no.42,Ratna chowk,bhavani peth, Pune'),(102,'Agri Begri',202,'survey no.42,Ratna chowk,bhavani peth, Pune'),(103,'Agrosiaa',202,'survey no.42,Ratna chowk,bhavani peth, Pune'),(104,'krushi Seed',201,'navi mumbai, mumbai'),(105,'Unnat kisan',201,'kalyan, mumbai');
/*!40000 ALTER TABLE `dealers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_package`
--

DROP TABLE IF EXISTS `order_package`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order_package` (
  `order_id` int(11) NOT NULL,
  `crops_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `50kg` int(11) DEFAULT NULL,
  `20kg` int(11) DEFAULT NULL,
  `10kg` int(11) DEFAULT NULL,
  `5kg` int(11) DEFAULT NULL,
  `1kg` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`,`crops_id`,`product_id`),
  KEY `crops_id_fk_idx` (`crops_id`),
  KEY `product_id_fk_idx` (`product_id`),
  CONSTRAINT `crops_id_fk` FOREIGN KEY (`crops_id`) REFERENCES `crops` (`crops_id`),
  CONSTRAINT `order_id_fk` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `product_id_fk` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_package`
--

LOCK TABLES `order_package` WRITE;
/*!40000 ALTER TABLE `order_package` DISABLE KEYS */;
INSERT INTO `order_package` VALUES (10001,11,101,0,2,1,0,0),(10001,11,102,1,1,1,0,0),(10001,22,105,1,0,0,2,0),(10001,33,106,0,0,0,0,1),(10002,22,104,1,0,0,2,5),(10009,11,101,0,1,1,0,0),(10009,11,102,0,1,0,0,0),(10009,22,105,1,0,0,0,0),(10015,11,101,1,1,0,0,0),(10015,11,102,0,0,4,4,0),(10015,33,106,0,0,0,0,1),(10015,33,107,0,0,0,0,1),(10016,11,101,1,1,0,0,0),(10016,11,102,0,0,4,4,0),(10016,11,103,0,1,1,0,0),(10016,33,106,0,0,0,0,1),(10016,33,107,0,0,0,0,1),(10017,11,101,1,1,0,0,0),(10017,11,102,0,0,4,4,0),(10017,11,103,0,1,1,0,0),(10017,33,106,0,0,0,0,1),(10017,33,107,0,0,0,0,1),(10018,11,101,0,0,3,3,1),(10018,11,103,0,3,2,1,0),(10019,11,101,1,1,1,0,1),(10019,11,102,0,1,1,1,1),(10025,11,101,1,1,2,0,0),(10025,11,102,0,1,0,2,0),(10025,22,104,0,1,0,2,0),(10025,33,108,0,0,0,0,1),(10026,11,101,1,1,0,0,0),(10026,22,105,1,1,0,0,0),(10027,11,102,0,2,0,2,0),(10027,22,104,0,2,0,3,0),(10028,11,102,2,1,0,0,0),(10028,33,106,0,0,0,1,0),(10111,11,101,1,1,0,0,0),(10111,11,102,0,0,3,3,0),(10112,11,101,1,1,0,3,0),(10112,11,103,0,1,0,1,0),(10112,33,106,0,0,1,0,0),(100111,11,101,0,2,2,0,0),(100111,33,106,0,2,1,0,0),(101222,11,101,1,1,0,1,0),(101222,11,102,1,0,0,0,0),(101223,22,104,0,1,0,0,0);
/*!40000 ALTER TABLE `order_package` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `dealer_id` int(11) DEFAULT NULL,
  `order_date` date DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `orders_ibfk_1` (`dealer_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`dealer_id`) REFERENCES `dealers` (`dealer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (10001,1234,101,'2019-01-15'),(10002,1234,102,'2019-01-15'),(10003,1234,103,'2019-01-15'),(10004,1111,104,'2019-01-20'),(10005,1111,105,'2019-01-20'),(10009,1234,101,'2019-02-02'),(10010,321,101,'2019-02-01'),(10015,1234,101,'2019-07-06'),(10016,1234,104,'2019-07-06'),(10017,1234,104,'2019-07-06'),(10018,123,102,'2019-07-06'),(10019,123,103,'2019-07-06'),(10020,123,103,'2019-07-06'),(10025,1234,104,'2019-07-09'),(10026,1234,105,'2019-07-09'),(10027,123,102,'2019-07-09'),(10028,123,101,'2019-07-09'),(10111,123,104,'2019-07-09'),(10112,123,105,'2019-07-09'),(100111,123,104,'2019-07-22'),(101222,123,101,'2019-07-11'),(101223,123,102,'2019-07-11');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `products` (
  `product_id` int(11) NOT NULL,
  `crops_id` int(11) DEFAULT NULL,
  `product_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `crop-fk_idx` (`crops_id`),
  CONSTRAINT `crop-fk` FOREIGN KEY (`crops_id`) REFERENCES `crops` (`crops_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (101,11,'reaserch paddy shraddha'),(102,11,'Hybrid maize Ajinkya'),(103,11,'Notified Indrayani'),(104,22,'Corns'),(105,22,'Bajara'),(106,33,'caret'),(107,33,'radish'),(108,33,'cabage');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `region`
--

DROP TABLE IF EXISTS `region`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `region` (
  `region_id` int(11) NOT NULL,
  `region_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`region_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `region`
--

LOCK TABLES `region` WRITE;
/*!40000 ALTER TABLE `region` DISABLE KEYS */;
INSERT INTO `region` VALUES (201,'mumbai,Maharashtra'),(202,'pune,Maharashtr'),(203,'nagar,Maharashtr'),(204,'ahmedabad,Gujrath');
/*!40000 ALTER TABLE `region` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(15) NOT NULL,
  `password` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name_UNIQUE` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (123,'123','123'),(1111,'raj','raj111'),(1234,'mahesh','mahesh08');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_sale`
--

DROP TABLE IF EXISTS `user_sale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_sale` (
  `user_id` int(11) DEFAULT NULL,
  `day_total` int(11) DEFAULT NULL,
  `sale_date` date DEFAULT NULL,
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_sale_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_sale`
--

LOCK TABLES `user_sale` WRITE;
/*!40000 ALTER TABLE `user_sale` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_sale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_session`
--

DROP TABLE IF EXISTS `user_session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_session` (
  `session_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `start_time` date DEFAULT NULL,
  `end_time` date DEFAULT NULL,
  `latitude` float DEFAULT NULL,
  `longitude` float DEFAULT NULL,
  PRIMARY KEY (`session_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_session_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_session`
--

LOCK TABLES `user_session` WRITE;
/*!40000 ALTER TABLE `user_session` DISABLE KEYS */;
INSERT INTO `user_session` VALUES (10001,123,'2019-07-09',NULL,18.4901,73.855);
/*!40000 ALTER TABLE `user_session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'novogold'
--

--
-- Dumping routines for database 'novogold'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-15  0:26:58
