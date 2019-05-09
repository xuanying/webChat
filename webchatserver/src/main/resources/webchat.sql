CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'hrID',
  `name` varchar(32) DEFAULT NULL COMMENT '姓名',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

insert into user values(1,"yufei","yufei","123456");
insert into user values(2,"admin","admin","123456");
insert into user values(3,"duguqiubai","duguqiubai","123456");
insert into user values(4,"yangguo","yangguo","123456");
insert into user values(5,"guojin","gupjin","123456");

-- select * from user

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

insert into role value(1,"admin");
insert into role value(2,"user");
-- select * from role

CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `rid` (`rid`),
  KEY `user_role_ibfk_1` (`uid`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

insert into user_role values(1,1,1);
insert into user_role values(2,2,2);
insert into user_role values(3,3,2);
insert into user_role values(4,4,2);
insert into user_role values(5,5,2);

-- select * from user_role

CREATE TABLE `user_friend` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `fid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fid` (`fid`),
  KEY `user_friend_ibfk_1` (`uid`),
  CONSTRAINT `user_friend_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `user_friend_ibfk_2` FOREIGN KEY (`fid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

insert into user_friend values(1,1,2);
insert into user_friend values(2,1,3);
insert into user_friend values(3,1,4);
insert into user_friend values(4,1,5);
insert into user_friend values(5,3,4);
insert into user_friend values(6,3,5);
insert into user_friend values(7,3,2);
insert into user_friend values(8,4,2);
insert into user_friend values(9,4,3);
insert into user_friend values(10,4,5);
insert into user_friend values(11,5,2);
insert into user_friend values(12,5,3);
insert into user_friend values(13,5,4);

-- select * from user_friend

CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

insert into menu values(1,"/home/**");
insert into menu values(2,"/admin/**");

-- update menu set url="/home/**" where id=1;
-- update menu set url="/admin/**" where id=2;
-- select * from menu;

CREATE TABLE `menu_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mid` (`mid`),
  KEY `rid` (`rid`),
  CONSTRAINT `menu_role_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `menu` (`id`),
  CONSTRAINT `menu_role_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=278 DEFAULT CHARSET=utf8;

insert into menu_role values(1,1,2);
insert into menu_role values(2,2,1);
insert into menu_role values(3,1,1);

