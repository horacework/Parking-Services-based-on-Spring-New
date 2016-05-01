/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 100109
Source Host           : localhost:3306
Source Database       : parking

Target Server Type    : MYSQL
Target Server Version : 100109
File Encoding         : 65001

Date: 2016-05-01 21:25:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` varchar(36) DEFAULT NULL,
  `telphone` varchar(50) DEFAULT NULL,
  `content` varchar(200) NOT NULL,
  `currentTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feedback
-- ----------------------------
INSERT INTO `feedback` VALUES ('1', 'bfd083b6-9179-4c99-81ee-2713bc2a463c', '咯理论考虑', '咯巩固', '2016-04-28 22:57:47');

-- ----------------------------
-- Table structure for markerid
-- ----------------------------
DROP TABLE IF EXISTS `markerid`;
CREATE TABLE `markerid` (
  `id` varchar(36) NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `isDel` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of markerid
-- ----------------------------
INSERT INTO `markerid` VALUES ('b4850fda-047b-11e6-b034-00ff9099da81', '23.0444140612', '113.3944387036', '0');
INSERT INTO `markerid` VALUES ('b4851ab1-047b-11e6-b034-00ff9099da81', '23.0474740612', '113.3910077036', '0');
INSERT INTO `markerid` VALUES ('e5a3715d-047c-11e6-b034-00ff9099da81', '23.1547505064', '113.3404893861', '0');
INSERT INTO `markerid` VALUES ('e5a380fc-047c-11e6-b034-00ff9099da81', '23.0962370113', '113.2940412863', '0');

-- ----------------------------
-- Table structure for markerinfo
-- ----------------------------
DROP TABLE IF EXISTS `markerinfo`;
CREATE TABLE `markerinfo` (
  `id` varchar(36) NOT NULL,
  `name` varchar(20) NOT NULL,
  `imgUrl` varchar(60) DEFAULT NULL,
  `price` double NOT NULL DEFAULT '2',
  `zan` int(11) NOT NULL DEFAULT '0',
  `isDel` tinyint(1) NOT NULL DEFAULT '0',
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of markerinfo
-- ----------------------------
INSERT INTO `markerinfo` VALUES ('b4850fda-047b-11e6-b034-00ff9099da81', '广工大停车场', null, '2', '0', '0', '0', '0');
INSERT INTO `markerinfo` VALUES ('b4851ab1-047b-11e6-b034-00ff9099da81', '中心湖停车场', null, '2', '0', '0', '0', '0');
INSERT INTO `markerinfo` VALUES ('e5a3715d-047c-11e6-b034-00ff9099da81', '华工大停车场', null, '2.56', '1', '0', '0', '0');
INSERT INTO `markerinfo` VALUES ('e5a380fc-047c-11e6-b034-00ff9099da81', '中山大学停车场', null, '2', '1', '0', '0', '0');

-- ----------------------------
-- Table structure for parkinglog
-- ----------------------------
DROP TABLE IF EXISTS `parkinglog`;
CREATE TABLE `parkinglog` (
  `logId` varchar(36) NOT NULL,
  `userId` varchar(36) NOT NULL,
  `carId` varchar(36) NOT NULL,
  `markerId` varchar(36) NOT NULL,
  `enterTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `leaveTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `isOrder` tinyint(4) NOT NULL,
  `isComplete` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`logId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of parkinglog
-- ----------------------------
INSERT INTO `parkinglog` VALUES ('bad5e156-0ea0-11e6-969e-00ff9099da81', 'bfd083b6-9179-4c99-81ee-2713bc2a463c', 'f42631f6-fa26-4aa0-9f4b-7b1909ed6aa8', 'e5a3715d-047c-11e6-b034-00ff9099da81', '2016-04-29 04:10:04', '2016-04-29 14:20:18', '1', '1');
INSERT INTO `parkinglog` VALUES ('bad5ee26-0ea0-11e6-969e-00ff9099da81', 'bfd083b6-9179-4c99-81ee-2713bc2a463c', '0a9a5764-f36f-4450-8a36-f721ed4dae2b', 'b4850fda-047b-11e6-b034-00ff9099da81', '2016-04-30 06:13:07', '2016-04-30 11:19:13', '0', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(36) NOT NULL,
  `name` varchar(20) NOT NULL,
  `password` varchar(36) NOT NULL,
  `isDel` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('213121', 'chen', 'aaaa', '0');
INSERT INTO `user` VALUES ('29192790-400c-4a43-a586-a7655460e106', 'houren', 'aaaa', '0');
INSERT INTO `user` VALUES ('36b6a9af-dfc7-458c-b477-0f20b6eee403', 'titi', '81dc9bdb52d04dc20036dbd8313ed055', '0');
INSERT INTO `user` VALUES ('72d60e36-fbc7-4de9-ba11-8b9d98fe69e3', 'yyyy', 'eeee', '0');
INSERT INTO `user` VALUES ('7a835e70-819d-421e-be28-7299bbf9dbdf', 'pppp', '81dc9bdb52d04dc20036dbd8313ed055', '0');
INSERT INTO `user` VALUES ('bfd083b6-9179-4c99-81ee-2713bc2a463c', 'gggg', '81dc9bdb52d04dc20036dbd8313ed055', '0');
INSERT INTO `user` VALUES ('d9ef9c55-379f-4cd5-9227-0bb6fc221b37', 'gfdd', '1234', '0');
INSERT INTO `user` VALUES ('e30a1801-bdec-4ba7-981b-09e2807ff26f', 'bibi', '1234', '0');
INSERT INTO `user` VALUES ('ed2f5ebb-30af-43fc-8171-cd4ae608388f', 'hhhh', '81dc9bdb52d04dc20036dbd8313ed055', '0');

-- ----------------------------
-- Table structure for usercar
-- ----------------------------
DROP TABLE IF EXISTS `usercar`;
CREATE TABLE `usercar` (
  `carId` varchar(36) NOT NULL,
  `userId` varchar(36) NOT NULL,
  `plate` varchar(10) NOT NULL,
  `isDel` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`carId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usercar
-- ----------------------------
INSERT INTO `usercar` VALUES ('0a9a5764-f36f-4450-8a36-f721ed4dae2b', 'bfd083b6-9179-4c99-81ee-2713bc2a463c', '粤A 14444', '0');
INSERT INTO `usercar` VALUES ('bfd083b6-9179-4c99-81ee-2711232a463c', 'bfd083b6-9179-4c99-81ee-2713bc2a463c', '粤B 12345', '1');
INSERT INTO `usercar` VALUES ('f42631f6-fa26-4aa0-9f4b-7b1909ed6aa8', 'bfd083b6-9179-4c99-81ee-2713bc2a463c', '京G HA123', '0');
INSERT INTO `usercar` VALUES ('f961ae92-0db3-4144-a461-fcd1efc99bbe', 'ed2f5ebb-30af-43fc-8171-cd4ae608388f', '川A 51211', '0');

-- ----------------------------
-- Table structure for userfavorite
-- ----------------------------
DROP TABLE IF EXISTS `userfavorite`;
CREATE TABLE `userfavorite` (
  `id` varchar(36) NOT NULL,
  `markerId` varchar(36) NOT NULL,
  `userId` varchar(36) NOT NULL,
  `currentTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `cancelTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `isCancel` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userfavorite
-- ----------------------------
INSERT INTO `userfavorite` VALUES ('45a02dd0-0f65-11e6-af62-00ff9099da81', 'e5a3715d-047c-11e6-b034-00ff9099da81', 'ed2f5ebb-30af-43fc-8171-cd4ae608388f', '2016-05-01 16:08:22', '2016-05-26 16:08:15', '0');
INSERT INTO `userfavorite` VALUES ('45a03a31-0f65-11e6-af62-00ff9099da81', 'e5a380fc-047c-11e6-b034-00ff9099da81', 'ed2f5ebb-30af-43fc-8171-cd4ae608388f', '2016-05-01 06:11:09', '2016-05-01 16:09:44', '1');

-- ----------------------------
-- Table structure for userlog
-- ----------------------------
DROP TABLE IF EXISTS `userlog`;
CREATE TABLE `userlog` (
  `logId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` varchar(36) NOT NULL,
  `loginTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `deviceId` varchar(36) NOT NULL,
  `isLoginOut` tinyint(1) NOT NULL DEFAULT '0',
  `logoutTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`logId`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userlog
-- ----------------------------
INSERT INTO `userlog` VALUES ('4', 'khggj', '0000-00-00 00:00:00', 'jkhhhhhhhhhhhhhhhhhhh', '0', null);
INSERT INTO `userlog` VALUES ('5', '213121', '2016-04-19 17:09:01', 'ssssssssssssssssssssssssssssssssssss', '0', null);
INSERT INTO `userlog` VALUES ('6', '213121', '2016-04-25 13:28:35', 'ssssssssssssssssssssssssssssssssssss', '0', null);
INSERT INTO `userlog` VALUES ('7', '213121', '2016-04-25 16:57:21', '869460011154248', '0', null);
INSERT INTO `userlog` VALUES ('8', '213121', '2016-04-25 20:39:48', '869460011154248', '0', null);
INSERT INTO `userlog` VALUES ('9', '29192790-400c-4a43-a586-a7655460e106', '2016-04-25 20:44:29', '869460011154248', '0', null);
INSERT INTO `userlog` VALUES ('10', '72d60e36-fbc7-4de9-ba11-8b9d98fe69e3', '2016-04-25 20:49:19', '869460011154248', '0', null);
INSERT INTO `userlog` VALUES ('11', 'd9ef9c55-379f-4cd5-9227-0bb6fc221b37', '2016-04-25 20:50:56', '869460011154248', '0', null);
INSERT INTO `userlog` VALUES ('12', 'e30a1801-bdec-4ba7-981b-09e2807ff26f', '2016-04-25 20:55:07', '869460011154248', '0', null);
INSERT INTO `userlog` VALUES ('13', '36b6a9af-dfc7-458c-b477-0f20b6eee403', '2016-04-25 20:59:50', '869460011154248', '0', null);
INSERT INTO `userlog` VALUES ('14', '36b6a9af-dfc7-458c-b477-0f20b6eee403', '2016-04-25 21:00:31', '869460011154248', '0', null);
INSERT INTO `userlog` VALUES ('15', '36b6a9af-dfc7-458c-b477-0f20b6eee403', '2016-04-26 19:50:49', '869460011154248', '0', null);
INSERT INTO `userlog` VALUES ('16', '36b6a9af-dfc7-458c-b477-0f20b6eee403', '2016-04-26 19:54:55', '869460011154248', '0', null);
INSERT INTO `userlog` VALUES ('17', '36b6a9af-dfc7-458c-b477-0f20b6eee403', '2016-04-26 19:55:32', '869460011154248', '0', null);
INSERT INTO `userlog` VALUES ('18', '36b6a9af-dfc7-458c-b477-0f20b6eee403', '2016-04-26 20:14:00', '869460011154248', '0', null);
INSERT INTO `userlog` VALUES ('19', '36b6a9af-dfc7-458c-b477-0f20b6eee403', '2016-04-26 20:20:42', '869460011154248', '1', '2016-04-26 20:21:12');
INSERT INTO `userlog` VALUES ('20', '7a835e70-819d-421e-be28-7299bbf9dbdf', '2016-04-26 22:22:50', '869460011154248', '1', '2016-04-26 22:59:00');
INSERT INTO `userlog` VALUES ('21', 'bfd083b6-9179-4c99-81ee-2713bc2a463c', '2016-04-26 22:59:56', '869460011154248', '1', '2016-04-28 21:44:32');
INSERT INTO `userlog` VALUES ('22', 'bfd083b6-9179-4c99-81ee-2713bc2a463c', '2016-04-28 21:44:45', '869460011154248', '0', null);
INSERT INTO `userlog` VALUES ('23', 'bfd083b6-9179-4c99-81ee-2713bc2a463c', '2016-04-30 22:35:56', '869055029617010', '1', '2016-05-01 01:04:40');
INSERT INTO `userlog` VALUES ('24', 'ed2f5ebb-30af-43fc-8171-cd4ae608388f', '2016-05-01 01:05:12', '869055029617010', '0', null);
INSERT INTO `userlog` VALUES ('25', 'ed2f5ebb-30af-43fc-8171-cd4ae608388f', '2016-05-01 20:54:45', '351524050634454', '0', null);

-- ----------------------------
-- Table structure for usermoney
-- ----------------------------
DROP TABLE IF EXISTS `usermoney`;
CREATE TABLE `usermoney` (
  `logId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` varchar(36) NOT NULL,
  `type` tinyint(4) NOT NULL,
  `figure` int(11) NOT NULL,
  `remain` int(11) NOT NULL,
  `currentTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`logId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usermoney
-- ----------------------------
INSERT INTO `usermoney` VALUES ('1', 'bfd083b6-9179-4c99-81ee-2713bc2a463c', '2', '10', '10', '2016-04-26 22:59:56');
INSERT INTO `usermoney` VALUES ('2', 'bfd083b6-9179-4c99-81ee-2713bc2a463c', '2', '10', '20', '2016-04-27 23:18:49');
INSERT INTO `usermoney` VALUES ('3', 'bfd083b6-9179-4c99-81ee-2713bc2a463c', '1', '10', '10', '2016-04-27 23:19:03');
INSERT INTO `usermoney` VALUES ('4', 'ed2f5ebb-30af-43fc-8171-cd4ae608388f', '2', '10', '10', '2016-05-01 01:05:12');

-- ----------------------------
-- Table structure for userorder
-- ----------------------------
DROP TABLE IF EXISTS `userorder`;
CREATE TABLE `userorder` (
  `orderId` varchar(36) NOT NULL,
  `markerId` varchar(36) NOT NULL,
  `userId` varchar(36) NOT NULL,
  `orderTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `present` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `isDel` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userorder
-- ----------------------------

-- ----------------------------
-- View structure for parkingview
-- ----------------------------
DROP VIEW IF EXISTS `parkingview`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `parkingview` AS select p.* , usercar.plate, markerinfo.name from parkinglog AS p inner join usercar on usercar.carId = p.carId inner join markerinfo on markerinfo.id=p.markerId ;
