-- MySQL dump 10.13  Distrib 5.7.20, for Linux (x86_64)
--
-- Host: localhost    Database: vocabulary_learning
-- ------------------------------------------------------
-- Server version	5.7.20-0ubuntu0.17.10.1

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
-- Table structure for table `probabilities`
--

DROP TABLE IF EXISTS `probabilities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `probabilities` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `probability` int(11) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `word_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkwi1oac42i7vpsjd8363mx3o4` (`user_id`),
  KEY `FK80ul6r12k8vkplpuptee359tx` (`word_id`),
  CONSTRAINT `FK80ul6r12k8vkplpuptee359tx` FOREIGN KEY (`word_id`) REFERENCES `words` (`id`),
  CONSTRAINT `FKkwi1oac42i7vpsjd8363mx3o4` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `probabilities`
--

LOCK TABLES `probabilities` WRITE;
/*!40000 ALTER TABLE `probabilities` DISABLE KEYS */;
INSERT INTO `probabilities` VALUES (1,1,1,1),(2,1,1,2),(3,1,1,3),(4,1,1,4),(5,1,1,5),(6,1,1,6),(7,1,1,7),(8,1,1,8),(9,1,1,9),(10,1,1,10),(11,1,1,11),(12,1,1,12),(13,1,1,13),(14,1,1,14),(15,1,1,15),(16,1,1,16),(17,1,1,17),(18,1,1,18),(19,1,1,19),(20,1,1,20),(21,1,1,21),(22,1,1,22),(23,1,1,23),(24,1,1,24),(25,1,1,25),(26,1,1,26),(27,1,1,27),(28,1,1,28),(29,1,1,29),(30,1,1,30),(31,1,1,31),(32,1,1,32),(33,1,1,33),(34,1,1,34),(35,1,1,35),(36,1,1,36),(37,1,1,37),(38,1,1,38),(39,1,1,39),(40,1,1,40),(41,1,1,41),(42,1,1,42),(43,1,1,43),(44,1,1,44),(45,1,1,45),(46,1,1,46),(47,1,1,47),(48,1,1,48),(49,1,1,49),(50,1,1,50),(51,1,1,51),(52,1,1,52),(53,1,1,53),(54,1,1,54),(55,1,1,55),(56,1,1,56),(57,1,1,57),(58,1,1,58),(59,1,1,59),(60,1,1,60),(61,1,1,61),(62,1,1,62),(63,1,1,63),(64,1,1,64),(65,1,1,65),(66,1,1,66),(67,1,1,67),(68,1,1,68),(69,1,1,69),(70,1,1,70),(71,1,1,71),(72,1,1,72),(73,1,1,73),(74,1,1,74),(75,1,1,75),(76,1,1,76),(77,1,1,77),(78,1,1,78),(79,1,1,79),(80,1,1,80),(81,1,1,81),(82,1,1,82),(83,1,1,83),(84,1,1,84),(85,1,1,85),(86,1,1,86),(87,1,1,87),(88,1,1,88),(89,1,1,89),(90,1,1,90),(91,1,1,91),(92,1,1,92),(93,1,1,93),(94,1,1,94),(95,1,1,95),(96,1,1,96),(97,1,1,97),(98,1,1,98),(99,1,1,99),(100,1,1,100),(101,1,1,101),(102,1,1,102),(103,1,1,103),(104,1,1,104),(105,1,1,105),(106,1,1,106),(107,1,1,107),(108,1,1,108),(109,1,1,109),(110,1,1,110),(111,1,1,111),(112,1,1,112),(113,1,1,113),(114,1,1,114),(115,1,1,115),(116,1,1,116),(117,1,1,117),(118,1,1,118),(119,1,1,119),(120,1,1,120),(121,1,1,121),(122,1,1,122),(123,1,1,123),(124,1,1,124),(125,1,1,125),(126,1,1,126),(127,1,1,127),(128,1,1,128),(129,1,1,129),(130,1,1,130),(131,1,1,131),(132,1,1,132),(133,1,1,133),(134,1,1,134),(135,1,1,135),(136,1,1,136),(137,1,1,137),(138,1,1,138),(139,1,1,139),(140,1,1,140),(141,1,1,141),(142,1,1,142),(143,1,1,143),(144,1,1,144),(145,1,1,145),(146,1,1,146),(147,1,1,147),(148,1,1,148),(149,1,1,149),(150,1,1,150),(151,1,1,151),(152,1,1,152),(153,1,1,153),(154,1,1,154),(155,1,1,155),(156,1,1,156),(157,1,1,157),(158,1,1,158),(159,1,1,159),(160,1,1,160),(161,1,1,161),(162,1,1,162),(163,1,1,163),(164,1,1,164),(165,1,1,165),(166,1,1,166),(167,1,1,167),(168,1,1,168),(169,1,1,169),(170,1,1,170),(171,1,1,171),(172,1,1,172),(173,1,1,173),(174,1,1,174),(175,1,1,175),(176,1,1,176),(177,1,1,177),(178,1,1,178),(179,1,1,179),(180,1,1,180),(181,1,1,181),(182,1,1,182),(183,1,1,183),(184,1,1,184),(185,1,1,185),(186,1,1,186),(187,1,1,187),(188,1,1,188),(189,1,1,189),(190,1,1,190),(191,1,1,191),(192,1,1,192),(193,1,1,193),(194,1,1,194),(195,1,1,195),(196,1,1,196),(197,1,1,197),(198,1,1,198),(199,1,1,199),(200,1,1,200);
/*!40000 ALTER TABLE `probabilities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `login` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `permission` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`),
  UNIQUE KEY `UK_ow0gan20590jrb00upg3va2fn` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin@gmail.com','admin','$2a$10$p3DYnRk.uiY/bwET84K5Dei8Jrg3y.VfhqR5cSt.VJfmlKt0xPm5K','admin');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `word_groups`
--

DROP TABLE IF EXISTS `word_groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `word_groups` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` date DEFAULT NULL,
  `ifBasicGroup` bit(1) NOT NULL,
  `lastUpdate` datetime(6) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_4ku4il91q7jpy4kjdrkmhjhyv` (`name`),
  KEY `FKr6adatm7q1uw89m5fpjn4u4ts` (`user_id`),
  CONSTRAINT `FKr6adatm7q1uw89m5fpjn4u4ts` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `word_groups`
