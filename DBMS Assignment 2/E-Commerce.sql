-- Create database.
CREATE DATABASE `e_commerce`;

-- Select database.
USE `e_commerce`;

-- Create category table.
CREATE TABLE `category`(
    `category_id` INT AUTO_INCREMENT PRIMARY KEY,
    `category_name` VARCHAR(30) NOT NULL,
    `parent_id` INT DEFAULT NULL,
    CONSTRAINT asd FOREIGN KEY (parent_id) REFERENCES category(category_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Inserts data into the category table.
INSERT INTO `category`(`category_name`, `parent_id`) VALUES ("Mobiles and Tablets", NULL),
                                                     ("Mobiles", 1),
                                                     ("Smart Phones", 2),
                                                     ("Featured Phones", 2),
                                                     ("Tablets", 1),
                                                     ("2G", 5),
                                                     ("3G", 5),
                                                     ("Accessories", 1),
                                                     ("Cases and Covers", 1),
                                                     ("Computers", NULL),
                                                     ("Desktop", 10),
                                                     ("Laptop", 10),
                                                     ("Laptop Accessories", 10),
                                                     ("Keyboard", 13),
                                                     ("Mouse", 13),
                                                     ("Headphones", 13),
                                                     ("Printers", 10),
                                                     ("Inkjet", 17),
                                                     ("Laser", 17),
                                                     ("Home Appliances", NULL),
                                                     ("TVs", 20),
                                                     ("LED", 21),
                                                     ("LCD", 21),
                                                     ("Plasma", 21),
                                                     ("Air Conditioners", 20),
                                                     ("Washing Machine", 20),
                                                     ("Full Automatic", 26),
                                                     ("Top Load", 27),
                                                     ("Front Load", 27),
                                                     ("Semi Automatic", 26);
                                                      
-- Display all the categories along with its Parent category sorted on parent name.
SELECT IFNULL(parent.`category_name`, "Top Category") AS 'Parent Category', child.`category_name` AS 'Category'
FROM `category` AS parent
RIGHT JOIN `category` AS child
ON child.`parent_id` = parent.`category_id`
ORDER BY parent.`category_name` ASC;

-- Display all the top categories.
SELECT `category_name`
FROM `category`
WHERE `parent_id` IS NULL;