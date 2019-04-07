/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.6.21 : Database - foodiee_soft
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`foodiee_soft` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `foodiee_soft`;

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `active` int(1) DEFAULT '1',
  `created_by` int(11) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `modification_date` date DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

/*Data for the table `customer` */

insert  into `customer`(`customer_id`,`customer_name`,`contact`,`address`,`active`,`created_by`,`created_date`,`modified_by`,`modification_date`) values (1,'Mr Walking',NULL,NULL,1,1,'2018-05-18',NULL,NULL),(2,'Johnson Wick','0331657481','Karachi',1,1,'2018-05-18',1,'2018-07-03'),(3,'Aamir khan','0333245178','Hyderabad',0,1,'2018-05-18',1,'2018-07-07'),(4,'Masood','03025478411','Karachi',1,1,'2018-05-18',NULL,NULL),(5,'Watson','03313325691','Hyderabad',1,1,'2018-05-18',NULL,NULL),(6,'Vijay kumar','03313325692','Hyd',1,1,'2018-05-18',1,'2018-10-07'),(7,'Pardeep','0333144578','London',0,1,'2018-07-29',NULL,NULL),(8,'Ali','03313325691','Hyd',1,1,'2018-10-09',NULL,NULL),(9,'666vmkd','0000000','0000',0,1,'2018-11-05',NULL,NULL),(10,'2544','svvdsvs','dssvsv',0,1,'2018-11-05',NULL,NULL),(11,'16sw7','jhjj','jjj',0,1,'2018-11-05',NULL,NULL),(12,'4432432gf','ffff','kkkk',0,1,'2018-11-05',NULL,NULL),(13,'3d','jjj','jjj',0,1,'2018-11-05',NULL,NULL),(14,'Zeeshan','0300054879','Hyd',1,1,'2018-11-05',NULL,NULL),(15,'Johnny john','03312256941','Karachi',1,1,'2018-11-05',1,'2018-11-05'),(16,'Xoni s','03315555','Lahore',1,1,'2018-11-05',20,'2019-01-30'),(17,'Ajayl','03332654781','Hyderabad',1,1,'2018-11-05',20,'2019-01-30'),(18,'Alpha','033333333','h',1,20,'2019-01-30',NULL,NULL),(19,'Beta','0300555555','SYA',1,20,'2019-01-30',NULL,NULL),(20,'MM','055545555','Xyz',1,20,'2019-01-30',NULL,NULL);

/*Table structure for table `discount` */

DROP TABLE IF EXISTS `discount`;

