-- MySQL Script generated by MySQL Workbench
-- Thu Oct 15 14:37:13 2015
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`group_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`group_user` (
  `id` INT NOT NULL,
  `user_id` INT NULL,
  `group_id` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user` (
  `id` INT NOT NULL,
  `name` VARCHAR(255) NULL,
  `email` VARCHAR(255) NULL,
  `create_at` DATETIME NULL,
  `update_at` DATETIME NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_user_group_user`
    FOREIGN KEY (`id`)
    REFERENCES `mydb`.`group_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`group` (
  `id` INT NOT NULL,
  `name` VARCHAR(255) NULL,
  `description` VARCHAR(255) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_group_group_user1`
    FOREIGN KEY (`id`)
    REFERENCES `mydb`.`group_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`category` (
  `id` INT NOT NULL,
  `categorycol` VARCHAR(255) NULL,
  `categorycol1` DECIMAL(12) NULL,
  `categorycol2` DATETIME NULL,
  `categorycol3` BLOB NULL,
  `categorycol4` BINARY(2) NULL,
  `categorycol5` BLOB(255) NULL,
  `categorycol6` LONGBLOB NULL,
  `categorycol7` MEDIUMBLOB NULL,
  `categorycol8` MEDIUMBLOB NULL,
  `categorycol9` TINYBLOB NULL,
  `categorycol10` VARBINARY(255) NULL,
  `categorycol11` DATE NULL,
  `categorycol12` DATETIME(6) NULL,
  `categorycol13` TIME(6) NULL,
  `categorycol14` TIMESTAMP(6) NULL,
  `categorycol15` YEAR NULL,
  `categorycol16` GEOMETRY NULL,
  `categorycol17` GEOMETRYCOLLECTION NULL,
  `categorycol18` LINESTRING NULL,
  `categorycol19` MULTILINESTRING NULL,
  `categorycol20` MULTIPOINT NULL,
  `categorycol21` MULTIPOLYGON NULL,
  `categorycol22` POINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
