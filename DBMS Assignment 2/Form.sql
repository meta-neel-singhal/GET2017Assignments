-- Create database form.
CREATE DATABASE form;

-- Select database form.
USE form;

-- Create a table zipcode
CREATE TABLE zipcode (
    zipcode INT NOT NULL PRIMARY KEY,
    city VARCHAR(25),
    state VARCHAR(25)
);

-- Load data from csv file to zipcode table.
LOAD DATA INFILE 'pincode_data.csv'
INTO TABLE form.zipcode 
FIELDS TERMINATED BY ',' 
ENCLOSED BY '"' 
LINES TERMINATED BY '\n';

-- Display details where zipcode is 302001
SELECT zipcode, city, state 
FROM zipcode 
ORDER BY state ASC, city ASC;