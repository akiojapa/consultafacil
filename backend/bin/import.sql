
/*Criação da tabela nível de acesso */
CREATE TABLE IF NOT EXISTS `consulta_facildb`.`access_level` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `name_access` VARCHAR(45) NOT NULL,
  `order_level` INT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB


/*Criação da tabela Usuários */
CREATE TABLE IF NOT EXISTS `consulta_facildb`.`Users` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `cpf` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `access_level_ID1` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Users_access_level_idx` (`access_level_ID1` ASC) VISIBLE,
  CONSTRAINT `fk_Users_access_level`
    FOREIGN KEY (`access_level_ID1`)
    REFERENCES `consulta_facildb`.`access_level` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB

/*Criação da tabela Pacientes */
CREATE TABLE IF NOT EXISTS `consulta_facildb`.`Patient` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `name_pac` VARCHAR(45) NOT NULL,
  `cel_pac` VARCHAR(45) NULL,
  `email_pac` VARCHAR(45) NOT NULL,
  `Users_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Patient_Users1_idx` (`Users_ID` ASC) VISIBLE,
  CONSTRAINT `fk_Patient_Users1`
    FOREIGN KEY (`Users_ID`)
    REFERENCES `consulta_facildb`.`Users` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB




/*Criação da tabela Recepcionistas */
CREATE TABLE IF NOT EXISTS `consulta_facildb`.`Receptionist` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `name_rec` VARCHAR(45) NOT NULL,
  `Users_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Receptionist_Users1_idx` (`Users_ID` ASC) VISIBLE,
  CONSTRAINT `fk_Receptionist_Users1`
    FOREIGN KEY (`Users_ID`)
    REFERENCES `consulta_facildb`.`Users` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB


/*Criação da tabela Médicos */
CREATE TABLE IF NOT EXISTS `consulta_facildb`.`Doctor` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `name_doc` VARCHAR(45) NOT NULL,
  `doc_spec` VARCHAR(45) NOT NULL,
  `Users_ID` INT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Doctor_Users1_idx` (`Users_ID` ASC) VISIBLE,
  CONSTRAINT `fk_Doctor_Users1`
    FOREIGN KEY (`Users_ID`)
    REFERENCES `consulta_facildb`.`Users` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB


/*Criação da tabela Agenda */
CREATE TABLE IF NOT EXISTS `consulta_facildb`.`Schedule` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `day` DATE NULL,
  `hr_ini` TIME NULL,
  `hr_end` TIME NULL,
  `status` VARCHAR(45) NULL,
  `Doctor_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Schedule_Doctor1_idx` (`Doctor_ID` ASC) VISIBLE,
  CONSTRAINT `fk_Schedule_Doctor1`
    FOREIGN KEY (`Doctor_ID`)
    REFERENCES `consulta_facildb`.`Doctor` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB



/*Criação da tabela UBS */
CREATE TABLE IF NOT EXISTS `consulta_facildb`.`UBS` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `name_ubs` VARCHAR(45) NOT NULL,
  `loc_ubs` VARCHAR(45) NULL,
  `Receptionist_ID` INT NOT NULL,
  `Doctor_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_UBS_Receptionist1_idx` (`Receptionist_ID` ASC) VISIBLE,
  INDEX `fk_UBS_Doctor1_idx` (`Doctor_ID` ASC) VISIBLE,
  CONSTRAINT `fk_UBS_Receptionist1`
    FOREIGN KEY (`Receptionist_ID`)
    REFERENCES `consulta_facildb`.`Receptionist` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_UBS_Doctor1`
    FOREIGN KEY (`Doctor_ID`)
    REFERENCES `consulta_facildb`.`Doctor` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB


/*Criação da tabela Consultas */
CREATE TABLE IF NOT EXISTS `consulta_facildb`.`Appointment` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `status` VARCHAR(45) NULL,
  `Patient_ID` INT NOT NULL,
  `UBS_ID` INT NOT NULL,
  `Schedule_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Appointment_Patient1_idx` (`Patient_ID` ASC) VISIBLE,
  INDEX `fk_Appointment_UBS1_idx` (`UBS_ID` ASC) VISIBLE,
  INDEX `fk_Appointment_Schedule1_idx` (`Schedule_ID` ASC) VISIBLE,
  CONSTRAINT `fk_Appointment_Patient1`
    FOREIGN KEY (`Patient_ID`)
    REFERENCES `consulta_facildb`.`Patient` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Appointment_UBS1`
    FOREIGN KEY (`UBS_ID`)
    REFERENCES `consulta_facildb`.`UBS` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Appointment_Schedule1`
    FOREIGN KEY (`Schedule_ID`)
    REFERENCES `consulta_facildb`.`Schedule` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB