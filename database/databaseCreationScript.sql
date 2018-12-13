SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

SET sql_notes = 0;

CREATE SCHEMA IF NOT EXISTS `java2` DEFAULT CHARACTER SET utf8;
USE `java2` ;

DROP TABLE IF EXISTS `todo_list_items` ;
DROP TABLE IF EXISTS `todo_lists` ;
DROP TABLE IF EXISTS `affairs` ;
DROP TABLE IF EXISTS `users` ;

CREATE TABLE IF NOT EXISTS `users` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `created_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

CREATE TABLE IF NOT EXISTS `affairs` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(32) NOT NULL,
  `description` VARCHAR(100) NOT NULL,
  `created_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

CREATE TABLE IF NOT EXISTS `todo_lists` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `user_id` BIGINT NOT NULL,
  `created_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

ALTER TABLE `todo_lists`
ADD CONSTRAINT `fk_todo_lists_user_id`
FOREIGN KEY (`user_id`) REFERENCES `users`(`id`);

ALTER TABLE `todo_lists`
ADD INDEX `ix_todo_lists_user_id`(`user_id`);

ALTER TABLE `todo_lists`
ADD UNIQUE INDEX `ix_todo_lists_user_id_title`(`user_id`, `title`);

CREATE TABLE IF NOT EXISTS `todo_list_items` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `todo_list_id` BIGINT NOT NULL,
  `affair_id` BIGINT NOT NULL,
/*  `quantity` INT NOT NULL, */
  `created_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

ALTER TABLE `todo_list_items`
ADD CONSTRAINT `fk_todo_list_items_todo_list_id`
FOREIGN KEY (`todo_list_id`) REFERENCES `todo_lists`(`id`);

ALTER TABLE `todo_list_items`
ADD INDEX `ix_todo_list_items_todo_list_id`(`todo_list_id`);

ALTER TABLE `todo_list_items`
ADD CONSTRAINT `fk_todo_list_items_affair_id`
FOREIGN KEY (`affair_id`) REFERENCES `affairs`(`id`);

ALTER TABLE `todo_list_items`
ADD INDEX `ix_todo_list_items_affair_id`(`affair_id`);

SET sql_notes = 1;
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;