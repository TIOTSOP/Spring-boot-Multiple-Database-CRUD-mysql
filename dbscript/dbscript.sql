CREATE DATABASE IF NOT EXISTS `multi_main` ;
CREATE DATABASE IF NOT EXISTS `satelite_aryabhat` ;
CREATE DATABASE IF NOT EXISTS `satelite_saral` ;

CREATE TABLE `satelite_aryabhat`.`aryabhat_data` (
  `id` INT NOT NULL,
  `ftpPath` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));




CREATE TABLE `satelite_saral`.`saral_data` (
  `id` INT NOT NULL,
  `ftpPath` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));
  
  INSERT INTO `satelite_aryabhat`.`aryabhat_data`(`id`,`ftpPath`)VALUES(1,'ftp://scatsat1:%22%22@ftp.mosdac.gov.in/2020/JUL/L2B/');
  INSERT INTO `satelite_saral`.`saral_data`(`id`,`ftpPath`)VALUES(1,'ftp://scatsat1:%22%22@ftp.mosdac.gov.in/2020/JUL/L4INDIA/');