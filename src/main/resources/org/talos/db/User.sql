DROP TABLE IF EXISTS `USER`;
CREATE TABLE `USER` (
  `Email` varchar(45) NOT NULL,
  `First_Name` varchar(45) NOT NULL,
  `Last_Name` varchar(45) NOT NULL,
  `Connected_Date` timestamp NOT NULL,
  `Points` bigint NOT NULL,
  PRIMARY KEY (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;