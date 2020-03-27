/*Table structure for table `position` */

DROP TABLE IF EXISTS `position`;

CREATE TABLE `position` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '职位',
  `createDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `enabled` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

/*Data for the table `position` */

insert  into `position`(`id`,`name`,`createDate`,`enabled`) 
values (29,'技术总监','2018-01-11 21:13:42',1),(30,'运营总监','2018-01-11 21:13:48',1),
(31,'市场总监','2018-01-11 00:00:00',1),(33,'研发工程师','2018-01-14 00:00:00',0),
(34,'运维工程师','2018-01-14 16:11:41',1),(36,'Java研发经理','2019-10-01 00:00:00',1);

