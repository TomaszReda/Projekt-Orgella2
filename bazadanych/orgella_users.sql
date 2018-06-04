-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: orgella
-- ------------------------------------------------------
-- Server version	5.6.40-log

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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `firstname` varchar(12) DEFAULT NULL,
  `lastname` varchar(12) DEFAULT NULL,
  `login` varchar(15) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  `regulamin1` bit(1) NOT NULL,
  `regulamin2` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'tomekreda@op.pl','Tomek','Reda','Administrator','$2a$10$x4J7rZdAW1ZMzzJ/q1YpdeIXgQ5fPqrcZl3YMxPJd4UMmxA33uEgC','',''),(11,'sadsada@op.pl','asdsad','adadada','sadasdada','$2a$10$yEhdBtMVAGZSmpWyUxXWt.tNBnqMIEExyujVYOuQi/tXgZqUtx6zS','',''),(8,'adsada@op.pl','sadsada','dadadada','Testowany15','$2a$10$97WMEgRdD9Io4GOoJT.KPO0iRugbRRCy57e2f0wy9ZTVEt2pxBipy','',''),(5,'tomekredsa16@gmail.com','Tomek','Reda','Testowany11','$2a$10$vGV0ROc8IC2uzvXL9gNEGuwojS1505GRLZimt9DXyKwaeXZCNTvXC','',''),(6,'tomekresda16@gmail.com','Tomek','Reda','Testowany13','$2a$10$9ZdtyzUW6bAeZcKf.w0eoujIf8yRb9WRy8/R7ERzQ6oDjR7MHA5Km','',''),(7,'dsadada@op.pl','dasdadas','dadadss','dsadass','$2a$10$GfO0cymyNg5mfQnMABp08eWMdez77rcCc5L1kkxQWGwMPmMwpfpy2','',''),(10,'testowany1001@op.pl','asdsad','adadada','testowany100','$2a$10$MO1kF7dR/.mWbuSpuqJRd..xmAnb8UBUuCeCpZtkNVrFB6NQFda2e','',''),(12,'tomekrseda@op.pld','asdsad','adadada','S?odkiCiesielka','$2a$10$IFvGoJFdRSF4XgXGgLBSH.hAvQ626DjI1G64irMps2XgJiv6dbBWC','',''),(13,'testowany1111@op.pl','asdadsadadsa','dadsadadada','Mateusz111','$2a$10$.8I4Orz6Gyjz/XGlWHXNkeJJbDg6vUeJKd0m2LwGWLHnhm57wFoSW','','');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-04 11:02:36
