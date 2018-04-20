use ttms;
create table user_table(
	id int auto_increment,
    username varchar(20) not null,
    password varchar(20) not null,
    email varchar(50) default null,
    phone varchar(11) default null,
    question varchar(255) default null,
    answer varchar(255) default null,
    create_time datetime not null,
    update_time datetime not null,
    primary key (id),
    unique key (username) using btree
) engine = InnoDB default charset = utf8user_table