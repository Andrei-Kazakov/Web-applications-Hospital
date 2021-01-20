USE `hospital_db`;

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `login` varchar(200) NOT NULL UNIQUE,
  `password` int NOT NULL,
  `role` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idUser_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `hospital` (
  `idHospital` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `adress` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idHospital`),
  UNIQUE KEY `idHospital_UNIQUE` (`idHospital`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `patient` (
  `idPatient` int NOT NULL AUTO_INCREMENT,
  `User_id` int NOT NULL,
  PRIMARY KEY (`idPatient`),
  KEY `fk_Patient_User1_idx` (`User_id`),
  CONSTRAINT `fk_Patient_User1` FOREIGN KEY (`User_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;