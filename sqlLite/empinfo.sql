BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS `empinfo` (
	`first`	TEXT,
	`last`	TEXT,
	`id`	INTEGER,
	`age`	INTEGER,
	`city`	TEXT,
	`state`	TEXT
);
INSERT INTO `empinfo` VALUES (NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `empinfo` VALUES (NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `empinfo` VALUES ('Mary','Jones',99982,25,'Payson','Arizona');
INSERT INTO `empinfo` VALUES ('Eric','Edwads',88232,32,'San Diego','California');
INSERT INTO `empinfo` VALUES ('Mary Ann','Edwards',88232,32,'Phoenix','Arizona');
INSERT INTO `empinfo` VALUES ('Ginger','Howell',98002,42,'Cottonwood','Arizona');
INSERT INTO `empinfo` VALUES ('Sebastian','Smith',92001,23,'Gila Bend','Arizona');
INSERT INTO `empinfo` VALUES ('Gus','Gray',22322,35,'Bagdad','Arizona');
INSERT INTO `empinfo` VALUES ('Mary Ann','May',32326,52,'Tucson','Arizona');
INSERT INTO `empinfo` VALUES ('Erica','Williams',32327,60,'Show Low','Arizona');
INSERT INTO `empinfo` VALUES ('Leroy','Brown',32380,22,'Pinetop','Arizona');
INSERT INTO `empinfo` VALUES ('Elroy','Cleaver',32382,22,'Globe','Arizona');
COMMIT;
