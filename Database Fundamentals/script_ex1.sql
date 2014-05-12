-- MySQL Script generated by MySQL Workbench
-- 05/12/14 17:20:41
-- Model: New Model    Version: 1.0
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Client` (
  `Cod_Client` INT NOT NULL,
  `Nume_Client` VARCHAR(45) NOT NULL,
  `Oras_Client` VARCHAR(45) NOT NULL,
  `Adresa_Client` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Cod_Client`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Categorie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Categorie` (
  `Categorie_Film` INT NOT NULL,
  `Denumire_Categorie` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Categorie_Film`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DVD`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DVD` (
  `Cod_DVD` INT NOT NULL,
  `Titlu Film` VARCHAR(45) NOT NULL,
  `Descriere_Film` VARCHAR(45) NULL,
  `Durata` VARCHAR(45) NULL,
  `Nr_Exemplare` VARCHAR(45) NULL,
  `Tarif_inchiriere_zi` VARCHAR(45) NULL,
  PRIMARY KEY (`Cod_DVD`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Categorie_has_DVD`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Categorie_has_DVD` (
  `Categorie_Categorie_Film` INT NOT NULL,
  `DVD_Cod_DVD` INT NOT NULL,
  PRIMARY KEY (`Categorie_Categorie_Film`, `DVD_Cod_DVD`),
  INDEX `fk_Categorie_has_DVD_DVD1_idx` (`DVD_Cod_DVD` ASC),
  INDEX `fk_Categorie_has_DVD_Categorie_idx` (`Categorie_Categorie_Film` ASC),
  CONSTRAINT `fk_Categorie_has_DVD_Categorie`
    FOREIGN KEY (`Categorie_Categorie_Film`)
    REFERENCES `mydb`.`Categorie` (`Categorie_Film`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Categorie_has_DVD_DVD1`
    FOREIGN KEY (`DVD_Cod_DVD`)
    REFERENCES `mydb`.`DVD` (`Cod_DVD`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Bon`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Bon` (
  `Bon_de_inchiriere` INT NOT NULL,
  `Data` DATE NOT NULL,
  `Nr_DVD_Inchiriate` VARCHAR(45) NOT NULL,
  `Cod_Client` INT NOT NULL,
  PRIMARY KEY (`Bon_de_inchiriere`),
  UNIQUE INDEX `Bon_de_inchiriere_UNIQUE` (`Bon_de_inchiriere` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Client_has_Bon`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Client_has_Bon` (
  `Client_Cod_Client` INT NOT NULL,
  `Bon_Bon_de_inchiriere` INT NOT NULL,
  PRIMARY KEY (`Client_Cod_Client`, `Bon_Bon_de_inchiriere`),
  INDEX `fk_Client_has_Bon_Bon1_idx` (`Bon_Bon_de_inchiriere` ASC),
  INDEX `fk_Client_has_Bon_Client1_idx` (`Client_Cod_Client` ASC),
  CONSTRAINT `fk_Client_has_Bon_Client1`
    FOREIGN KEY (`Client_Cod_Client`)
    REFERENCES `mydb`.`Client` (`Cod_Client`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Client_has_Bon_Bon1`
    FOREIGN KEY (`Bon_Bon_de_inchiriere`)
    REFERENCES `mydb`.`Bon` (`Bon_de_inchiriere`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Bon_has_DVD`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Bon_has_DVD` (
  `Bon_Bon_de_inchiriere` INT NOT NULL,
  `DVD_Cod_DVD` INT NOT NULL,
  PRIMARY KEY (`Bon_Bon_de_inchiriere`, `DVD_Cod_DVD`),
  INDEX `fk_Bon_has_DVD_DVD1_idx` (`DVD_Cod_DVD` ASC),
  INDEX `fk_Bon_has_DVD_Bon1_idx` (`Bon_Bon_de_inchiriere` ASC),
  CONSTRAINT `fk_Bon_has_DVD_Bon1`
    FOREIGN KEY (`Bon_Bon_de_inchiriere`)
    REFERENCES `mydb`.`Bon` (`Bon_de_inchiriere`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Bon_has_DVD_DVD1`
    FOREIGN KEY (`DVD_Cod_DVD`)
    REFERENCES `mydb`.`DVD` (`Cod_DVD`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;