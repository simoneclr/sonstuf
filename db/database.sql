CREATE DATABASE  IF NOT EXISTS `sonstuf` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_estonian_ci */;
USE `sonstuf`;
-- MySQL dump 10.13  Distrib 5.6.27, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: sonstuf
-- ------------------------------------------------------
-- Server version	5.6.27

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
-- Table structure for table `auth_tokens`
--

DROP TABLE IF EXISTS `auth_tokens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auth_tokens` (
  `auth_token_id` varchar(8) COLLATE utf8_estonian_ci NOT NULL,
  `hash` varchar(64) COLLATE utf8_estonian_ci NOT NULL,
  `iduser` int(11) NOT NULL,
  PRIMARY KEY (`auth_token_id`),
  KEY `fk_auth_tokens_user1_idx` (`iduser`),
  CONSTRAINT `fk_auth_tokens_user1` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_estonian_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `idcategory` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_estonian_ci DEFAULT NULL,
  `description` text COLLATE utf8_estonian_ci,
  PRIMARY KEY (`idcategory`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_estonian_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `idmessage` int(11) NOT NULL AUTO_INCREMENT,
  `datetime` timestamp NULL DEFAULT NULL,
  `message` text COLLATE utf8_estonian_ci,
  `idoffer` int(11) NOT NULL,
  `idsender` int(11) NOT NULL,
  PRIMARY KEY (`idmessage`),
  KEY `fk_message_offer1_idx` (`idoffer`),
  KEY `fk_message_user1_idx` (`idsender`),
  CONSTRAINT `fk_message_offer1` FOREIGN KEY (`idoffer`) REFERENCES `offer` (`idoffer`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_message_user1` FOREIGN KEY (`idsender`) REFERENCES `user` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_estonian_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `offer`
--

DROP TABLE IF EXISTS `offer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `offer` (
  `idoffer` int(11) NOT NULL AUTO_INCREMENT,
  `isincharge` tinyint(1) NOT NULL DEFAULT '0',
  `idrequest` int(11) NOT NULL,
  `iduser` int(11) NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  `posttime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`idoffer`),
  UNIQUE KEY `idrequest_iduser` (`idrequest`,`iduser`),
  KEY `fk_offer_request1_idx` (`idrequest`),
  KEY `fk_offer_user1_idx` (`iduser`),
  CONSTRAINT `fk_offer_request1` FOREIGN KEY (`idrequest`) REFERENCES `request` (`idrequest`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_offer_user1` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_estonian_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `offererrank`
--

DROP TABLE IF EXISTS `offererrank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `offererrank` (
  `rank` int(11) NOT NULL,
  `comment` text COLLATE utf8_estonian_ci,
  `offer_idoffer` int(11) NOT NULL,
  PRIMARY KEY (`offer_idoffer`),
  CONSTRAINT `fk_offererrank_offer1` FOREIGN KEY (`offer_idoffer`) REFERENCES `offer` (`idoffer`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_estonian_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `request`
--

DROP TABLE IF EXISTS `request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `request` (
  `idrequest` int(11) NOT NULL AUTO_INCREMENT,
  `title` text COLLATE utf8_estonian_ci NOT NULL,
  `description` text COLLATE utf8_estonian_ci NOT NULL,
  `place` text COLLATE utf8_estonian_ci NOT NULL,
  `datetime` text COLLATE utf8_estonian_ci NOT NULL,
  `photo` text COLLATE utf8_estonian_ci,
  `iduser` int(11) NOT NULL,
  `idcategory` int(11) NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  `posttime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`idrequest`),
  KEY `fk_request_user_idx` (`iduser`),
  KEY `fk_request_category1_idx` (`idcategory`),
  CONSTRAINT `fk_request_category1` FOREIGN KEY (`idcategory`) REFERENCES `category` (`idcategory`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_request_user` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_estonian_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `requesterrank`
--

DROP TABLE IF EXISTS `requesterrank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `requesterrank` (
  `rank` int(11) NOT NULL,
  `comment` text COLLATE utf8_estonian_ci,
  `idoffer` int(11) NOT NULL,
  PRIMARY KEY (`idoffer`),
  CONSTRAINT `fk_requesterrank_offer1` FOREIGN KEY (`idoffer`) REFERENCES `offer` (`idoffer`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_estonian_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `iduser` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_estonian_ci NOT NULL,
  `surname` varchar(45) COLLATE utf8_estonian_ci NOT NULL,
  `phone` varchar(45) COLLATE utf8_estonian_ci DEFAULT NULL,
  `email` varchar(100) COLLATE utf8_estonian_ci DEFAULT NULL,
  `passwordhash` varchar(110) COLLATE utf8_estonian_ci DEFAULT NULL,
  `ranko` float DEFAULT '0',
  `rankp` float DEFAULT '0',
  `birthdate` date DEFAULT NULL,
  `admin` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`iduser`),
  UNIQUE KEY `phone_UNIQUE` (`phone`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_estonian_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-17 11:51:37
