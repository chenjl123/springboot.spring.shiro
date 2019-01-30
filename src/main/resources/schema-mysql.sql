DROP TABLE IF EXISTS user_info;
create table user_info(
   id INT NOT NULL AUTO_INCREMENT,
   username VARCHAR(10) NOT NULL,
   password VARCHAR(32) NOT NULL,
   telephone VARCHAR(15) NOT NULL,
   isadmin INT(2) NOT NULL DEFAULT 0,
   entry_date TIMESTAMP NOT NULL DEFAULT current_timestamp(),
   PRIMARY KEY ( id )
)engine=innodb default charset=utf8 auto_increment=1;

DROP TABLE IF EXISTS role;
create table role(
   id INT NOT NULL AUTO_INCREMENT,
   name VARCHAR(10) NOT NULL,
   entry_date TIMESTAMP  NOT NULL DEFAULT current_timestamp(),
   PRIMARY KEY ( id )
)engine=innodb default charset=utf8 auto_increment=1;

DROP TABLE IF EXISTS urls;
create table urls(
   id INT NOT NULL AUTO_INCREMENT,
   name VARCHAR(10) NOT NULL,
   link_url VARCHAR(255) NOT NULL,
   entry_date TIMESTAMP NOT NULL DEFAULT current_timestamp() ,
   PRIMARY KEY ( id )
)engine=innodb default charset=utf8 auto_increment=1;

DROP TABLE IF EXISTS user_urls;
create table user_urls(
   id INT NOT NULL AUTO_INCREMENT,
   userid int NOT NULL,
   urlsid int NOT NULL,
   entry_date TIMESTAMP NOT NULL  DEFAULT current_timestamp(),
   PRIMARY KEY ( id )
)engine=innodb default charset=utf8 auto_increment=1;

DROP TABLE IF EXISTS role_urls;
create table role_urls(
   id INT NOT NULL AUTO_INCREMENT,
   roleid int NOT NULL,
   urlsid int NOT NULL,
   entry_date TIMESTAMP NOT NULL  DEFAULT current_timestamp(),
   PRIMARY KEY ( id )
)engine=innodb default charset=utf8 auto_increment=1;

DROP TABLE IF EXISTS user_role;
create table user_role(
   id INT NOT NULL AUTO_INCREMENT,
   roleid int NOT NULL,
   userid int NOT NULL,
   entry_date TIMESTAMP NOT NULL  DEFAULT current_timestamp(),
   PRIMARY KEY ( id )
)engine=innodb default charset=utf8 auto_increment=1;