/*Table structure for table `hr` */

DROP TABLE IF EXISTS `hr`;

CREATE TABLE `hr` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'hrID',
  `name` varchar(32) DEFAULT NULL COMMENT '姓名',
  `phone` char(11) DEFAULT NULL COMMENT '手机号码',
  `telephone` varchar(16) DEFAULT NULL COMMENT '住宅电话',
  `address` varchar(64) DEFAULT NULL COMMENT '联系地址',
  `enabled` tinyint(1) DEFAULT '1',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `userface` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `hr` */

insert  into `hr`(`id`,`name`,`phone`,`telephone`,`address`,`enabled`,`username`,`password`,`userface`,`remark`) values (3,'系统管理员','18568887789','029-82881234','深圳南山',1,'admin','$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm','http://bpic.588ku.com/element_pic/01/40/00/64573ce2edc0728.jpg',NULL),(5,'李白','18568123489','029-82123434','海口美兰',1,'libai','$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514093920321&di=913e88c23f382933ef430024afd9128a&imgtype=0&src=http%3A%2F%2Fp.3761.com%2Fpic%2F9771429316733.jpg',NULL),(10,'韩愈','18568123666','029-82111555','广州番禺',1,'hanyu','$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1517070040185&di=be0375e0c3db6c311b837b28c208f318&imgtype=0&src=http%3A%2F%2Fimg2.soyoung.com%2Fpost%2F20150213%2F6%2F20150213141918532.jpg',NULL),(11,'柳宗元','18568123377','029-82111333','广州天河',1,'liuzongyuan','$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1515233756&di=0856d923a0a37a87fd26604a2c871370&imgtype=jpg&er=1&src=http%3A%2F%2Fwww.qqzhi.com%2Fuploadpic%2F2014-09-27%2F041716704.jpg',NULL),(12,'曾巩','18568128888','029-82111222','广州越秀',1,'zenggong','$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1517070040185&di=be0375e0c3db6c311b837b28c208f318&imgtype=0&src=http%3A%2F%2Fimg2.soyoung.com%2Fpost%2F20150213%2F6%2F20150213141918532.jpg',NULL);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `nameZh` varchar(64) DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`id`,`name`,`nameZh`) values (1,'ROLE_manager','部门经理'),(2,'ROLE_personnel','人事专员'),(3,'ROLE_recruiter','招聘主管'),(4,'ROLE_train','培训主管'),(5,'ROLE_performance','薪酬绩效主管'),(6,'ROLE_admin','系统管理员'),(13,'ROLE_test2','测试角色2'),(14,'ROLE_test1','测试角色1'),(17,'ROLE_test3','测试角色3'),(18,'ROLE_test4','测试角色4'),(19,'ROLE_test4','测试角色4'),(20,'ROLE_test5','测试角色5'),(21,'ROLE_test6','测试角色6');



/*Table structure for table `hr_role` */

DROP TABLE IF EXISTS `hr_role`;

CREATE TABLE `hr_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hrid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `rid` (`rid`),
  KEY `hr_role_ibfk_1` (`hrid`),
  CONSTRAINT `hr_role_ibfk_1` FOREIGN KEY (`hrid`) REFERENCES `hr` (`id`) ON DELETE CASCADE,
  CONSTRAINT `hr_role_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;

/*Data for the table `hr_role` */

