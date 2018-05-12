-- create database gpmanagement default charset utf8;

use gpmanagement;
 -- create table user_table (
 --    id int primary key auto_increment,
 --    number varchar(8) not null,
 --    username varchar(50) not null,
 --    password varchar(255) not null, 
 --    phone varchar(11) not null,
 --    email varchar(100) not null,
 --    type int not null,
 --     create_time timestamp,
 --     update_time timestamp
 -- ) engine = InnoDB charset = utf8;

-- truncate user_table;
 insert into user_table values
 	(null, '04111111', '老师', 'E10ADC3949BA59ABBE56E057F20F883E', '15688887459', 'teacher@126.com', 2, now(), now()),
 	(null, '04163209', '曾帅智', 'E10ADC3949BA59ABBE56E057F20F883E', '15619258920', 'challengerzsz@126.com', 2, now(), now()),
  (null, '04163216', '江婷婷', 'E10ADC3949BA59ABBE56E057F20F883E', '18792898826', 'waxi@126.com', 2, now(), now());