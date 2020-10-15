CREATE DATABASE  IF NOT EXISTS `movies-ratings`;

DROP TABLE IF EXISTS `movies-ratings`.`users`;
CREATE TABLE `movies-ratings`.`users` (
  id INT(11) NOT NULL UNIQUE AUTO_INCREMENT,
  first_name VARCHAR(50)  NOT NULL,
  last_name VARCHAR(50)  NOT NULL,
  username varchar(50) UNIQUE NOT NULL,
  password char(68) NOT NULL,
  enabled tinyint(1) NOT NULL,
  PRIMARY KEY (id,username)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- passwords--
-- piotr - piotr--
-- nati - nati--
-- admin - admin--


INSERT INTO `movies-ratings`.`users` 
VALUES 
(1,'Piotr','Sumara','piotr','{bcrypt}$2a$10$PjD6RC11Ujurn9nSPWo47.ftrr.nRxeOmPcFAXENEXO6vFJ.Cnj8m',1),
(2, 'Natalia', 'Kulig','nati','{bcrypt}$2a$10$Hc7kLmyDzV5FxcEfQ1OItuEwbwP95H/q4YFNupt7FxS7VVrBkZKTS',1),
(3, 'Admin', 'Admin','admin','{bcrypt}$2a$10$kqSAEdSwbCiZKcGsi1SkUe4XB2C3/PjQ8OYFJ42gQk/cAIekwGKdq',1);




DROP TABLE IF EXISTS `movies-ratings`.`authorities`;
CREATE TABLE `movies-ratings`.`authorities` (
  user_id INT(11) NOT NULL UNIQUE AUTO_INCREMENT,
  username varchar(50) NOT NULL UNIQUE NULL,
  authority varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (username,authority),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (user_id,username) REFERENCES users(id,username)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;



INSERT INTO `movies-ratings`.`authorities` 
VALUES 
(3,'admin','ROLE_ADMIN'),
(1,'piotr','ROLE_USER'),
(2,'nati','ROLE_USER');
 
 DROP TABLE IF EXISTS `movies-ratings`.`films`;

 CREATE TABLE `movies-ratings`.`films`(
 id INT(11) NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
 title VARCHAR(50)  UNIQUE NOT NULL,
 release_year VARCHAR(4)  NOT NULL
 )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
 
 DROP TABLE IF EXISTS `movies-ratings`.`series`;

 CREATE TABLE `movies-ratings`.`series`(
 id INT(11) NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
 title VARCHAR(50)  UNIQUE NOT NULL,
 release_year VARCHAR(4)  NOT NULL
 )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


 DROP TABLE IF EXISTS `movies-ratings`.`films_ratings`;

 CREATE TABLE `movies-ratings`.`films_ratings`(
 id INT(11) NOT NULL AUTO_INCREMENT UNIQUE PRIMARY KEY,
 user_id INT(11) NOT NULL,
 film_id INT(11) NOT NULL,
 FOREIGN KEY(user_id) references users(id),
 FOREIGN KEY(film_id) references films(id),
 rating smallint NOT NULL
 )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
 
DROP TABLE IF EXISTS `movies-ratings`.`series_ratings`;

 CREATE TABLE `movies-ratings`.`series_ratings`(
 id INT(11) NOT NULL AUTO_INCREMENT UNIQUE PRIMARY KEY,
 user_id INT(11) NOT NULL,
 serie_id INT(11) NOT NULL,
 FOREIGN KEY(user_id) references users(id),
 FOREIGN KEY(serie_id) references series(id),
 rating smallint NOT NULL
 )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

 
 SELECT * FROM `movies-ratings`.`films_ratings` as A
 INNER JOIN `movies-ratings`.`users` as B
 ON A.user_id = B.id
 INNER JOIN `movies-ratings`.`films` as C
 ON A.film_id = C.id;
 
 SELECT * FROM `movies-ratings`.`series_ratings` as A
 INNER JOIN `movies-ratings`.`users` as B
 ON A.user_id = B.id
 INNER JOIN `movies-ratings`.`series` as C
 ON A.serie_id = C.id;