insert  into `hr_role`(`id`,`hrid`,`rid`) values (1,3,6),(35,12,4),(36,12,3),(37,12,2),(43,11,3),(44,11,2),(45,11,4),(46,11,5),(48,10,3),(49,10,4),(72,5,1),(73,5,2),(74,5,3);

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(64) DEFAULT NULL,
  `path` varchar(64) DEFAULT NULL,
  `component` varchar(64) DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `iconCls` varchar(64) DEFAULT NULL,
  `keepAlive` tinyint(1) DEFAULT NULL,
  `requireAuth` tinyint(1) DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `parentId` (`parentId`),
  CONSTRAINT `menu_ibfk_1` FOREIGN KEY (`parentId`) REFERENCES `menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

/*Data for the table `menu` */

insert  into `menu`(`id`,`url`,`path`,`component`,`name`,`iconCls`,`keepAlive`,`requireAuth`,`parentId`,`enabled`) values (1,'/',NULL,NULL,'所有',NULL,NULL,NULL,NULL,1),(2,'/','/home','Home','员工资料','fa fa-user-circle-o',NULL,1,1,1),(3,'/','/home','Home','人事管理','fa fa-address-card-o',NULL,1,1,1),(4,'/','/home','Home','薪资管理','fa fa-money',NULL,1,1,1),(5,'/','/home','Home','统计管理','fa fa-bar-chart',NULL,1,1,1),(6,'/','/home','Home','系统管理','fa fa-windows',NULL,1,1,1),(7,'/employee/basic/**','/emp/basic','EmpBasic','基本资料',NULL,NULL,1,2,1),(8,'/employee/advanced/**','/emp/adv','EmpAdv','高级资料',NULL,NULL,1,2,1),(9,'/personnel/emp/**','/per/emp','PerEmp','员工资料',NULL,NULL,1,3,1),(10,'/personnel/ec/**','/per/ec','PerEc','员工奖惩',NULL,NULL,1,3,1),(11,'/personnel/train/**','/per/train','PerTrain','员工培训',NULL,NULL,1,3,1),(12,'/personnel/salary/**','/per/salary','PerSalary','员工调薪',NULL,NULL,1,3,1),(13,'/personnel/remove/**','/per/mv','PerMv','员工调动',NULL,NULL,1,3,1),(14,'/salary/sob/**','/sal/sob','SalSob','工资账套管理',NULL,NULL,1,4,1),(15,'/salary/sobcfg/**','/sal/sobcfg','SalSobCfg','员工账套设置',NULL,NULL,1,4,1),(16,'/salary/table/**','/sal/table','SalTable','工资表管理',NULL,NULL,1,4,1),(17,'/salary/month/**','/sal/month','SalMonth','月末处理',NULL,NULL,1,4,1),(18,'/salary/search/**','/sal/search','SalSearch','工资表查询',NULL,NULL,1,4,1),(19,'/statistics/all/**','/sta/all','StaAll','综合信息统计',NULL,NULL,1,5,1),(20,'/statistics/score/**','/sta/score','StaScore','员工积分统计',NULL,NULL,1,5,1),(21,'/statistics/personnel/**','/sta/pers','StaPers','人事信息统计',NULL,NULL,1,5,1),(22,'/statistics/recored/**','/sta/record','StaRecord','人事记录统计',NULL,NULL,1,5,1),(23,'/system/basic/**','/sys/basic','SysBasic','基础信息设置',NULL,NULL,1,6,1),(24,'/system/cfg/**','/sys/cfg','SysCfg','系统管理',NULL,NULL,1,6,1),(25,'/system/log/**','/sys/log','SysLog','操作日志管理',NULL,NULL,1,6,1),(26,'/system/hr/**','/sys/hr','SysHr','操作员管理',NULL,NULL,1,6,1),(27,'/system/data/**','/sys/data','SysData','备份恢复数据库',NULL,NULL,1,6,1),(28,'/system/init/**','/sys/init','SysInit','初始化数据库',NULL,NULL,1,6,1);

/*Table structure for table `menu_role` */

DROP TABLE IF EXISTS `menu_role`;

CREATE TABLE `menu_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mid` (`mid`),
  KEY `rid` (`rid`),
  CONSTRAINT `menu_role_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `menu` (`id`),
  CONSTRAINT `menu_role_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=283 DEFAULT CHARSET=utf8;

/*Data for the table `menu_role` */

insert  into `menu_role`(`id`,`mid`,`rid`) values (161,7,3),(162,7,6),(163,9,6),(164,10,6),(165,11,6),(166,12,6),(167,13,6),(168,14,6),(169,15,6),(170,16,6),(171,17,6),(172,18,6),(173,19,6),(174,20,6),(175,21,6),(176,22,6),(177,23,6),(178,25,6),(179,26,6),(180,27,6),(181,28,6),(182,24,6),(247,7,4),(248,8,4),(249,11,4),(250,7,2),(251,8,2),(252,9,2),(253,10,2),(254,12,2),(255,13,2),(256,7,1),(257,8,1),(258,9,1),(259,10,1),(260,11,1),(261,12,1),(262,13,1),(263,14,1),(264,15,1),(265,16,1),(266,17,1),(267,18,1),(268,19,1),(269,20,1),(270,21,1),(271,22,1),(272,23,1),(273,24,1),(274,25,1),(275,26,1),(276,27,1),(277,28,1),(280,7,14),(281,8,14),(282,9,14);

