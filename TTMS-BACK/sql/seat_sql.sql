use ttms;
create table seat_table(
	id int primary key auto_increment,
    hall_id int not null,
    seat_row int not null,
    seat_column int not null,
    status int comment '座位好坏',
    create_time timestamp,
    update_time timestamp
) engine = InnoDB charset = utf8