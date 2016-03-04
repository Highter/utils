DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL auto_increment COMMENT '主键id',
  `number` varchar(20) default NULL COMMENT '学号',
  `name` varchar(20) default NULL COMMENT '姓名',
  `age` int(11) default NULL COMMENT '年龄',
  `sex` int(11) default '0' COMMENT '性别:0表示男，1表示女，默认为0',
  `mobile` varchar(13) default NULL COMMENT '联系电话',
  `education` varchar(10) default NULL COMMENT '学历',
  `createTime` datetime COMMENT '添加时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='学生信息表';

INSERT INTO `student` VALUES ('1', '110', 'B', '21', '0', '119', '本科',NOW());
INSERT INTO `student` VALUES ('2', '121', 'C', '23', '0', '123456', '大专',NOW());
INSERT INTO `student` VALUES ('3', '110', 'D', '23', '1', '114', '本科',NOW());