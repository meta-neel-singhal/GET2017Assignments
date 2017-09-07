-- Create database form.
CREATE DATABASE `form`;

-- Select database form.
USE `form`;

-- Create a table zipcode_data.
CREATE TABLE `zipcode_data` (
    `zipcode` INT NOT NULL PRIMARY KEY,
    `city` VARCHAR(25),
    `state` VARCHAR(25)
);

-- Load data from csv file to zipcode table.
LOAD DATA INFILE 'pincode_data.csv'
INTO TABLE `form`.`zipcode_data` 
FIELDS TERMINATED BY ',' 
ENCLOSED BY '"' 
LINES TERMINATED BY '\n';

-- Display the Zip Code, City Names and States ordered by State Name and City Name.
SELECT `zipcode`, `city`, `state` 
FROM `zipcode_data`
ORDER BY `state` ASC, `city` ASC;

/* ---------------------------------------------- Alternate Method ---------------------------------------------- */

-- Creating database form.
CREATE DATABASE `form`;

-- Using database form.
USE `form`;

-- Creating states table.
CREATE TABLE `states` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(30) NOT NULL
);

-- Creating cities table.
CREATE TABLE `cities` (
   `id` INT AUTO_INCREMENT PRIMARY KEY,
   `name` VARCHAR(30) NOT NULL,
   `state_id` INT,
   CONSTRAINT `fk_city_state`
       FOREIGN KEY (`state_id`)
       REFERENCES `states` (`id`)
       ON DELETE CASCADE
       ON UPDATE CASCADE
);
   
-- Creating zipcode table.
CREATE TABLE `zip_code` (
   `code` INT PRIMARY KEY,
   `state_id` INT,
   `city_id` INT,
   CONSTRAINT `fk_state_zipcode` 
       FOREIGN KEY (`state_id`) 
       REFERENCES `states` (`id`) 
       ON DELETE CASCADE 
       ON UPDATE CASCADE,
   CONSTRAINT `fk_city_zipcode`
       FOREIGN KEY (`city_id`)
       REFERENCES `cities` (`id`)
       ON DELETE CASCADE
       ON UPDATE CASCADE
);

-- Inserting the data in states table.
INSERT INTO `states`(`name`) VALUES ('Rajasthan'),
                                    ('Andhra Pradesh'),
                                    ('Assam'),
                                    ('Bihar');
                                
-- Inserting the data in cities table.
INSERT INTO `cities`(`name`, `state_id`) VALUES ('Banswara', 1),
                                                ('Dungarpur', 1),
                                                ('Jaipur', 1),
                                                ('Godavari', 2),
                                                ('Nellore', 2),
                                                ('Nagaon', 3),
                                                ('Diphu', 3),
                                                ('Patna', 4),
                                                ('Gaya', 4);
                                    
-- Inserting the data in zip_code table.
INSERT INTO `zip_code`(`code`, `city_id`, `state_id`) VALUES (327001, 1, 1),
                                                             (314001, 2, 1),
                                                             (302016, 3, 1),
                                                             (533260, 4, 2),
                                                             (524414, 5, 2),
                                                             (782001, 6, 3),
                                                             (782447, 7, 3),
                                                             (804453, 8, 4),
                                                             (804428, 9, 4);

-- Display the Zip Code, City Names and States ordered by State Name and City Name.
SELECT z.`code` AS 'ZIP CODE', c.`name` AS 'CITY NAME', s.`name` AS 'STATE'
FROM `zip_code` z
JOIN `cities` c
ON c.`id` = z.`city_id`
JOIN `states` s
ON s.`id` = z.`state_id`
ORDER BY z.`state_id`, z.`city_id`;