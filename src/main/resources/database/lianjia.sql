

--address_support

DROP TABLE IF EXISTS `support_address`;
CREATE TABLE `support_address` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `belong_to` varchar(32) NOT NULL DEFAULT '0' COMMENT '��һ��������λ��',
  `en_name` varchar(32) NOT NULL COMMENT '������λӢ������д',
  `cn_name` varchar(32) NOT NULL COMMENT '������λ������',
  `level` varchar(16) NOT NULL COMMENT '�������� ��-city ����-region',
  `baidu_map_lng` double NOT NULL COMMENT '�ٶȵ�ͼ����',
  `baidu_map_lat` double NOT NULL COMMENT '�ٶȵ�ͼγ��',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_en_name_and_belong_to` (`en_name`,`level`,`belong_to`) USING BTREE COMMENT 'ÿ�����е�Ӣ�������Ƕ�һ�޶���'
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4;