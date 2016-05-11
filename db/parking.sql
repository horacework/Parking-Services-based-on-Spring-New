/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 100109
Source Host           : localhost:3306
Source Database       : parking

Target Server Type    : MYSQL
Target Server Version : 100109
File Encoding         : 65001

Date: 2016-05-11 15:50:49
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
  `space` int(10) NOT NULL DEFAULT '100',
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
INSERT INTO `markerinfo` VALUES ('b4850fda-047b-11e6-b034-00ff9099da81', '广工大停车场', '100', null, '2', '176', '0', '0', '0');
INSERT INTO `markerinfo` VALUES ('b4851ab1-047b-11e6-b034-00ff9099da81', '中心湖停车场', '100', null, '2', '126', '0', '0', '0');
INSERT INTO `markerinfo` VALUES ('e5a3715d-047c-11e6-b034-00ff9099da81', '华工大停车场', '100', null, '2.56', '260', '0', '0', '0');
INSERT INTO `markerinfo` VALUES ('e5a380fc-047c-11e6-b034-00ff9099da81', '中山大学停车场', '100', null, '2', '59', '0', '0', '0');

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
INSERT INTO `parkinglog` VALUES ('098e7b5c-c3b6-4c3a-a55a-aa0ba66c4ff7', 'ed2f5ebb-30af-43fc-8171-cd4ae608388f', 'becbefaf-bed8-4aeb-9095-65afe4d32f1b', 'e5a3715d-047c-11e6-b034-00ff9099da81', '2016-05-08 15:50:31', '2016-05-08 15:50:52', '0', '1');
INSERT INTO `parkinglog` VALUES ('0c466222-d21c-4b4b-8377-8978d732cc9e', 'ed2f5ebb-30af-43fc-8171-cd4ae608388f', 'becbefaf-bed8-4aeb-9095-65afe4d32f1b', 'e5a3715d-047c-11e6-b034-00ff9099da81', '2016-05-06 02:03:53', '2016-05-06 02:04:59', '0', '1');
INSERT INTO `parkinglog` VALUES ('5206a23b-75ad-4c8d-968d-2280f70f6736', 'ed2f5ebb-30af-43fc-8171-cd4ae608388f', 'becbefaf-bed8-4aeb-9095-65afe4d32f1b', 'e5a3715d-047c-11e6-b034-00ff9099da81', '2016-05-08 16:00:20', '2016-05-08 16:00:52', '0', '1');
INSERT INTO `parkinglog` VALUES ('b16503d3-bc9e-4dd9-8af1-c661d5d8f279', 'ed2f5ebb-30af-43fc-8171-cd4ae608388f', 'becbefaf-bed8-4aeb-9095-65afe4d32f1b', 'e5a3715d-047c-11e6-b034-00ff9099da81', '2016-05-08 15:51:04', '2016-05-08 15:51:16', '0', '1');
INSERT INTO `parkinglog` VALUES ('bad5e156-0ea0-11e6-969e-00ff9099da81', 'bfd083b6-9179-4c99-81ee-2713bc2a463c', 'f42631f6-fa26-4aa0-9f4b-7b1909ed6aa8', 'e5a3715d-047c-11e6-b034-00ff9099da81', '2016-04-29 04:10:04', '2016-04-29 14:20:18', '1', '1');
INSERT INTO `parkinglog` VALUES ('bad5ee26-0ea0-11e6-969e-00ff9099da81', 'bfd083b6-9179-4c99-81ee-2713bc2a463c', '0a9a5764-f36f-4450-8a36-f721ed4dae2b', 'b4850fda-047b-11e6-b034-00ff9099da81', '2016-04-30 06:13:07', '2016-04-30 11:19:13', '0', '1');
INSERT INTO `parkinglog` VALUES ('df8d5af0-103d-11e6-9ba1-00ff9099da81', 'ed2f5ebb-30af-43fc-8171-cd4ae608388f', 'f961ae92-0db3-4144-a461-fcd1efc99bbe', 'e5a3715d-047c-11e6-b034-00ff9099da81', '2016-05-02 16:31:06', '2016-05-04 22:14:49', '1', '1');
INSERT INTO `parkinglog` VALUES ('fdd11471-56d3-4894-95b3-faf7399475af', 'ed2f5ebb-30af-43fc-8171-cd4ae608388f', 'becbefaf-bed8-4aeb-9095-65afe4d32f1b', 'e5a3715d-047c-11e6-b034-00ff9099da81', '2016-05-06 02:03:34', '2016-05-06 02:03:53', '0', '1');

