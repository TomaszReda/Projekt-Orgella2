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
-- Table structure for table `zdjecia`
--

DROP TABLE IF EXISTS `zdjecia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zdjecia` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `adres` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zdjecia`
--

LOCK TABLES `zdjecia` WRITE;
/*!40000 ALTER TABLE `zdjecia` DISABLE KEYS */;
INSERT INTO `zdjecia` VALUES (1,'images/8b5bf498-ca22-423b-8739-c41cf75058b1.jpg'),(2,'images/2efe142c-6a8b-42fe-92f0-adfbb849418c.jpg'),(3,'images/11720ba9-1993-4a1b-9343-b077243aff58.jpg'),(4,'images/4a495c76-2191-4c97-a199-408bd4abe585.jpg'),(5,'images/f069d29b-8b24-4dde-b83c-91c0150584f2.jpg'),(6,'images/32b9d785-fc24-4881-9b21-3ad1f68cd7a6.jpg'),(7,'images/df30c387-873e-45a6-825e-cab126e7b6b2.jpg'),(8,'images/d299b19c-e3c4-4f7c-8584-5bc329c18eb3.png'),(9,'images/e595f780-8eba-4e33-ad72-fecb2237f148.jpg'),(10,'images/97a0909b-ff2a-4a02-a0f8-c35a93c95a28.jpg'),(11,'images/76c8f215-65f3-4c8c-abc1-fec52ca8395e.jpg'),(12,'images/3061e8ba-66c3-4b96-99e8-bee01d0fcd40.jpg'),(13,'images/1634a179-a442-45c4-a3a3-ff036023f858.jpg'),(14,'images/0c047b53-9227-45df-bbe0-3e0048798acd.jpg'),(15,'images/827cbdeb-c268-449f-ba89-5eaf8dadcfbd.jpg'),(16,'images/7ddd4dcb-44a7-459f-b066-6a15967ce5a9.jpg'),(17,'images/401395e4-49af-4951-83b8-4cac4b89e215.jpg'),(18,'images/8ab00be5-2a47-445f-9bf7-57913e863a4c.jpg'),(19,'images/2165ac2a-74f4-4dee-b4b9-7091f60d23f3.png'),(20,'images/4e99c657-646f-4726-a80b-188889670fba.jpg'),(21,'images/ef5b4f9d-c34f-4fa6-a3e1-c0fa523a4dcd.jpg'),(22,'images/18075b27-bae4-4d16-99a4-2879e8bbbc0e.jpg'),(23,'images/65829387-84af-49c0-a9b6-71be1d36720c.jpg'),(24,'images/97cbe52a-bc60-466d-8509-79b3fb55efc0.jpg'),(25,'images/d69fed00-a785-45f2-92f1-f30eff81724f.jpg'),(26,'images/58379517-e382-4584-bcf9-d528d3e90c36.jpg'),(27,'images/6544ab77-17d1-42b2-a410-ae99fdeca2c4.jpg'),(28,'images/007e6208-1233-4dd5-8205-6298f3491161.jpg'),(29,'images/9e51a1a8-cfbe-4e51-aa8c-8596fd217755.jpg'),(30,'images/8687af49-5c4f-451f-8be0-9eb94dd7a0f2.jpg'),(31,'images/b6232e1c-6fd2-42ba-aa55-14a81d64704e.jpg');
/*!40000 ALTER TABLE `zdjecia` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-04 11:02:37