CREATE TABLE `discount` (
  `discount_id` int(11) NOT NULL AUTO_INCREMENT,
  `discount_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`discount_id`),
  CONSTRAINT `discount_ibfk_1` FOREIGN KEY (`discount_id`) REFERENCES `order_table` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `discount` */

insert  into `discount`(`discount_id`,`discount_type`) values (1,'Amount'),(2,'Percentage');

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(255) DEFAULT NULL,
  `contact_num` varchar(255) DEFAULT NULL,
  `salary` decimal(16,4) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `creation_date` date DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `active` int(1) DEFAULT '1',
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `employee` */

insert  into `employee`(`employee_id`,`emp_name`,`contact_num`,`salary`,`created_by`,`creation_date`,`modified_by`,`designation`,`active`) values (1,'Vijay xoni','033133256911',34550.0000,'1','2018-07-02',20,'Manager',1),(2,'Johnson','03204578410',14000.0000,'1','2018-07-02',NULL,'Waiter ',0),(3,'John','03315548899',0.0000,'1','2018-07-01',20,'Waiter',1),(4,'Watson','0320458741',14000.0000,'1','2018-07-04',NULL,'Waiter',1),(5,'John wick','0215784425',14000.0000,'1','2018-07-06',1,'Waiter',0),(6,'Dishan','05145558799',50000.0000,'1','2018-07-10',1,'CFO',1),(7,'Johnny ','02154787444',14000.0000,'1','2018-07-17',20,'Waiter',1),(8,'Tom C','030254788',555.5000,'1','2018-11-09',20,'Salesman',0),(9,'Omer ','03312253666',50000.0000,'20','2019-01-06',20,'Employee',1);

/*Table structure for table `food_category` */

DROP TABLE IF EXISTS `food_category`;

CREATE TABLE `food_category` (
  `food_cat_id` int(11) NOT NULL AUTO_INCREMENT,
  `food_name` varchar(255) DEFAULT NULL,
  `active` int(1) DEFAULT '1',
  `created_by` int(11) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `modification_date` date DEFAULT NULL,
  PRIMARY KEY (`food_cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `food_category` */

insert  into `food_category`(`food_cat_id`,`food_name`,`active`,`created_by`,`created_date`,`modified_by`,`modification_date`) values (1,'Sweets',1,1,'2018-04-19',1,'2018-07-07'),(2,'Pizza',1,1,'2018-04-19',NULL,NULL),(3,'Briyani 1kg',1,1,'2018-04-19',1,'2018-07-03'),(4,'Cold Drink',1,1,'2018-04-19',20,'2019-01-27'),(5,'Ice Cream',1,1,'2018-04-20',NULL,NULL),(6,'Fast Food',1,1,'2018-04-21',NULL,NULL),(7,'Juice',0,1,'2018-06-07',NULL,NULL),(8,'Burger',1,1,'2018-11-06',1,'2018-11-06'),(9,'Handi',1,20,'2019-01-27',NULL,NULL);

/*Table structure for table `inventroy` */

DROP TABLE IF EXISTS `inventroy`;

CREATE TABLE `inventroy` (
  `inventory_id` int(11) NOT NULL AUTO_INCREMENT,
  `inventory_name` varchar(255) DEFAULT NULL,
  `cost` decimal(16,4) DEFAULT NULL,
  `active` int(1) DEFAULT '1',
  `created_date` date DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`inventory_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `inventroy` */

/*Table structure for table `order_details` */

DROP TABLE IF EXISTS `order_details`;

CREATE TABLE `order_details` (
  `order_details_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `order_status` varchar(255) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `total_price` double(16,4) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `active` int(1) DEFAULT '1',
  `created_by` int(11) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `modification_date` date DEFAULT NULL,
  PRIMARY KEY (`order_details_id`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `order_details_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=195 DEFAULT CHARSET=latin1;

/*Data for the table `order_details` */

insert  into `order_details`(`order_details_id`,`order_id`,`customer_id`,`order_status`,`product_id`,`total_price`,`quantity`,`active`,`created_by`,`created_date`,`modified_by`,`modification_date`) values (1,1,2,NULL,3,240.0000,2,1,1,'2018-07-07',NULL,NULL),(2,2,3,NULL,3,240.0000,2,1,1,'2018-07-07',NULL,NULL),(3,3,3,NULL,3,120.0000,1,1,1,'2017-04-07',NULL,NULL),(4,3,3,NULL,4,90.0000,1,1,1,'2017-04-07',NULL,NULL),(5,4,1,NULL,1,750.0000,5,1,1,'2018-06-15',NULL,NULL),(6,5,2,NULL,5,600.0000,4,1,1,'2018-07-12',NULL,NULL),(7,5,2,NULL,9,60.0000,2,1,1,'2018-07-12',NULL,NULL),(8,5,2,NULL,10,480.0000,4,1,1,'2018-07-12',NULL,NULL),(9,5,2,NULL,7,100.0000,2,1,1,'2018-07-12',NULL,NULL),(10,5,2,NULL,5,150.0000,1,1,1,'2018-07-12',NULL,NULL),(11,5,2,NULL,2,9093.0000,7,1,1,'2018-07-12',NULL,NULL),(12,6,1,NULL,4,180.0000,2,1,1,'2018-07-12',NULL,NULL),(13,7,4,NULL,3,120.0000,1,1,1,'2018-07-12',NULL,NULL),(14,7,4,NULL,7,50.0000,1,1,1,'2018-07-12',NULL,NULL),(15,8,1,NULL,1,150.0000,1,1,1,'2018-07-13',NULL,NULL),(16,8,1,NULL,3,120.0000,1,1,1,'2018-07-13',NULL,NULL),(17,9,1,NULL,2,2598.0000,2,1,1,'2018-07-13',NULL,NULL),(18,10,6,NULL,3,120.0000,1,1,1,'2018-07-13',NULL,NULL),(19,10,6,NULL,4,90.0000,1,1,1,'2018-07-13',NULL,NULL),(20,11,4,NULL,1,150.0000,1,1,1,'2018-07-13',NULL,NULL),(21,12,1,NULL,6,150.0000,1,1,1,'2018-07-13',NULL,NULL),(22,13,2,NULL,1,150.0000,1,1,1,'2018-07-13',NULL,NULL),(23,14,6,NULL,4,180.0000,2,1,1,'2018-07-13',NULL,NULL),(24,14,6,NULL,7,50.0000,1,1,1,'2018-07-13',NULL,NULL),(25,14,6,NULL,2,1299.0000,1,1,1,'2018-07-13',NULL,NULL),(26,14,6,NULL,11,1199.0000,1,1,1,'2018-07-13',NULL,NULL),(27,15,3,NULL,1,750.0000,5,1,1,'2018-07-13',NULL,NULL),(28,15,3,NULL,6,150.0000,1,1,1,'2018-07-13',NULL,NULL),(29,15,3,NULL,11,1199.0000,1,1,1,'2018-07-13',NULL,NULL),(30,16,2,NULL,2,1299.0000,1,1,1,'2018-07-13',NULL,NULL),(31,16,2,NULL,5,150.0000,1,1,1,'2018-07-13',NULL,NULL),(32,16,2,NULL,9,30.0000,1,1,1,'2018-07-13',NULL,NULL),(33,16,2,NULL,11,1199.0000,1,1,1,'2018-07-13',NULL,NULL),(34,16,2,NULL,4,90.0000,1,1,1,'2018-07-13',NULL,NULL),(35,17,5,NULL,2,1299.0000,1,1,1,'2018-07-13',NULL,NULL),(36,17,5,NULL,3,120.0000,1,1,1,'2018-07-13',NULL,NULL),(37,17,5,NULL,5,150.0000,1,1,1,'2018-07-13',NULL,NULL),(38,17,5,NULL,7,50.0000,1,1,1,'2018-07-13',NULL,NULL),(39,17,5,NULL,9,30.0000,1,1,1,'2018-07-13',NULL,NULL),(40,17,5,NULL,11,1199.0000,1,1,1,'2018-07-13',NULL,NULL),(41,18,1,NULL,4,90.0000,1,1,1,'2018-07-13',NULL,NULL),(42,19,1,NULL,5,150.0000,1,1,1,'2018-07-13',NULL,NULL),(43,19,1,NULL,7,50.0000,1,1,1,'2018-07-13',NULL,NULL),(44,19,1,NULL,10,120.0000,1,1,1,'2018-07-13',NULL,NULL),(45,19,1,NULL,1,150.0000,1,1,1,'2018-07-13',NULL,NULL),(46,19,1,NULL,2,1299.0000,1,1,1,'2018-07-13',NULL,NULL),(47,19,1,NULL,3,120.0000,1,1,1,'2018-07-13',NULL,NULL),(48,19,1,NULL,7,50.0000,1,1,1,'2018-07-13',NULL,NULL),(49,19,1,NULL,10,120.0000,1,1,1,'2018-07-13',NULL,NULL),(50,19,1,NULL,4,90.0000,1,1,1,'2018-07-13',NULL,NULL),(51,20,5,NULL,1,150.0000,1,1,1,'2018-07-14',NULL,NULL),(52,20,5,NULL,2,1299.0000,1,1,1,'2018-07-14',NULL,NULL),(53,20,5,NULL,3,120.0000,1,1,1,'2018-07-14',NULL,NULL),(54,20,5,NULL,4,90.0000,1,1,1,'2018-07-14',NULL,NULL),(55,20,5,NULL,5,150.0000,1,1,1,'2018-07-14',NULL,NULL),(56,20,5,NULL,6,150.0000,1,1,1,'2018-07-14',NULL,NULL),(57,20,5,NULL,7,50.0000,1,1,1,'2018-07-14',NULL,NULL),(58,20,5,NULL,9,30.0000,1,1,1,'2018-07-14',NULL,NULL),(59,20,5,NULL,10,120.0000,1,1,1,'2018-07-14',NULL,NULL),(60,20,5,NULL,11,1199.0000,1,1,1,'2018-07-14',NULL,NULL),(61,21,5,NULL,1,600.0000,4,1,1,'2018-07-14',NULL,NULL),(62,21,5,NULL,2,3897.0000,3,1,1,'2018-07-14',NULL,NULL),(63,21,5,NULL,6,150.0000,1,1,1,'2018-07-14',NULL,NULL),(64,21,5,NULL,9,90.0000,3,1,1,'2018-07-14',NULL,NULL),(65,21,5,NULL,11,1199.0000,1,1,1,'2018-07-14',NULL,NULL),(66,21,5,NULL,4,90.0000,1,1,1,'2018-07-14',NULL,NULL),(67,21,5,NULL,3,120.0000,1,1,1,'2018-07-14',NULL,NULL),(68,21,5,NULL,5,150.0000,1,1,1,'2018-07-14',NULL,NULL),(69,22,1,NULL,1,150.0000,1,1,1,'2018-07-16',NULL,NULL),(70,22,1,NULL,2,1299.0000,1,1,1,'2018-07-16',NULL,NULL),(71,22,1,NULL,3,120.0000,1,1,1,'2018-07-16',NULL,NULL),(72,22,1,NULL,4,90.0000,1,1,1,'2018-07-16',NULL,NULL),(73,22,1,NULL,5,150.0000,1,1,1,'2018-07-16',NULL,NULL),(74,22,1,NULL,9,30.0000,1,1,1,'2018-07-16',NULL,NULL),(75,22,1,NULL,12,150.0000,1,1,1,'2018-07-16',NULL,NULL),(76,23,1,NULL,1,750.0000,5,1,1,'2018-07-16',NULL,NULL),(77,23,1,NULL,2,3897.0000,3,1,1,'2018-07-16',NULL,NULL),(78,23,1,NULL,5,450.0000,3,1,1,'2018-07-16',NULL,NULL),(79,23,1,NULL,9,30.0000,1,1,1,'2018-07-16',NULL,NULL),(80,24,2,NULL,1,150.0000,1,1,1,'2018-07-16',NULL,NULL),(81,25,1,NULL,2,1299.0000,1,1,1,'2018-07-21',NULL,NULL),(82,26,1,NULL,5,150.0000,1,1,1,'2018-07-21',NULL,NULL),(83,27,1,NULL,2,1299.0000,1,1,1,'2018-07-21',NULL,NULL),(84,29,1,NULL,4,90.0000,1,1,1,'2018-07-21',NULL,NULL),(85,30,1,NULL,4,90.0000,1,1,1,'2018-07-21',NULL,NULL),(86,31,1,NULL,9,30.0000,1,1,1,'2018-07-21',NULL,NULL),(87,33,1,NULL,5,150.0000,1,1,1,'2018-07-21',NULL,NULL),(88,34,1,NULL,4,90.0000,1,1,1,'2018-07-21',NULL,NULL),(89,35,1,NULL,4,90.0000,1,1,1,'2018-07-21',NULL,NULL),(90,37,1,NULL,9,30.0000,1,1,1,'2018-07-21',NULL,NULL),(91,39,1,NULL,2,1299.0000,1,1,1,'2018-07-21',NULL,NULL),(92,40,1,NULL,11,1199.0000,1,1,1,'2018-07-21',NULL,NULL),(93,41,1,NULL,6,150.0000,1,1,1,'2018-07-21',NULL,NULL),(94,42,1,NULL,9,30.0000,1,1,1,'2018-07-21',NULL,NULL),(95,43,1,NULL,6,150.0000,1,1,1,'2018-07-21',NULL,NULL),(96,44,1,NULL,4,90.0000,1,1,1,'2018-07-21',NULL,NULL),(97,45,1,NULL,11,1199.0000,1,1,1,'2018-07-21',NULL,NULL),(98,45,1,NULL,5,150.0000,1,1,1,'2018-07-21',NULL,NULL),(99,46,1,NULL,12,150.0000,1,1,1,'2018-07-21',NULL,NULL),(100,46,1,NULL,11,1199.0000,1,1,1,'2018-07-21',NULL,NULL),(101,46,1,NULL,4,90.0000,1,1,1,'2018-07-21',NULL,NULL),(102,46,1,NULL,2,1299.0000,1,1,1,'2018-07-21',NULL,NULL),(103,47,1,NULL,6,150.0000,1,1,1,'2018-08-03',NULL,NULL),(104,47,1,NULL,2,1299.0000,1,1,1,'2018-08-03',NULL,NULL),(105,48,1,NULL,6,150.0000,1,1,1,'2018-08-03',NULL,NULL),(106,48,1,NULL,2,1299.0000,1,1,1,'2018-08-03',NULL,NULL),(107,49,1,NULL,6,150.0000,1,1,1,'2018-08-03',NULL,NULL),(108,49,1,NULL,2,1299.0000,1,1,1,'2018-08-03',NULL,NULL),(109,50,1,NULL,6,150.0000,1,1,1,'2018-08-03',NULL,NULL),(110,50,1,NULL,2,1299.0000,1,1,1,'2018-08-03',NULL,NULL),(111,51,1,NULL,5,150.0000,1,1,1,'2018-08-03',NULL,NULL),(112,51,1,NULL,10,120.0000,1,1,1,'2018-08-03',NULL,NULL),(113,52,1,NULL,11,1199.0000,1,1,1,'2018-08-03',NULL,NULL),(114,52,1,NULL,4,90.0000,1,1,1,'2018-08-03',NULL,NULL),(115,53,1,NULL,4,90.0000,1,1,1,'2018-08-03',NULL,NULL),(116,53,1,NULL,5,150.0000,1,1,1,'2018-08-03',NULL,NULL),(117,54,1,NULL,5,150.0000,1,1,1,'2018-08-03',NULL,NULL),(118,54,1,NULL,4,90.0000,1,1,1,'2018-08-03',NULL,NULL),(119,55,1,NULL,4,90.0000,1,1,1,'2018-08-03',NULL,NULL),(120,56,1,NULL,4,90.0000,1,1,1,'2018-08-03',NULL,NULL),(121,57,1,NULL,4,90.0000,1,1,1,'2018-08-03',NULL,NULL),(122,57,1,NULL,5,150.0000,1,1,1,'2018-08-03',NULL,NULL),(123,57,1,NULL,10,120.0000,1,1,1,'2018-08-03',NULL,NULL),(124,57,1,NULL,12,150.0000,1,1,1,'2018-08-03',NULL,NULL),(125,58,1,NULL,4,90.0000,1,1,1,'2018-08-03',NULL,NULL),(126,58,1,NULL,5,150.0000,1,1,1,'2018-08-03',NULL,NULL),(127,58,1,NULL,12,150.0000,1,1,1,'2018-08-03',NULL,NULL),(128,58,1,NULL,1,150.0000,1,1,1,'2018-08-03',NULL,NULL),(129,58,1,NULL,10,120.0000,1,1,1,'2018-08-03',NULL,NULL),(130,59,1,NULL,4,90.0000,1,1,1,'2018-08-03',NULL,NULL),(131,59,1,NULL,4,90.0000,1,1,1,'2018-08-03',NULL,NULL),(132,59,1,NULL,6,600.0000,4,1,1,'2018-08-03',NULL,NULL),(133,60,1,NULL,1,150.0000,1,1,1,'2018-08-03',NULL,NULL),(134,60,1,NULL,5,150.0000,1,1,1,'2018-08-03',NULL,NULL),(135,60,1,NULL,4,90.0000,1,1,1,'2018-08-03',NULL,NULL),(136,60,1,NULL,10,360.0000,3,1,1,'2018-08-03',NULL,NULL),(137,61,1,NULL,4,90.0000,1,1,1,'2018-08-03',NULL,NULL),(138,61,1,NULL,10,120.0000,1,1,1,'2018-08-03',NULL,NULL),(139,62,5,NULL,10,120.0000,1,1,1,'2018-08-03',NULL,NULL),(140,62,5,NULL,12,150.0000,1,1,1,'2018-08-03',NULL,NULL),(141,63,1,NULL,4,90.0000,1,1,1,'2018-08-03',NULL,NULL),(142,64,1,NULL,5,150.0000,1,1,1,'2018-08-03',NULL,NULL),(143,64,1,NULL,4,90.0000,1,1,1,'2018-08-03',NULL,NULL),(144,65,1,NULL,3,120.0000,1,1,1,'2018-08-03',NULL,NULL),(145,65,1,NULL,4,90.0000,1,1,1,'2018-08-03',NULL,NULL),(146,65,1,NULL,6,600.0000,4,1,1,'2018-08-03',NULL,NULL),(147,66,1,NULL,2,1299.0000,1,1,1,'2018-08-03',NULL,NULL),(148,67,1,NULL,5,150.0000,1,1,1,'2018-08-03',NULL,NULL),(149,68,1,NULL,4,90.0000,1,1,1,'2018-08-03',NULL,NULL),(150,69,1,NULL,4,90.0000,1,1,1,'2018-08-03',NULL,NULL),(151,70,1,NULL,4,90.0000,1,1,1,'2018-08-03',NULL,NULL),(152,70,1,NULL,6,150.0000,1,1,1,'2018-08-03',NULL,NULL),(153,70,1,NULL,11,1199.0000,1,1,1,'2018-08-03',NULL,NULL),(154,71,1,NULL,4,270.0000,3,1,1,'2018-08-03',NULL,NULL),(155,71,1,NULL,10,120.0000,1,1,1,'2018-08-03',NULL,NULL),(156,72,1,NULL,4,90.0000,1,1,1,'2018-08-03',NULL,NULL),(157,72,1,NULL,4,180.0000,2,1,1,'2018-08-03',NULL,NULL),(158,72,1,NULL,6,150.0000,1,1,1,'2018-08-03',NULL,NULL),(159,72,1,NULL,10,120.0000,1,1,1,'2018-08-03',NULL,NULL),(160,72,1,NULL,11,1199.0000,1,1,1,'2018-08-03',NULL,NULL),(161,72,1,NULL,1,150.0000,1,1,1,'2018-08-03',NULL,NULL),(162,73,6,NULL,1,300.0000,2,1,1,'2018-08-03',NULL,NULL),(163,74,6,NULL,1,150.0000,1,1,1,'2018-08-03',NULL,NULL),(164,74,6,NULL,2,3897.0000,3,1,1,'2018-08-03',NULL,NULL),(165,74,6,NULL,3,120.0000,1,1,1,'2018-08-03',NULL,NULL),(166,74,6,NULL,6,150.0000,1,1,1,'2018-08-03',NULL,NULL),(167,74,6,NULL,11,1199.0000,1,1,1,'2018-08-03',NULL,NULL),(168,75,1,NULL,4,90.0000,1,1,1,'2018-08-03',NULL,NULL),(169,76,3,NULL,4,90.0000,1,1,1,'2018-08-03',NULL,NULL),(170,77,1,NULL,5,150.0000,1,1,1,'2018-08-03',NULL,NULL),(171,78,1,NULL,5,150.0000,1,1,1,'2018-08-04',NULL,NULL),(172,79,1,NULL,2,1299.0000,1,1,1,'2018-08-08',NULL,NULL),(173,80,1,NULL,2,1299.0000,1,1,1,'2018-08-08',NULL,NULL),(174,81,1,NULL,5,150.0000,1,1,1,'2018-08-09',NULL,NULL),(175,81,1,NULL,4,90.0000,1,1,1,'2018-08-09',NULL,NULL),(176,81,1,NULL,2,1299.0000,1,1,1,'2018-08-09',NULL,NULL),(177,82,1,NULL,6,150.0000,1,1,1,'2018-08-15',NULL,NULL),(178,83,3,NULL,6,150.0000,1,1,1,'2018-08-16',NULL,NULL),(179,84,1,NULL,3,120.0000,1,1,1,'2018-08-16',NULL,NULL),(180,85,1,NULL,5,150.0000,1,1,1,'2018-08-16',NULL,NULL),(181,86,5,NULL,4,90.0000,1,1,1,'2018-08-16',NULL,NULL),(182,87,1,NULL,2,1299.0000,1,1,1,'2018-08-16',NULL,NULL),(183,87,1,NULL,3,120.0000,1,1,1,'2018-08-16',NULL,NULL),(184,88,1,NULL,2,1299.0000,1,1,1,'2018-08-16',NULL,NULL),(185,89,1,NULL,1,150.0000,1,1,1,'2018-08-16',NULL,NULL),(186,90,1,NULL,6,150.0000,1,1,1,'2018-08-16',NULL,NULL),(187,91,1,NULL,1,150.0000,1,1,1,'2018-08-16',NULL,NULL),(188,91,1,NULL,2,1299.0000,1,1,1,'2018-08-16',NULL,NULL),(189,92,1,NULL,2,1299.0000,1,1,1,'2018-10-07',NULL,NULL),(190,93,6,NULL,3,120.0000,1,1,1,'2018-10-09',NULL,NULL),(191,94,2,NULL,1,150.0000,1,1,1,'2018-11-11',NULL,NULL),(192,95,1,NULL,1,150.0000,1,1,20,'2018-12-23',NULL,NULL),(193,96,1,NULL,16,600.0000,1,1,20,'2019-03-18',NULL,NULL),(194,96,1,NULL,13,590.0000,1,1,20,'2019-03-18',NULL,NULL);

/*Table structure for table `order_table` */

DROP TABLE IF EXISTS `order_table`;

CREATE TABLE `order_table` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `order_status` varchar(255) DEFAULT NULL,
  `active` int(1) DEFAULT '1',
  `created_by` int(11) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `modification_date` date DEFAULT NULL,
  `discount_id` int(11) DEFAULT NULL,
  `discount` int(11) DEFAULT NULL,
  `total_bill` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `order_table_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=latin1;

/*Data for the table `order_table` */

insert  into `order_table`(`order_id`,`customer_id`,`customer_name`,`number`,`order_status`,`active`,`created_by`,`created_date`,`modified_by`,`modification_date`,`discount_id`,`discount`,`total_bill`) values (1,2,NULL,5255,'dispatched',1,1,'2018-07-07',NULL,NULL,1,0,240),(2,3,NULL,1878,'dispatched',1,1,'2018-07-07',NULL,NULL,1,0,240),(3,3,NULL,9796,'dispatched',1,1,'2017-04-07',NULL,NULL,1,0,210),(4,1,NULL,3892,'dispatched',1,1,'2018-06-15',NULL,NULL,1,0,750),(5,2,NULL,5986,'dispatched',1,1,'2018-07-12',NULL,NULL,1,0,10483),(6,1,NULL,6940,'dispatched',1,1,'2018-07-12',NULL,NULL,1,0,180),(7,4,NULL,5693,'dispatched',1,1,'2018-07-12',NULL,NULL,1,0,170),(8,1,NULL,7117,'dispatched',1,1,'2018-07-13',NULL,NULL,1,0,270),(9,1,NULL,1043,'dispatched',1,1,'2018-07-13',NULL,NULL,1,0,2598),(10,6,NULL,8060,'dispatched',1,1,'2018-07-13',NULL,NULL,1,0,210),(11,4,NULL,8492,'dispatched',1,1,'2018-07-13',NULL,NULL,1,0,150),(12,1,NULL,9730,'dispatched',1,1,'2018-07-13',NULL,NULL,1,0,150),(13,2,NULL,7835,'dispatched',1,1,'2018-07-13',NULL,NULL,1,0,150),(14,6,NULL,9474,'dispatched',1,1,'2018-07-13',NULL,NULL,1,100,2628),(15,3,NULL,8987,'dispatched',1,1,'2018-07-13',NULL,NULL,1,100,1999),(16,2,NULL,7405,'dispatched',1,1,'2018-07-13',NULL,NULL,1,0,2768),(17,5,NULL,3134,'dispatched',1,1,'2018-07-13',NULL,NULL,1,10,2838),(18,1,NULL,5319,'dispatched',1,1,'2018-07-13',NULL,NULL,1,0,90),(19,1,NULL,2365,'dispatched',1,1,'2018-07-13',NULL,NULL,1,0,2149),(20,5,NULL,5304,'dispatched',1,1,'2018-07-14',NULL,NULL,1,0,3358),(21,5,NULL,482,'dispatched',1,1,'2018-07-14',NULL,NULL,1,0,6296),(22,1,NULL,4990,'dispatched',1,1,'2018-07-16',NULL,NULL,1,0,1989),(23,1,NULL,2294,'dispatched',1,1,'2018-07-16',NULL,NULL,1,0,5127),(24,2,NULL,4256,'dispatched',0,1,'2018-07-16',NULL,NULL,1,0,150),(25,1,NULL,8759,'dispatched',1,1,'2018-07-21',NULL,NULL,1,0,1299),(26,1,NULL,4850,'dispatched',1,1,'2018-07-21',NULL,NULL,1,0,150),(27,1,NULL,5302,'dispatched',1,1,'2018-07-21',NULL,NULL,1,0,1299),(28,1,NULL,4269,'dispatched',1,1,'2018-07-21',NULL,NULL,1,0,0),(29,1,NULL,626,'dispatched',1,1,'2018-07-21',NULL,NULL,1,0,90),(30,1,NULL,4679,'dispatched',1,1,'2018-07-21',NULL,NULL,1,0,90),(31,1,NULL,6042,'dispatched',1,1,'2018-07-21',NULL,NULL,1,0,30),(32,1,NULL,9087,'dispatched',1,1,'2018-07-21',NULL,NULL,1,0,0),(33,1,NULL,1077,'dispatched',1,1,'2018-07-21',NULL,NULL,1,0,150),(34,1,NULL,2786,'dispatched',1,1,'2018-07-21',NULL,NULL,1,0,90),(35,1,NULL,9890,'dispatched',1,1,'2018-07-21',NULL,NULL,1,0,90),(36,1,NULL,2816,'dispatched',1,1,'2018-07-21',NULL,NULL,1,0,0),(37,1,NULL,8038,'dispatched',1,1,'2018-07-21',NULL,NULL,1,0,30),(38,1,NULL,5303,'dispatched',1,1,'2018-07-21',NULL,NULL,1,0,0),(39,1,NULL,4499,'dispatched',1,1,'2018-07-21',NULL,NULL,1,0,1299),(40,1,NULL,3599,'dispatched',1,1,'2018-07-21',NULL,NULL,1,0,1199),(41,1,NULL,8,'dispatched',1,1,'2018-07-21',NULL,NULL,1,0,150),(42,1,NULL,5825,'dispatched',1,1,'2018-07-21',NULL,NULL,1,0,30),(43,1,NULL,1546,'dispatched',1,1,'2018-07-21',NULL,NULL,1,0,150),(44,1,NULL,8411,'dispatched',1,1,'2018-07-21',NULL,NULL,1,0,90),(45,1,NULL,8227,'dispatched',1,1,'2018-07-21',NULL,NULL,1,0,1349),(46,1,NULL,770,'dispatched',1,1,'2018-07-21',NULL,NULL,1,0,2738),(47,1,NULL,5990,'dispatched',1,1,'2018-08-03',NULL,NULL,1,0,1449),(48,1,NULL,1266,'dispatched',1,1,'2018-08-03',NULL,NULL,1,0,1449),(49,1,NULL,5168,'dispatched',1,1,'2018-08-03',NULL,NULL,1,4,1445),(50,1,NULL,7284,'dispatched',1,1,'2018-08-03',NULL,NULL,1,4,1445),(51,1,NULL,9370,'dispatched',1,1,'2018-08-03',NULL,NULL,1,0,270),(52,1,NULL,4514,'dispatched',1,1,'2018-08-03',NULL,NULL,1,0,1289),(53,1,NULL,9775,'dispatched',1,1,'2018-08-03',NULL,NULL,1,0,240),(54,1,NULL,2382,'dispatched',1,1,'2018-08-03',NULL,NULL,1,0,240),(55,1,NULL,3687,'dispatched',1,1,'2018-08-03',NULL,NULL,1,0,90),(56,1,NULL,2650,'dispatched',1,1,'2018-08-03',NULL,NULL,1,0,90),(57,1,NULL,3990,'dispatched',1,1,'2018-08-03',NULL,NULL,1,0,510),(58,1,NULL,3716,'dispatched',1,1,'2018-08-03',NULL,NULL,1,0,660),(59,1,NULL,8578,'dispatched',1,1,'2018-08-03',NULL,NULL,1,0,780),(60,1,NULL,9510,'dispatched',1,1,'2018-08-03',NULL,NULL,1,0,750),(61,1,NULL,3817,'dispatched',1,1,'2018-08-03',NULL,NULL,1,0,210),(62,5,NULL,9207,'dispatched',1,1,'2018-08-03',NULL,NULL,1,0,270),(63,1,NULL,5199,'dispatched',1,1,'2018-08-03',NULL,NULL,1,0,90),(64,1,NULL,6271,'dispatched',1,1,'2018-08-03',NULL,NULL,1,0,240),(65,1,NULL,6203,'dispatched',1,1,'2018-08-03',NULL,NULL,1,0,810),(66,1,NULL,7902,'dispatched',1,1,'2018-08-03',NULL,NULL,1,0,1299),(67,1,NULL,8167,'dispatched',1,1,'2018-08-03',NULL,NULL,1,0,150),(68,1,NULL,2081,'dispatched',1,1,'2018-08-03',NULL,NULL,1,0,90),(69,1,NULL,9043,'dispatched',1,1,'2018-08-03',NULL,NULL,1,0,90),(70,1,NULL,4745,'dispatched',1,1,'2018-08-03',NULL,NULL,1,0,1439),(71,1,NULL,8138,'dispatched',1,1,'2018-08-03',NULL,NULL,1,0,390),(72,1,NULL,9504,'dispatched',1,1,'2018-08-03',NULL,NULL,1,0,1889),(73,6,NULL,1100,'dispatched',1,1,'2018-08-03',NULL,NULL,1,0,300),(74,6,NULL,2209,'dispatched',1,1,'2018-08-03',NULL,NULL,1,0,5516),(75,1,NULL,5896,'dispatched',1,1,'2018-08-03',NULL,NULL,1,0,90),(76,3,NULL,7640,'dispatched',1,1,'2018-08-03',NULL,NULL,1,0,90),(77,1,NULL,3333,'dispatched',0,1,'2018-08-03',NULL,NULL,1,0,150),(78,1,NULL,1250,'dispatched',1,1,'2018-08-04',NULL,NULL,1,0,150),(79,1,NULL,9751,'dispatched',1,1,'2018-08-08',NULL,NULL,1,0,1299),(80,1,NULL,1453,'dispatched',1,1,'2018-08-08',NULL,NULL,1,0,1299),(81,1,NULL,1781,'dispatched',0,1,'2018-08-09',NULL,NULL,1,0,1539),(82,1,NULL,8235,'Dispatched',1,1,'2018-08-15',NULL,NULL,1,0,150),(83,3,NULL,9444,'dispatched',0,1,'2018-08-16',NULL,NULL,1,0,150),(84,1,NULL,8072,'dispatched',1,1,'2018-08-16',NULL,NULL,1,0,120),(85,1,NULL,5493,'dispatched',1,1,'2018-08-16',NULL,NULL,1,0,150),(86,5,NULL,8012,'Dispatched',1,1,'2018-08-16',NULL,NULL,1,0,90),(87,1,NULL,4015,'Pending',1,1,'2018-08-16',NULL,NULL,1,0,1419),(88,1,NULL,3323,'Dispatched',1,1,'2018-08-16',NULL,NULL,1,0,1299),(89,1,NULL,8127,'Dispatched',1,1,'2018-08-16',NULL,NULL,1,0,150),(90,1,NULL,9395,'Pending',1,1,'2018-08-16',NULL,NULL,1,0,150),(91,1,NULL,5977,'Dispatched',1,1,'2018-08-16',NULL,NULL,1,0,1449),(92,1,NULL,4680,'Dispatched',1,1,'2018-10-07',NULL,NULL,2,50,650),(93,6,NULL,4004,'Dispatched',1,1,'2018-10-09',NULL,NULL,1,0,120),(94,2,NULL,1456,'Dispatched',1,1,'2018-11-11',NULL,NULL,1,50,100),(95,1,NULL,3763,'Dispatched',1,20,'2018-12-23',NULL,NULL,1,0,150),(96,1,'Mr Walking',9721,'Dispatched',1,20,'2019-03-18',NULL,NULL,1,0,1190);

/*Table structure for table `permission` */

DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
  `permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;

/*Data for the table `permission` */

insert  into `permission`(`permission_id`,`name`) values (1,'Add User'),(2,'Update User'),(3,'Delete User'),(5,'Add Customer'),(6,'Update Customer'),(7,'Delete Customer'),(9,'Add User Type'),(10,'Update User Type'),(11,'Delete User Type'),(12,'View User Type'),(13,'Add Product Categories'),(14,'Update Product Categories'),(15,'Delete Product Categories'),(16,'View Product Categories'),(17,'Add Security Question'),(18,'Update Security Question'),(19,'Delete Security Question'),(20,'View Security Question'),(25,'Add Product Stock'),(26,'Delete Product Stock'),(27,'Update Product Stock'),(28,'View Product Stock'),(29,'View Sale Dashboard'),(30,'View Inventory Management'),(31,'View User Management'),(32,'View Sale History'),(33,'View Reports Management'),(34,'View Customer Management'),(36,'View User Privileges'),(37,'View User Accounts'),(38,'Generate Today\'s Sale Report'),(39,'Generate Monthly Sale Report'),(40,'Generate Custom Sale Report'),(41,'View Raw Material'),(42,'Add Raw Material'),(43,'Update Raw Material'),(44,'Delete Raw Material');

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `food_cat_id` int(11) DEFAULT NULL,
  `food_name` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `active` int(1) DEFAULT '1',
  `quantity` int(11) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `modification_date` date DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `food_cat_id` (`food_cat_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`food_cat_id`) REFERENCES `food_category` (`food_cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

/*Data for the table `product` */

insert  into `product`(`product_id`,`food_cat_id`,`food_name`,`price`,`active`,`quantity`,`created_by`,`created_date`,`modified_by`,`modification_date`) values (1,1,'Ice cream Mango ',150,1,39,1,'2018-05-18',1,'2018-07-07'),(2,2,'Large Pizza',1299,1,20,1,'2018-05-18',1,'2018-07-07'),(3,6,'Broast Roll',120,1,43,1,'2018-05-18',1,'2018-05-18'),(4,3,'Chiken Briyani Half Plate',90,1,18,1,'2018-05-18',1,'2018-07-07'),(5,7,'Mango Juice',150,0,50,1,'2018-06-07',1,'2018-06-06'),(6,4,'Apple Juice 200ml',150,1,9,1,'2018-06-07',1,'2018-07-07'),(7,6,'Veg Roll',50,1,0,1,'2018-06-07',1,'2018-07-07'),(8,1,'Regular Pizza',250,0,38,1,'2018-06-07',NULL,NULL),(9,4,'String 250 ml',30,0,0,1,'2018-06-07',NULL,NULL),(10,6,'Zinger                       ',120,1,12,1,'2018-06-07',20,'2019-01-30'),(11,4,'String 300 ml                   ',1199,1,47,1,'2018-07-03',20,'2019-02-23'),(12,6,'Burger',150,0,0,1,'2018-07-16',NULL,NULL),(13,6,'Chiken Handi half              ',590,1,35,1,'2018-11-11',1,'2018-11-11'),(14,5,'Mango Ice Cream ',500,1,10,20,'2019-01-26',NULL,NULL),(15,9,'Full Handi',990,1,15,20,'2019-01-30',NULL,NULL),(16,9,'beta',600,1,9,20,'2019-02-23',20,'2019-02-23');

/*Table structure for table `questions` */

DROP TABLE IF EXISTS `questions`;

CREATE TABLE `questions` (
  `question_id` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(255) DEFAULT NULL,
  `active` int(1) DEFAULT '1',
  `created_by` int(11) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `modification_date` date DEFAULT NULL,
  PRIMARY KEY (`question_id`),
  CONSTRAINT `questions_ibfk_1` FOREIGN KEY (`question_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `questions` */

insert  into `questions`(`question_id`,`question`,`active`,`created_by`,`created_date`,`modified_by`,`modification_date`) values (1,'who is your childhood friend?',1,1,'2018-04-19',1,'2018-07-07'),(2,'who is your favourite pet?',1,1,'2018-04-19',1,'2018-07-07'),(3,'Who is your oldest class mate?',1,1,'2018-04-19',1,'2018-04-21'),(6,'Who is your first friend ? ',0,1,NULL,NULL,NULL),(7,'what ?',1,20,'2019-01-26',20,'2019-01-26'),(8,'Who is ?',1,20,'2019-01-26',20,'2019-01-26'),(9,'?',0,20,'2019-01-26',NULL,NULL);

/*Table structure for table `raw_material` */

DROP TABLE IF EXISTS `raw_material`;

CREATE TABLE `raw_material` (
  `raw_material_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `active` int(1) DEFAULT '1',
  `quantity` int(11) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `modification_date` date DEFAULT NULL,
  PRIMARY KEY (`raw_material_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `raw_material` */

insert  into `raw_material`(`raw_material_id`,`product_name`,`price`,`active`,`quantity`,`created_by`,`created_date`,`modified_by`,`modification_date`) values (1,'xy',5555,0,5,1,'2018-10-13',NULL,NULL),(2,'Xyf',6000,1,5,1,'2018-10-11',0,'2019-01-27'),(3,'ABCD',1200,0,9,1,'2018-10-16',0,'2018-10-07'),(4,'Abb',6000,0,3,1,'2018-10-11',NULL,NULL),(5,'Oil',5000,1,33,20,'2019-01-14',NULL,NULL);

/*Table structure for table `table_detail` */

DROP TABLE IF EXISTS `table_detail`;

CREATE TABLE `table_detail` (
  `table_id` int(11) NOT NULL AUTO_INCREMENT,
  `table_details` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`table_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `table_detail` */

/*Table structure for table `table_reservation` */

DROP TABLE IF EXISTS `table_reservation`;

CREATE TABLE `table_reservation` (
  `table_reserv_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) DEFAULT NULL,
  `party_type` varchar(255) DEFAULT NULL,
  `reservation_date` date DEFAULT NULL,
  `check_in_time` varchar(255) DEFAULT NULL,
  `party_size` int(11) DEFAULT NULL,
  `active` int(1) DEFAULT '1',
  PRIMARY KEY (`table_reserv_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

/*Data for the table `table_reservation` */

insert  into `table_reservation`(`table_reserv_id`,`customer_id`,`party_type`,`reservation_date`,`check_in_time`,`party_size`,`active`) values (1,6,'Family Dinner','2018-10-18','04:03 PM',3,0),(2,8,'Marriage Party','2018-10-25','03:00 AM',12,0),(3,8,'Office Dinner','2018-10-19','08:00 PM',4,1),(4,6,'Office Dinner','2018-10-31','08:00 PM',9,1),(5,4,'Family Lunch','2018-10-19','02:0 AM',2,0),(6,5,'Birthday party','2018-10-27','06:00 PM',2,1),(7,6,'Family Lunch','2018-10-03','04:01 PM',5,1),(8,2,'Family Lunch','2018-11-10','03:01 PM',2,1),(9,6,'Family Lunch','2018-11-11','03:00 PM',2,1),(10,17,'Office Lunch','2019-01-02','01:00 PM',4,1),(11,16,'Office Lunch','2019-02-14','01:00 AM',2,1),(12,16,'Office Lunch','2019-02-07','02:00 PM',2,1);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_cat_id` int(11) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `contact_num` varchar(255) DEFAULT NULL,
  `question_id` int(11) DEFAULT NULL,
  `answer` varchar(255) DEFAULT NULL,
  `active` int(1) DEFAULT '1',
  `created_by` int(11) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `modification_date` date DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_cat_id`,`user_name`,`password`,`name`,`address`,`contact_num`,`question_id`,`answer`,`active`,`created_by`,`created_date`,`modified_by`,`modification_date`) values (1,1,'admin','admin','Vijay Kumar','Hyderabad','03313325691',1,'ALi ',1,NULL,NULL,20,'2019-03-05'),(2,3,'Ali','ali','Ali Raza','Karachi','03332587478',2,'Cat',1,1,'2018-04-20',1,'2018-04-21'),(3,2,'Humza Ali','humza','Humza Ali','Hyderabad','03313325691',1,'Azam',1,1,'2018-04-21',4,'2018-04-21'),(4,1,'M Saad','saad','Saad Jatt','Hyderabad','03332547878',1,'ans',1,1,'2018-04-21',1,'2018-04-21'),(5,1,'KashifAli12','kk','Kashif ALi','hyd','033133325691',1,'Ali',1,1,'2018-04-21',NULL,NULL),(6,1,'Raza','raza','Raza Khan','','03336554789',1,'',1,1,'2018-04-21',NULL,NULL),(7,2,'sadquat Ali  allii','123','Sadaquat Ali Ruk','Hyderabad','03312541789',2,'Vijay',1,1,'2018-05-05',1,'2018-06-07'),(8,3,'M Saad','saad','Saad Jatt','Hyderabad','03022514154',1,'Ali',1,2,'2018-05-06',2,'2018-05-06'),(9,3,'aK','AK','aLI A','HYD','0331332569',2,'DOG',1,1,'2018-05-06',NULL,NULL),(10,4,'ab','ab','Ali Raza','Hyd','03313325691',1,'Saad',1,1,'2018-06-05',NULL,NULL),(11,5,'Masoodjj','masood','Masood','Hyderbad','03028741678',1,'Ali',1,1,'2018-06-07',NULL,NULL),(12,3,'AliRaza','AliRaza','Ali','','',1,'',1,1,'2018-07-03',NULL,NULL),(13,2,'Vijay','vksoni','Vijay kumar xoni','','',1,'',1,1,'2018-07-10',1,'2018-07-13'),(14,7,'Johnson','john','John','','',1,'',1,1,'2018-07-16',NULL,NULL),(15,3,'Omair','xoni','Omair khan','Hyd','03316666555',1,'Vijay',1,1,'2018-10-09',NULL,NULL),(16,9,'AliRaza','AliRaza','AliRaza','3','03333',1,'',1,1,'2018-10-26',NULL,NULL),(17,2,'#d','vk','SD3','Hyd','554',1,'Ali',1,1,'2018-11-05',NULL,NULL),(18,3,'VK Xoni','xoni','Xoni','Lahore','',1,'Saad',1,1,'2018-11-05',1,'2018-11-06'),(19,8,'Masood','masood','Masood','Hyd','03225471896',1,'Xoni',1,1,'2018-11-11',NULL,NULL),(20,1,'admin','admin','Vijay kumar','Hyd','03313325691',1,'john',1,1,'2018-11-11',NULL,NULL),(21,1,'joe','admin','Vijay kumar','Hyd','03313325692',1,'Ali',1,20,'2018-11-11',NULL,NULL),(22,8,'John_Doe','doe','John','karachi','02315487987',1,'Johnny',1,20,'2018-11-11',NULL,NULL),(23,10,'VijayK','vj','vjk','Hyd','03023325691',2,'Dog',1,20,'2018-11-11',NULL,NULL),(24,2,'Javed','vksoni04',NULL,'Karachi',NULL,1,'Ali',1,1,NULL,NULL,NULL),(25,6,'Xoni04','xoni','Vk','Hyd','03254578745',8,'This',1,20,'2019-02-07',NULL,NULL),(26,9,'ssss','soniji','vk','xyz','0303030303',8,'abcx',1,20,'2019-03-05',NULL,NULL),(27,9,'vvvv','vkvkvk','vkvk','kfkfk','03332323',8,'ali',1,20,'2019-03-05',NULL,NULL);

/*Table structure for table `user_permission` */

DROP TABLE IF EXISTS `user_permission`;

CREATE TABLE `user_permission` (
  `user_cat_id` int(11) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  KEY `user_cat_id` (`user_cat_id`),
  KEY `permission_id` (`permission_id`),
  CONSTRAINT `user_permission_ibfk_1` FOREIGN KEY (`user_cat_id`) REFERENCES `user_type` (`user_cat_id`),
  CONSTRAINT `user_permission_ibfk_2` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user_permission` */

insert  into `user_permission`(`user_cat_id`,`permission_id`) values (3,31),(3,33),(3,12),(3,37),(3,20),(3,36),(3,17),(3,18),(3,9),(3,30),(3,28),(3,16),(3,10),(3,27),(3,25),(3,13),(3,34),(3,5),(3,29),(3,32),(3,38),(3,39),(3,40),(2,1),(2,34),(2,39),(2,29),(2,30),(7,1),(7,33),(7,34),(7,29),(7,12),(7,31),(7,30),(1,1),(1,2),(1,3),(1,5),(1,6),(1,7),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18),(1,19),(1,20),(1,25),(4,1),(5,1),(5,3),(8,1),(8,7);

/*Table structure for table `user_type` */

DROP TABLE IF EXISTS `user_type`;

CREATE TABLE `user_type` (
  `user_cat_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_type` varchar(255) DEFAULT NULL,
  `active` int(1) DEFAULT '1',
  `created_by` int(11) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `modification_date` date DEFAULT NULL,
  PRIMARY KEY (`user_cat_id`),
  CONSTRAINT `user_type_ibfk_1` FOREIGN KEY (`user_cat_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `user_type` */

insert  into `user_type`(`user_cat_id`,`user_type`,`active`,`created_by`,`created_date`,`modified_by`,`modification_date`) values (1,'Admin',1,1,'2018-04-19',NULL,NULL),(2,'Employee',1,1,'2018-04-01',1,'2018-04-21'),(3,'Manager',1,1,'2018-04-19',1,'2018-04-21'),(4,'Senior Manager',1,1,'2018-04-19',1,'2018-05-06'),(5,'Junior Manager',1,1,'2018-04-19',NULL,NULL),(6,'Manager',1,1,'2018-06-20',NULL,NULL),(7,'Sub manager',1,1,'2018-07-03',NULL,NULL),(8,'Salesman',1,1,'2018-10-09',20,'2019-03-05'),(9,'Sub Admin',1,1,'2018-10-26',1,'2018-10-26'),(10,'CEO',0,1,'2018-11-06',1,'2018-11-10'),(11,'CEO',0,1,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
