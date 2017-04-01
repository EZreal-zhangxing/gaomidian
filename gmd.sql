/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : gmd_db

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2017-04-01 17:32:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `artical`
-- ----------------------------
DROP TABLE IF EXISTS `artical`;
CREATE TABLE `artical` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL,
  `articelDesc` varchar(2000) DEFAULT NULL,
  `content` longtext,
  `modelId` int(11) NOT NULL,
  `articelPicName` varchar(200) DEFAULT NULL,
  `articelPicPath` varchar(200) DEFAULT NULL,
  `outUrl` varchar(200) DEFAULT NULL COMMENT '文章外链',
  `date` datetime DEFAULT NULL,
  `likeNum` int(11) NOT NULL DEFAULT '0',
  `isOrder` int(1) NOT NULL DEFAULT '0' COMMENT '0不可预约 1可预约',
  `MaxMannum` int(11) DEFAULT NULL,
  `videoId` int(11) DEFAULT NULL,
  `salary` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of artical
-- ----------------------------
INSERT INTO `artical` VALUES ('1', '悦风采-高米店榜样-参与我们', '', '悦风采-高米店榜样-参与我们\r\n     \r\n    ', '6', '2c9087b66a209ef3772e5ad32d0cc2c7.jpg', 'C://Upload/2c9087b66a209ef3772e5ad32d0cc2c7.jpg', '', '2017-03-09 14:28:51', '2', '1', '30', null, null);
INSERT INTO `artical` VALUES ('3', '悦风采-高米店榜样-活动报道', '', '悦风采-高米店榜样-活动报道\r\n     \r\n    ', '8', 'e657536d787198997e62dfc3070b4964.jpg', 'C://Upload/e657536d787198997e62dfc3070b4964.jpg', '', '2017-03-09 14:24:03', '0', '0', '0', null, null);
INSERT INTO `artical` VALUES ('4', '悦风采-高米店榜样-精彩花絮', '文章描述', '悦风采-高米店榜样-精彩花絮\r\n     \r\n    ', '9', '98c4147e6d5ce34a5cb7a704b1e0b879.jpg', 'C://Upload/98c4147e6d5ce34a5cb7a704b1e0b879.jpg', '', '2017-04-01 12:05:36', '0', '0', '0', null, null);
INSERT INTO `artical` VALUES ('5', '悦风采-关于高米店', '', '悦风采-关于高米店\r\n     \r\n    ', '5', null, null, 'http://www.baidu.com', '2017-03-09 14:25:02', '0', '0', '0', null, null);
INSERT INTO `artical` VALUES ('6', '悦生活-爱生活', '', '悦生活-爱生活\r\n     \r\n    ', '10', 'fc1d4490b902a4db773281f643e1261d.jpg', 'C://Upload/fc1d4490b902a4db773281f643e1261d.jpg', '', '2017-03-16 14:16:20', '1', '1', '1', null, null);
INSERT INTO `artical` VALUES ('7', '悦生活-街坊圈', '', '悦生活-街坊圈\r\n     \r\n    ', '11', '0ddee628a165d8ccc419fe8c8f0e937d.jpg', 'C://Upload/0ddee628a165d8ccc419fe8c8f0e937d.jpg', 'http://mp.weixin.qq.com/s/9xqW5f0oL0m49M_hhuKyPA', '2017-03-15 14:21:15', '0', '0', '0', null, null);
INSERT INTO `artical` VALUES ('8', '悦风采-高米店榜样-参与我们2', '悦风采-高米店榜样-参与我们2-文章介绍', '<span style=\"font-size: 14px; line-height: 20px;\">悦风采-高米店榜样-参与我们2</span><div><span style=\"font-size: 14px; line-height: 20px;\">参与我们</span></div>', '6', 'c1fd5c01aa6eb763c5ded5c7141c989b.jpg', 'C://Upload/c1fd5c01aa6eb763c5ded5c7141c989b.jpg', '', '2017-03-14 13:35:47', '2', '0', '300', null, null);
INSERT INTO `artical` VALUES ('13', '精彩花絮', '', '精彩花絮 内容', '9', '0052b5e1dce668934d1c8b83c3116aca.jpg', 'C://Upload/0052b5e1dce668934d1c8b83c3116aca.jpg', '', '2017-03-10 15:31:37', '0', '0', '0', '27', null);
INSERT INTO `artical` VALUES ('14', '精彩花絮2', '', '精彩花絮2\r\n     \r\n    ', '9', 'e3d4fdd502cec44a19256c601ccb7761.jpg', 'C://Upload/e3d4fdd502cec44a19256c601ccb7761.jpg', '', '2017-03-16 14:24:53', '0', '0', '0', null, null);
INSERT INTO `artical` VALUES ('15', '微直播', '', '\r\n     \r\n    ', '7', null, null, 'http://mp.weixin.qq.com/s/9xqW5f0oL0m49M_hhuKyPA', '2017-03-14 11:57:30', '0', '0', '0', null, null);
INSERT INTO `artical` VALUES ('16', '悦生活-养生吧1', '悦生活-养生吧1', '悦生活-养生吧<div>第二行</div>', '13', 'a7c0d1353e795225a4680d0d6a7b00ad.jpg', 'C://Upload/a7c0d1353e795225a4680d0d6a7b00ad.jpg', '', '2017-03-16 14:39:35', '0', '0', '0', null, null);
INSERT INTO `artical` VALUES ('17', '悦生活-养生吧2', '悦生活-养生吧2', 'fdsafas<div>悦生活-养生吧2悦生活-养生吧2悦生活-养生吧2悦生活-养生吧2<br></div><div>悦生活-养生吧2悦生活-养生吧2<br></div>', '13', '104bbcbabd59679dfbf8c68b82b3e1f5.jpg', 'C://Upload/104bbcbabd59679dfbf8c68b82b3e1f5.jpg', 'http://mp.weixin.qq.com/s/9xqW5f0oL0m49M_hhuKyPA', '2017-03-16 14:34:33', '0', '0', '0', null, null);
INSERT INTO `artical` VALUES ('18', '招聘信息', '百度公司', '招聘信息\r\n     \r\n    <div>百度公司</div><div>工作地点</div><div>薪资：</div>', '12', null, null, '', '2017-03-16 15:00:46', '0', '0', '0', null, '3K-4K');
INSERT INTO `artical` VALUES ('19', '招聘信息2', '新浪公司', '<div>公司：中华企业咨询有限公司</div><div>要求：经验不限/专科学历</div><div>工作地址：北京市大兴区高米店五彩缤纷城D座</div><div><span style=\"color: inherit;\">职位描述：</span><span style=\"color: inherit;\">1、建立、维护、扩大终端客户群体，完成公司下达任务；</span><span style=\"color: inherit;\">2、按照企业工作和程序开展产品推广活动，介绍产品并提供相应解决方案；</span><span style=\"color: inherit;\">3、建立业务客户资料卡及客户档案；</span><span style=\"color: inherit;\">4、参加公司召开的销售会议或组织的培训；</span><span style=\"color: inherit;\">&nbsp;5、与当地用户沟通并完成销售任务；与客户建立良好关系，以完善企业营销网络；</span></div>\r\n     \r\n    ', '12', null, null, '', '2017-03-16 15:14:14', '0', '0', '0', null, '5K-10K');
INSERT INTO `artical` VALUES ('20', '最高价值140元的精美双人餐，提供免费WiFi', '', '<div><span style=\"color: inherit;\">有效期&nbsp;</span><span style=\"color: inherit;\">2016.11.7 至 2017.2.4（周末、法定节假日通用）</span></div><div>使用时间</div><div>10:30-14:30,17:00-21:00</div><div>预约提醒</div><div>无需预约，消费高峰时可能需要等位</div><div>限购限用提醒</div><div>每张美团券建议2人使用</div><div>包间</div><div>店内无包间</div><div>堂食外带</div><div>堂食外带均可，如需打包，需到店另付打包费2元/盒</div><div>温馨提示</div><div>团购用户不可同时享受商家其他优惠</div><div>酒水饮料等问题，请致电商家咨询，以商家反馈为准</div><div>商家服务</div><div>提供免费WiFi</div>\r\n     \r\n    ', '14', '5093dc0774ccd1df7522d865eb334275.jpg', 'C://Upload/5093dc0774ccd1df7522d865eb334275.jpg', '', '2017-03-16 16:08:31', '0', '0', '0', null, '');
INSERT INTO `artical` VALUES ('21', '意见箱', '', '意见箱\r\n     \r\n    ', '18', null, null, 'http://www.baidu.com', '2017-03-17 09:42:38', '0', '0', '0', null, '');
INSERT INTO `artical` VALUES ('22', '新鲜事1', '', '新鲜事1\r\n     \r\n    ', '15', 'b939809174a98e9704a185a50548fefa.jpg', 'C://Upload/b939809174a98e9704a185a50548fefa.jpg', '', '2017-03-17 09:55:20', '0', '0', '0', null, '');
INSERT INTO `artical` VALUES ('23', '新鲜事2', '', '\r\n     \r\n    ', '15', 'fe2054dc60eb3d9299e46445b043f0ee.jpg', 'C://Upload/fe2054dc60eb3d9299e46445b043f0ee.jpg', 'http://news.sohu.com/20170316/n483551282.shtml', '2017-03-17 09:56:02', '0', '0', '0', null, '');
INSERT INTO `artical` VALUES ('24', '治政策1', '', '治政策1\r\n     \r\n    ', '16', '582214ef04c2b8b2cf43941c7ee61d9c.jpg', 'C://Upload/582214ef04c2b8b2cf43941c7ee61d9c.jpg', '', '2017-03-17 10:05:17', '0', '0', '0', null, '');
INSERT INTO `artical` VALUES ('25', '治政策2', '', '\r\n     \r\n    ', '16', 'a1a171828c26f7df18e0896112db0e85.jpg', 'C://Upload/a1a171828c26f7df18e0896112db0e85.jpg', 'http://www.sina.com', '2017-03-17 10:05:41', '0', '0', '0', null, '');
INSERT INTO `artical` VALUES ('26', '惠办事1', '', '惠办事1\r\n     \r\n    ', '17', 'e00311d58592ec766b9bf63e1c7f153a.jpg', 'C://Upload/e00311d58592ec766b9bf63e1c7f153a.jpg', '', '2017-03-17 10:08:23', '0', '0', '0', null, '');
INSERT INTO `artical` VALUES ('27', '惠办事2', '', '\r\n     \r\n    ', '17', '55280e9848a00ebc8d0ef98bd300413c.png', 'C://Upload/55280e9848a00ebc8d0ef98bd300413c.png', 'http://www.baidu.com', '2017-03-17 10:08:45', '0', '0', '0', null, '');
INSERT INTO `artical` VALUES ('28', '标题', '这是H5文章标题介绍', '\r\n     \r\n    ', '19', null, null, 'http://www.baidu.com', '2017-03-24 12:05:38', '0', '0', '0', null, '');
INSERT INTO `artical` VALUES ('29', '积分规则', '', '<div>积分&gt;100可兑换</div><div>积分≧100可兑换</div><div>积分≧200可兑换</div><div>积分≧300可兑换</div><div>积分≧400可兑换</div><div>积分≧400可兑换</div>\r\n     \r\n    ', '20', null, null, '', '2017-03-30 15:55:27', '0', '0', '0', null, '');

