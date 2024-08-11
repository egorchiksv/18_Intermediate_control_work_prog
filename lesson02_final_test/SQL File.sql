CREATE DATABASE peoplefriends;

USE peoplefriends;

-- 8. Создать таблицы с иерархией из диаграммы в БД
CREATE TABLE Cats (
	Id INT PRIMARY KEY AUTO_INCREMENT,
	AnimalName CHAR(20),
    DateOfBirth DATE,
    Commands TEXT
);

CREATE TABLE Dogs (
	Id INT PRIMARY KEY AUTO_INCREMENT,
	AnimalName CHAR(20),
    DateOfBirth DATE,
    Commands TEXT
);

CREATE TABLE Hamsters (
	Id INT PRIMARY KEY AUTO_INCREMENT,
	AnimalName CHAR(20),
    DateOfBirth DATE,
    Commands TEXT
);

CREATE TABLE Horses (
	Id INT PRIMARY KEY AUTO_INCREMENT,
	AnimalName CHAR(20),
    DateOfBirth DATE,
    Commands TEXT
);

CREATE TABLE Camels (
	Id INT PRIMARY KEY AUTO_INCREMENT,
	AnimalName CHAR(20),
    DateOfBirth DATE,
    Commands TEXT
);

CREATE TABLE Donkeys (
	Id INT PRIMARY KEY AUTO_INCREMENT,
	AnimalName CHAR(20),
    DateOfBirth DATE,
    Commands TEXT
);

-- 9. Заполнить низкоуровневые таблицы именами(животных), командами которые они выполняют и датами рождения
INSERT INTO Cats (AnimalName, Commands, DateOfBirth) VALUES 
	('Whiskers', 'Sit, Pounce', '2019-05-15'),
	('Smudge', 'Sit, Pounce, Scratch', '2020-02-20'),
    ('Oliver', 'Meow, Scratch, Jump', '2020-06-30');
   
INSERT INTO Dogs (AnimalName, Commands, DateOfBirth) VALUES 
	('Fido', 'Sit, Stay, Fetch', '2021-01-01'),
	('Buddy', 'Sit, Paw, Bark', '2018-12-10'),
    ('Bella', 'Sit, Stay, Roll', '2019-11-11');
    
INSERT INTO Hamsters (AnimalName, Commands, DateOfBirth) VALUES 
	('Hammy', 'Roll, Hide', '2021-03-10'),
	('Peanut', 'Roll, Spin', '2021-08-01');
    
INSERT INTO Horses (AnimalName, Commands, DateOfBirth) VALUES 
	('Thunder', 'Trot, Canter, Gallop', '2015-07-21'),
	('Storm', 'Trot, Canter', '2014-05-05'),
    ('Blaze', 'Trot, Jump, Gallop', '2016-02-29');
    
INSERT INTO Camels (AnimalName, Commands, DateOfBirth) VALUES 
	('Sandy', 'Walk, Carry Load', '2016-11-03'),
	('Dune', 'Walk, Sit', '2018-12-12'),
    ('Sahara', 'Walk, Run', '2015-08-14');
    
INSERT INTO Donkeys (AnimalName, Commands, DateOfBirth) VALUES 
	('Eeyore', 'Walk, Carry Load, Bray', '2017-09-18'),
	('Burro', 'Walk, Bray, Kick', '2019-01-23');

/* 10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку. 
Объединить таблицы лошади, и ослы в одну таблицу.
*/
TRUNCATE Camels;

INSERT INTO Horses (AnimalName, Commands, DateOfBirth)
SELECT AnimalName, Commands, DateOfBirth
FROM Donkeys;

DROP TABLE Donkeys;

RENAME TABLE Horses TO Horses_Donkeys;

/* 11.Создать новую таблицу “молодые животные” в которую попадут все животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
до месяца подсчитать возраст животных в новой таблице
*/
CREATE TABLE YoungAnimals (
	Id INT PRIMARY KEY AUTO_INCREMENT,
	AnimalName CHAR(20),
    Commands TEXT,
    DateOfBirth DATE,
    Age TEXT
);


