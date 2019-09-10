/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.16 : Database - bookstore
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bookstore` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `bookstore`;

/*Table structure for table `orderitem` */

DROP TABLE IF EXISTS `orderitem`;

CREATE TABLE `orderitem` (
  `order_id` varchar(100) NOT NULL DEFAULT '',
  `product_id` varchar(100) NOT NULL DEFAULT '',
  `buynum` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`,`product_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `orderitem_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `orderitem` */

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `id` varchar(100) NOT NULL DEFAULT '',
  `money` double DEFAULT NULL,
  `receiverAddress` varchar(255) DEFAULT NULL,
  `receiverName` varchar(20) DEFAULT NULL,
  `receiverPhone` varchar(20) DEFAULT NULL,
  `paystate` int(11) DEFAULT NULL,
  `ordertime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

/*Table structure for table `products` */

DROP TABLE IF EXISTS `products`;

CREATE TABLE `products` (
  `id` varchar(100) NOT NULL DEFAULT '',
  `name` varchar(40) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  `pnum` int(11) DEFAULT NULL,
  `imgurl` varchar(10000) DEFAULT NULL,
  `description` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `products` */

insert  into `products`(`id`,`name`,`price`,`category`,`pnum`,`imgurl`,`description`) values ('0496307b-29b5-43ae-aa88-e9d973ff732d','西游记',50.6,'计算机',456874595,'bookcover/101.jpg','西游记九九八十一难'),('25bc2aa3-20ff-4e90-9b50-9de9202d04db','C语言',45,'计算机',456874595,'bookcover/102.jpg','C语言入门到放弃'),('3b5d86ca-cbc1-49e6-be88-6c5b8155e162','HTML',35,'计算机',456874595,'bookcover/103.jpg','HTMLadasfa'),('4c5a30f0-1a99-4dbd-be3e-06cf2235b1cb','网络基础',50.6,'计算机',456874595,'bookcover/104.jpg','网络基础aasafafa'),('4c866bcd-9448-496d-9c6f-b7b9373e726b','丰子恺万般滋味，都',43.58,'励志',456874595,'bookcover/105.jpg','丰子恺万般滋味，都'),('5088f140-9322-4d2f-a475-9481593c8d0b','自在独行',46.45,'学术',456874595,'bookcover/106.jpg','自在独行'),('5a3289f0-8fd3-43ee-8e02-0d175ccfd96d','汪曾祺散文精选集：',78.5,'少儿',456874595,'bookcover/107.jpg','汪曾祺散文精选集：'),('5f75dea3-82ac-4390-967c-bb6e769533cc','飞花令里读诗词',87.6,'计算机',456874595,'bookcover/TS1.jpg','飞花令里读诗词'),('64533642-3c42-4167-b03d-47ed8b9490c8','人生四书',13.3,'社科',456874595,'bookcover/TS2.jpg','人生四书'),('6b58f103-57bc-44fc-9ea5-4350aa93d247','蒋勋说红楼梦',12.76,'原版',456874595,'bookcover/TS3.jpg','蒋勋说红楼梦'),('6eea786d-93e6-4a70-bfa4-c247ee83cd57','故事写作大师班',54.65,'科技',456874595,'bookcover/TS4.jpg','故事写作大师班'),('80d9b289-36aa-4df8-a3b2-e7f5e936979d','巴黎评论',157.45,'生活百科',456874595,'bookcover/TS5.jpg','巴黎评论'),('832488f7-59b5-4f0e-ae71-aaf20cbdc908','白先勇细说红楼梦',4.5,'考试',456874595,'bookcover/TS6.jpg','白先勇细说红楼梦'),('8ae603a9-466e-4eaa-8482-e716b6c9bbea','白岩松：白说',12.45,'外语',456874595,'bookcover/TS7.jpg','白岩松：白说'),('8cac7083-8ae5-4845-9252-26f1c8e6d32c','周作人译文全',79.52,'生活',456874595,'bookcover/TS8.jpg','周作人译文全'),('9c1990a8-a178-4a1f-a7d4-4b31c6bf9da0','三毛典藏全集',53.78,'艺术',456874595,'bookcover/TS9.jpg','三毛典藏全集'),('9c37b5ef-6244-4dc0-aebc-d76b4fbc1f61','余秋雨',12.57,'计算机',456874595,'bookcover/dayongxiaohua.jpg','余秋雨'),('bf99778a-d250-4909-beba-178f48c97fed','苦难辉煌',45.6,'计算机',456874595,'bookcover/dulala.jpg','苦难辉煌'),('c4e76020-bd97-4fdc-841e-543e58506b96','在孩子下次生病前',123.21,'计算机',456874595,'bookcover/euro.jpg','在孩子下次生病前'),('d001e2e3-2635-4082-b668-4d3d796bd4aa','搜索力：帮你解决',17.5,'计算机',456874595,'bookcover/fish.jpg','搜索力：帮你解决'),('dcab04e3-e360-4136-b539-30bd62f8ce34','给孩子的图解百科全',4.8,'经管',456874595,'bookcover/java2.jpg','给孩子的图解百科全'),('e0f7c7df-d3fe-484d-bee1-a66e85652294','戴建业精读世说新语',96.5,'计算机',456874595,'bookcover/ngcn.jpg','戴建业精读世说新语'),('e1e6bb23-666d-4d1f-a547-44299bd04d40','北洋军阀史话',45.51,'文学',456874595,'bookcover/oneplant.jpg','北洋军阀史话');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `introduce` varchar(100) DEFAULT NULL,
  `activeCode` varchar(50) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `role` varchar(10) DEFAULT '普通用户',
  `registTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`gender`,`email`,`telephone`,`introduce`,`activeCode`,`state`,`role`,`registTime`) values (19,'wzx','123','男','2259654581@qq.com','17674054625','无敌是多么寂寞','abcd123456',1,'管理员','2019-08-08 15:42:47'),(20,'admin','admin','男','666666@qq.com','12345678910','我是管理员，我是管理员，我是管理员','adminadmin',1,'管理员','2019-08-07 11:09:57'),(22,'lisi','222','女','123456@qq.com','1111100000','哈哈哈哈','lisijihuo',1,'普通用户','2019-08-10 11:24:29'),(23,'xiaoli','123','男','111111@qq.com','11111111111','qwerdf',NULL,0,'普通用户','2019-08-10 10:56:41'),(30,'tom','123','女','qwer@qq.com','1234141141','wtqtqwtwqtqwtqtqwtqt','ac8b23f7-a49a-4035-9f53-5da48d40ba64',1,'普通用户','2019-08-12 19:02:53');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