-- ----------------------------
-- Table structure for `articallike`
-- ----------------------------
DROP TABLE IF EXISTS `articallike`;
CREATE TABLE `articallike` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `articelId` int(11) NOT NULL,
  `likeUser` int(11) NOT NULL,
  `likeDate` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=202 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of articallike
-- ----------------------------
INSERT INTO `articallike` VALUES ('168', '14', '2', '2017-03-02 16:52:46');
INSERT INTO `articallike` VALUES ('169', '10', '2', '2017-03-02 16:52:56');
INSERT INTO `articallike` VALUES ('171', '13', '1', '2017-03-07 09:19:20');
INSERT INTO `articallike` VALUES ('172', '11', '1', '2017-03-07 09:19:22');
INSERT INTO `articallike` VALUES ('173', '15', '1', '2017-03-07 09:40:56');
INSERT INTO `articallike` VALUES ('174', '14', '1', '2017-03-09 11:19:03');
INSERT INTO `articallike` VALUES ('175', '17', '1', '2017-03-09 11:19:04');
INSERT INTO `articallike` VALUES ('197', '8', '1', '2017-03-17 10:53:34');
INSERT INTO `articallike` VALUES ('198', '1', '1', '2017-03-17 10:53:45');
INSERT INTO `articallike` VALUES ('199', '1', '2', '2017-03-17 10:54:23');
INSERT INTO `articallike` VALUES ('200', '8', '2', '2017-03-17 10:54:24');
INSERT INTO `articallike` VALUES ('201', '6', '1', '2017-03-24 09:55:45');

