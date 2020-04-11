/*
 Navicat Premium Data Transfer

 Source Server         : 本地mysql
 Source Server Type    : MySQL
 Source Server Version : 100411
 Source Host           : localhost:3306
 Source Schema         : space

 Target Server Type    : MySQL
 Target Server Version : 100411
 File Encoding         : 65001

 Date: 11/04/2020 17:29:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`
(
    `menu_id`     int(10) UNSIGNED                                        NOT NULL AUTO_INCREMENT COMMENT '主键',
    `parent_id`   int(11)                                                 NOT NULL COMMENT '父id',
    `url`         varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
    `menu_name`   varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '菜单名称',
    `display`     tinyint(1)                                              NOT NULL COMMENT '是否显示；0：显示；1：不显示',
    `create_time` datetime(0)                                             NOT NULL COMMENT '创建时间',
    `create_by`   varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '创建人',
    PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 10
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '前台菜单表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu`
VALUES (1, 0, NULL, '父菜单', 0, '2020-04-10 11:31:30', '小明');
INSERT INTO `menu`
VALUES (2, 1, NULL, '子菜单0', 0, '2020-04-10 11:32:08', '小明');
INSERT INTO `menu`
VALUES (3, 1, NULL, '子菜单1', 0, '2020-04-10 11:32:17', '小明');
INSERT INTO `menu`
VALUES (4, 1, NULL, '子菜单2', 0, '2020-04-10 11:32:25', '小明');
INSERT INTO `menu`
VALUES (5, 0, NULL, '父菜单1', 0, '2020-04-10 11:32:52', '小明');
INSERT INTO `menu`
VALUES (6, 0, NULL, '父菜单2', 0, '2020-04-10 11:32:56', '小明');
INSERT INTO `menu`
VALUES (7, 0, NULL, '父菜单3', 0, '2020-04-10 11:33:00', '小明');
INSERT INTO `menu`
VALUES (8, 0, NULL, '父菜单4', 0, '2020-04-10 11:33:04', '小明');
INSERT INTO `menu`
VALUES (9, 0, NULL, '父菜单5', 0, '2020-04-10 11:33:08', '小明');

-- ----------------------------
-- Table structure for sp_log
-- ----------------------------
DROP TABLE IF EXISTS `sp_log`;
CREATE TABLE `sp_log`
(
    `log_id`       bigint(20) UNSIGNED                                     NOT NULL COMMENT '日志编号',
    `type`         tinyint(1)                                              NULL DEFAULT NULL COMMENT '日志类型',
    `user_account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人员',
    `operation`    varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作',
    `method`       varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '方法名称',
    `create_time`  datetime(0)                                             NULL DEFAULT NULL COMMENT '操作时间',
    PRIMARY KEY (`log_id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '操作日志表'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sp_login_info
-- ----------------------------
DROP TABLE IF EXISTS `sp_login_info`;
CREATE TABLE `sp_login_info`
(
    `id`           int(11) UNSIGNED                                        NOT NULL AUTO_INCREMENT COMMENT '访问编号',
    `user_account` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '登录账户',
    `ip_address`   varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '登录IP地址',
    `browser`      varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '浏览器类型',
    `os`           varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci   NULL DEFAULT NULL COMMENT '操作系统',
    `status`       tinyint(1)                                              NULL DEFAULT NULL COMMENT '登录状态',
    `msg`          varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '提示消息',
    `login_time`   datetime(0)                                             NULL DEFAULT NULL COMMENT '登录时间',
    `user_name`    varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '用户名',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '登录日志表'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sp_menu
-- ----------------------------
DROP TABLE IF EXISTS `sp_menu`;
CREATE TABLE `sp_menu`
(
    `menu_id`   int(11) UNSIGNED                                        NOT NULL AUTO_INCREMENT COMMENT '菜单编号',
    `parent_id` int(11)                                                 NULL DEFAULT NULL COMMENT '父编号',
    `menu_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '菜单名称',
    `url`       varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
    `perms`     varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '授权(多个用逗号分隔，\r\n如：user:list,user:create)',
    `type`      tinyint(1)                                              NOT NULL COMMENT '类型 0：目录 1：菜\r\n单 2：按钮',
    `icon`      varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '图标',
    `order_num` int(11)                                                 NOT NULL COMMENT '排序',
    PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 13
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '菜单管理表\r\n'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sp_menu
-- ----------------------------
INSERT INTO `sp_menu`
VALUES (1, 0, '系统管理', '#', NULL, 0, NULL, 0);
INSERT INTO `sp_menu`
VALUES (2, 1, '菜单管理', '#', 'sys:menu:*', 1, NULL, 1);
INSERT INTO `sp_menu`
VALUES (3, 2, '添加菜单', NULL, 'sys:menu:add', 2, NULL, 0);
INSERT INTO `sp_menu`
VALUES (4, 2, '删除菜单', NULL, 'sys:menu:del', 2, NULL, 0);
INSERT INTO `sp_menu`
VALUES (5, 2, '获取菜单', NULL, 'sys:menu:get', 2, NULL, 0);
INSERT INTO `sp_menu`
VALUES (6, 2, '修改菜单', NULL, 'sys:menu:alter', 2, NULL, 0);
INSERT INTO `sp_menu`
VALUES (7, 0, '对象存储', '#', NULL, 1, NULL, 0);
INSERT INTO `sp_menu`
VALUES (8, 7, '添加存储配置', NULL, 'sys:oss:add', 2, NULL, 0);
INSERT INTO `sp_menu`
VALUES (9, 7, '删除对象存储', NULL, 'sys:oss:del', 2, NULL, 0);
INSERT INTO `sp_menu`
VALUES (10, 7, '获取对象存储', NULL, 'sys:oss:get', 2, NULL, 0);
INSERT INTO `sp_menu`
VALUES (11, 7, '修改对象存储配置', NULL, 'sys:oss:alter', 2, NULL, 0);

-- ----------------------------
-- Table structure for sp_post
-- ----------------------------
DROP TABLE IF EXISTS `sp_post`;
CREATE TABLE `sp_post`
(
    `id`          int(11) UNSIGNED                                        NOT NULL AUTO_INCREMENT COMMENT '编号',
    `post_name`   varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '岗位名称',
    `status`      tinyint(255)                                            NULL DEFAULT NULL COMMENT '状态；0：正常1：停用',
    `create_by`   varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '创建人',
    `create_time` datetime(0)                                             NULL DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '修改人',
    `update_time` datetime(0)                                             NULL DEFAULT NULL COMMENT '修改时间',
    `remark`      varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 5
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '岗位信息表'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sp_post
-- ----------------------------
INSERT INTO `sp_post`
VALUES (1, 'demoData', 0, '', '2020-04-08 23:56:47', NULL, NULL, 'demoData');
INSERT INTO `sp_post`
VALUES (2, '测试岗位', 0, 'admin', '2020-04-09 00:42:53', NULL, NULL, '无');
INSERT INTO `sp_post`
VALUES (3, '测试岗位1', 0, 'admin', '2020-04-09 00:44:40', NULL, NULL, '无');
INSERT INTO `sp_post`
VALUES (4, '测试岗位2', 0, 'admin', '2020-04-10 11:16:22', NULL, NULL, '无');

-- ----------------------------
-- Table structure for sp_role
-- ----------------------------
DROP TABLE IF EXISTS `sp_role`;
CREATE TABLE `sp_role`
(
    `role_id`     int(11)                                                 NOT NULL COMMENT '角色编号',
    `role_name`   varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '角色名称',
    `remark`      varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
    `create_time` datetime(0)                                             NULL DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '角色表'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sp_role
-- ----------------------------
INSERT INTO `sp_role`
VALUES (1, 'admin', '超级管理员', '2020-04-02 15:31:35');
INSERT INTO `sp_role`
VALUES (2, 'common', '普通管理员', '2020-04-06 16:51:52');

-- ----------------------------
-- Table structure for sp_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sp_role_menu`;
CREATE TABLE `sp_role_menu`
(
    `id`      int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `role_id` int(11) NULL DEFAULT NULL COMMENT '角色编号',
    `menu_id` int(11) NULL DEFAULT NULL COMMENT '菜单编号',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '角色菜单表'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sp_role_menu
-- ----------------------------
INSERT INTO `sp_role_menu`
VALUES (1, 1, 1);

-- ----------------------------
-- Table structure for sp_setting
-- ----------------------------
DROP TABLE IF EXISTS `sp_setting`;
CREATE TABLE `sp_setting`
(
    `id`           int(11)                                                 NOT NULL AUTO_INCREMENT COMMENT '编号',
    `config_name`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '配置名称',
    `config_key`   varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '键',
    `config_value` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '值',
    `create_time`  datetime(0)                                             NULL DEFAULT NULL COMMENT '添加时间',
    `create_by`    varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '创建人',
    `update_time`  datetime(0)                                             NULL DEFAULT NULL COMMENT '修改时间',
    `update_by`    varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '修改人',
    `remark`       varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
    `status`       tinyint(1)                                              NULL DEFAULT NULL COMMENT '状态;0:正常；1：失效',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '系统功能配置表'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sp_setting
-- ----------------------------
INSERT INTO `sp_setting`
VALUES (1, '友站', '百度', 'https://www.baidu.com/', '2020-04-06 16:43:57', 'admin', '2020-04-06 16:47:44', NULL, '添加', 0);

-- ----------------------------
-- Table structure for sp_user
-- ----------------------------
DROP TABLE IF EXISTS `sp_user`;
CREATE TABLE `sp_user`
(
    `user_id`         int(11) UNSIGNED                                       NOT NULL AUTO_INCREMENT COMMENT '编号',
    `user_name`       varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名称',
    `user_account`    varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号名称',
    `user_passwd`     varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
    `phone`           char(11) CHARACTER SET utf8 COLLATE utf8_general_ci    NULL DEFAULT NULL COMMENT '手机号',
    `status`          tinyint(1)                                             NULL DEFAULT NULL COMMENT '用户状态；0：正常；1：冻结；2：禁用',
    `user_mail`       varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电子邮件',
    `create_time`     datetime(0)                                            NOT NULL COMMENT '账户创建时间',
    `last_login_time` datetime(0)                                            NULL DEFAULT NULL COMMENT '最后一次登录时间',
    PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 10
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '用户表'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sp_user
-- ----------------------------
INSERT INTO `sp_user`
VALUES (1, '小明', '12345', '123', NULL, 0, NULL, '2020-04-01 13:48:25', '2020-04-01 13:43:31');
INSERT INTO `sp_user`
VALUES (5, 'demoData', 'demoData', 'demoData', 'demoData', 0, NULL, '2020-04-08 23:56:47', NULL);
INSERT INTO `sp_user`
VALUES (6, 'fdsafdsf', 'dafdsfd', 'fdafdsfd', '12345', 0, NULL, '2020-04-09 00:41:21', NULL);
INSERT INTO `sp_user`
VALUES (7, 'reqwre', 'fasfewreqwr', 'fdafdsfd', '12345', 0, NULL, '2020-04-09 00:42:53', NULL);
INSERT INTO `sp_user`
VALUES (8, '1111111111', '22222222', 'fdafdsfd', '12345', 0, NULL, '2020-04-09 00:44:40', NULL);
INSERT INTO `sp_user`
VALUES (9, '23432', '53425435', '5432543', '12345', 0, NULL, '2020-04-10 11:16:22', NULL);

-- ----------------------------
-- Table structure for sp_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sp_user_role`;
CREATE TABLE `sp_user_role`
(
    `id`      int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `user_id` int(11) NOT NULL COMMENT '用户编号',
    `role_id` int(11) NOT NULL COMMENT '角色编号',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 5
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '用户角色表'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sp_user_role
-- ----------------------------
INSERT INTO `sp_user_role`
VALUES (1, 1, 1);
INSERT INTO `sp_user_role`
VALUES (2, 1, 2);
INSERT INTO `sp_user_role`
VALUES (3, 8, 2);
INSERT INTO `sp_user_role`
VALUES (4, 9, 2);

SET FOREIGN_KEY_CHECKS = 1;