-- ----------------------------
-- Table structure for parkingstatus
-- ----------------------------
DROP TABLE IF EXISTS `parkingstatus`;
CREATE TABLE `parkingstatus` (
  `logId` varchar(36) NOT NULL,
  `markerId` varchar(36) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`logId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of parkingstatus
-- ----------------------------
INSERT INTO `parkingstatus` VALUES ('098e7b5c-c3b6-4c3a-a55a-aa0ba66c4ff7', 'e5a3715d-047c-11e6-b034-00ff9099da81', '1');
INSERT INTO `parkingstatus` VALUES ('0c466222-d21c-4b4b-8377-8978d732cc9e', 'e5a3715d-047c-11e6-b034-00ff9099da81', '1');
INSERT INTO `parkingstatus` VALUES ('24135813-016f-4cfe-90b5-b6521cb6d368', 'e5a3715d-047c-11e6-b034-00ff9099da81', '0');
INSERT INTO `parkingstatus` VALUES ('2dc227be-9d0f-4d17-8c41-058cf0234865', 'e5a3715d-047c-11e6-b034-00ff9099da81', '0');
INSERT INTO `parkingstatus` VALUES ('4a07ef18-5369-4e58-b483-bea77f17b758', 'e5a3715d-047c-11e6-b034-00ff9099da81', '0');
INSERT INTO `parkingstatus` VALUES ('5206a23b-75ad-4c8d-968d-2280f70f6736', 'e5a3715d-047c-11e6-b034-00ff9099da81', '1');
INSERT INTO `parkingstatus` VALUES ('61509f7e-2058-4af3-8f7a-cffd0287f1a0', 'e5a3715d-047c-11e6-b034-00ff9099da81', '0');
INSERT INTO `parkingstatus` VALUES ('8690a4fd-2f78-4313-9cc6-350829e68494', 'e5a3715d-047c-11e6-b034-00ff9099da81', '2');
INSERT INTO `parkingstatus` VALUES ('8f03fc27-8d56-46b3-98bd-7b8c433b8f40', 'e5a3715d-047c-11e6-b034-00ff9099da81', '0');
INSERT INTO `parkingstatus` VALUES ('925c7b6d-8ce1-48fa-a894-eb66e96bf461', 'e5a3715d-047c-11e6-b034-00ff9099da81', '2');
INSERT INTO `parkingstatus` VALUES ('96d6869c-8afd-4c38-8b0f-2b70fbe74ced', 'e5a3715d-047c-11e6-b034-00ff9099da81', '2');
INSERT INTO `parkingstatus` VALUES ('9fc21078-b1be-47a4-831c-f3e46438024b', 'e5a3715d-047c-11e6-b034-00ff9099da81', '0');
INSERT INTO `parkingstatus` VALUES ('a88c8932-a2b0-4f65-bb42-900dd2152069', 'e5a3715d-047c-11e6-b034-00ff9099da81', '0');
INSERT INTO `parkingstatus` VALUES ('acea947d-99bb-4191-b087-7e2fe4388574', 'e5a3715d-047c-11e6-b034-00ff9099da81', '2');
INSERT INTO `parkingstatus` VALUES ('b16503d3-bc9e-4dd9-8af1-c661d5d8f279', 'e5a3715d-047c-11e6-b034-00ff9099da81', '1');
INSERT INTO `parkingstatus` VALUES ('bafe8eff-7f44-43d1-9f40-5dd263c16ee5', 'e5a3715d-047c-11e6-b034-00ff9099da81', '0');
INSERT INTO `parkingstatus` VALUES ('c143f065-2023-409c-862f-f2b6c2499ae6', 'e5a3715d-047c-11e6-b034-00ff9099da81', '0');
INSERT INTO `parkingstatus` VALUES ('c282ff5e-c1c3-4515-8f3c-255a0052d813', 'e5a3715d-047c-11e6-b034-00ff9099da81', '2');
INSERT INTO `parkingstatus` VALUES ('c827aa0e-9c80-48ff-8b1e-92d703aac355', 'e5a3715d-047c-11e6-b034-00ff9099da81', '0');
INSERT INTO `parkingstatus` VALUES ('d2191fed-f75d-4148-abe8-38e7c1af5097', 'e5a3715d-047c-11e6-b034-00ff9099da81', '1');
INSERT INTO `parkingstatus` VALUES ('e154f8b0-3b0d-4d1f-9022-f11b9a03b21e', 'e5a3715d-047c-11e6-b034-00ff9099da81', '2');
INSERT INTO `parkingstatus` VALUES ('e9201203-8c77-4a67-a78d-ff9a2e161683', 'e5a3715d-047c-11e6-b034-00ff9099da81', '2');
INSERT INTO `parkingstatus` VALUES ('f8573e93-eb3d-4b92-9f07-578885793920', 'e5a3715d-047c-11e6-b034-00ff9099da81', '0');
INSERT INTO `parkingstatus` VALUES ('fdd11471-56d3-4894-95b3-faf7399475af', 'e5a3715d-047c-11e6-b034-00ff9099da81', '1');

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
INSERT INTO `usercar` VALUES ('becbefaf-bed8-4aeb-9095-65afe4d32f1b', 'ed2f5ebb-30af-43fc-8171-cd4ae608388f', '京A 88888', '0');
INSERT INTO `usercar` VALUES ('bfd083b6-9179-4c99-81ee-2711232a463c', 'bfd083b6-9179-4c99-81ee-2713bc2a463c', '粤B 12345', '0');
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
INSERT INTO `userfavorite` VALUES ('45a02dd0-0f65-11e6-af62-00ff9099da81', 'e5a3715d-047c-11e6-b034-00ff9099da81', 'ed2f5ebb-30af-43fc-8171-cd4ae608388f', '2016-05-01 16:08:22', '2016-05-06 02:02:32', '1');
INSERT INTO `userfavorite` VALUES ('45a03a31-0f65-11e6-af62-00ff9099da81', 'e5a380fc-047c-11e6-b034-00ff9099da81', 'ed2f5ebb-30af-43fc-8171-cd4ae608388f', '2016-05-01 06:11:09', '2016-05-01 16:09:44', '1');
INSERT INTO `userfavorite` VALUES ('71af8aec-ba74-4090-8557-855007f8e927', 'e5a380fc-047c-11e6-b034-00ff9099da81', 'ed2f5ebb-30af-43fc-8171-cd4ae608388f', '2016-05-06 01:55:50', null, '0');
INSERT INTO `userfavorite` VALUES ('8b4a5470-1f43-4359-885e-13f1a0d9ade0', 'b4850fda-047b-11e6-b034-00ff9099da81', 'ed2f5ebb-30af-43fc-8171-cd4ae608388f', '2016-05-06 01:50:43', null, '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

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
INSERT INTO `userlog` VALUES ('26', 'ed2f5ebb-30af-43fc-8171-cd4ae608388f', '2016-05-06 02:12:40', '869055029617010', '1', '2016-05-08 19:11:58');

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
INSERT INTO `userorder` VALUES ('0d0a9ab8-12ca-4b21-81fe-871f448f14e6', 'e5a380fc-047c-11e6-b034-00ff9099da81', 'ed2f5ebb-30af-43fc-8171-cd4ae608388f', '2017-03-02 08:05:00', '2016-05-06 02:01:41', '0');
INSERT INTO `userorder` VALUES ('8389cad4-1032-11e6-9ba1-00ff9099da81', 'b4851ab1-047b-11e6-b034-00ff9099da81', 'ed2f5ebb-30af-43fc-8171-cd4ae608388f', '2016-06-02 08:11:17', '2016-05-03 15:21:36', '0');
INSERT INTO `userorder` VALUES ('8389f6ea-1032-11e6-9ba1-00ff9099da81', 'b4850fda-047b-11e6-b034-00ff9099da81', 'ed2f5ebb-30af-43fc-8171-cd4ae608388f', '2016-05-05 13:26:28', '2016-05-02 05:00:00', '1');
INSERT INTO `userorder` VALUES ('9e14dc93-4251-4997-8555-352663db2710', 'b4851ab1-047b-11e6-b034-00ff9099da81', 'ed2f5ebb-30af-43fc-8171-cd4ae608388f', '2016-05-20 14:05:00', '2016-05-04 20:13:12', '0');
INSERT INTO `userorder` VALUES ('b8ef0fdf-7884-44d6-8eba-30a413845949', 'e5a3715d-047c-11e6-b034-00ff9099da81', 'ed2f5ebb-30af-43fc-8171-cd4ae608388f', '2016-08-05 18:20:00', '2016-05-03 15:19:51', '0');

-- ----------------------------
-- View structure for parkingview
-- ----------------------------
DROP VIEW IF EXISTS `parkingview`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `parkingview` AS select p.* , usercar.plate, markerinfo.name from parkinglog AS p inner join usercar on usercar.carId = p.carId inner join markerinfo on markerinfo.id=p.markerId ;