-- ----------------------------
-- Table structure for `banner`
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bannerName` varchar(200) NOT NULL,
  `bannerPath` varchar(200) NOT NULL,
  `belong` int(11) DEFAULT NULL COMMENT 'banner所属区域',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of banner
-- ----------------------------
INSERT INTO `banner` VALUES ('4', 'a008c54c5d0bddf41e546e9ac0a1cff4.jpg', 'C://Banner/a008c54c5d0bddf41e546e9ac0a1cff4.jpg', '1');
INSERT INTO `banner` VALUES ('5', '6998beac5ef4a3d0baa70153db8a6f2c.jpg', 'C://Banner/6998beac5ef4a3d0baa70153db8a6f2c.jpg', '1');
INSERT INTO `banner` VALUES ('6', 'ee7a6a35d2e64e900c477dba24a7c180.jpg', 'C://Banner/ee7a6a35d2e64e900c477dba24a7c180.jpg', '1');
INSERT INTO `banner` VALUES ('7', 'a54bca0a2fd97e6ed0951f49eadc6f18.jpg', 'C://Banner/a54bca0a2fd97e6ed0951f49eadc6f18.jpg', '1');
INSERT INTO `banner` VALUES ('8', '0cd9752e3326efe045b3ed70af0f2901.jpg', 'C://Banner/0cd9752e3326efe045b3ed70af0f2901.jpg', '2');
INSERT INTO `banner` VALUES ('16', '7a2402fd687d7983f57f00327257013b.gif', 'C://Banner/7a2402fd687d7983f57f00327257013b.gif', '2');
INSERT INTO `banner` VALUES ('17', 'a40f1a264e1303721a3a4f0904930069.jpg', 'C://Banner/a40f1a264e1303721a3a4f0904930069.jpg', '2');
INSERT INTO `banner` VALUES ('22', 'c7184e3d20a29383d49629b098cfbd04.jpg', 'C://Banner/c7184e3d20a29383d49629b098cfbd04.jpg', '2');
INSERT INTO `banner` VALUES ('23', '5cac0f72fa26117f47136c039609c468.jpg', 'C://GMD/Banner/5cac0f72fa26117f47136c039609c468.jpg', '1');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `articelId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `comment` varchar(300) DEFAULT NULL,
  `Date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('2', '13', '1', 'test品论1', '2017-03-13 13:40:36');
INSERT INTO `comment` VALUES ('3', '13', '1', 'test品论1', '2017-03-13 13:40:39');
INSERT INTO `comment` VALUES ('4', '13', '1', 'test品论1', '2017-03-13 13:40:40');
INSERT INTO `comment` VALUES ('5', '13', '1', 'test品论1', '2017-03-13 13:40:40');
INSERT INTO `comment` VALUES ('6', '13', '1', 'test品论1', '2017-03-13 13:40:40');
INSERT INTO `comment` VALUES ('7', '13', '1', 'test品论1', '2017-03-13 13:40:40');
INSERT INTO `comment` VALUES ('8', '13', '1', 'test品论1', '2017-03-13 13:40:40');
INSERT INTO `comment` VALUES ('9', '13', '1', 'test品论1', '2017-03-13 13:40:41');
INSERT INTO `comment` VALUES ('10', '13', '1', 'test品论1', '2017-03-13 13:40:41');
INSERT INTO `comment` VALUES ('11', '13', '1', 'test品论1', '2017-03-13 13:40:41');
INSERT INTO `comment` VALUES ('12', '13', '1', 'test品论1', '2017-03-13 13:40:41');
INSERT INTO `comment` VALUES ('13', '13', '1', 'test品论1', '2017-03-13 13:40:41');
INSERT INTO `comment` VALUES ('14', '13', '1', 'test品论1', '2017-03-13 13:40:42');
INSERT INTO `comment` VALUES ('15', '13', '1', 'test品论1', '2017-03-13 13:40:42');
INSERT INTO `comment` VALUES ('18', '6', '1', 'test品论', '2017-03-13 15:30:34');
INSERT INTO `comment` VALUES ('19', '13', '2', 'da', '2017-03-17 10:56:14');

-- ----------------------------
-- Table structure for `image`
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `filename` varchar(100) DEFAULT NULL,
  `filepath` varchar(100) DEFAULT NULL,
  `artical_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of image
