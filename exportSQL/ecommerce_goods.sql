-- MySQL dump 10.13  Distrib 5.7.9, for osx10.9 (x86_64)
--
-- Host: 127.0.0.1    Database: ecommerce
-- ------------------------------------------------------
-- Server version	5.7.10

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `goods`
--

DROP TABLE IF EXISTS `goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goods` (
  `gid` int(11) NOT NULL AUTO_INCREMENT,
  `gname` varchar(255) NOT NULL,
  `gdesc` varchar(255) DEFAULT NULL,
  `gstocks` int(11) NOT NULL,
  `cid` int(11) NOT NULL,
  `gprice` decimal(20,2) DEFAULT NULL,
  PRIMARY KEY (`gid`),
  KEY `cid` (`cid`),
  CONSTRAINT `goods_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods`
--

LOCK TABLES `goods` WRITE;
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` VALUES (1,'Call Of Duty','Activision',10,3,59.99),(2,'Assassin\'s Creed 4 Black Flag','Ubisofy',8,3,45.55),(3,'Expert One-on-One J2EE Design and Development','by Rod Johnson, Paperback',5,1,38.02),(4,'Core J2EE Patterns: Best Practices and Design Strategies (2nd Edition)','by Deepak Alur and Dan Malks, Kindle Edition',6,1,43.99),(5,'Honeywell MN10CESWW 10,000 BTU Portable Air Conditioner with Remote Control - White','by Honeywell',12,2,398.98),(6,'SPT RF-314SS Double Door Refrigerator, Stainless Steel, 3.1 Cubic Feet','by SPT',10,2,215.04),(7,'Speedo Vanquisher 2.0 Mirrored Swim Goggle','by Speedo',7,4,17.99),(8,'Nalgene Tritan Wide Mouth BPA-Free Water Bottle, 1-Quart','by Nalgene',8,4,9.69),(9,'New Balance Men\'s Soft-Shell Jacket with Fleece Lining','92% Polyester/8% Spandex, Imported, Machine Wash',11,5,29.95),(10,'London Fog Men\'s Beaverton Microfiber Newsboy Jacket with Contrast Bib','100% Polyester, Imported\r\n100% Polyester, Imported, Machine Wash',9,5,100.00);
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-02-25 18:58:52
