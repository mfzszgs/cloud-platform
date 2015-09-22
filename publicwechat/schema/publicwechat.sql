DROP DATABASE IF EXISTS publicWechat;
CREATE DATABASE publicWechat DEFAULT CHARACTER SET utf8 COLLATE 'utf8_general_ci';
USE publicWechat;

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
VALUES(2,"一口粗饭");
INSERT INTO typeTable(typeNum,typeName)
VALUES(3,"一栋老宅");
INSERT INTO typeTable(typeNum,typeName)
VALUES(4,"一颗古树");
INSERT INTO typeTable(typeNum,typeName)
VALUES(5,"一双巧手");
INSERT INTO typeTable(typeNum,typeName)
VALUES(6,"一抹缤纷");
INSERT INTO typeTable(typeNum,typeName)
VALUES(7,"一段过往");
INSERT INTO typeTable(typeNum,typeName)
VALUES(8,"一帧剪影");
INSERT INTO typeTable(typeNum,typeName)
VALUES(9,"一亩田园");
INSERT INTO typeTable(typeNum,typeName)
VALUES(10,"口述乡村");
INSERT INTO typeTable(typeNum,typeName)
VALUES(11,"乡村民俗");
INSERT INTO typeTable(typeNum,typeName)
VALUES(12,"其他");

GRANT ALL PRIVILEGES ON *.* TO 'myuser'@'%'IDENTIFIED BY 'mypassword' WITH GRANT OPTION; 