
CREATE TABLE `TEST` (
  `ID` int NOT NULL AUTO_INCREMENT ,
  `PARENT_FK` int DEFAULT NULL ,
  `NAME` varchar(50) ,
  `COLOR` varchar(50),
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ;

INSERT INTO TEST (id, PARENT_FK, NAME, COLOR) VALUES (1, 0, 'Warrior', 'red');
INSERT INTO TEST (id, PARENT_FK, NAME, COLOR) VALUES (2, 0, 'Wizard', 'green');
INSERT INTO TEST (id, PARENT_FK, NAME, COLOR) VALUES (3, 0, 'Priest', 'white');
INSERT INTO TEST (id, PARENT_FK, NAME, COLOR) VALUES (4, 0, 'Rogue', 'yellow');
INSERT INTO TEST (id, PARENT_FK, NAME, COLOR) VALUES (5, 1, 'Fighter', 'blue');
INSERT INTO TEST (id, PARENT_FK, NAME, COLOR) VALUES (6, 1, 'Paladin', 'lightblue');
INSERT INTO TEST (id, PARENT_FK, NAME, COLOR) VALUES (7, 1, 'Ranger', 'lightgreen');
INSERT INTO TEST (id, PARENT_FK, NAME, COLOR) VALUES (8, 2, 'Mage', 'grey');
INSERT INTO TEST (id, PARENT_FK, NAME, COLOR) VALUES (9, 2, 'Specialist wizard', 'lightgrey');
INSERT INTO TEST (id, PARENT_FK, NAME, COLOR) VALUES (10, 3, 'Cleric', 'red');
INSERT INTO TEST (id, PARENT_FK, NAME, COLOR) VALUES (11, 3, 'Druid', 'green');
INSERT INTO TEST (id, PARENT_FK, NAME, COLOR) VALUES (12, 3, 'Priest', 'white');
INSERT INTO TEST (id, PARENT_FK, NAME, COLOR) VALUES (13, 4, 'Thief', 'yellow');
INSERT INTO TEST (id, PARENT_FK, NAME, COLOR) VALUES (14, 4, 'Bard', 'blue');
INSERT INTO TEST (id, PARENT_FK, NAME, COLOR) VALUES (15, 13, 'Assassin', 'lightblue');




