/*
Navicat MySQL Data Transfer

Source Server         : zhangxq
Source Server Version : 50051
Source Host           : localhost:3306
Source Database       : db_ssm

Target Server Type    : MYSQL
Target Server Version : 50051
File Encoding         : 65001

创建一个表，用来保存每一个tag和tag出现的次数
字段 含义
id  主键
tag tag值
int 次数
recentData  最近更新

Date: 2016-07-17 13:23:09
*/

CREATE TABLE t_tag(id INT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(20), times INT,recent_time TIMESTAMP );
INSERT INTO t_tag(name, times) VALUES('test', 1);
INSERT INTO t_tag(name, times) VALUES('test2', 1);