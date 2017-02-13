CREATE TABLE `htp`.`book` (
  `id` INT NOT NULL,
  `brief` VARCHAR(50) NULL,
  `publish_year` INT NULL,
  `author` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));

  CREATE TABLE `htp`.`employee` (
  `id` INT NOT NULL,
  `name` VARCHAR(255) NULL,
  `date_of_birth` DATE NULL,
  `email` VARCHAR(50) NULL,
  PRIMARY KEY (`id`));

  CREATE TABLE `htp`.`mm_employee_book` (
  `book_id` INT NOT NULL,
  `employee_id` INT NOT NULL,
  PRIMARY KEY (`book_id`, `employee_id`));