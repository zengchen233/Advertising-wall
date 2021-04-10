/*
 Navicat Premium Data Transfer

 Source Server         : zCC
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : guanggao_db

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 19/03/2021 22:46:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for register_table
-- ----------------------------
DROP TABLE IF EXISTS `register_table`;
CREATE TABLE `register_table`  (
  `id` char(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of register_table
-- ----------------------------
INSERT INTO `register_table` VALUES ('zengchen', 'çÎÜÐÐÉÒ×  ');
INSERT INTO `register_table` VALUES ('向蔚思', 'çÎÜÐÐÉÒ×  ');
INSERT INTO `register_table` VALUES ('曾晨', 'çÎÜÐÐÉÒ×  ');
INSERT INTO `register_table` VALUES ('王梦翔', '¡¢');
INSERT INTO `register_table` VALUES ('雷思龙', 'çÎÜÐÐÉÒ×  ');

SET FOREIGN_KEY_CHECKS = 1;
