DROP DATABASE IF EXISTS crowder;
CREATE DATABASE crowder DEFAULT CHARACTER SET utf8 COLLATE 'utf8_general_ci';
USE crowder;

CREATE TABLE crowderTable (
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) ,
    sex VARCHAR(1),
    age INT,
    occupation VARCHAR(20),
	phone VARCHAR(20),
	email VARCHAR(30),
	provice VARCHAR(20),
	city VARCHAR(20),
	address VARCHAR(100)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

GRANT ALL PRIVILEGES ON *.* TO 'myuser'@'%'IDENTIFIED BY 'mypassword' WITH GRANT OPTION; 