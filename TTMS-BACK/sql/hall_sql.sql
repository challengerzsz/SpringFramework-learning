use ttms;
create table hall_table (
	  id int primary key auto_increment,
    hall_name varchar(20) not null,
    comment varchar(255),
    seat_count int not null,
    status int not null,
	  on_show_movie varchar(50)
) engine = InnoDB charset = utf8;