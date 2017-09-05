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