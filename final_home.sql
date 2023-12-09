DROP DATABASE IF EXISTS peopleFriends;
CREATE DATABASE peopleFriends;
USE peopleFriends;

-- Создание и заполнение низкоуровневых таблиц
CREATE TABLE IF NOT EXISTS dog
(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(20) NOT NULL,
	birthday DATE,
	breed INT,
	commands TEXT
);
CREATE TABLE IF NOT EXISTS cat
(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(20) NOT NULL,
	birthday DATE,
	breed INT,
	commands TEXT
);
CREATE TABLE IF NOT EXISTS hamster
(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(20) NOT NULL,
	birthday DATE,
	breed INT,
	commands TEXT
);
CREATE TABLE IF NOT EXISTS horse
(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(20) NOT NULL,
	birthday DATE,
	breed INT,
	commands TEXT
);
CREATE TABLE IF NOT EXISTS donkey
(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(20) NOT NULL,
	birthday DATE,
	breed INT,
	commands TEXT
);
CREATE TABLE IF NOT EXISTS camel
(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(20) NOT NULL,
	birthday DATE,
	breed INT,
	commands TEXT
);

INSERT INTO dog (name,birthday,breed,commands)
VALUES
	('Fido', '2020-01-01', 1, 'Sit, Stay, Fetch'),
    ('Buddy', '2018-12-10', 1, 'Sit, Paw, Bark'),
    ('Bella', '2019-11-11', 1, 'Sit, Stay, Roll');
INSERT INTO cat (name,birthday,breed,commands)
VALUES
	('Whiskers','2019-05-15',2,'Sit, Pounce'),
    ('Smudge','2020-02-20',2,'Sit, Pounce, Scratch'),
    ('Oliver','2020-06-30',2,'Meow, Scratch, Jump');
INSERT INTO hamster (name,birthday,breed,commands)
VALUES
	('Hammy', '2021-03-10', 3, 'Roll, Hide'),
    ('Peanut', '2021-08-01', 3, 'Roll, Spin');
INSERT INTO horse (name,birthday,breed,commands)
VALUES
	('Thunder','2015-07-21',4,'Trot, Canter, Gallop'),
    ('Storm','2014-05-05',4,'Trot, Canter'),
    ('Blaze','2016-02-29',4,'Trot, Jump, Gallop');
INSERT INTO donkey (name,birthday,breed,commands)
VALUES
	('Eeyore','2017-09-18',5,'Walk, CarryLoad, Bray'),
    ('Burro','2019-01-23',5,'Walk, Bray, Kick');
INSERT INTO camel (name,birthday,breed,commands)
VALUES
	('Sandy','2016-11-03',6,'Walk, CarryLoad'),
    ('Dune','2018-12-12',6,'Walk, Sit'),
    ('Sahara','2015-08-14',6,'Walk, Run');

-- Удаление верблюдов
DROP TABLE camel;

-- Объединение ослов и лошадей
CREATE TABLE IF NOT EXISTS horse_donkey AS
	SELECT name,birthday,breed,commands
	FROM horse;
INSERT INTO horse_donkey (name,birthday,breed,commands)
SELECT name,birthday,breed,commands FROM donkey;


-- Общая таблица
CREATE TABLE IF NOT EXISTS animal
(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(20) NOT NULL,
	birthday DATE,
	breed INT,
	commands TEXT,
	animal_type VARCHAR(20)
);	
INSERT INTO animal (name,birthday,breed,commands,animal_type)
SELECT name,birthday,breed,commands,"dog"
FROM dog
UNION
SELECT name,birthday,breed,commands,'cat'
FROM cat 
UNION
SELECT name,birthday,breed,commands,'hamster'
FROM hamster 
UNION
SELECT name,birthday,breed,commands,'horse'
FROM horse
UNION
SELECT name,birthday,breed,commands,'donkey'
FROM donkey;

-- Молодые животные
CREATE TABLE IF NOT EXISTS little_animal
(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(20) NOT NULL,
	birthday DATE,
	breed INT,
	commands TEXT,
	age INT
);
INSERT INTO little_animal (name,birthday,breed,commands,age)
SELECT name,birthday,breed,commands, TIMESTAMPDIFF(MONTH,birthday,CURDATE()) as age
FROM dog
WHERE TIMESTAMPDIFF(MONTH,birthday,CURDATE()) BETWEEN 12 AND 36 
UNION
SELECT name,birthday,breed,commands,TIMESTAMPDIFF(MONTH,birthday,CURDATE()) as age
FROM cat
WHERE TIMESTAMPDIFF(MONTH,birthday,CURDATE()) BETWEEN 12 AND 36 
UNION
SELECT name,birthday,breed,commands,TIMESTAMPDIFF(MONTH,birthday,CURDATE()) as age
FROM hamster
WHERE TIMESTAMPDIFF(MONTH,birthday,CURDATE()) BETWEEN 12 AND 36 
UNION
SELECT name,birthday,breed,commands,TIMESTAMPDIFF(MONTH,birthday,CURDATE()) as age 
FROM horse
WHERE TIMESTAMPDIFF(MONTH,birthday,CURDATE()) BETWEEN 12 AND 36 
UNION
SELECT name,birthday,breed,commands,TIMESTAMPDIFF(MONTH,birthday,CURDATE()) as age
FROM donkey
WHERE TIMESTAMPDIFF(MONTH,birthday,CURDATE()) BETWEEN 12 AND 36 ;

Select * from animal;