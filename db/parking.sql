/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 100109
Source Host           : localhost:3306
Source Database       : parking

Target Server Type    : MYSQL
Target Server Version : 100109
File Encoding         : 65001

Date: 2016-04-19 17:13:07
*/

SET FOREIGN_KEY_CHECKS=0;

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
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(36) NOT NULL,
  `name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `isDel` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('213121', 'chen', 'aaaa', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userlog
-- ----------------------------
INSERT INTO `userlog` VALUES ('4', 'khggj', '0000-00-00 00:00:00', 'jkhhhhhhhhhhhhhhhhhhh', '0', null);
INSERT INTO `userlog` VALUES ('5', '213121', '2016-04-19 17:09:01', 'ssssssssssssssssssssssssssssssssssss', '0', null);
