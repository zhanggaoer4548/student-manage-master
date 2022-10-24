/*
 Navicat Premium Data Transfer

 Source Server         : 175.24.15.179
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : 175.24.15.179:3306
 Source Schema         : student_manage

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 02/12/2020 16:50:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_course
-- ----------------------------
DROP TABLE IF EXISTS `tb_course`;
CREATE TABLE `tb_course`  (
  `course_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '课程号',
  `course_name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '课程名',
  `teacher_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '授课老师',
  `student_num` int NULL DEFAULT NULL COMMENT '选课人数',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`course_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_course
-- ----------------------------
INSERT INTO `tb_course` VALUES ('C001', '高等数学（上）', 'T001', 0, '2020-12-02 00:00:00', '2020-12-02 00:00:00');
INSERT INTO `tb_course` VALUES ('C002', '高等数学（下）', 'T001', 0, '2020-12-02 00:00:00', '2020-12-02 00:00:00');
INSERT INTO `tb_course` VALUES ('C003', '大学物理', 'T002', 0, '2020-12-02 00:00:00', '2020-12-02 00:00:00');
INSERT INTO `tb_course` VALUES ('C004', '语文', 'T003', 0, '2020-12-02 00:00:00', '2020-12-02 00:00:00');

-- ----------------------------
-- Table structure for tb_login_history
-- ----------------------------
DROP TABLE IF EXISTS `tb_login_history`;
CREATE TABLE `tb_login_history`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL,
  `ip` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_login_history
-- ----------------------------
INSERT INTO `tb_login_history` VALUES (3, 1, '0:0:0:0:0:0:0:1', '2020-12-02 00:00:00');
INSERT INTO `tb_login_history` VALUES (4, 1, '0:0:0:0:0:0:0:1', '2020-12-02 00:00:00');
INSERT INTO `tb_login_history` VALUES (5, 1, '0:0:0:0:0:0:0:1', '2020-12-02 00:00:00');
INSERT INTO `tb_login_history` VALUES (6, 1, '0:0:0:0:0:0:0:1', '2020-12-02 00:00:00');
INSERT INTO `tb_login_history` VALUES (7, 1, '0:0:0:0:0:0:0:1', '2020-12-02 00:00:00');
INSERT INTO `tb_login_history` VALUES (8, 1, '0:0:0:0:0:0:0:1', '2020-12-02 00:00:00');
INSERT INTO `tb_login_history` VALUES (9, 1, '0:0:0:0:0:0:0:1', '2020-12-02 00:00:00');
INSERT INTO `tb_login_history` VALUES (10, 7, '0:0:0:0:0:0:0:1', '2020-12-02 00:00:00');

-- ----------------------------
-- Table structure for tb_score
-- ----------------------------
DROP TABLE IF EXISTS `tb_score`;
CREATE TABLE `tb_score`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `course_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '课程号',
  `student_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学号',
  `score` float NULL DEFAULT NULL COMMENT '分数',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_score
-- ----------------------------
INSERT INTO `tb_score` VALUES (14, 'C001', 'S001', 65, '2020-12-02 00:00:00', '2020-12-02 00:00:00');
INSERT INTO `tb_score` VALUES (15, 'C002', 'S001', 84, '2020-12-02 00:00:00', '2020-12-02 00:00:00');
INSERT INTO `tb_score` VALUES (16, 'C003', 'S001', 35, '2020-12-02 00:00:00', '2020-12-02 00:00:00');
INSERT INTO `tb_score` VALUES (17, 'C001', 'S002', 100, '2020-12-02 00:00:00', '2020-12-02 00:00:00');
INSERT INTO `tb_score` VALUES (18, 'C001', 'S003', 165, '2020-12-02 00:00:00', '2020-12-02 00:00:00');

-- ----------------------------
-- Table structure for tb_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student`  (
  `student_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学号',
  `student_name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '姓名',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '个性签名',
  `id_card` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `age` int NULL DEFAULT NULL COMMENT '年龄',
  `gender` tinyint NULL DEFAULT NULL COMMENT '性别，1男，2女',
  `year` char(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '入学年份',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`student_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_student
-- ----------------------------
INSERT INTO `tb_student` VALUES ('0000', 'DayRain', '明天会更好！', '3654222556544555', 20, 1, '2020', '2020-12-02 00:00:00', '2020-12-02 00:00:00');
INSERT INTO `tb_student` VALUES ('S001', '小明同学', NULL, '3654222556544555', 18, 1, '2020', '2020-12-02 00:00:00', '2020-12-02 00:00:00');
INSERT INTO `tb_student` VALUES ('S002', '小红同学', NULL, '3654222556544555', 20, 1, '1997', '2020-12-02 00:00:00', '2020-12-02 00:00:00');
INSERT INTO `tb_student` VALUES ('S003', '小李同学', NULL, '36556666665555', 20, 1, '2019', '2020-12-02 00:00:00', '2020-12-02 00:00:00');
INSERT INTO `tb_student` VALUES ('S004', '测试同学', NULL, '12312312', 18, 1, '2020', '2020-12-02 00:00:00', '2020-12-02 00:00:00');

-- ----------------------------
-- Table structure for tb_teacher
-- ----------------------------
DROP TABLE IF EXISTS `tb_teacher`;
CREATE TABLE `tb_teacher`  (
  `teacher_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `teacher_name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `gender` tinyint NULL DEFAULT NULL COMMENT '1男，2女',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`teacher_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_teacher
-- ----------------------------
INSERT INTO `tb_teacher` VALUES ('T001', '李老师', 1, '2020-12-02 00:00:00', '2020-12-02 00:00:00');
INSERT INTO `tb_teacher` VALUES ('T002', '吴老师', 2, '2020-12-02 00:00:00', '2020-12-02 00:00:00');
INSERT INTO `tb_teacher` VALUES ('T003', '王老师', 1, '2020-12-02 00:00:00', '2020-12-02 00:00:00');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_type` tinyint NULL DEFAULT NULL COMMENT '1管理员，2学生',
  `username` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `student_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学号',
  `display_name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '显示的名字',
  `state` tinyint NOT NULL DEFAULT 1 COMMENT '账号状态，1正常，2封禁',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 1, 'admin', '202cb962ac59075b964b07152d234b70', '0', '管理员', 1, '2020-11-30 10:48:24', '2020-11-30 10:48:26');
INSERT INTO `tb_user` VALUES (7, 2, '0000', '202cb962ac59075b964b07152d234b70', '0000', 'DayRain', 1, '2020-12-02 00:00:00', '2020-12-02 00:00:00');

SET FOREIGN_KEY_CHECKS = 1;
