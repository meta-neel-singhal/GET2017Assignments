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
    `name` VARCHAR(30) PRIMARY KEY
);

-- Creating cities table.
CREATE TABLE `cities` (
   `name` VARCHAR(30) PRIMARY KEY
);
   
-- Creating zipcode table.
CREATE TABLE `zip_code` (
   `code` INT NOT NULL PRIMARY KEY,
   `state_name` VARCHAR(30),
   `city_name` VARCHAR(30),
   CONSTRAINT `fk_state_name` 
       FOREIGN KEY (`state_name`) 
       REFERENCES `states` (`name`) 
       ON DELETE CASCADE 
       ON UPDATE CASCADE,
   CONSTRAINT `fk_city_name`
       FOREIGN KEY (`city_name`)
       REFERENCES `cities` (`name`)
       ON DELETE CASCADE
       ON UPDATE CASCADE
);

-- Inserting the data in states table.
INSERT INTO `states`(`name`) VALUES ('Rajasthan'),
                                    ('Andhra Pradesh'),
                                    ('Assam'),
                                    ('Bihar');
                                
-- Inserting the data in cities table.
INSERT INTO `cities`(`name`) VALUES ('Banswara'),
                                    ('Dungarpur'),
                                    ('Jaipur'),
                                    ('Godavari'),
                                    ('Nellore'),
                                    ('Nagaon'),
                                    ('Diphu'),
                                    ('Patna'),
                                    ('Gaya');
                                    
-- Inserting the data in zip_code table.
INSERT INTO `zip_code`(`code`, `city_name`, `state_name`) VALUES (327001, 'Banswara', 'Rajasthan'),
                                                                 (314001,'Dungarpur','Rajasthan'),
                                                                 (302016,'Jaipur','Rajasthan'),
                                                                 (533260,'Dungarpur','Andhra Pradesh'),
                                                                 (524414,'Nellore','Andhra Pradesh'),
                                                                 (782001,'Nagaon','Assam'),
                                                                 (782447,'Diphu','Assam'),
                                                                 (804453,'Patna','Bihar'),
                                                                 (804428,'Gaya','Bihar  ');

-- Display the Zip Code, City Names and States ordered by State Name and City Name.
SELECT `code`, `city_name`, `state_name`
FROM `zip_code`
ORDER BY `state_name`, `city_name`;
