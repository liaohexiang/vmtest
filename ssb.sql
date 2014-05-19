CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `service` (
  `service_id` int(11) NOT NULL,
  `service_name` varchar(50) NOT NULL,
  `service_desc` text,
  PRIMARY KEY (`service_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user_service` (
  `user_service_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `service_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_service_id`),
  KEY `FK_user_service` (`user_id`),
  KEY `FK_user_service_1` (`service_id`),
  CONSTRAINT `FK_user_service` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_
id`),
  CONSTRAINT `FK_user_service_1` FOREIGN KEY (`service_id`) REFERENCES `service`
 (`service_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1050 DEFAULT CHARSET=utf8;


insert into `user` (`user_id`, `user_name`) values('1003','hank');
insert into `user` (`user_id`, `user_name`) values('10001','tony');
insert into `user` (`user_id`, `user_name`) values('10002','james');

insert into `service` (`service_id`, `service_name`, `service_desc`) values('1001','service1',NULL);
insert into `service` (`service_id`, `service_name`, `service_desc`) values('1002','service2',NULL);
insert into `service` (`service_id`, `service_name`, `service_desc`) values('1003','service3',NULL);
insert into `service` (`service_id`, `service_name`, `service_desc`) values('1004','service4',NULL);
insert into `service` (`service_id`, `service_name`, `service_desc`) values('1005','service5',NULL);

insert into `user_service` ( `user_id`, `service_id`) values('10002','1005');
insert into `user_service` ( `user_id`, `service_id`) values('10002','1001');
insert into `user_service` ( `user_id`, `service_id`) values('10002','1002');
insert into `user_service` ( `user_id`, `service_id`) values('10002','1003');
insert into `user_service` ( `user_id`, `service_id`) values('10002','1004');