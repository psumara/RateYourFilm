CREATE DATABASE  IF NOT EXISTS `movies-ratings`;

 DROP TABLE IF EXISTS `movies-ratings`.`users`;

 CREATE TABLE `movies-ratings`.`users`(
 user_id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
 first_name VARCHAR(50)  NOT NULL,
 last_name VARCHAR(50)  NOT NULL
 )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

 INSERT INTO `movies-ratings`.`users` VALUES
 (1, 'Piotr', 'Sumara'),
 (2, 'Natalia', 'Kulig');

 DROP TABLE IF EXISTS `movies-ratings`.`films`;

 CREATE TABLE `movies-ratings`.`films`(
 film_id INT PRIMARY KEY,
 title VARCHAR(50)  UNIQUE NOT NULL,
 release_year VARCHAR(4)  NOT NULL
 );

 INSERT INTO `movies-ratings`.`films`
 VALUES
 (1,'Piraci z karaibów', 2004);

 DROP TABLE IF EXISTS `movies-ratings`.`ratings`;

 CREATE TABLE `movies-ratings`.`ratings`(
 user_id INT NOT NULL,
 film_id INT NOT NULL,
 title VARCHAR(50) NOT NULL,
 FOREIGN KEY(user_id) references users(user_id),
 FOREIGN KEY(film_id) references films(film_id),
 FOREIGN KEY(title) references films(title),
 rating smallint NOT NULL
 );

 INSERT INTO `movies-ratings`.`ratings`(user_id, film_id, title, rating)
 VALUES
 (1,1,'Piraci z karaibów',5),
 (2,1,'Piraci z karaibów',5);

 SELECT * FROM `movies-ratings`.`ratings` as A
 INNER JOIN `movies-ratings`.`users` as B
 ON A.user_id = B.user_id
 INNER JOIN `movies-ratings`.`films` as C
 ON A.film_id = C.film_id
 AND  A.title = C.title