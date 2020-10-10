CREATE DATABASE  IF NOT EXISTS `movies-ratings`;

DROP TABLE IF EXISTS `movies-ratings`.`users`;

CREATE TABLE `movies-ratings`.`users`(
user_id INT PRIMARY KEY,
first_name VARCHAR(50)  NOT NULL,
last_name VARCHAR(50)  NOT NULL
);

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
FOREIGN KEY(user_id) references users(user_id),
FOREIGN KEY(film_id) references films(film_id),
rating smallint NOT NULL
);

INSERT INTO `movies-ratings`.`ratings`(user_id, film_id, rating)
VALUES
(1,1,5),
(2,1,5);

SELECT * FROM ratings
INNER JOIN users
ON ratings.user_id = users.user_id
INNER JOIN films
ON ratings.film_id = films.film_id
	