drop database if exists SSMforCX;
create database SSMforCX DEFAULT CHARACTER SET utf8;
use SSMforCX;

create table `Account`(
	id INT auto_increment,
	username VARCHAR(20) NOT NULL,
	password VARCHAR(20) NOT NULL,
	PRIMARY KEY(id)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8;

INSERT INTO Account(username,password) VALUES('admin', '1'); 
INSERT INTO Account(username,password) VALUES('ppcli', '1'); 

create table money(
	username VARCHAR(20),
	m DECIMAL
)ENGINE=InnoDB  DEFAULT CHARSET=utf8;

insert into money values('user1',100);
insert into money values('user2',0);

