CREATE DATABASE  IF NOT EXISTS `movies-ratings`;

 DROP TABLE IF EXISTS `movies-ratings`.`users`;

 CREATE TABLE `movies-ratings`.`users`(
 id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
 first_name VARCHAR(50)  NOT NULL,
 last_name VARCHAR(50)  NOT NULL
 )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- passwords--
-- piotr - piotr--
-- nati - nati--
-- admin - admin--
 INSERT INTO `movies-ratings`.`users` VALUES
(1, 'Piotr', 'Sumara'),
(2, 'Natalia', 'Kulig'),
(3, 'Admin','Admin');

CREATE TABLE `movies-ratings`.`security_users` (
  username varchar(50) NOT NULL,
  password char(68) NOT NULL,
  enabled tinyint(1) NOT NULL,
  user_id INT(11) NOT NULL,
  PRIMARY KEY (username),
  FOREIGN KEY (user_id) REFERENCES users(id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `movies-ratings`.`security_users` VALUES
('piotr','{bcrypt}$2a$10$PjD6RC11Ujurn9nSPWo47.ftrr.nRxeOmPcFAXENEXO6vFJ.Cnj8m',1,1),
('nati','{bcrypt}$2a$10$Hc7kLmyDzV5FxcEfQ1OItuEwbwP95H/q4YFNupt7FxS7VVrBkZKTS',1,2),
('admin','{bcrypt}$2a$10$kqSAEdSwbCiZKcGsi1SkUe4XB2C3/PjQ8OYFJ42gQk/cAIekwGKdq',1,3);


DROP TABLE IF EXISTS `movies-ratings`.`authorities`;
CREATE TABLE `movies-ratings`.`authorities` (
  username varchar(50) NOT NULL,
  authority varchar(50) NOT NULL,
  FOREIGN KEY (username) REFERENCES security_users (username)
  
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `movies-ratings`.`authorities` 
VALUES 
('admin','ROLE_ADMIN'),
('piotr','ROLE_USER'),
('nati','ROLE_USER');


 DROP TABLE IF EXISTS `movies-ratings`.`films`;

 CREATE TABLE `movies-ratings`.`films`(
 id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
 title VARCHAR(50)  UNIQUE NOT NULL,
 release_year VARCHAR(4)  NOT NULL
 )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

 INSERT INTO `movies-ratings`.`films`
 VALUES
 (1,'Piraci z karaibów', 2004);

 DROP TABLE IF EXISTS `movies-ratings`.`ratings`;

 CREATE TABLE `movies-ratings`.`ratings`(
 rating_id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
 user_id INT(11) NOT NULL,
 film_id INT(11) NOT NULL,
 FOREIGN KEY(user_id) references users(id),
 FOREIGN KEY(film_id) references films(id),
 rating smallint NOT NULL
 )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

 INSERT INTO `movies-ratings`.`ratings`(user_id, film_id, rating)
 VALUES
 (1,1,5),
 (2,1,5);

 SELECT * FROM `movies-ratings`.`ratings` as A
 INNER JOIN `movies-ratings`.`users` as B
 ON A.user_id = B.id
 INNER JOIN `movies-ratings`.`films` as C
 ON A.film_id = C.id
