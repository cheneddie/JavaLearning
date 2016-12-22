CREATE TABLE `pet` (
  `id`          int   NOT NULL Primary Key AUTO_INCREMENT,  
  `petname` 	varchar(20) DEFAULT NULL,
  `masterName`  varchar(32) DEFAULT NULL,
  `birthday`    date  DEFAULT NULL,
  `price`       int DEFAULT NULL,
  `weight`      double DEFAULT NULL,
  `filename` 	varchar(60) DEFAULT NULL,
  `picture` 	longblob ,
  `comment` 	longtext 
) 
ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;