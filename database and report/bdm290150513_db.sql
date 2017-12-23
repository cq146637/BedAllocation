/*
Navicat MySQL Data Transfer

Source Server         : Internetdb
Source Server Version : 50173
Source Host           : bdm290150513.my3w.com:3306
Source Database       : bdm290150513_db

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2017-06-17 15:33:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for Allocation
-- ----------------------------
DROP TABLE IF EXISTS `Allocation`;
CREATE TABLE `Allocation` (
  `Bid` varchar(20) NOT NULL DEFAULT '',
  `Pid` varchar(20) NOT NULL DEFAULT '',
  `Stime` date NOT NULL,
  `Etime` date NOT NULL,
  PRIMARY KEY (`Bid`,`Pid`),
  KEY `Pid` (`Pid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Allocation
-- ----------------------------
INSERT INTO `Allocation` VALUES ('B02', 'P02', '2017-02-06', '2017-05-05');
INSERT INTO `Allocation` VALUES ('B01', 'P05', '2017-02-02', '2019-05-05');

-- ----------------------------
-- Table structure for Bed
-- ----------------------------
DROP TABLE IF EXISTS `Bed`;
CREATE TABLE `Bed` (
  `Bid` varchar(20) NOT NULL DEFAULT '',
  `Nid` varchar(20) DEFAULT NULL,
  `Bstatus` enum('使用','空闲') DEFAULT '空闲',
  `Checks` enum('0','1') DEFAULT '0',
  PRIMARY KEY (`Bid`),
  KEY `Nid` (`Nid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Bed
-- ----------------------------
INSERT INTO `Bed` VALUES ('B01', 'P06', '使用', '0');
INSERT INTO `Bed` VALUES ('B02', 'N06', '使用', '0');
INSERT INTO `Bed` VALUES ('B03', 'P010', '空闲', '0');
INSERT INTO `Bed` VALUES ('B04', 'P01', '空闲', '0');
INSERT INTO `Bed` VALUES ('B05', 'P03', '空闲', '0');
INSERT INTO `Bed` VALUES ('B06', 'N08', '空闲', '0');

-- ----------------------------
-- Table structure for Doctor
-- ----------------------------
DROP TABLE IF EXISTS `Doctor`;
CREATE TABLE `Doctor` (
  `Did` varchar(20) NOT NULL,
  `Dname` varchar(20) NOT NULL,
  `Dsex` enum('男','女') NOT NULL,
  `Dage` smallint(6) NOT NULL,
  `Dtele` varchar(11) NOT NULL,
  `Daddr` varchar(50) DEFAULT NULL,
  `Dstatus` enum('上班','出差') DEFAULT '上班',
  `Dposition` varchar(20) NOT NULL,
  PRIMARY KEY (`Did`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Doctor
-- ----------------------------
INSERT INTO `Doctor` VALUES ('D01', '张欣欣', '女', '21', '1234567891', '上兰村', '上班', '外科医生');
INSERT INTO `Doctor` VALUES ('D02', '洪小卿', '女', '24', '12345678901', '中北大学', '上班', '牙科医生');
INSERT INTO `Doctor` VALUES ('D03', '陈乾', '男', '35', '12345678902', '中北大学', '上班', '眼科医生');
INSERT INTO `Doctor` VALUES ('D04', '符壮珠', '男', '25', '12345678903', '中北大学', '上班', '脑科医生');
INSERT INTO `Doctor` VALUES ('D05', '周杰伦', '男', '24', '12345678904', '中北大学', '上班', '内科医生');
INSERT INTO `Doctor` VALUES ('D06', '张学友', '男', '30', '12345678905', '中北大学', '出差', '外科医生');
INSERT INTO `Doctor` VALUES ('D07', '郭富城', '男', '23', '12345678906', '', '上班', '内科医生');
INSERT INTO `Doctor` VALUES ('D08', '李冰冰', '女', '30', '12345678907', '中北大学', '上班', '内科医生');
INSERT INTO `Doctor` VALUES ('D09', '周迅', '女', '26', '12345678908', '中北大学', '上班', '眼科医生');
INSERT INTO `Doctor` VALUES ('D10', '马大云', '男', '34', '12345678909', '中北大学', '上班', '骨科医生');

-- ----------------------------
-- Table structure for Nurse
-- ----------------------------
DROP TABLE IF EXISTS `Nurse`;
CREATE TABLE `Nurse` (
  `Nid` varchar(20) NOT NULL,
  `Nname` varchar(20) NOT NULL,
  `Nsex` enum('男','女') NOT NULL,
  `Nage` int(4) NOT NULL,
  `Ntele` varchar(11) NOT NULL,
  `Naddr` varchar(50) DEFAULT NULL,
  `Nstatus` enum('上班','出差') DEFAULT '上班',
  PRIMARY KEY (`Nid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Nurse
-- ----------------------------
INSERT INTO `Nurse` VALUES ('N01', '刘磊', '男', '19', '15070841001', '中北大学', '上班');
INSERT INTO `Nurse` VALUES ('N02', '李明', '男', '20', '15070841002', '中北大学', '上班');
INSERT INTO `Nurse` VALUES ('N03', '安静', '女', '18', '15070841003', '中北大学', '上班');
INSERT INTO `Nurse` VALUES ('N04', '杜鹃', '女', '23', '15070841004', '医科大学', '上班');
INSERT INTO `Nurse` VALUES ('N05', '陈赫', '男', '18', '15070841005', '医科大学', '上班');
INSERT INTO `Nurse` VALUES ('N06', '刘德华', '男', '28', '15070841006', '上兰村', '上班');
INSERT INTO `Nurse` VALUES ('N07', '范冰冰', '女', '23', '15070841007', '下兰村', '上班');
INSERT INTO `Nurse` VALUES ('N08', '李宇春', '男', '20', '15070841008', '怡丁苑', '上班');
INSERT INTO `Nurse` VALUES ('N09', '安娜', '女', '21', '15070841009', '文瀛楼', '出差');
INSERT INTO `Nurse` VALUES ('N10', '杨颖', '女', '22', '15070841010', '怡丁苑', '出差');

-- ----------------------------
-- Table structure for Patient
-- ----------------------------
DROP TABLE IF EXISTS `Patient`;
CREATE TABLE `Patient` (
  `Pid` varchar(20) NOT NULL,
  `Pname` varchar(20) NOT NULL,
  `Psex` enum('男','女') NOT NULL,
  `Page` smallint(6) NOT NULL,
  `Ptele` varchar(11) NOT NULL,
  `Paddr` varchar(50) DEFAULT NULL,
  `Pdescribe` varchar(100) NOT NULL,
  `Pstatus` enum('住院','康复','未分配') DEFAULT '未分配',
  `Did` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Pid`),
  KEY `Did` (`Did`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Patient
-- ----------------------------
INSERT INTO `Patient` VALUES ('P01', '李晓', '女', '20', '20170614001', '运城', '感冒', '未分配', 'D05');
INSERT INTO `Patient` VALUES ('P06', '小红', '女', '16', '20170614006', '榆次', '骨折', '住院', 'D10');
INSERT INTO `Patient` VALUES ('P02', '刘鑫', '男', '19', '20170614002', '太原', '感冒', '住院', 'D07');
INSERT INTO `Patient` VALUES ('P03', '张三', '男', '26', '20170614003', '太原', '发烧', '未分配', 'D08');
INSERT INTO `Patient` VALUES ('P04', '李四', '男', '16', '20170614004', '太原', '眼疾', '未分配', 'D03');
INSERT INTO `Patient` VALUES ('P05', '王五', '男', '18', '20170614005', '太原', '脑瘤', '未分配', 'D04');
INSERT INTO `Patient` VALUES ('P07', '小李', '女', '20', '20170614007', '太原', '发烧', '未分配', 'D01');
INSERT INTO `Patient` VALUES ('P08', '小明', '男', '19', '20170614008', '太原', '发烧', '未分配', 'D08');
INSERT INTO `Patient` VALUES ('P09', '小晨', '女', '18', '20170614009', '太原', '感冒', '未分配', 'D07');
INSERT INTO `Patient` VALUES ('P010', '萨芬', '男', '20', '18525248552', '中北大学', '发烧', '未分配', 'D04');

-- ----------------------------
-- Table structure for User
-- ----------------------------
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
  `Uaccount` varchar(20) NOT NULL,
  `Uname` varchar(20) NOT NULL,
  `Upassword` varchar(20) NOT NULL,
  `Utype` enum('管理员','医生','护士','病人') NOT NULL,
  PRIMARY KEY (`Uaccount`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of User
-- ----------------------------
INSERT INTO `User` VALUES ('N06', '理想', '654321', '医生');
INSERT INTO `User` VALUES ('P05', '王四', '125463', '医生');
INSERT INTO `User` VALUES ('D01', '张欣欣', '123456', '管理员');
INSERT INTO `User` VALUES ('D02', '洪小卿', '555666', '医生');
INSERT INTO `User` VALUES ('D09', '周迅', '154897', '医生');
INSERT INTO `User` VALUES ('N01', '刘磊', '123456', '护士');
INSERT INTO `User` VALUES ('D08', '李冰冰', '666555', '医生');
INSERT INTO `User` VALUES ('D04', '服装猪', '123456', '医生');
INSERT INTO `User` VALUES ('D05', '周杰伦', '123456', '医生');
INSERT INTO `User` VALUES ('D06', '张学友', '123456', '医生');
INSERT INTO `User` VALUES ('P01', '李晓', '123456', '病人');
INSERT INTO `User` VALUES ('P02', '刘鑫', '123456', '病人');
INSERT INTO `User` VALUES ('P03', '张三', '123456', '病人');
INSERT INTO `User` VALUES ('P04', '李四', '123456', '病人');
