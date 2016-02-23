CREATE TABLE `data` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Time_Stamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `User` varchar(45) NOT NULL,
  `Operator` varchar(45) NOT NULL,
  `Cinr` int(11) NOT NULL,
  `Latitude` decimal(13,10) NOT NULL,
  `Longtitude` decimal(13,10) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
