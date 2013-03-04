/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50516
Source Host           : localhost:3306
Source Database       : wwxt

Target Server Type    : MYSQL
Target Server Version : 50516
File Encoding         : 65001

Date: 2013-03-01 16:01:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bs_dm_bm`
-- ----------------------------
DROP TABLE IF EXISTS `bs_dm_bm`;
CREATE TABLE `bs_dm_bm` (
  `BM_DM` varchar(20) NOT NULL DEFAULT '',
  `BM_MC` varchar(100) DEFAULT NULL,
  `BMMS` varchar(200) DEFAULT NULL,
  `LRRY` varchar(50) DEFAULT NULL,
  `LRRQ` datetime DEFAULT NULL,
  `BMYS` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`BM_DM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `qx_module`
-- ----------------------------
DROP TABLE IF EXISTS `qx_module`;
CREATE TABLE `qx_module` (
  `ID` decimal(8,0) NOT NULL,
  `NODE` varchar(20) DEFAULT NULL,
  `NAME` varchar(60) DEFAULT NULL,
  `URL` varchar(150) DEFAULT NULL,
  `PID` varchar(20) DEFAULT NULL,
  `SORT` decimal(8,0) DEFAULT NULL,
  `ISLEAF` decimal(8,0) DEFAULT NULL,
  `ISMODULE` decimal(8,0) DEFAULT NULL,
  `FUNCMOD` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `tbl_additiveb`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_additiveb`;
CREATE TABLE `tbl_additiveb` (
  `SId` varchar(50) NOT NULL,
  `spcode` varchar(40) DEFAULT NULL,
  `MaxValue` text,
  `minCode` double DEFAULT NULL,
  `maxCode` double DEFAULT NULL,
  `Remark` text,
  `spname` text,
  `spnamepy` text,
  `codeUnit` varchar(170) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `tbl_addname`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_addname`;
CREATE TABLE `tbl_addname` (
  `Sid` varchar(50) NOT NULL,
  `Tjjname` text NOT NULL,
  `Cns` text,
  `Ins` text,
  `effect` text,
  `TjjengName` text,
  `tjjpy` text,
  `effectpy` text,
  `Isall` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `tbl_area`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_area`;
CREATE TABLE `tbl_area` (
  `area_id` int(11) NOT NULL,
  `area_name` varchar(50) DEFAULT NULL COMMENT '单位名称',
  `area_mapcode` varchar(50) DEFAULT NULL COMMENT '区域代码',
  `area_root` int(11) DEFAULT NULL COMMENT '根序号',
  `area_fzr` varchar(50) DEFAULT NULL COMMENT '负责人',
  `area_fzrphone` varchar(50) DEFAULT NULL COMMENT '负责人电话',
  `area_fzrmtel` varchar(50) DEFAULT NULL COMMENT '负责人手机号码',
  `area_linker` varchar(50) DEFAULT NULL COMMENT '联系人',
  `area_linkerphone` varchar(50) DEFAULT NULL COMMENT '联系人电话',
  `area_linkermtel` varchar(50) DEFAULT NULL COMMENT '联系人手机号码',
  `area_code` varchar(50) DEFAULT NULL COMMENT '编码',
  `area_fax` varchar(50) DEFAULT NULL COMMENT '传真',
  `area_addr` varchar(150) DEFAULT NULL COMMENT '地址',
  `area_count` int(11) DEFAULT NULL COMMENT '计数',
  `area_email` varchar(50) DEFAULT NULL COMMENT 'E-mail',
  `area_px` int(11) DEFAULT NULL COMMENT '排序',
  `area_qyname` varchar(50) DEFAULT NULL COMMENT '区域名称',
  PRIMARY KEY (`area_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='单位表';

-- ----------------------------
-- Table structure for `tbl_areamap`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_areamap`;
CREATE TABLE `tbl_areamap` (
  `areaID` int(11) NOT NULL,
  `areaName` varchar(50) DEFAULT NULL COMMENT '地区名称',
  `areaFath` int(11) DEFAULT NULL COMMENT '上级地区',
  `root` int(11) DEFAULT NULL COMMENT '上级ID',
  `areaRemark` varchar(50) DEFAULT NULL COMMENT '备注',
  `adduser` varchar(20) DEFAULT NULL COMMENT '添加人',
  `addDate` datetime DEFAULT NULL COMMENT '添加日期',
  `areaOrder` tinyint(4) DEFAULT NULL COMMENT '地区排序',
  `areaCode` varchar(12) DEFAULT NULL COMMENT '区域代码',
  PRIMARY KEY (`areaID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='区域代码（旧）';

-- ----------------------------
-- Table structure for `tbl_bsinfo`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_bsinfo`;
CREATE TABLE `tbl_bsinfo` (
  `bsinfo_id` int(11) NOT NULL,
  `bsinfo_title` varchar(250) DEFAULT NULL COMMENT '标题',
  `bsinfo_content` text COMMENT '内容',
  `bsinfo_areaid` int(11) DEFAULT NULL COMMENT '单位ID',
  `bsinfo_keyno` varchar(50) DEFAULT NULL COMMENT '关键词（预留）',
  `bsinfo_bispub` smallint(6) DEFAULT NULL COMMENT '是否公开（预留）',
  `bsinfo_date` datetime DEFAULT NULL COMMENT '日期',
  `bsinfo_type` varchar(50) DEFAULT NULL COMMENT '类型',
  `bsinfo_level` varchar(50) DEFAULT NULL COMMENT '等级',
  `bsinfo_dx` varchar(50) DEFAULT NULL COMMENT '对象',
  `bsinfo_year` varchar(50) DEFAULT NULL COMMENT '年',
  `bsinfo_month` varchar(50) DEFAULT NULL COMMENT '月',
  `bsinfo_treatDate` datetime DEFAULT NULL COMMENT '分析日期',
  `bsinfo_treatMan` varchar(50) DEFAULT NULL COMMENT '分析员',
  `bsinfo_treat` longtext COMMENT '分析内容',
  `bsinfo_files` varchar(150) DEFAULT NULL COMMENT '文件',
  `bsinfo_showtype` varchar(1) DEFAULT NULL COMMENT '显示方式',
  PRIMARY KEY (`bsinfo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='预析报告列表';

-- ----------------------------
-- Table structure for `tbl_bzinfo`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_bzinfo`;
CREATE TABLE `tbl_bzinfo` (
  `bzinfo_id` int(11) NOT NULL,
  `bzinfo_no` varchar(150) NOT NULL,
  `bzinfo_name` text,
  `bzinfo_fbrq` varchar(50) DEFAULT NULL,
  `bzinfo_ssrq` varchar(50) DEFAULT NULL,
  `bzinfo_bisys` varchar(2) DEFAULT NULL,
  `bzinfo_type` varchar(50) DEFAULT NULL,
  `bzinfo_files` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`bzinfo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `tbl_members`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_members`;
CREATE TABLE `tbl_members` (
  `member_id` int(11) NOT NULL,
  `member_name` varchar(50) DEFAULT NULL COMMENT '名称',
  `member_zw` varchar(50) DEFAULT NULL COMMENT '职位',
  `member_areaid` varchar(50) DEFAULT NULL COMMENT '所在部门ID',
  `member_depteid` varchar(50) DEFAULT NULL COMMENT '部门所在区域ID',
  `member_roleid` varchar(50) DEFAULT NULL COMMENT '角色ID',
  `member_passwd` varchar(50) DEFAULT NULL COMMENT '密码',
  `member_keyno` varchar(50) DEFAULT NULL COMMENT 'KEY编号',
  `member_used` smallint(6) DEFAULT NULL COMMENT '是否在用',
  `member_right` varchar(150) DEFAULT NULL COMMENT '预留字段1',
  `member_phone` varchar(50) DEFAULT NULL COMMENT '电话',
  `member_mtel` varchar(50) DEFAULT NULL COMMENT '手机',
  `member_keytype` smallint(6) DEFAULT NULL COMMENT 'KEY类型',
  `member_zwid` varchar(50) DEFAULT NULL COMMENT '职位ID',
  `member_memo` varchar(250) DEFAULT NULL COMMENT '备注',
  `member_cs` varchar(50) DEFAULT NULL COMMENT '处室',
  `member_group` int(11) DEFAULT NULL COMMENT '组',
  `member_zscode` varchar(50) DEFAULT NULL COMMENT '所属站所',
  `member_newareacode` varchar(50) DEFAULT NULL COMMENT '预留字段2',
  `member_code` varchar(20) DEFAULT NULL COMMENT '预留字段3',
  `member_zdjs` varchar(10) DEFAULT NULL COMMENT '执法角色',
  `member_px` int(11) NOT NULL COMMENT '排序',
  `member_zfzh` varchar(50) DEFAULT NULL COMMENT '执法证号',
  `member_ns` varchar(50) DEFAULT NULL COMMENT '年审',
  `member_fzrq` datetime DEFAULT NULL COMMENT '发证日期',
  `member_yxqz` datetime DEFAULT NULL COMMENT '有效期至',
  `member_zjstate` varchar(50) DEFAULT NULL COMMENT '证件状态',
  `member_zjbz` varchar(50) DEFAULT NULL COMMENT '证件备注',
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人员表';

-- ----------------------------
-- Table structure for `tbl_member_extrole`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_member_extrole`;
CREATE TABLE `tbl_member_extrole` (
  `mr_memberid` int(11) NOT NULL COMMENT '人员ID',
  `mr_aqlb_roleid` int(11) DEFAULT NULL COMMENT '角色ID',
  `mr_qxlb_role_id` int(11) DEFAULT NULL COMMENT '区域ID',
  PRIMARY KEY (`mr_memberid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `tbl_member_group`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_member_group`;
CREATE TABLE `tbl_member_group` (
  `member_group_id` int(11) NOT NULL COMMENT '工作组ID',
  `member_group_name` varchar(50) DEFAULT NULL COMMENT '工作组名称',
  `member_group_areaid` int(11) DEFAULT NULL COMMENT '工作组所在部门ID',
  PRIMARY KEY (`member_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作组';

-- ----------------------------
-- Table structure for `tbl_member_role`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_member_role`;
CREATE TABLE `tbl_member_role` (
  `mr_id` int(11) NOT NULL,
  `mr_memberid` int(11) DEFAULT NULL COMMENT '人员ID',
  `mr_roleid` int(11) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`mr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人员-角色';

-- ----------------------------
-- Table structure for `tbl_right`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_right`;
CREATE TABLE `tbl_right` (
  `right_id` int(11) NOT NULL,
  `right_filename` varchar(150) DEFAULT NULL COMMENT '链接',
  `right_key` varchar(50) DEFAULT NULL COMMENT '关键词',
  `right_name` varchar(50) DEFAULT NULL COMMENT '名称',
  `right_parentid` smallint(6) DEFAULT NULL COMMENT '上级ID',
  `right_rootid` smallint(6) DEFAULT NULL COMMENT '是否根目录',
  `right_type` smallint(6) DEFAULT NULL COMMENT '类型',
  `right_orderby` int(11) DEFAULT NULL COMMENT '序号',
  `right_bismenu` tinyint(4) DEFAULT NULL COMMENT '是否目录',
  `right_bisshowkz` tinyint(4) DEFAULT NULL COMMENT '是否显示',
  `right_biskh` varchar(1) DEFAULT NULL COMMENT '是否间隔',
  `right_bisSub` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`right_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表（菜单）';

-- ----------------------------
-- Table structure for `tbl_right_parameter`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_right_parameter`;
CREATE TABLE `tbl_right_parameter` (
  `p_roleid` int(11) NOT NULL,
  `p_rolename` varchar(50) DEFAULT NULL,
  `p_rightid` int(11) NOT NULL,
  `p_rightname` varchar(50) DEFAULT NULL,
  `p_parameter` varchar(200) NOT NULL COMMENT '参数'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `tbl_role`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_role`;
CREATE TABLE `tbl_role` (
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `role_areaid` int(11) DEFAULT NULL COMMENT '所属部门ID',
  `role_name` varchar(50) DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Table structure for `tbl_role_right`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_role_right`;
CREATE TABLE `tbl_role_right` (
  `rr_id` int(11) NOT NULL,
  `rr_roleid` int(11) DEFAULT NULL COMMENT '角色ID',
  `rr_rightkey` varchar(50) DEFAULT NULL COMMENT '权限关键词',
  `rr_ctrl` varchar(50) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`rr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限关联';

-- ----------------------------
-- Table structure for `tbl_yginfo`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_yginfo`;
CREATE TABLE `tbl_yginfo` (
  `yginfo_id` int(11) NOT NULL,
  `yginfo_title` varchar(250) DEFAULT NULL,
  `yginfo_content` longtext,
  `yginfo_tblname` varchar(50) DEFAULT NULL,
  `yginfo_keyno` varchar(50) DEFAULT NULL,
  `yginfo_bispub` smallint(6) DEFAULT NULL,
  `yginfo_date` datetime DEFAULT NULL,
  `yginfo_bisused` smallint(6) DEFAULT NULL,
  `yginfo_member` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`yginfo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日常巡查相关信息';

-- ----------------------------
-- Table structure for `wiki_content`
-- ----------------------------
DROP TABLE IF EXISTS `wiki_content`;
CREATE TABLE `wiki_content` (
  `Cid` int(11) NOT NULL AUTO_INCREMENT COMMENT '内容ID',
  `DirId` int(11) DEFAULT NULL COMMENT '目录ID',
  `Title` varchar(200) DEFAULT NULL COMMENT '标题',
  `Content` varchar(10000) DEFAULT NULL COMMENT '内容',
  `Date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录时间',
  PRIMARY KEY (`Cid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='内容';

-- ----------------------------
-- Table structure for `wiki_directory`
-- ----------------------------
DROP TABLE IF EXISTS `wiki_directory`;
CREATE TABLE `wiki_directory` (
  `DirId` int(11) NOT NULL AUTO_INCREMENT COMMENT '目录ID',
  `DirName` varchar(100) DEFAULT NULL COMMENT '目录名',
  `Pid` int(11) DEFAULT NULL COMMENT '父级ID',
  `Order` int(11) DEFAULT NULL COMMENT '排序',
  `Icon` varchar(100) DEFAULT NULL COMMENT '图标',
  PRIMARY KEY (`DirId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='目录结构';

-- ----------------------------
-- Table structure for `wiki_record`
-- ----------------------------
DROP TABLE IF EXISTS `wiki_record`;
CREATE TABLE `wiki_record` (
  `Id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `TblName` varchar(100) DEFAULT NULL COMMENT '表名',
  `Type` varchar(1) DEFAULT NULL COMMENT '类型：增（i）、删（d）、改（u）、查（s）',
  `PersonId` int(11) DEFAULT NULL COMMENT '人员编号',
  `Time` datetime DEFAULT NULL COMMENT '时间',
  `Remark` varchar(300) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发布修改记录';

/*==============================================================*/
/* Table: file_upload                                           */
/*==============================================================*/
create table file_upload
(
   fid                  int not null auto_increment comment '自增主键',
   fileName             varchar(200) comment '文件名',
   fileSize             varchar(100) comment '文件大小',
   filePath             varchar(200) comment '相对路径',
   uploadTime           datetime default CURRENT_TIMESTAMP comment '上传时间',
   primary key (fid)
);

alter table file_upload comment '文件上传表';

/*==============================================================*/
/* Table: global_config                                         */
/*==============================================================*/
create table global_config
(
   gid                  int not null auto_increment comment '自增主键',
   gname                varchar(100) comment '名称',
   gvalue               varchar(200) comment '对应值',
   primary key (gid)
);

alter table global_config comment '全局配置表';