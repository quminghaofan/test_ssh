/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : sys

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2015-12-28 00:51:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `artworkorder`
-- ----------------------------
DROP TABLE IF EXISTS `artworkorder`;
CREATE TABLE `artworkorder` (
  `orderType` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `isAccept` varchar(255) DEFAULT NULL,
  `isCancelled` tinyint(1) NOT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `orderId` varchar(255) DEFAULT NULL,
  `placeDate` date DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `demoPic` varchar(255) DEFAULT NULL,
  `endPrice` double DEFAULT NULL,
  `midPrice` double DEFAULT NULL,
  `needDescription` varchar(255) DEFAULT NULL,
  `stage` varchar(255) DEFAULT NULL,
  `startPrice` double DEFAULT NULL,
  `payAccount_id` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `commodityArtwork_id` bigint(20) DEFAULT NULL,
  `customizedArtwork_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK33576BDADFCDAF8C` (`customizedArtwork_id`),
  KEY `FK33576BDAAD1B8E94` (`payAccount_id`),
  KEY `FK33576BDA3C02B728` (`commodityArtwork_id`),
  KEY `FK33576BDA600205DF` (`userId`),
  CONSTRAINT `FK33576BDA3C02B728` FOREIGN KEY (`commodityArtwork_id`) REFERENCES `artwork` (`id`),
  CONSTRAINT `FK33576BDA600205DF` FOREIGN KEY (`userId`) REFERENCES `user` (`id`),
  CONSTRAINT `FK33576BDAAD1B8E94` FOREIGN KEY (`payAccount_id`) REFERENCES `account` (`id`),
  CONSTRAINT `FK33576BDADFCDAF8C` FOREIGN KEY (`customizedArtwork_id`) REFERENCES `artwork` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of artworkorder
-- ----------------------------
INSERT INTO `artworkorder` VALUES ('艺术品商品订单', '2', '厦门', '2', '0', '13689898888', '1451223419382', '2015-12-27', '未支付', null, null, null, null, null, null, null, '32', '22', null);
INSERT INTO `artworkorder` VALUES ('定制艺术品订单', '3', '厦门大学x', '2', '0', '12345678900', '1451226268516', '2015-12-27', '未支付', '..\\attached\\1451226268341.jpg', '0', '0', '生产法收到的v', '', '0', null, '32', null, '53');
INSERT INTO `artworkorder` VALUES ('定制艺术品订单', '4', '如果该回家', '2', '0', '12345678900', '1451234323417', '2015-12-28', '未支付', '..\\attached\\1451234322826.jpg', '0', '0', '人GV画就', '', '0', null, '32', null, '54');
