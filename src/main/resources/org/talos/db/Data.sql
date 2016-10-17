DROP TABLE IF EXISTS `DATA`;
CREATE TABLE `DATA` (
  `Email` varchar(45) NOT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TimeStamp` timestamp NOT NULL,
  `User` varchar(45) NOT NULL,
  `Operator` varchar(45) NOT NULL,
  `NetworkType` varchar(45) NOT NULL,
  `Cinr` int(11) NOT NULL,
  `Latitude` decimal(13,10) NOT NULL,
  `Longitude` decimal(13,10) NOT NULL,
  PRIMARY KEY (`ID`, `Email`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;