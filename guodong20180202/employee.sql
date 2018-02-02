/*
SQLyog Ultimate - MySQL GUI v8.2 
MySQL - 5.5.27 : Database - sakila
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sakila` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `sakila`;

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `e_id` smallint(4) NOT NULL,
  `e_leader_id` smallint(4) DEFAULT NULL,
  `e_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`e_id`,`e_leader_id`,`e_name`) values (1,0,'鲁班（董事长）'),(2,1,'张飞（技术部主任）'),(3,1,'小乔（人事部主任）'),(4,2,'大乔（组长）'),(5,2,'周瑜（组长）'),(6,3,'刘备'),(7,4,'廉颇（员工）'),(8,7,'gdd');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
