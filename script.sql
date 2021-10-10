-- font: https://www.mysqltutorial.org/mysql-primary-key/

drop database project1;
create database project1;

use project1;

CREATE TABLE config (
    id int AUTO_INCREMENT,
    name varchar(255),
    db varchar(30),
    PRIMARY KEY(id)
);

INSERT INTO config (id, name, db) VALUES (1, 'Config Project 1','project1');

create table people (
    id serial not null primary key,
    first_name varchar(20) not null,
    last_name varchar(20) not null,
    age integer not null
);

insert into people (id, first_name, last_name, age) values
(1, 'Vlad', 'Boyarskiy', 21),
(2,'Oksi', ' Bahatskaya', 30),
(3,'Vadim', ' Vadimich', 32);

CREATE TABLE product (
    id int AUTO_INCREMENT,
    name varchar(255),
    quantity int,
    price double,
    PRIMARY KEY(id)
);

CREATE TABLE users (
   id INT AUTO_INCREMENT PRIMARY KEY,
   email VARCHAR(128),
   enabled TINYINT,
   first_name VARCHAR(45),
   last_name VARCHAR(45),
   password VARCHAR(45),
   photos VARCHAR(64)
);

ALTER TABLE users
ADD UNIQUE INDEX first_name_unique (first_name ASC) ;

ALTER TABLE users
ADD UNIQUE INDEX  email_unique (email ASC) ;

CREATE TABLE roles(
   id INT AUTO_INCREMENT,
   name VARCHAR(40),
   description VARCHAR(150),
   PRIMARY KEY(id)
);

CREATE TABLE user_roles(
   user_id INT,
   role_id INT,
   PRIMARY KEY(user_id,role_id),
   FOREIGN KEY(user_id)
       REFERENCES users(id),
   FOREIGN KEY(role_id)
       REFERENCES roles(id)
);

CREATE TABLE pkdemos(
   id INT,
   title VARCHAR(255) NOT NULL
);

ALTER TABLE pkdemos
ADD PRIMARY KEY(id);


CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