-- ----------------------------
INSERT INTO `image` VALUES ('1', '文件名', '文件路径', '1');

-- ----------------------------
-- Table structure for `model`
-- ----------------------------
DROP TABLE IF EXISTS `model`;
CREATE TABLE `model` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ModelName` varchar(100) DEFAULT NULL,
  `ParentMode` int(11) DEFAULT NULL,
  `ModelLevel` int(11) DEFAULT NULL,
  `Statue` int(1) DEFAULT NULL COMMENT '1 文章 2是模块 3是链接',
  `isOrder` int(1) DEFAULT '0' COMMENT '0不可预约 1可预约',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of model
-- ----------------------------
INSERT INTO `model` VALUES ('1', '悦风采', '-1', '1', '2', '0');
INSERT INTO `model` VALUES ('2', '悦生活', '-1', '1', '2', '0');
INSERT INTO `model` VALUES ('3', '悦品读', '-1', '1', '2', '0');
INSERT INTO `model` VALUES ('4', '高米店榜样', '1', '2', '2', '0');
INSERT INTO `model` VALUES ('5', '关于高米店', '1', '2', '3', '0');
INSERT INTO `model` VALUES ('6', '参与我们', '4', '3', '1', '1');
INSERT INTO `model` VALUES ('7', '微直播', '4', '3', '3', '0');
INSERT INTO `model` VALUES ('8', '活动报道', '4', '3', '1', '0');
INSERT INTO `model` VALUES ('9', '精彩花絮', '4', '3', '1', '0');
INSERT INTO `model` VALUES ('10', '爱活动', '2', '2', '1', '1');
INSERT INTO `model` VALUES ('11', '街坊圈', '2', '2', '3', '0');
INSERT INTO `model` VALUES ('12', '招聘汇', '2', '2', '1', '0');
INSERT INTO `model` VALUES ('13', '养生吧', '2', '2', '1', '0');
INSERT INTO `model` VALUES ('14', '享优惠', '2', '2', '1', '0');
INSERT INTO `model` VALUES ('15', '新鲜事', '3', '2', '1', '0');
INSERT INTO `model` VALUES ('16', '知政策', '3', '2', '1', '0');
INSERT INTO `model` VALUES ('17', '惠办事', '3', '2', '1', '0');
INSERT INTO `model` VALUES ('18', '意见箱', '3', '2', '3', '0');
INSERT INTO `model` VALUES ('19', 'H5标题', '4', '2', '1', '0');
INSERT INTO `model` VALUES ('20', '积分规则', '2', '2', '1', '0');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(50) NOT NULL,
  `Password` varchar(32) NOT NULL,
  `Point` int(11) NOT NULL DEFAULT '0',
  `lastPointDate` varchar(200) DEFAULT NULL,
  `niceName` varchar(50) DEFAULT NULL,
  `trueName` varchar(50) DEFAULT NULL,
  `sex` int(1) NOT NULL DEFAULT '0' COMMENT '1 男 0女',
  `birthday` date DEFAULT NULL,
  `community` varchar(200) DEFAULT NULL COMMENT '社区',
  `detailAddress` varchar(200) DEFAULT NULL COMMENT '详细地址',
  `checkcode` varchar(100) DEFAULT NULL,
  `statue` int(1) NOT NULL DEFAULT '1' COMMENT '1 生效 2 注册 3找回',
  `loginPointDate` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'c33367701511b4f6020ec61ded352059', '66', '2017-03-30', 'who', '张行', '1', '2017-02-28', '12', '3123', null, '1', '2017-04-01');
INSERT INTO `user` VALUES ('2', 'zhangxing', 'f79061e590419c502396e7f65e68e5c7', '500', '2017-03-17', 'zxnick', null, '0', null, null, null, null, '1', null);
INSERT INTO `user` VALUES ('3', 'admin', '202cb962ac59075b964b07152d234b70', '0', '2017-03-09', 'adminick2', null, '0', null, null, null, null, '1', null);
INSERT INTO `user` VALUES ('4', 'admin1', 'e3726ea49822e5f231562bef154ff21f', '300', '2017-03-09', 'admin1nick', null, '0', null, null, null, null, '1', null);
INSERT INTO `user` VALUES ('5', 'zhangxing1', '532d853b3c73b1f27179467d4cf57739', '2', '2017-03-09', 'zx1nick', null, '0', null, null, null, null, '1', null);
INSERT INTO `user` VALUES ('17', '18310137178', 'f79061e590419c502396e7f65e68e5c7', '2', '2017-03-21', 'zx', '张行', '0', null, null, null, null, '1', null);

-- ----------------------------
-- Table structure for `useradmin`
-- ----------------------------
DROP TABLE IF EXISTS `useradmin`;
CREATE TABLE `useradmin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of useradmin
-- ----------------------------
INSERT INTO `useradmin` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3');

