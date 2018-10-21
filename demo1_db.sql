/*
MySQL Backup
Source Server Version: 5.5.5
Source Database: demodb1
Date: 10/21/2018 19:17:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
--  Table structure for `specializations`
-- ----------------------------
DROP TABLE IF EXISTS `specializations`;
CREATE TABLE `specializations` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `NumberCredit` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_st0bjplrx44hqis27rt2mf5vr` (`Name`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records 
-- ----------------------------
INSERT INTO `specializations` VALUES ('1','JAVA','61'), ('2','C#','62'), ('5','BUSINESS ADMINISTRATOR','50'), ('7','ASSEMBLY','90'), ('19','LUA','120'), ('20','SWIFT','70'), ('21','KOTLIN ANDROID','90'), ('22','INTERNATIONAL BUSINESS','56');
