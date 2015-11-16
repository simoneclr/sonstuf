SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema sonstuf
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sonstuf` DEFAULT CHARACTER SET utf8 COLLATE utf8_estonian_ci ;
USE `sonstuf` ;

-- -----------------------------------------------------
-- Table `sonstuf`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sonstuf`.`user` (
  `iduser` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NULL,
  `email` VARCHAR(100) NULL,
  `passwordhash` VARCHAR(110) NULL,
  `ranko` VARCHAR(45) NULL DEFAULT 0,
  `rankp` VARCHAR(45) NULL DEFAULT 0,
  `birthdate` VARCHAR(45) NULL,
  PRIMARY KEY (`iduser`),
  UNIQUE INDEX `phone_UNIQUE` (`phone` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sonstuf`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sonstuf`.`category` (
  `idcategory` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `description` TEXT NULL,
  PRIMARY KEY (`idcategory`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sonstuf`.`request`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sonstuf`.`request` (
  `idrequest` INT NOT NULL AUTO_INCREMENT,
  `title` TEXT NOT NULL,
  `description` TEXT NOT NULL,
  `place` TEXT NOT NULL,
  `datetime` TEXT NOT NULL,
  `photo` TEXT NULL,
  `iduser` INT NOT NULL,
  `idcategory` INT NOT NULL,
  `status` TINYINT NULL,
  PRIMARY KEY (`idrequest`),
  INDEX `fk_request_user_idx` (`iduser` ASC),
  INDEX `fk_request_category1_idx` (`idcategory` ASC),
  CONSTRAINT `fk_request_user`
    FOREIGN KEY (`iduser`)
    REFERENCES `sonstuf`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_request_category1`
    FOREIGN KEY (`idcategory`)
    REFERENCES `sonstuf`.`category` (`idcategory`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sonstuf`.`offer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sonstuf`.`offer` (
  `idoffer` INT NOT NULL AUTO_INCREMENT,
  `isincharge` TINYINT(1) NOT NULL DEFAULT 0,
  `idrequest` INT NOT NULL,
  `iduser` INT NOT NULL,
  `status` TINYTEXT NULL,
  PRIMARY KEY (`idoffer`),
  INDEX `fk_offer_request1_idx` (`idrequest` ASC),
  INDEX `fk_offer_user1_idx` (`iduser` ASC),
  UNIQUE INDEX `idrequest_iduser` (`idrequest` ASC, `iduser` ASC),
  CONSTRAINT `fk_offer_request1`
    FOREIGN KEY (`idrequest`)
    REFERENCES `sonstuf`.`request` (`idrequest`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_offer_user1`
    FOREIGN KEY (`iduser`)
    REFERENCES `sonstuf`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sonstuf`.`message`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sonstuf`.`message` (
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
    REFERENCES `sonstuf`.`offer` (`idoffer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_message_user1`
    FOREIGN KEY (`idsender`)
    REFERENCES `sonstuf`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sonstuf`.`offererrank`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sonstuf`.`offererrank` (
  `rank` INT NOT NULL,
  `comment` TEXT NULL,
  `offer_idoffer` INT NOT NULL,
  PRIMARY KEY (`offer_idoffer`),
  CONSTRAINT `fk_offererrank_offer1`
    FOREIGN KEY (`offer_idoffer`)
    REFERENCES `sonstuf`.`offer` (`idoffer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sonstuf`.`requesterrank`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sonstuf`.`requesterrank` (
  `rank` INT NOT NULL,
  `comment` TEXT NULL,
  `idoffer` INT NOT NULL,
  PRIMARY KEY (`idoffer`),
  CONSTRAINT `fk_requesterrank_offer1`
    FOREIGN KEY (`idoffer`)
    REFERENCES `sonstuf`.`offer` (`idoffer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sonstuf`.`auth_tokens`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sonstuf`.`auth_tokens` (
  `auth_token_id` VARCHAR(8) NOT NULL,
  `hash` VARCHAR(64) NOT NULL,
  `iduser` INT NOT NULL,
  PRIMARY KEY (`auth_token_id`),
  INDEX `fk_auth_tokens_user1_idx` (`iduser` ASC),
  CONSTRAINT `fk_auth_tokens_user1`
    FOREIGN KEY (`iduser`)
    REFERENCES `sonstuf`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
