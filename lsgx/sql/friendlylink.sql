/*
 Navicat MySQL Data Transfer

 Source Server         : lyjspringmvc
 Source Server Version : 50709
 Source Host           : localhost
 Source Database       : guangde

 Target Server Version : 50709
 File Encoding         : utf-8

 Date: 01/04/2016 19:59:17 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `friendlylink`
-- ----------------------------
DROP TABLE IF EXISTS `friendlylink`;
CREATE TABLE `friendlylink` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `linkurl` varchar(50) NOT NULL,
  `webtitle` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `friendlylink`
-- ----------------------------
BEGIN;
INSERT INTO `friendlylink` VALUES ('1', 'http://www.baidu.com/', '浙江省慈善总会'), ('2', 'http://www.baidu.com/', '浙江省慈善总会'), ('3', 'http://www.baidu.com/', '浙江省慈善总会'), ('4', 'http://www.baidu.com', '浙江省慈善总会'), ('5', 'http://www.baidu.com/', '浙江省慈善总会'), ('6', 'http://www.baidu.com/', '浙江省慈善总会');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
