/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50735
 Source Host           : localhost:3306
 Source Schema         : just_sql

 Target Server Type    : MySQL
 Target Server Version : 50735
 File Encoding         : 65001

 Date: 06/05/2022 15:28:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dictionary
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(72) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `code` varchar(72) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(72) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dictionary
-- ----------------------------
INSERT INTO `dictionary` VALUES (1, '法师', '1', 'attribute');
INSERT INTO `dictionary` VALUES (2, '战士', '2', 'attribute');
INSERT INTO `dictionary` VALUES (3, '刺客', '3', 'attribute');
INSERT INTO `dictionary` VALUES (4, '射手', '4', 'attribute');
INSERT INTO `dictionary` VALUES (5, '上路', '1', 'position');
INSERT INTO `dictionary` VALUES (6, '打野', '2', 'position');
INSERT INTO `dictionary` VALUES (7, '中路', '3', 'position');
INSERT INTO `dictionary` VALUES (8, 'adc', '4', 'position');
INSERT INTO `dictionary` VALUES (9, '辅助', '5', 'position');
INSERT INTO `dictionary` VALUES (10, '强攻', '1', 'talent');
INSERT INTO `dictionary` VALUES (11, '迅捷步法\r', '2', 'talent');
INSERT INTO `dictionary` VALUES (12, '征服者', '3', 'talent');
INSERT INTO `dictionary` VALUES (13, '掠食者', '4', 'talent');
INSERT INTO `dictionary` VALUES (14, '黑暗收割', '5', 'talent');
INSERT INTO `dictionary` VALUES (15, '丛刃', '6', 'talent');
INSERT INTO `dictionary` VALUES (16, '艾黎', '7', 'talent');
INSERT INTO `dictionary` VALUES (17, '相位猛冲', '8', 'talent');
INSERT INTO `dictionary` VALUES (18, '不灭之握', '9', 'talent');
INSERT INTO `dictionary` VALUES (19, '余震', '10', 'talent');
INSERT INTO `dictionary` VALUES (20, '守护者', '11', 'talent');
INSERT INTO `dictionary` VALUES (21, '冰川增幅', '12', 'talent');
INSERT INTO `dictionary` VALUES (22, '启封的秘籍', '13', 'talent');

-- ----------------------------
-- Table structure for hero
-- ----------------------------
DROP TABLE IF EXISTS `hero`;
CREATE TABLE `hero`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(72) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `attribute` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '属性(1: 法师， 2：战士， 3： 刺客， 4： 射手)',
  `position` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '位置（1：上路， 2：打野， 3：中单， 4： adc, 5: 辅助）',
  `talent` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '天赋（强攻，致命节奏， 迅捷步法，征服者，掠食者，黑暗收割，丛刃，艾黎，相位猛冲，不灭之握，余震，守护者，冰川增幅，启封的秘籍）',
  `q` varchar(72) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `w` varchar(72) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `e` varchar(72) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `r` varchar(72) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `skin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '皮肤',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hero
-- ----------------------------
INSERT INTO `hero` VALUES (1, '萨米拉', '4', '1', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `hero` VALUES (10, '123123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `hero` VALUES (11, '123123123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `hero` VALUES (12, '阿打发', '1', '1', '2', '123', '23', '3', '3', '323123123');
INSERT INTO `hero` VALUES (13, '1', '1', '1', '1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `hero` VALUES (14, '剑圣', '3', '2', '2', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for tabletest
-- ----------------------------
DROP TABLE IF EXISTS `tabletest`;
CREATE TABLE `tabletest`  (
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tabletest
-- ----------------------------
INSERT INTO `tabletest` VALUES ('张三', '12', '2020-10-21', 1);
INSERT INTO `tabletest` VALUES ('李四', '22', '2021-10-12', 2);
INSERT INTO `tabletest` VALUES ('唐山吴彦祖', '23', '2021-10-12', 3);

SET FOREIGN_KEY_CHECKS = 1;