-- ----------------------------
-- Table structure for `userorder`
-- ----------------------------
DROP TABLE IF EXISTS `userorder`;
CREATE TABLE `userorder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `userTel` varchar(50) DEFAULT NULL,
  `userAddress` varchar(200) DEFAULT NULL,
  `comAddress` varchar(200) DEFAULT NULL,
  `articelId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `statue` int(1) NOT NULL DEFAULT '1' COMMENT '//0 已取消 1已预约 2已过期',
  `orderDate` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userorder
-- ----------------------------
INSERT INTO `userorder` VALUES ('1', '张行', '18310137178', '23', '123', '1', '1', '1', '2017-03-16');
INSERT INTO `userorder` VALUES ('2', '张行', '123', '123', '123', '6', '1', '1', '2017-03-16');
INSERT INTO `userorder` VALUES ('3', 'admi', 'nsdff', 'fsda', 'fda', '1', '1', '1', '2017-03-17');
INSERT INTO `userorder` VALUES ('4', 'fd', 'fa', 'faf', 'a', '1', '2', '1', '2017-03-17');

-- ----------------------------
-- Table structure for `video`
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `videoName` varchar(50) NOT NULL,
  `videoPath` varchar(200) NOT NULL,
  `filesize` float(11,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES ('27', 'd2a844a284dd59fbf299b895fc31498d.mp4', 'C://Video/d2a844a284dd59fbf299b895fc31498d.mp4', '23014356');
