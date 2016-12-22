CREATE TABLE `place` (
  `placeId` 	int(11) NOT NULL AUTO_INCREMENT,
  `typeId` 		int(11) DEFAULT NULL,
  `name` 		varchar(255) DEFAULT NULL,
  `phone` 		varchar(255) DEFAULT NULL,
  `address` 	varchar(255) DEFAULT NULL,
  `longitude` 	double DEFAULT NULL,
  `latitude` 	double DEFAULT NULL,
  `link` 		varchar(255) DEFAULT NULL,
  `filename` 	varchar(255) DEFAULT NULL,
  `picture` 	longblob ,
  `comment` 	longtext ,
  PRIMARY KEY (`placeId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;