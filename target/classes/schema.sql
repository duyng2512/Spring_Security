CREATE TABLE IF NOT EXISTS `user` (
`id` INT NOT NULL AUTO_INCREMENT,
`username` VARCHAR(45) NOT NULL,
`password` TEXT NOT NULL,
`algorithm` VARCHAR(45) NOT NULL,
PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `authorities` (
`id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`user` INT NOT NULL,
PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `product` (
 `id` INT NOT NULL AUTO_INCREMENT,
 `name` VARCHAR(45) NOT NULL,
 `price` VARCHAR(45) NOT NULL,
 `currency` VARCHAR(45) NOT NULL,
 PRIMARY KEY (`id`));

INSERT INTO `user` (`id`, `username`, `password`, `algorithm`)
VALUES ('1', 'john', '$2a$10$ezYrWWSQRuFqqP/c4v0yM.alwSZFyBZyrbm4i8pkfKGGUxY68YEOG', 'BCRYPT');

INSERT INTO `authorities` (`id`, `name`, `user`) VALUES ('1', 'READ', '1');
INSERT INTO `authorities` (`id`, `name`, `user`) VALUES ('2', 'WRITE', '1');