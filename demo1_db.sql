/*
MySQL Backup
Source Server Version: 5.5.5
Source Database: demodb1
Date: 10/19/2018 09:22:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
--  Table structure for `specializations`
-- ----------------------------
DROP TABLE IF EXISTS `specializations`;
CREATE TABLE `specializations` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(150) COLLATE utf8_vietnamese_ci NOT NULL,
  `NumberCredit` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- ----------------------------
--  Records 
-- ----------------------------
INSERT INTO `specializations` VALUES ('21','INTERNET OF THINGS','55'), ('22','ARDUINO','60'), ('23','C#','65'), ('25','JAVA','65'), ('27','JAVA','65');
