DROP TABLE IF EXISTS `USER`;
CREATE TABLE `USER` (
  `Email` varchar(45) NOT NULL,
  `FirstName` varchar(45) NOT NULL,
  `LastName` varchar(45) NOT NULL,
  `ConnectedDate` timestamp NOT NULL,
  `Points` bigint NOT NULL,
  PRIMARY KEY (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;