--

LOCK TABLES `word_groups` WRITE;
/*!40000 ALTER TABLE `word_groups` DISABLE KEYS */;
INSERT INTO `word_groups` VALUES (1,'2017-12-04','','2017-12-04 17:44:04.215000','Jedzenie',1),(2,'2017-12-04','','2017-12-04 16:13:28.749000','Podstawowe zwroty',1),(3,'2017-12-04','','2017-12-04 16:21:57.920000','Liczby',1),(4,'2017-12-04','','2017-12-04 16:27:34.948000','Sport',1),(5,'2017-12-04','','2017-12-04 16:31:17.519000','Człowiek',1),(6,'2017-12-04','','2017-12-04 16:37:34.397000','Pogoda',1),(7,'2017-12-04','','2017-12-04 16:40:15.462000','Dom',1),(8,'2017-12-04','','2017-12-04 16:43:02.705000','Świat przyrody',1),(9,'2017-12-04','','2017-12-04 17:48:35.440000','Turystyka',1),(10,'2017-12-04','','2017-12-04 16:03:07.809000','Zdrowie',1),(11,'2017-12-04','','2017-12-04 17:44:27.261000','Praca',1),(12,'2017-12-04','','2017-12-04 17:54:39.636000','Przymiotniki',1);
/*!40000 ALTER TABLE `word_groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `words`
--

DROP TABLE IF EXISTS `words`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `words` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `eng` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pl` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `wordGroup_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdgpx3boxpqa4u25txisounui3` (`wordGroup_id`),
  CONSTRAINT `FKdgpx3boxpqa4u25txisounui3` FOREIGN KEY (`wordGroup_id`) REFERENCES `word_groups` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `words`
--

LOCK TABLES `words` WRITE;
/*!40000 ALTER TABLE `words` DISABLE KEYS */;
INSERT INTO `words` VALUES (1,'bread','chleb',1),(2,'milk','mleko',1),(3,'butter','masło',1),(4,'water','woda',1),(5,'juice','sok',1),(6,'vegetables','warzywa',1),(7,'fruits','owoce',1),(8,'apple','jabłko',1),(9,'grapes','winogrona',1),(10,'cheese','ser',1),(11,'pasta','makaron',1),(12,'potato','ziemniak',1),(13,'rice','ryż',1),(14,'tomato','pomidor',1),(15,'cucumber','ogórek',1),(16,'lettuce','sałata',1),(17,'nice to see you','miło Cię widzieć',2),(18,'how are you?','jak się masz?',2),(19,'hello','cześć',2),(20,'good morning','dzień dobry',2),(21,'good evening','dobry wieczór',2),(22,'good bye','do widzenia',2),(23,'thank you','dziękuję',2),(24,'you\'re welcome','nie ma za co',2),(25,'happy birthday','Wszystkiego najlepszego (urodziny)',2),(26,'marry christmas','wesołych świąt',2),(27,'What time is it?','która jest godzina?',2),(28,'one','jeden',3),(29,'two','dwa',3),(30,'three','trzy',3),(31,'four','cztery',3),(32,'five','pięć',3),(33,'six','sześć',3),(34,'seven','siedem',3),(35,'eight','osiem',3),(36,'nine','dziewięć',3),(37,'ten','dziesięć',3),(38,'eleven','jedenaście',3),(39,'twelve','dwanaście',3),(40,'thirteen','trzynaście',3),(41,'fourteen','czternaście',3),(42,'fifteen','piętnaście',3),(43,'first','pierwszy',3),(44,'second','drugi',3),(45,'third','trzeci',3),(46,'twenty','dwadzieścia',3),(47,'ball','piłka',4),(48,'racket','rakieta',4),(49,'gym','siłownia',4),(50,'bicycle','rower',4),(51,'basketball','koszykówka',4),(52,'voleyball','siatkówka',4),(53,'football','piłka nożna',4),(54,'tennis','tenis',4),(55,'climbing','wspinaczka',4),(56,'cycling','kolarstwo',4),(57,'hockey','hokej',4),(58,'running','bieganie',4),(59,'swimming','pływanie',4),(60,'referee','sędzia',4),(61,'foul','faul',4),(62,'face','twarz',5),(63,'leg','noga',5),(64,'hand','dłoń',5),(65,'head','głowa',5),(66,'nose','nos',5),(67,'nail','paznokieć',5),(68,'arm','ramię',5),(69,'bone','kość',5),(70,'knee','kolano',5),(71,'eye','oko',5),(72,'ear','ucho',5),(73,'back','plecy',5),(74,'mouth','usta',5),(75,'hair','włosy',5),(76,'hearth','serce',5),(77,'sun','słońce',6),(78,'cloud','chmura',6),(79,'rain','deszcz',6),(80,'wind','wiatr',6),(81,'hot','gorąco',6),(82,'snow','śnieg',6),(83,'ice','lód',6),(84,'cloudy','pochmurno',6),(85,'cloud','chmura',6),(86,'sunny','słonecznie',6),(87,'umbrella','parasol',6),(88,'hail','grad',6),(89,'room','pokój',7),(90,'kitchen','kuchnia',7),(91,'bedroom','sypialnia',7),(92,'bathroom','łazienka',7),(93,'toilet','toaleta',7),(94,'attic','strych',7),(95,'bed','łóżko',7),(96,'chair','krzesło',7),(97,'table','stół',7),(98,'desk','biurko',7),(99,'wardrobe','szafa',7),(100,'door','drzwi',7),(101,'hall','korytarz',7),(102,'cottage','chatka',7),(103,'tree','drzewo',8),(104,'sea','morze',8),(105,'river','rzeka',8),(106,'mountain','góra',8),(107,'stream','strumyk',8),(108,'lake','jezioro',8),(109,'flower','kwiatek',8),(110,'grass','trawa',8),(111,'moon','księżyc',8),(112,'animal','zwierzę',8),(113,'dog','pies',8),(114,'cat','kot',8),(115,'snake','wąż',8),(116,'butterfly','motyl',8),(117,'pig','świnia',8),(118,'cow','krowa',8),(119,'airport','lotnisko',9),(120,'station','dworzec',9),(121,'trip','podróż',9),(122,'suitcase','walizka',9),(123,'plane','samolot',9),(124,'taxi','taksówka',9),(125,'ticket','bilet',9),(126,'bus','bus',9),(127,'train','pociąg',9),(128,'map','mapa',9),(129,'city centre','centrum miasta',9),(130,'old town','starówka',9),(131,'flight','lot',9),(132,'guide','przewodnik',9),(133,'ship','statek',9),(134,'boss','szef',11),(135,'work','praca',11),(136,'computer','komputer',11),(137,'break','przerwa',11),(138,'office','biuro',11),(139,'desk','biurko',11),(140,'phone','telefon',11),(141,'holiday','urlop',11),(142,'employee','pracownik',11),(143,'agreement','umowa',11),(144,'payment','wypłata',11),(145,'promotion','awans',11),(146,'job interview','rozmowa o pracę',11),(147,'task','zadanie',11),(148,'company','firma',11),(149,'cover letter','list motywacyjny',11),(150,'salary','pensja',11),(151,'lawyer','adwokat',11),(152,'actor','aktor',11),(153,'gross','brutto',11),(154,'dentist','dentysta',11),(155,'miner','górnik',11),(156,'hairdresser','fryzer',11),(157,'waiter','kelner',11),(158,'net','netto',11),(159,'doctor','lekarz',11),(160,'cook','kucharz',11),(161,'teacher','nauczyciel',11),(162,'writer','pisarz',11),(163,'fireman','strażak',11),(164,'country','państwo',9),(165,'holiday','wakacje',9),(166,'key','klucz',9),(167,'road','droga',9),(168,'bridge','most',9),(169,'camping','biwakowanie',9),(170,'luggage','bagaż',9),(171,'railway station','dworzec kolejowy',9),(172,'tourist','turysta',9),(173,'tram','tramwaj',9),(174,'backpack','plecak',9),(175,'clean','czysty',12),(176,'empty','pusty',12),(177,'full','pełny',12),(178,'angry','zły',12),(179,'hungry','głodny',12),(180,'sad','smutny',12),(181,'tired','zmęczony',12),(182,'worried','zmartwiony',12),(183,'disappointed','rozczarowany',12),(184,'happy','szczęśliwy',12),(185,'funny','zabawny',12),(186,'fast','szybki',12),(187,'slow','wolny',12),(188,'light','lekki',12),(189,'delicious','pyszny',12),(190,'dangerous','niebezpieczny',12),(191,'safe','bezpieczny',12),(192,'expensive','drogi',12),(193,'young','młody',12),(194,'old','stary',12),(195,'stupid','głupi',12),(196,'fat','gruby',12),(197,'beautiful','piękny',12),(198,'big','duży',12),(199,'small','mały',12),(200,'long','długi',12);
/*!40000 ALTER TABLE `words` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-04 17:58:48
