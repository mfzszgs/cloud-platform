DROP DATABASE IF EXISTS pressofficewechat;
CREATE DATABASE pressofficewechat DEFAULT CHARACTER SET utf8 COLLATE 'utf8_general_ci';
USE pressofficewechat;

CREATE TABLE msg (
    id   INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(80) ,
    summary VARCHAR(400),
    msgUrl VARCHAR(400),
    thumbMediaId VARCHAR(400),
    msgType INT,
    rank INT
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE typeTable (
    typeNum   INT AUTO_INCREMENT PRIMARY KEY,
	typeName VARCHAR(80)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO typeTable(typeNum,typeName)
VALUES(1,"未分类");
INSERT INTO typeTable(typeNum,typeName)
VALUES(2,"新书消息");
INSERT INTO typeTable(typeNum,typeName)
VALUES(3,"新闻中心");
INSERT INTO typeTable(typeNum,typeName)
VALUES(4,"关于我们");
INSERT INTO typeTable(typeNum,typeName)
VALUES(5,"未定义");
INSERT INTO typeTable(typeNum,typeName)
VALUES(6,"未定义");
INSERT INTO typeTable(typeNum,typeName)
VALUES(7,"未定义");
INSERT INTO typeTable(typeNum,typeName)
VALUES(8,"未定义");
INSERT INTO typeTable(typeNum,typeName)
VALUES(9,"未定义");
INSERT INTO typeTable(typeNum,typeName)
VALUES(10,"未定义");
INSERT INTO typeTable(typeNum,typeName)
VALUES(11,"未定义");
INSERT INTO typeTable(typeNum,typeName)
VALUES(12,"其他");

GRANT ALL PRIVILEGES ON *.* TO 'myuser'@'%'IDENTIFIED BY 'mypassword' WITH GRANT OPTION; 