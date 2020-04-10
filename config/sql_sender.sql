-- -----------------------------------------------------
-- Schema sql_sender
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `sql_sender`;
CREATE SCHEMA IF NOT EXISTS `sql_sender` DEFAULT CHARACTER SET utf8mb4;
USE `sql_sender` ;

-- -----------------------------------------------------
-- Table `sql_sender`.`Role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql_sender`.`Role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `title_UNIQUE` (`title` ASC) VISIBLE);


-- -----------------------------------------------------
-- Table `sql_sender`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql_sender`.`User` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(70) NOT NULL,
  `Role_id` INT,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idUser_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
  INDEX `fk_User_Role1_idx` (`Role_id` ASC) VISIBLE,
  CONSTRAINT `fk_User_Role1`
    FOREIGN KEY (`Role_id`)
    REFERENCES `sql_sender`.`Role` (`id`)
    ON DELETE  SET NULL
    ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Table `sql_sender`.`Request_result`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql_sender`.`Request_result` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `message` VARCHAR(600) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);


-- -----------------------------------------------------
-- Table `sql_sender`.`Request`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql_sender`.`Request` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `text` VARCHAR(600) NOT NULL,
  `execute_date` DATETIME NOT NULL,
  `User_id` INT NOT NULL,
  `Request_result_id` INT,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idRequest_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_Request_User_idx` (`User_id` ASC) VISIBLE,
  INDEX `fk_Request_Request_result1_idx` (`Request_result_id` ASC) VISIBLE,
  CONSTRAINT `fk_Request_User`
    FOREIGN KEY (`User_id`)
    REFERENCES `sql_sender`.`User` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Request_Request_result1`
    FOREIGN KEY (`Request_result_id`)
    REFERENCES `sql_sender`.`Request_result` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Table `sql_sender`.`Location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql_sender`.`Location` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `title_UNIQUE` (`title` ASC) VISIBLE);


-- -----------------------------------------------------
-- Table `sql_sender`.`Event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql_sender`.`Event` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `summary` VARCHAR(600) NOT NULL,
  `date` DATETIME NOT NULL,
  `Location_id` INT NOT NULL,
  `price` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `title_UNIQUE` (`title` ASC) VISIBLE,
  INDEX `fk_Event_Location1_idx` (`Location_id` ASC) VISIBLE,
  CONSTRAINT `fk_Event_Location1`
    FOREIGN KEY (`Location_id`)
    REFERENCES `sql_sender`.`Location` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Table `sql_sender`.`Ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql_sender`.`Ticket` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `User_id` INT NOT NULL,
  `Event_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_Ticket_User1_idx` (`User_id` ASC) VISIBLE,
  INDEX `fk_Ticket_Event1_idx` (`Event_id` ASC) VISIBLE,
  CONSTRAINT `fk_Ticket_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `sql_sender`.`User` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Ticket_Event1`
    FOREIGN KEY (`Event_id`)
    REFERENCES `sql_sender`.`Event` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Table `sql_sender`.`Log_record`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql_sender`.`Log_record` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Request_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Log_record_Request1_idx` (`Request_id` ASC) VISIBLE,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  CONSTRAINT `fk_Log_record_Request1`
    FOREIGN KEY (`Request_id`)
    REFERENCES `sql_sender`.`Request` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

-- -----------------------------------------------------
-- Filling the table(`sql_sender`.`Role`) with test data
-- -----------------------------------------------------
INSERT INTO `sql_sender`.`role` (`id`, `title`) VALUES ('1', 'ADMIN');
INSERT INTO `sql_sender`.`role` (`id`, `title`) VALUES ('2', 'USER');

-- -----------------------------------------------------
-- Filling the table(`sql_sender`.`User`) with test data
-- -----------------------------------------------------
INSERT INTO `sql_sender`.`user` (`id`, `username`, `password`, `Role_id`) VALUES ('1', 'admin', 'admin', '1');

-- -----------------------------------------------------
-- Filling the table(`sql_sender`.`Location`) with test data
-- -----------------------------------------------------
INSERT INTO `sql_sender`.`location` (`id`, `title`) VALUES ('1', 'Кинотеатр \"Ракета\"');
INSERT INTO `sql_sender`.`location` (`id`, `title`) VALUES ('2', 'КЗ \"Минск\"');
INSERT INTO `sql_sender`.`location` (`id`, `title`) VALUES ('3', 'Prime Hall ');

-- -----------------------------------------------------
-- Filling the table(`sql_sender`.`Event`) with test data
-- -----------------------------------------------------
INSERT INTO `sql_sender`.`event` (`id`, `title`, `summary`, `date`, `Location_id`, `price`) VALUES ('1', 'Джокер', 'Готэм, начало 1980-х годов. Комик Артур Флек живет с больной матерью, которая с детства учит его «ходить с улыбкой». Пытаясь нести в мир хорошее и дарить людям радость, Артур сталкивается с человеческой жестокостью и постепенно приходит к выводу, что этот мир получит от него не добрую улыбку, а ухмылку злодея Джокера.', '2020-10-12 14:32:44', '1', '10');
INSERT INTO `sql_sender`.`event` (`id`, `title`, `summary`, `date`, `Location_id`, `price`) VALUES ('2', 'Таксист', 'Ветеран вьетнамской войны Трэйвис Бикл ведет свое одинокое такси по ночным улицам бесконечного города, и перед ним разворачивается мрачная панорама человеческих грехов. Как ветхозаветный пророк, он надеется, что однажды небеса пошлют на землю спасительный дождь, который очистит Нью-Йорк от вековой грязи.', '2021-11-20 20:12:40', '1', '12');

-- -----------------------------------------------------
-- Filling the table(`sql_sender`.`Ticket`) with test data
-- -----------------------------------------------------
INSERT INTO `sql_sender`.`ticket` (`id`, `User_id`, `Event_id`) VALUES ('1', '1', '1');

-- -----------------------------------------------------
-- Filling the table(`sql_sender`.`Request_result`) with test data
-- -----------------------------------------------------
INSERT INTO `sql_sender`.`request_result` (`id`, `message`) VALUES ('1', '0 row(s) returned');

-- -----------------------------------------------------
-- Filling the table(`sql_sender`.`Request`) with test data
-- -----------------------------------------------------
INSERT INTO `sql_sender`.`request` (`id`, `text`, `execute_date`, `User_id`, `Request_result_id`) VALUES ('1', 'SELECT * FROM sql_sender.request;', '2020-10-12 14:32:44', '1', '1');

-- -----------------------------------------------------
-- Filling the table(`sql_sender`.`Location`) with test data
-- -----------------------------------------------------
INSERT INTO `sql_sender`.`log_record` (`id`, `Request_id`) VALUES ('1', '1');


