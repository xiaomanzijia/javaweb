/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : lsgx

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-01-06 20:19:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `alipay_trade`
-- ----------------------------
DROP TABLE IF EXISTS `alipay_trade`;
CREATE TABLE `alipay_trade` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id主键',
  `tradeno` varchar(255) DEFAULT NULL COMMENT '订单号',
  `state` varchar(255) DEFAULT NULL COMMENT '状态',
  `dtype` varchar(255) DEFAULT NULL COMMENT '捐助类型',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `amount` decimal(10,2) DEFAULT NULL COMMENT '金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of alipay_trade
-- ----------------------------
INSERT INTO `alipay_trade` VALUES ('1', null, 'abc', null, '2016-01-06 20:02:34', null, null, null);
INSERT INTO `alipay_trade` VALUES ('2', null, 'abc', null, '2016-01-06 20:03:39', null, null, '0.50');