DELIMITER $$
CREATE FUNCTION AgeAnimals (date_b DATE)
RETURNS TEXT
DETERMINISTIC
BEGIN
    DECLARE res TEXT DEFAULT '';
	SET res = CONCAT(
            TIMESTAMPDIFF(YEAR, date_b, CURDATE()),
            ' years ',
            TIMESTAMPDIFF(MONTH, date_b, CURDATE()) % 12,
            ' month'
        );
	RETURN res;
END $$
DELIMITER ;

INSERT INTO YoungAnimals (AnimalName, Commands, DateOfBirth, Age)
SELECT AnimalName, Commands, DateOfBirth, AgeAnimals(DateOfBirth)
FROM Cats
WHERE TIMESTAMPDIFF(YEAR, DateOfBirth, CURDATE()) BETWEEN 1 AND 3
UNION ALL
SELECT AnimalName, Commands, DateOfBirth, AgeAnimals(DateOfBirth)
FROM Dogs
WHERE TIMESTAMPDIFF(YEAR, DateOfBirth, CURDATE()) BETWEEN 1 AND 3
UNION ALL
SELECT AnimalName, Commands, DateOfBirth, AgeAnimals(DateOfBirth)
FROM Hamsters
WHERE TIMESTAMPDIFF(YEAR, DateOfBirth, CURDATE()) BETWEEN 1 AND 3
UNION ALL
SELECT AnimalName, Commands, DateOfBirth, AgeAnimals(DateOfBirth)
FROM Horses_Donkeys
WHERE TIMESTAMPDIFF(YEAR, DateOfBirth, CURDATE()) BETWEEN 1 AND 3;

SET SQL_SAFE_UPDATES = 0;

DELETE FROM Cats 
WHERE TIMESTAMPDIFF(YEAR, DateOfBirth, CURDATE()) IN (1, 2, 3);

DELETE FROM Dogs 
WHERE TIMESTAMPDIFF(YEAR, DateOfBirth, CURDATE()) BETWEEN 1 AND 3;

DELETE FROM Hamsters
WHERE TIMESTAMPDIFF(YEAR, DateOfBirth, CURDATE()) BETWEEN 1 AND 3;

DELETE FROM Horses_Donkeys 
WHERE TIMESTAMPDIFF(YEAR, DateOfBirth, CURDATE()) BETWEEN 1 AND 3;

/* 12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
прошлую принадлежность к старым таблицам.
*/
CREATE TABLE Animals (
	Id INT PRIMARY KEY AUTO_INCREMENT,
	AnimalName CHAR(20),
    Commands TEXT,
    DateOfBirth DATE,
    Age TEXT,
    AnimalType CHAR(20)
);

INSERT INTO Animals (AnimalName, Commands, DateOfBirth, Age, AnimalType)
SELECT AnimalName, Commands, DateOfBirth, AgeAnimals(DateOfBirth), 'cat'
FROM Cats;

INSERT INTO Animals (AnimalName, Commands, DateOfBirth, Age, AnimalType)
SELECT AnimalName, Commands, DateOfBirth, AgeAnimals(DateOfBirth), 'dog'
FROM Dogs;

INSERT INTO Animals (AnimalName, Commands, DateOfBirth, Age, AnimalType)
SELECT AnimalName, Commands, DateOfBirth, AgeAnimals(DateOfBirth), 'hamster'
FROM Hamsters;

INSERT INTO Animals (AnimalName, Commands, DateOfBirth, Age, AnimalType)
SELECT AnimalName, Commands, DateOfBirth, AgeAnimals(DateOfBirth), 'horse_donkey'
FROM Horses_Donkeys;

INSERT INTO Animals (AnimalName, Commands, DateOfBirth, Age, AnimalType)
SELECT AnimalName, Commands, DateOfBirth, AgeAnimals(DateOfBirth), 'younganimal'
FROM YoungAnimals;