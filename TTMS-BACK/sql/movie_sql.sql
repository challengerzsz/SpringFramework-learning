use ttms;
create table movie_table(
	id int primary key auto_increment,
    name varchar(20) unique,
    type varchar(20),
	lang varchar(20),
	comment varchar(100),
    image varchar(255),
    duration varchar(20),
    price double,
    status int
) engine = InnoDB charset = utf8;