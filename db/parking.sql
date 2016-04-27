/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 100109
Source Host           : localhost:3306
Source Database       : parking

Target Server Type    : MYSQL
Target Server Version : 100109
File Encoding         : 65001

Date: 2016-04-27 23:23:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` varchar(36) DEFAULT NULL,
  `title` varchar(40) NOT NULL,
  `content` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feedback
-- ----------------------------

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
INSERT INTO `markerinfo` VALUES ('e5a3715d-047c-11e6-b034-00ff9099da81', '华工大停车场', null, '2', '0', '0', '0', '0');
INSERT INTO `markerinfo` VALUES ('e5a380fc-047c-11e6-b034-00ff9099da81', '中山大学停车场', null, '2', '0', '0', '0', '0');

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
  `isCancel` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userfavorite
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

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
INSERT INTO `userlog` VALUES ('21', 'bfd083b6-9179-4c99-81ee-2713bc2a463c', '2016-04-26 22:59:56', '869460011154248', '0', null);

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usermoney
-- ----------------------------
INSERT INTO `usermoney` VALUES ('1', 'bfd083b6-9179-4c99-81ee-2713bc2a463c', '2', '10', '10', '2016-04-26 22:59:56');
INSERT INTO `usermoney` VALUES ('2', 'bfd083b6-9179-4c99-81ee-2713bc2a463c', '2', '10', '20', '2016-04-27 23:18:49');
INSERT INTO `usermoney` VALUES ('3', 'bfd083b6-9179-4c99-81ee-2713bc2a463c', '1', '10', '10', '2016-04-27 23:19:03');

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
