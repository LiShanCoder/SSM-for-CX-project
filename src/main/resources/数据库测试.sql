drop database if exists SSMforCX;
create database SSMforCX DEFAULT CHARACTER SET utf8;
use SSMforCX;

create table `Account`(
	id INT auto_increment,
	username VARCHAR(20) NOT NULL,
	password VARCHAR(20) NOT NULL,
	role_id int NOT NULL,
	PRIMARY KEY(id)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8;
INSERT INTO Account(username,password, role_id) VALUES('admin', '1', 110); 
INSERT INTO Account(username,password, role_id) VALUES('ppcli', '1', 58); 


create table money(
	username VARCHAR(20),
	m DECIMAL
)ENGINE=InnoDB  DEFAULT CHARSET=utf8;
insert into money values('user1',100);
insert into money values('user2',0);


create table Role4Power(
	id int auto_increment,
	role_id int NOT NULL,
	power_id int NOT NULL,
	PRIMARY KEY(id)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8;
insert into Role4Power values(1, 110, 1001);
insert into Role4Power values(2, 110, 1002);

create table Role(
	id int auto_increment,
	name varchar(20) NOT NULL,
	PRIMARY KEY(id)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8;
insert into Role values(110, '管理员');
insert into Role values(58, '普通用户');

create table Power(
	id int auto_increment,
	title varchar(30) NOT NULL,
#	describ varchar(100),
	url varchar(100) NOT NULL,
	PRIMARY KEY(id)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8;
insert into Power values(1001, '功能1', 'fun1.do');
insert into Power values(1002, '功能2', 'fun2.do');