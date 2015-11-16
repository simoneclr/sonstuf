SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user` (
  `iduser` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `surname` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `email` VARCHAR(100) NULL,
  `passwordhash` VARCHAR(200) NULL,
  `ranko` VARCHAR(45) NULL,
  `rankp` VARCHAR(45) NULL,
  `birthday` VARCHAR(45) NULL,
  PRIMARY KEY (`iduser`),
  UNIQUE INDEX `phone_UNIQUE` (`phone` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`category` (
  `idcategory` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `description` TEXT NULL,
  PRIMARY KEY (`idcategory`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`request`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`request` (
  `idrequest` INT NOT NULL AUTO_INCREMENT,
  `title` TEXT NOT NULL,
  `description` TEXT NOT NULL,
  `place` TEXT NOT NULL,
  `datetime` TEXT NOT NULL,
  `photo` TEXT NULL,
  `iduser` INT NOT NULL,
  `idcategory` INT NOT NULL,
  PRIMARY KEY (`idrequest`),
  INDEX `fk_request_user_idx` (`iduser` ASC),
  INDEX `fk_request_category1_idx` (`idcategory` ASC),
  CONSTRAINT `fk_request_user`
    FOREIGN KEY (`iduser`)
    REFERENCES `mydb`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_request_category1`
    FOREIGN KEY (`idcategory`)
    REFERENCES `mydb`.`category` (`idcategory`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`offer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`offer` (
  `idoffer` INT NOT NULL AUTO_INCREMENT,
  `isincharge` TINYINT(1) NOT NULL DEFAULT 0,
  `idrequest` INT NOT NULL,
  `iduser` INT NOT NULL,
  PRIMARY KEY (`idoffer`),
  INDEX `fk_offer_request1_idx` (`idrequest` ASC),
  INDEX `fk_offer_user1_idx` (`iduser` ASC),
  UNIQUE INDEX `idrequest_iduser` (`idrequest` ASC, `iduser` ASC),
  CONSTRAINT `fk_offer_request1`
    FOREIGN KEY (`idrequest`)
    REFERENCES `mydb`.`request` (`idrequest`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_offer_user1`
    FOREIGN KEY (`iduser`)
    REFERENCES `mydb`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`message`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`message` (
  `idmessage` INT NOT NULL AUTO_INCREMENT,
  `datetime` TIMESTAMP NULL,
  `message` TEXT NULL,
  `idoffer` INT NOT NULL,
  `idsender` INT NOT NULL,
  PRIMARY KEY (`idmessage`),
  INDEX `fk_message_offer1_idx` (`idoffer` ASC),
  INDEX `fk_message_user1_idx` (`idsender` ASC),
  CONSTRAINT `fk_message_offer1`
    FOREIGN KEY (`idoffer`)
    REFERENCES `mydb`.`offer` (`idoffer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_message_user1`
    FOREIGN KEY (`idsender`)
    REFERENCES `mydb`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`offererrank`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`offererrank` (
  `rank` INT NOT NULL,
  `comment` TEXT NULL,
  `offer_idoffer` INT NOT NULL,
  PRIMARY KEY (`offer_idoffer`),
  CONSTRAINT `fk_offererrank_offer1`
    FOREIGN KEY (`offer_idoffer`)
    REFERENCES `mydb`.`offer` (`idoffer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`requesterrank`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`requesterrank` (
  `rank` INT NOT NULL,
  `comment` TEXT NULL,
  `idoffer` INT NOT NULL,
  PRIMARY KEY (`idoffer`),
  CONSTRAINT `fk_requesterrank_offer1`
    FOREIGN KEY (`idoffer`)
    REFERENCES `mydb`.`offer` (`idoffer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
