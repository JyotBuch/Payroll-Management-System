-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: payrollmanagementdb
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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `acc_id` int NOT NULL AUTO_INCREMENT,
  `empid` int NOT NULL,
  `acc_number` varchar(20) NOT NULL,
  `bank_code` varchar(20) NOT NULL,
  `version` int NOT NULL,
  PRIMARY KEY (`acc_id`),
  KEY `empid` (`empid`),
  CONSTRAINT `account_ibfk_1` FOREIGN KEY (`empid`) REFERENCES `employee` (`empid`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (2,2,'233356AA3','IFSC20676',1),(3,3,'233356AA4','IFSC20677',1),(4,4,'233356AA5','IFSC20678',1),(6,6,'233356AA7','IFSC20680',1),(7,7,'233356AA8','IFSC20681',1),(8,8,'233356AA9','IFSC20682',1),(9,9,'233356AB1','IFSC20683',1),(10,10,'233356AB2','IFSC20684',1),(11,11,'233356A11','IFSC20775',1),(12,12,'233356A12','IFSC20776',1),(13,13,'233356A13','IFSC20777',1),(14,14,'233356A14','IFSC20778',1),(15,15,'233356A15','IFSC20779',1),(16,16,'233356A16','IFSC20780',1),(17,17,'233356A17','IFSC20781',1),(18,18,'233356A18','IFSC20782',1),(19,19,'233356A19','IFSC20783',1),(20,20,'233356A20','IFSC20784',1),(21,21,'233C356A2','IFSC21675',1),(22,22,'233C356A3','IFSC21676',1),(23,23,'233C356A4','IFSC21677',1),(24,24,'233C356A5','IFSC21678',1),(25,25,'233C356A6','IFSC21679',1),(26,26,'233C356A7','IFSC21680',1),(27,27,'233C356A8','IFSC21681',1),(28,28,'233C356A9','IFSC21682',1),(29,29,'223C356A1','IFSC21683',1),(30,30,'243C356A3','IFSC21684',1);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_archives`
--

DROP TABLE IF EXISTS `account_archives`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_archives` (
  `acc_id` int NOT NULL,
  `empid` int NOT NULL,
  `acc_number` varchar(20) NOT NULL,
  `bank_code` varchar(20) NOT NULL,
  `version` int NOT NULL,
  PRIMARY KEY (`acc_id`),
  KEY `empid` (`empid`),
  CONSTRAINT `account_archives_ibfk_1` FOREIGN KEY (`empid`) REFERENCES `employee_archives` (`empid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_archives`
--

LOCK TABLES `account_archives` WRITE;
/*!40000 ALTER TABLE `account_archives` DISABLE KEYS */;
INSERT INTO `account_archives` VALUES (1,1,'233356AA2','IFSC20675',1),(5,5,'233356AA6','IFSC20679',1);
/*!40000 ALTER TABLE `account_archives` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `deptid` int NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(40) NOT NULL,
  `orgid` int NOT NULL,
  PRIMARY KEY (`deptid`),
  KEY `orgid` (`orgid`),
  CONSTRAINT `department_ibfk_1` FOREIGN KEY (`orgid`) REFERENCES `organization` (`orgid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'HR',1),(2,'Intern',1),(3,'Sales',1),(4,'Research',1),(5,'HR',2),(6,'Intern',2),(7,'Sales',2),(8,'Research',2),(9,'HR',3),(10,'Intern',3),(11,'Sales',3),(12,'Research',3);
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dependents`
--

DROP TABLE IF EXISTS `dependents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dependents` (
  `dependentid` int NOT NULL AUTO_INCREMENT,
  `empid` int NOT NULL,
  `f_name` varchar(20) NOT NULL,
  `m_name` varchar(20) NOT NULL,
  `l_name` varchar(20) NOT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `relation` varchar(20) NOT NULL,
  `dob` date NOT NULL,
  `gender` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`dependentid`),
  KEY `empid` (`empid`),
  CONSTRAINT `dependents_ibfk_1` FOREIGN KEY (`empid`) REFERENCES `employee` (`empid`),
  CONSTRAINT `dependents_chk_1` CHECK ((`gender` in (_utf8mb4'male',_utf8mb4'female',_utf8mb4'other')))
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dependents`
--

LOCK TABLES `dependents` WRITE;
/*!40000 ALTER TABLE `dependents` DISABLE KEYS */;
INSERT INTO `dependents` VALUES (2,1,'Samuel','Lee','Thompson','9345256212','Father','1975-05-04','male'),(3,1,'Sarah','Samuel','Thompson','9345256213','Mother','1977-11-02','female'),(4,2,'Smith','David','Scott','9345256322','Husband','1985-06-14','male'),(5,2,'Jack','David','Scott','9345256342','Son','2004-02-11','male'),(6,3,'Sam','Jones','Gelar','9345257322','Father','1975-08-13','male'),(7,3,'Peter','Sam','Gelar','9345257442','Brother','2002-01-19','male'),(8,4,'Martin','Joe','Jones','9345257822','Brother','1995-08-13','male'),(9,4,'Monica','Joe','Jones','9345257942','Sister','2001-09-17','female'),(10,13,'Sophia','Allan','Gelar','9213467621','Brother','1995-08-13','female'),(11,13,'Jennifer','Allan','Gelar','9213467623','Sister','2003-07-07','female'),(12,14,'Jack','Kevin','Sciarra','9213467625','Father','1995-11-01','male'),(13,14,'Amy','Jack','Sciarra','9213467627','Mother','1998-10-17','female'),(14,16,'Mabon','Den','Raphaely','9213468625','Son','2000-05-23','male'),(15,16,'Stella','Den','Raphaely','9213468627','Daughter','2002-11-07','female'),(16,28,'Mac','Joshua','Patel','9213468925','Son','2003-07-24','male'),(17,28,'Scarlett','Joshua','Patel','9213468627','Wife','1996-11-06','female'),(18,29,'Logan','Bill','Vargas','9213468025','Son','2003-09-24','male'),(19,29,'Lily','Bill','Vargas','9213468027','Daughter','2001-12-06','female'),(20,30,'Tom','Ethen','McEwen','9213461025','Father','1957-04-04','male'),(21,30,'Emma','Oliver','McEwen','9213461027','Daughter','2001-10-03','female'),(22,9,'Lee','Ching','Ernst','5151234571','father','1975-08-31','male');
/*!40000 ALTER TABLE `dependents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `empid` int NOT NULL AUTO_INCREMENT,
  `f_name` varchar(20) NOT NULL,
  `m_name` varchar(20) NOT NULL,
  `l_name` varchar(20) NOT NULL,
  `area` varchar(30) NOT NULL,
  `city` varchar(20) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `DOB` date NOT NULL,
  `joindate` date NOT NULL,
  `gender` varchar(6) DEFAULT NULL,
  `paygradeid` int NOT NULL,
  `deptid` int DEFAULT NULL,
  `orgid` int NOT NULL,
  `jobtitle` varchar(30) NOT NULL,
  `lastpaiddate` date DEFAULT NULL,
  PRIMARY KEY (`empid`),
  KEY `paygradeid` (`paygradeid`),
  KEY `deptid` (`deptid`),
  KEY `orgid` (`orgid`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`paygradeid`) REFERENCES `paygrade` (`paygradeid`),
  CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`deptid`) REFERENCES `department` (`deptid`) ON DELETE SET NULL,
  CONSTRAINT `employee_ibfk_3` FOREIGN KEY (`orgid`) REFERENCES `organization` (`orgid`),
  CONSTRAINT `employee_chk_1` CHECK ((`gender` in (_utf8mb4'male',_utf8mb4'female',_utf8mb4'other')))
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (2,'Mary','Smith','Scott','Austin','Texas','78888445','2000-04-13','2021-04-01','female',2,2,1,'Intern','2021-05-01'),(3,'Tim','Sam','Gelar','Austin','Texas','888973735','2000-06-16','2021-04-05','female',3,3,1,'Sales','2021-05-05'),(4,'Sam','Joe','Jones','Brookline','Boston','38348765','2001-01-12','2021-04-03','male',3,4,1,'Research','2021-04-03'),(6,'Jake','Roger','Peralta','Brooklyn','New York','33562562','1996-04-10','2021-03-11','male',2,4,1,'Research','2021-04-11'),(7,'Neena','Ramesh','Kocchar','Tilak Road','Pune','5151234568','1995-03-13','2021-03-09','female',2,2,1,'Intern','2021-03-09'),(8,'Alexander','Lex','Hunlod','Belmont','Boston','5151234569','1996-04-26','2021-02-04','male',3,3,1,'Sales','2021-05-04'),(9,'Bruce','Lee','Ernst','Belmont','Boston','5151234571','1993-03-22','2021-02-05','male',1,1,1,'HR','2021-03-05'),(10,'Diana','David','Lorentz','Brooklyn','New York','5151234572','1995-02-12','2021-02-05','female',2,4,1,'Research','2021-02-05'),(11,'Nancy','Christoppher','Greenberg','Austin','Texas','7883453856','1991-03-13','2021-04-07','female',4,5,2,'HR','2021-04-07'),(12,'Daniel','Janette','Faviet','Austin','Texas','7883453857','2000-02-16','2021-04-11','male',6,6,2,'Intern','2021-04-11'),(13,'John','Allan','Gelar','Chen','Texas','7883453858','2000-03-21','2021-04-02','male',6,7,2,'Sales','2021-04-02'),(14,'Isamel','Jack','Sciarra','Brookline','Boston','7883453859','2001-11-13','2021-04-06','female',5,8,2,'Research','2021-04-06'),(15,'Luis','Chandler','Popp','Belmont','Boston','7883453860','2000-04-24','2021-03-15','male',5,7,2,'Sales','2021-03-15'),(16,'Den','Roger','Raphaely','Brooklyn','New York','7883453860','1996-11-10','2021-03-14','male',5,8,2,'Research','2021-03-14'),(17,'Karen','Lee','Tobias','Tilak Road','Pune','7883453862','1998-05-13','2021-03-08','male',6,6,2,'Intern','2021-03-08'),(18,'Matthew','Anthony','Weiss','Belmont','Boston','7883453863','1999-07-07','2021-02-01','male',5,7,2,'Sales','2021-02-01'),(19,'Adam','Pat','Fripp','Belmont','Boston','7883453864','1993-10-22','2021-02-05','male',4,5,2,'HR','2021-02-05'),(20,'Payam','Donald','Kaufling','Brooklyn','New York','7883453868','1997-05-19','2021-02-09','male',6,8,2,'Research','2021-02-09'),(21,'Kevin','Robert','Mourgos','Austin','Texas','8889737351','2001-05-17','2021-04-04','male',7,9,3,'HR','2021-04-04'),(22,'Julia','Roger','Nayer','Austin','Texas','8889737352','2000-06-13','2021-04-07','female',9,10,3,'Intern','2021-04-07'),(23,'James','Chris','Landry','Austin','Texas','8889737353','2000-07-16','2021-04-15','male',8,11,3,'Sales','2021-04-15'),(24,'Steven','Max','Markle','Brookline','Boston','8889737354','2001-08-12','2021-04-23','male',8,12,3,'Research','2021-04-23'),(25,'Laura','Harry','Bissot','Belmont','Boston','8889737355','2000-09-02','2021-03-09','female',8,11,3,'Sales','2021-03-09'),(26,'Jason','Thomas','Mallin','Brooklyn','New York','8889737356','1996-02-10','2021-03-15','male',8,12,3,'Research','2021-03-15'),(27,'Stephen','Omen','Stiles','Tilak Road','Pune','8889737357','1995-08-13','2021-03-06','male',9,10,3,'Intern','2021-03-06'),(28,'Joshua','Michael','Patel','Belmont','Boston','8889737358','1996-09-26','2021-02-14','male',8,11,3,'Sales','2021-02-14'),(29,'Peter','Bill','Vargas','Belmont','Boston','8889737359','1993-10-22','2021-02-09','male',7,9,3,'HR','2021-02-09'),(30,'Oliver','Tom','McEwen','Brooklyn','New York','8889737360','1995-12-12','2021-02-05','male',9,12,3,'Research','2021-02-05');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `employee_delete` BEFORE DELETE ON `employee` FOR EACH ROW begin
insert into employee_archives(empid,f_name,m_name,l_name,area,city,phone,DOB,joindate,gender,deptid,orgid,jobtitle,leave_date) values (old.empid,old.f_name,old.m_name,old.l_name,old.area,old.city,old.phone,old.DOB,old.joindate,old.gender,old.deptid,old.orgid,old.jobtitle,curdate());

insert into account_archives(acc_id,empid,acc_number,bank_code,version) select acc_id,empid,acc_number,bank_code,version from account where empid=old.empid;

insert into salary_archives(transactionid,empid,paygradeid,date,leaves,leave_reduction_amount,bonus,tax_amount,net_salary,acc_id) select 
transactionid,empid,paygradeid,date,leaves,leave_reduction_amount,bonus,tax_amount,net_salary,acc_id from salary_invoices where empid=old.empid;

insert into updated_paygrade_salary_archives(transactionid,empid,paygradeid,date,leaves,leave_reduction_amount,bonus,tax_amount,net_salary,acc_id) select transactionid,empid,paygradeid,date,leaves,leave_reduction_amount,bonus,tax_amount,net_salary,acc_id from updated_paygrade_salary_invoices where empid=old.empid;

delete from salary_invoices where empid=old.empid;
delete from account where empid=old.empid;
delete from updated_paygrade_salary_invoices where empid=old.empid;
delete from dependents where empid=old.empid;
delete from user where userid=concat(old.empid,'$',old.orgid);
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `employee_archives`
--

DROP TABLE IF EXISTS `employee_archives`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_archives` (
  `empid` int NOT NULL,
  `f_name` varchar(20) NOT NULL,
  `m_name` varchar(20) NOT NULL,
  `l_name` varchar(20) NOT NULL,
  `area` varchar(30) NOT NULL,
  `city` varchar(20) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `DOB` date NOT NULL,
  `joindate` date NOT NULL,
  `gender` varchar(6) DEFAULT NULL,
  `deptid` int NOT NULL,
  `orgid` int NOT NULL,
  `jobtitle` varchar(30) NOT NULL,
  `leave_date` date DEFAULT NULL,
  PRIMARY KEY (`empid`),
  KEY `deptid` (`deptid`),
  KEY `orgid` (`orgid`),
  CONSTRAINT `employee_archives_ibfk_1` FOREIGN KEY (`deptid`) REFERENCES `department` (`deptid`),
  CONSTRAINT `employee_archives_ibfk_2` FOREIGN KEY (`orgid`) REFERENCES `organization` (`orgid`),
  CONSTRAINT `employee_archives_chk_1` CHECK ((`gender` in (_utf8mb4'male',_utf8mb4'female',_utf8mb4'other')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_archives`
--

LOCK TABLES `employee_archives` WRITE;
/*!40000 ALTER TABLE `employee_archives` DISABLE KEYS */;
INSERT INTO `employee_archives` VALUES (1,'Austin','Samuel','Thompson','Austin','Texas','78834532','2001-06-17','2021-04-03','male',1,1,'HR','2021-05-04'),(5,'Jane','Chandler','Akins','Belmont','Boston','5663675','2000-08-02','2021-03-05','male',3,1,'Sales','2021-05-06');
/*!40000 ALTER TABLE `employee_archives` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `latest_accounts_view`
--

DROP TABLE IF EXISTS `latest_accounts_view`;
/*!50001 DROP VIEW IF EXISTS `latest_accounts_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `latest_accounts_view` AS SELECT 
 1 AS `acc_id`,
 1 AS `empid`,
 1 AS `acc_number`,
 1 AS `bank_code`,
 1 AS `version`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `organization`
--

DROP TABLE IF EXISTS `organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `organization` (
  `orgid` int NOT NULL AUTO_INCREMENT,
  `org_name` varchar(40) NOT NULL,
  PRIMARY KEY (`orgid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organization`
--

LOCK TABLES `organization` WRITE;
/*!40000 ALTER TABLE `organization` DISABLE KEYS */;
INSERT INTO `organization` VALUES (1,'Infosys'),(2,'EDS'),(3,'HP');
/*!40000 ALTER TABLE `organization` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `org_delete` BEFORE DELETE ON `organization` FOR EACH ROW begin
delete from salary_invoices where transactionid in (select transactionid from salary_invoices natural join employee where orgid=old.orgid);
delete from salary_archives where transactionid in (select transactionid from salary_archives natural join employee where orgid=old.orgid);
delete from updated_paygrade_salary_invoices where transactionid in (select transactionid from updated_paygrade_salary_invoices natural join employee where orgid=old.orgid);
delete from updated_paygrade_salary_archives where transactionid in (select transactionid from updated_paygrade_salary_archives natural join employee where orgid=old.orgid);
delete from account where acc_id in (select acc_id from acccount natural join employee where orgid=old.orgid);
delete from account_archives where acc_id in (select acc_id from acccount_archives natural join employee where orgid=old.orgid);
delete from employee where orgid=old.orgid;
delete from employee_archives where orgid=old.orgid;
delete from dependents where dependentid in (select dependentid from dependents natural join employee where orgid=old.orgid);
delete from department where orgid=old.orgid;
delete from user where userid like concat('%$',old.orgid);
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Temporary view structure for view `payable_employees`
--

DROP TABLE IF EXISTS `payable_employees`;
/*!50001 DROP VIEW IF EXISTS `payable_employees`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `payable_employees` AS SELECT 
 1 AS `empid`,
 1 AS `name`,
 1 AS `orgid`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `paygrade`
--

DROP TABLE IF EXISTS `paygrade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paygrade` (
  `paygradeid` int NOT NULL AUTO_INCREMENT,
  `orgid` int NOT NULL,
  `paygrade_name` varchar(20) NOT NULL,
  `base_salary` float DEFAULT NULL,
  `benefits` float DEFAULT NULL,
  `tax_percent` float NOT NULL,
  `leave_reduction_percent` float NOT NULL,
  `leaves_permitted` int DEFAULT NULL,
  PRIMARY KEY (`paygradeid`),
  KEY `orgid` (`orgid`),
  CONSTRAINT `paygrade_ibfk_1` FOREIGN KEY (`orgid`) REFERENCES `organization` (`orgid`),
  CONSTRAINT `paygrade_chk_1` CHECK ((`base_salary` >= 0)),
  CONSTRAINT `paygrade_chk_2` CHECK ((`benefits` >= 0)),
  CONSTRAINT `paygrade_chk_3` CHECK ((`leaves_permitted` >= 0))
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paygrade`
--

LOCK TABLES `paygrade` WRITE;
/*!40000 ALTER TABLE `paygrade` DISABLE KEYS */;
INSERT INTO `paygrade` VALUES (1,1,'platinum',50000,15000,0.8,0.5,0),(2,1,'gold',25000,6000,0.8,0.8,3),(3,1,'silver',15000,7500,0.8,0.5,1),(4,2,'platinum',45000,2000,0.8,0.7,4),(5,2,'gold',20000,4500,0.7,0.5,2),(6,2,'silver',7000,450,0.7,0.2,1),(7,3,'platinum',50000,6500,0.6,0.7,3),(8,3,'gold',30000,400,0.7,0.7,6),(9,3,'silver',15000,5500,0.8,0.6,3);
/*!40000 ALTER TABLE `paygrade` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `paygrade_update` BEFORE UPDATE ON `paygrade` FOR EACH ROW begin
insert into updated_and_deleted_paygrade(orgid,paygrade_name,base_salary,benefits,tax_percent,leave_reduction_percent,leaves_permitted) values(old.orgid,old.paygrade_name,old.base_salary,old.benefits,old.tax_percent,old.leave_reduction_percent,old.leaves_permitted);
set @id=Last_insert_id();
insert into updated_paygrade_salary_invoices(transactionid,empid,paygradeid,date,leaves,leave_reduction_amount,bonus,tax_amount,net_salary,acc_id) select transactionid,empid,@id,date,leaves,leave_reduction_amount,bonus,tax_amount,net_salary,acc_id from salary_invoices where paygradeid=old.paygradeid;
delete from salary_invoices where paygradeid=old.paygradeid;
insert into updated_paygrade_salary_archives(transactionid,empid,paygradeid,date,leaves,leave_reduction_amount,bonus,tax_amount,net_salary,acc_id) select transactionid,empid,@id,date,leaves,leave_reduction_amount,bonus,tax_amount,net_salary,acc_id from salary_archives where paygradeid=old.paygradeid;
delete from salary_archives where paygradeid=old.paygradeid;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `paygrade_delete` BEFORE DELETE ON `paygrade` FOR EACH ROW begin
insert into updated_and_deleted_paygrade(orgid,paygrade_name,base_salary,benefits,tax_percent,leave_reduction_percent,leaves_permitted) values(old.orgid,old.paygrade_name,old.base_salary,old.benefits,old.tax_percent,old.leave_reduction_percent,old.leaves_permitted);
set @id=Last_insert_id();

insert into updated_paygrade_salary_invoices(transactionid,empid,paygradeid,date,leaves,leave_reduction_amount,bonus,tax_amount,net_salary,acc_id) select transactionid,empid,@id,date,leaves,leave_reduction_amount,bonus,tax_amount,net_salary,acc_id from salary_invoices where paygradeid=old.paygradeid;
delete from salary_invoices where paygradeid=old.paygradeid;

insert into updated_paygrade_salary_archives(transactionid,empid,paygradeid,date,leaves,leave_reduction_amount,bonus,tax_amount,net_salary,acc_id) select transactionid,empid,@id,date,leaves,leave_reduction_amount,bonus,tax_amount,net_salary,acc_id from salary_archives where paygradeid=old.paygradeid;
delete from salary_archives where paygradeid=old.paygradeid;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `salary_archives`
--

DROP TABLE IF EXISTS `salary_archives`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salary_archives` (
  `transactionid` int NOT NULL,
  `empid` int NOT NULL,
  `paygradeid` int NOT NULL,
  `acc_id` int NOT NULL,
  `date` date NOT NULL,
  `leaves` int NOT NULL,
  `leave_reduction_amount` float NOT NULL,
  `bonus` float NOT NULL,
  `tax_amount` float NOT NULL,
  `net_salary` float NOT NULL,
  PRIMARY KEY (`transactionid`),
  KEY `empid` (`empid`),
  KEY `paygradeid` (`paygradeid`),
  KEY `acc_id` (`acc_id`),
  CONSTRAINT `salary_archives_ibfk_1` FOREIGN KEY (`empid`) REFERENCES `employee_archives` (`empid`),
  CONSTRAINT `salary_archives_ibfk_2` FOREIGN KEY (`paygradeid`) REFERENCES `paygrade` (`paygradeid`),
  CONSTRAINT `salary_archives_ibfk_3` FOREIGN KEY (`acc_id`) REFERENCES `account_archives` (`acc_id`),
  CONSTRAINT `salary_archives_chk_1` CHECK ((`leaves` >= 0)),
  CONSTRAINT `salary_archives_chk_2` CHECK ((`leave_reduction_amount` >= 0)),
  CONSTRAINT `salary_archives_chk_3` CHECK ((`bonus` >= 0)),
  CONSTRAINT `salary_archives_chk_4` CHECK ((`tax_amount` >= 0)),
  CONSTRAINT `salary_archives_chk_5` CHECK ((`net_salary` >= 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary_archives`
--

LOCK TABLES `salary_archives` WRITE;
/*!40000 ALTER TABLE `salary_archives` DISABLE KEYS */;
INSERT INTO `salary_archives` VALUES (4,1,1,1,'2021-05-04',7,1750,6000,554,68696),(6,5,1,5,'2021-05-04',3,750,7000,570,70680);
/*!40000 ALTER TABLE `salary_archives` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary_invoices`
--

DROP TABLE IF EXISTS `salary_invoices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salary_invoices` (
  `transactionid` int NOT NULL AUTO_INCREMENT,
  `empid` int NOT NULL,
  `paygradeid` int NOT NULL,
  `acc_id` int NOT NULL,
  `date` date NOT NULL,
  `leaves` int NOT NULL,
  `leave_reduction_amount` float NOT NULL,
  `bonus` float NOT NULL,
  `tax_amount` float NOT NULL,
  `net_salary` float NOT NULL,
  PRIMARY KEY (`transactionid`),
  KEY `empid` (`empid`),
  KEY `paygradeid` (`paygradeid`),
  KEY `acc_id` (`acc_id`),
  CONSTRAINT `salary_invoices_ibfk_1` FOREIGN KEY (`empid`) REFERENCES `employee` (`empid`),
  CONSTRAINT `salary_invoices_ibfk_2` FOREIGN KEY (`paygradeid`) REFERENCES `paygrade` (`paygradeid`),
  CONSTRAINT `salary_invoices_ibfk_3` FOREIGN KEY (`acc_id`) REFERENCES `account` (`acc_id`),
  CONSTRAINT `salary_invoices_chk_1` CHECK ((`leaves` >= 0)),
  CONSTRAINT `salary_invoices_chk_2` CHECK ((`leave_reduction_amount` >= 0)),
  CONSTRAINT `salary_invoices_chk_3` CHECK ((`bonus` >= 0)),
  CONSTRAINT `salary_invoices_chk_4` CHECK ((`tax_amount` >= 0)),
  CONSTRAINT `salary_invoices_chk_5` CHECK ((`net_salary` >= 0))
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary_invoices`
--

LOCK TABLES `salary_invoices` WRITE;
/*!40000 ALTER TABLE `salary_invoices` DISABLE KEYS */;
INSERT INTO `salary_invoices` VALUES (1,8,3,8,'2021-05-04',8,525,2500,195.8,24279.2),(2,8,3,8,'2021-05-04',6,375,1000,185,22940),(3,8,3,8,'2021-05-04',5,300,500,181.6,22518.4),(5,2,2,2,'2021-05-04',5,400,5000,284.8,35315.2),(7,9,1,9,'2021-05-04',4,1000,8000,576,71424),(8,3,3,3,'2021-05-06',8,525,4000,207.8,25767.2),(9,6,2,6,'2021-05-06',7,800,7000,297.6,36902.4);
/*!40000 ALTER TABLE `salary_invoices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `updated_and_deleted_paygrade`
--

DROP TABLE IF EXISTS `updated_and_deleted_paygrade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `updated_and_deleted_paygrade` (
  `paygradeid` int NOT NULL AUTO_INCREMENT,
  `orgid` int NOT NULL,
  `paygrade_name` varchar(20) NOT NULL,
  `base_salary` float DEFAULT NULL,
  `benefits` float DEFAULT NULL,
  `tax_percent` float NOT NULL,
  `leave_reduction_percent` float NOT NULL,
  `leaves_permitted` int DEFAULT NULL,
  PRIMARY KEY (`paygradeid`),
  KEY `orgid` (`orgid`),
  CONSTRAINT `updated_and_deleted_paygrade_ibfk_1` FOREIGN KEY (`orgid`) REFERENCES `organization` (`orgid`),
  CONSTRAINT `updated_and_deleted_paygrade_chk_1` CHECK ((`base_salary` >= 0)),
  CONSTRAINT `updated_and_deleted_paygrade_chk_2` CHECK ((`benefits` >= 0)),
  CONSTRAINT `updated_and_deleted_paygrade_chk_3` CHECK ((`leaves_permitted` >= 0))
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `updated_and_deleted_paygrade`
--

LOCK TABLES `updated_and_deleted_paygrade` WRITE;
/*!40000 ALTER TABLE `updated_and_deleted_paygrade` DISABLE KEYS */;
INSERT INTO `updated_and_deleted_paygrade` VALUES (1,1,'platinum',50000,15000,0.8,0.5,0),(2,1,'gold',25000,6000,0.8,0.8,3),(3,1,'silver',15000,7500,0.8,0.5,1),(4,2,'platinum',45000,2000,0.8,0.7,4),(5,2,'gold',20000,4500,0.7,0.5,2),(6,2,'silver',7000,450,0.7,0.2,1),(7,3,'gold',50000,6500,0.6,0.7,3),(8,3,'gold',30000,400,0.7,0.7,6),(9,3,'gold',15000,5500,0.8,0.6,3),(10,1,'platinum',50000,15000,0.8,0.5,0),(11,1,'gold',25000,6000,0.8,0.8,3),(12,1,'silver',15000,7500,0.8,0.5,1),(13,2,'platinum',45000,2000,0.8,0.7,4),(14,2,'gold',20000,4500,0.7,0.5,2),(15,2,'silver',7000,450,0.7,0.2,1),(16,3,'gold',50000,6500,0.6,0.7,3),(17,3,'gold',30000,400,0.7,0.7,6),(18,3,'gold',15000,5500,0.8,0.6,3);
/*!40000 ALTER TABLE `updated_and_deleted_paygrade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `updated_paygrade_salary_archives`
--

DROP TABLE IF EXISTS `updated_paygrade_salary_archives`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `updated_paygrade_salary_archives` (
  `transactionid` int NOT NULL,
  `empid` int NOT NULL,
  `paygradeid` int NOT NULL,
  `acc_id` int NOT NULL,
  `date` date NOT NULL,
  `leaves` int NOT NULL,
  `leave_reduction_amount` float NOT NULL,
  `bonus` float NOT NULL,
  `tax_amount` float NOT NULL,
  `net_salary` float NOT NULL,
  PRIMARY KEY (`transactionid`),
  KEY `empid` (`empid`),
  KEY `paygradeid` (`paygradeid`),
  KEY `acc_id` (`acc_id`),
  CONSTRAINT `updated_paygrade_salary_archives_ibfk_1` FOREIGN KEY (`empid`) REFERENCES `employee_archives` (`empid`),
  CONSTRAINT `updated_paygrade_salary_archives_ibfk_2` FOREIGN KEY (`paygradeid`) REFERENCES `updated_and_deleted_paygrade` (`paygradeid`),
  CONSTRAINT `updated_paygrade_salary_archives_ibfk_3` FOREIGN KEY (`acc_id`) REFERENCES `account_archives` (`acc_id`),
  CONSTRAINT `updated_paygrade_salary_archives_chk_1` CHECK ((`leaves` >= 0)),
  CONSTRAINT `updated_paygrade_salary_archives_chk_2` CHECK ((`leave_reduction_amount` >= 0)),
  CONSTRAINT `updated_paygrade_salary_archives_chk_3` CHECK ((`bonus` >= 0)),
  CONSTRAINT `updated_paygrade_salary_archives_chk_4` CHECK ((`tax_amount` >= 0)),
  CONSTRAINT `updated_paygrade_salary_archives_chk_5` CHECK ((`net_salary` >= 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `updated_paygrade_salary_archives`
--

LOCK TABLES `updated_paygrade_salary_archives` WRITE;
/*!40000 ALTER TABLE `updated_paygrade_salary_archives` DISABLE KEYS */;
/*!40000 ALTER TABLE `updated_paygrade_salary_archives` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `updated_paygrade_salary_invoices`
--

DROP TABLE IF EXISTS `updated_paygrade_salary_invoices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `updated_paygrade_salary_invoices` (
  `transactionid` int NOT NULL,
  `empid` int NOT NULL,
  `paygradeid` int NOT NULL,
  `acc_id` int NOT NULL,
  `date` date NOT NULL,
  `leaves` int NOT NULL,
  `leave_reduction_amount` float NOT NULL,
  `bonus` float NOT NULL,
  `tax_amount` float NOT NULL,
  `net_salary` float NOT NULL,
  PRIMARY KEY (`transactionid`),
  KEY `empid` (`empid`),
  KEY `paygradeid` (`paygradeid`),
  KEY `acc_id` (`acc_id`),
  CONSTRAINT `updated_paygrade_salary_invoices_ibfk_1` FOREIGN KEY (`empid`) REFERENCES `employee` (`empid`),
  CONSTRAINT `updated_paygrade_salary_invoices_ibfk_2` FOREIGN KEY (`paygradeid`) REFERENCES `updated_and_deleted_paygrade` (`paygradeid`),
  CONSTRAINT `updated_paygrade_salary_invoices_ibfk_3` FOREIGN KEY (`acc_id`) REFERENCES `account` (`acc_id`),
  CONSTRAINT `updated_paygrade_salary_invoices_chk_1` CHECK ((`leaves` >= 0)),
  CONSTRAINT `updated_paygrade_salary_invoices_chk_2` CHECK ((`leave_reduction_amount` >= 0)),
  CONSTRAINT `updated_paygrade_salary_invoices_chk_3` CHECK ((`bonus` >= 0)),
  CONSTRAINT `updated_paygrade_salary_invoices_chk_4` CHECK ((`tax_amount` >= 0)),
  CONSTRAINT `updated_paygrade_salary_invoices_chk_5` CHECK ((`net_salary` >= 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `updated_paygrade_salary_invoices`
--

LOCK TABLES `updated_paygrade_salary_invoices` WRITE;
/*!40000 ALTER TABLE `updated_paygrade_salary_invoices` DISABLE KEYS */;
/*!40000 ALTER TABLE `updated_paygrade_salary_invoices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userid` varchar(20) NOT NULL,
  `password` varchar(40) DEFAULT NULL,
  `usertype` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  CONSTRAINT `user_chk_1` CHECK ((`usertype` in (_utf8mb4'admin',_utf8mb4'employee')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('10$1','17005c1048dda67c3f735014f33625dfd0c89d32','employee'),('11$2','0808f4f387948ca6e398f4030e8ee19d74c5883e','employee'),('12$2','4e05d4fa6439a3daf2b853e3df1858d42e861df1','employee'),('13$2','e23e98b3ba8e88821c3d15d8584656069e220db8','employee'),('14$2','55e28fa0e928e7427b2d45301b1953655ec8587d','employee'),('15$2','9974f6dca69a8f974864ba5d1b7ad655ff6db74c','employee'),('16$2','48dba552b48a80df8bfa91f877bcfa029133cdec','employee'),('17$2','c08f0699e04675a0f6d9738502060e5a3e0510e6','employee'),('18$2','5a032830ea6db6e3f7117e2661968e74331f4f3a','employee'),('19$2','7c816708ff015453787c83c4d0c00ddf93357fd3','employee'),('2$1','8be52126a6fde450a7162a3651d589bb51e9579d','employee'),('20$2','afbeceb482e29420c3149552ba94d7ccfa1f058b','employee'),('21$3','a15e28d7c372427140476d1df3dc4ba09c249107','employee'),('22$3','a5836b5921235c50e4e152b9274e9f4fb10905e1','employee'),('23$3','830407804e21a4b5d526ecf452ed4c3d2949f8ec','employee'),('24$3','8c82853fb79f2a3c53d43d6e82b7e5137679a3a2','employee'),('25$3','f78eca20109796e5c2598dac799a7b666e27e36e','employee'),('26$3','475b3681bf2492c2f172940145f06a49204b7556','employee'),('27$3','865c5f6596885147489ce163a02c5386e7220058','employee'),('28$3','9a3f2ec2ef7f50146c2aa44378a405266bcd8dbc','employee'),('29$3','581735c7e588ded7215ec900d1ab1cbe621e1b46','employee'),('3$1','de2a4d5751ab06dc4f987142db57c26d50925c8a','employee'),('30$3','6b85947e4a1efae7514e85dea5820396c6e0c5b6','employee'),('4$1','2db4c1811f424582a90f8d7ee77995cf018d9443','employee'),('6$1','b8de6df1561cd7ab6af36d0cb706b2168b4f4c69','employee'),('7$1','8a337f7233833c6cd96370d64adbd55f49b30db2','employee'),('8$1','2c186a6f0dda5aa237254943899d4fee0ab15dd0','employee'),('9$1','e74e5641aa1bea180e9a50cf7f269e6f0e28e341','employee'),('admin$1','f0578f1e7174b1a41c4ea8c6e17f7a8a3b88c92a','admin'),('admin$2','8be52126a6fde450a7162a3651d589bb51e9579d','admin'),('admin$3','de2a4d5751ab06dc4f987142db57c26d50925c8a','admin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'payrollmanagementdb'
--

--
-- Dumping routines for database 'payrollmanagementdb'
--
/*!50003 DROP FUNCTION IF EXISTS `ex_total_salary_earned` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `ex_total_salary_earned`(emid int) RETURNS float
    DETERMINISTIC
begin

declare total float default 0;

begin
declare current float;
declare finished int default 0;
declare cursor1 cursor for select net_salary from salary_archives where empid=emid;
declare continue handler for not found set finished=1;

open cursor1;
loop1:loop
fetch cursor1 into current;
if finished=1 then 
leave loop1;
end if;

set total=total+current;

end loop loop1;
close cursor1;
end;

begin
declare current float;
declare finished int default 0;
declare cursor2 cursor for select net_salary from updated_paygrade_salary_archives where empid=emid;
declare continue handler for not found set finished=1;

open cursor2;
loop2:loop
fetch cursor2 into current;
if finished=1 then 
leave loop2;
end if;

set total=total+current;

end loop loop2;
close cursor2;
end;

return total;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `get_latest_version` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `get_latest_version`(emp_id int) RETURNS int
    DETERMINISTIC
begin
select version into @ver from latest_accounts_view where empid=emp_id;
return(@ver);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `total_salary_earned` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `total_salary_earned`(emid int) RETURNS float
    DETERMINISTIC
begin

declare total float default 0;

begin
declare current float;
declare finished int default 0;
declare cursor1 cursor for select net_salary from salary_invoices where empid=emid;
declare continue handler for not found set finished=1;

open cursor1;
loop1:loop
fetch cursor1 into current;
if finished=1 then 
leave loop1;
end if;

set total=total+current;

end loop loop1;
close cursor1;
end;

begin
declare current float;
declare finished int default 0;
declare cursor2 cursor for select net_salary from updated_paygrade_salary_invoices where empid=emid;
declare continue handler for not found set finished=1;

open cursor2;
loop2:loop
fetch cursor2 into current;
if finished=1 then 
leave loop2;
end if;

set total=total+current;

end loop loop2;
close cursor2;
end;

return total;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `total_salary_paid` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `total_salary_paid`(org_id int) RETURNS float
    DETERMINISTIC
begin

declare total float default 0;

begin
declare net float;
declare tax float;
declare finished int default 0;
declare cursor1 cursor for select net_salary,tax_amount from salary_invoices natural join employee where orgid=org_id union all select net_salary,tax_amount from updated_paygrade_salary_invoices natural join employee where orgid=org_id;
declare continue handler for not found set finished=1;

open cursor1;
loop1:loop
fetch cursor1 into net,tax;
if finished=1 then 
leave loop1;
end if;

set total=total+net+tax;

end loop loop1;
close cursor1;
end;

begin
declare net float;
declare tax float;
declare finished int default 0;
declare cursor2 cursor for select net_salary,tax_amount from salary_archives natural join employee_archives where orgid=org_id union all select net_salary,tax_amount from updated_paygrade_salary_archives natural join employee_archives where orgid=org_id;
declare continue handler for not found set finished=1;

open cursor2;
loop2:loop
fetch cursor2 into net,tax;
if finished=1 then 
leave loop2;
end if;

set total=total+net+tax;

end loop loop2;
close cursor2;
end;

return total;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `add_employee` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_employee`(in f_name varchar(20), in m_name varchar(20),in l_name varchar(20),in area varchar(30),in city varchar(20),in phone varchar(10),in DOB date,in joindate date,in gender varchar(6),in paygradeid int,in deptid int,in jobtitle varchar(30), in acc_no varchar(20),in bank_code varchar(20),in curr_orgid int)
begin
declare emp_id int;

insert into employee(f_name,m_name,l_name,area,city,phone,DOB,joindate,gender,paygradeid,deptid,orgid,jobtitle,lastpaiddate) values(f_name,m_name,l_name,area,city,phone,DOB,joindate,gender,paygradeid,deptid,curr_orgid,jobtitle,joindate);
set emp_id=Last_insert_id();
insert into account(empid,acc_number,bank_code,version) values(emp_id,acc_no,bank_code,1);

set @userid=concat(emp_id,'$',curr_orgid);
set @pass=concat("pass",emp_id);

SET @UserCreation =CONCAT('CREATE USER "',@userid,'"@"localhost" IDENTIFIED BY "',@pass,'" ');
PREPARE stmt FROM @UserCreation ; EXECUTE stmt; DEALLOCATE PREPARE stmt;

SET @grants=CONCAT('GRANT employee TO "',@userid,'"@"localhost"');
PREPARE stmt FROM @grants ; EXECUTE stmt; DEALLOCATE PREPARE stmt;

insert into user(userid,password,usertype) values (@userid,sha1(@pass),'employee');

select userid from user where userid=@userid;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `calculate_netsalary` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `calculate_netsalary`(in gradeid int,in leaves int,in bonus float,OUT netsalary float,OUT leave_reduction float,OUT tax_amt float)
BEGIN
select base_salary,benefits,tax_percent,leave_reduction_percent,leaves_permitted into @base,@benefits,@taxpercent,@leave_red_per,@leaves_permitted from paygrade where paygradeid=gradeid;
set leave_reduction=case when leaves>@leaves_permitted then @base*(leaves - @leaves_permitted)*(@leave_red_per/100)
else 0
end;
set netsalary=@base+bonus+@benefits-leave_reduction;
set tax_amt=(@taxpercent/100)*netsalary;
set netsalary=netsalary-tax_amt;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pay_salary` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pay_salary`(in emid int,in bonus float,in leaves int)
begin
select paygradeid into @gr from employee where empid=emid;
select acc_id into @acc from latest_accounts_view where empid=emid;

call calculate_netsalary(@gr,leaves,bonus,@net,@leave_red,@tax);

insert into salary_invoices(empid,paygradeid,date,leaves,leave_reduction_amount,bonus,tax_amount,net_salary,acc_id) values (emid,@gr,curdate(),leaves,@leave_red,bonus,@tax,@net,@acc);
update employee set lastpaiddate=ADDDATE(lastpaiddate, INTERVAL 1 month) where empid=emid;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `latest_accounts_view`
--

/*!50001 DROP VIEW IF EXISTS `latest_accounts_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `latest_accounts_view` AS select `a`.`acc_id` AS `acc_id`,`a`.`empid` AS `empid`,`a`.`acc_number` AS `acc_number`,`a`.`bank_code` AS `bank_code`,`a`.`version` AS `version` from `account` `a` where (`a`.`version` = (select max(`account`.`version`) from `account` where (`account`.`empid` = `a`.`empid`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `payable_employees`
--

/*!50001 DROP VIEW IF EXISTS `payable_employees`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `payable_employees` AS select `employee`.`empid` AS `empid`,concat(`employee`.`f_name`,' ',`employee`.`m_name`,' ',`employee`.`l_name`) AS `name`,`employee`.`orgid` AS `orgid` from `employee` where ((to_days(curdate()) - to_days(`employee`.`lastpaiddate`)) >= 30) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-06 15:03:35
