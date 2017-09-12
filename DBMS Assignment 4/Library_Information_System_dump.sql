-- Deletes database if already exists.
DROP DATABASE IF EXISTS `library_information_system`;

-- Create database.
CREATE DATABASE `library_information_system`;

-- Select database.
USE `library_information_system`;

-- Create table members.
CREATE TABLE `members`(
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(45) NOT NULL,
    `address_line1` VARCHAR(30) NOT NULL,
    `address_line2` VARCHAR(30) NOT NULL,
    `category` VARCHAR(20) NOT NULL
);

-- Create table author.
CREATE TABLE `author`(
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(45) NOT NULL
);

-- Create table subjects.
CREATE TABLE `subjects`(
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(20) NOT NULL
);

-- Create table publisher.
CREATE TABLE `publisher`(
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(45) NOT NULL
);

-- Create table title.
CREATE TABLE `title`(
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `title` VARCHAR(50) NOT NULL,
    `subject_id` INT,
    `publisher_id` INT,
    CONSTRAINT `fk_title_subjects` FOREIGN KEY (`subject_id`)
        REFERENCES `subjects` (`id`)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT `fk_title_publisher` FOREIGN KEY (`publisher_id`)
        REFERENCES `publisher` (`id`)
        ON UPDATE CASCADE
        ON DELETE CASCADE
); 
    
-- Create table books.
CREATE TABLE `books`(
    `accession_no` VARCHAR(10) PRIMARY KEY,
    `title_id` INT,
    `purchase_date` DATE NOT NULL,
    `price` DOUBLE NOT NULL,
    `status` ENUM('AVAILABLE', 'UNAVAILABLE') NOT NULL,
    CONSTRAINT `fk_book_title` FOREIGN KEY (`title_id`)
        REFERENCES `title` (`id`)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

-- Create table title_author.
CREATE TABLE `title_author`(
    `title_id` INT,
    `author_id` INT,
    PRIMARY KEY (`title_id`, `author_id`),
    CONSTRAINT `fk_title_author_title` FOREIGN KEY (`title_id`)
        REFERENCES `title` (`id`)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT `fk_title_author_author` FOREIGN KEY (`author_id`)
        REFERENCES `author` (`id`)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);
    
-- Create table book_issue.
CREATE TABLE `book_issue`(
    `issue_date` TIMESTAMP,
    `accession_no` VARCHAR(10),
    `member_id` INT,
    `due_date` DATE NOT NULL DEFAULT 0,
    PRIMARY KEY (`issue_date`,`accession_no`,`member_id`),
    CONSTRAINT `fk_book_issue_book` FOREIGN KEY (`accession_no`)
        REFERENCES `books` (`accession_no`)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT `fk_book_issue_member` FOREIGN KEY (`member_id`)
        REFERENCES `members` (`id`)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

-- Create table book_return.
CREATE TABLE `book_return`(
    `return_date` TIMESTAMP,
    `accession_no` VARCHAR(10),
    `member_id` INT,
    `issue_date` TIMESTAMP NOT NULL,
    PRIMARY KEY (`return_date`,`accession_no`,`member_id`),
    CONSTRAINT `fk_book_return_members` FOREIGN KEY (`member_id`)
        REFERENCES `members` (`id`)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT `fk_book_return_books` FOREIGN KEY (`accession_no`)
        REFERENCES `books` (`accession_no`)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);
    
-- Show all tables in the database.
SHOW tables;

-- To set default value of column issue_date to current date.
ALTER TABLE `book_issue`
MODIFY COLUMN `issue_date` TIMESTAMP
DEFAULT NOW();

-- To set default value of column due_date to current date + 15.
CREATE TRIGGER `due_date_Trigger` 
    BEFORE INSERT ON `book_issue`  
    FOR EACH ROW 
    SET NEW.`due_date` = CURDATE() + INTERVAL 15 day;

-- Delete the foreign key fk_book_issue_member.
ALTER TABLE `book_issue`
DROP FOREIGN KEY `fk_book_issue_member`;

-- Delete the foreign key fk_book_return_members.
ALTER TABLE `book_return`
DROP FOREIGN KEY `fk_book_return_members`;

-- Delete table members.
DROP TABLE `members`;

-- Again create table members.
CREATE TABLE `members`(
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(45) NOT NULL,
    `address_line1` VARCHAR(30) NOT NULL,
    `address_line2` VARCHAR(30) NOT NULL,
    `category` VARCHAR(20) NOT NULL
);

-- Again add the foreign key fk_book_issue_member.
ALTER TABLE `book_issue` 
ADD CONSTRAINT `fk_book_issue_member`
FOREIGN KEY (`member_id`)
REFERENCES `members`(`id`);

-- Again add the foreign key fk_book_return_member.
ALTER TABLE `book_return`
ADD CONSTRAINT fk_book_return_member
FOREIGN KEY (`member_id`)
REFERENCES `members`(`id`);

-- Insert values into table authors.
INSERT INTO `author`(`name`) VALUES("J. K. Rowling");
INSERT INTO `author`(`name`) VALUES("Chetan Bhagat");
INSERT INTO `author`(`name`) VALUES("Harold Robbins");
INSERT INTO `author`(`name`) VALUES("James Gosling");
INSERT INTO `author`(`name`) VALUES("Danielle Steel");
INSERT INTO `author`(`name`) VALUES("William Shakespeare");

-- Insert values into table publisher.
INSERT INTO `publisher`(`name`) VALUES("NotionPress");
INSERT INTO `publisher`(`name`) VALUES("Tata McGraw Hill");
INSERT INTO `publisher`(`name`) VALUES("Arihant Publications");
INSERT INTO `publisher`(`name`) VALUES("Taxmann Publications");
INSERT INTO `publisher`(`name`) VALUES("Genius Publications");
INSERT INTO `publisher`(`name`) VALUES("Ashirwad Publications");

-- Insert values into table subjects.
INSERT INTO `subjects`(`name`) VALUES("DBMS");
INSERT INTO `subjects`(`name`) VALUES("C++ Programming");
INSERT INTO `subjects`(`name`) VALUES("Oracle");
INSERT INTO `subjects`(`name`) VALUES("JavaScript");
INSERT INTO `subjects`(`name`) VALUES("JAVA");
INSERT INTO `subjects`(`name`) VALUES("Mathematics");

-- Insert values into table members.
INSERT INTO `members`(`name`, `address_line1`, `address_line2`, `category`) VALUES("Neel Singhal", "Sector-3", "Gopalpura", "Student");
INSERT INTO `members`(`name`, `address_line1`, `address_line2`, `category`) VALUES("Udit Saxena", "Sector-14", "Shanti Nagar", "Teacher");
INSERT INTO `members`(`name`, `address_line1`, `address_line2`, `category`) VALUES("Gaurav Tak", "Sector-6", "Sanganer", "Student");
INSERT INTO `members`(`name`, `address_line1`, `address_line2`, `category`) VALUES("Shivam Lalwani", "Sector-13", "Pratap Nagar", "Teacher");
INSERT INTO `members`(`name`, `address_line1`, `address_line2`, `category`) VALUES("Gourav Gandhi", "Sector-2", "Choti Chopad", "Professor");
INSERT INTO `members`(`name`, `address_line1`, `address_line2`, `category`) VALUES("Udit Mehra", "Sector-11", "Shanti Nagar", "Professor");
INSERT INTO `members`(`name`, `address_line1`, `address_line2`, `category`) VALUES("Gaurav Jain", "Sector-9", "Sanganer", "Chairman");
INSERT INTO `members`(`name`, `address_line1`, `address_line2`, `category`) VALUES("Shivam Pathak", "Sector-12", "Pratap Nagar", "Manager");

-- Insert values into table titles.
INSERT INTO `title`(`title`, `subject_id`, `publisher_id`) VALUES("Harry Potter - Goblet of Fire", 1, 6);
INSERT INTO `title`(`title`, `subject_id`, `publisher_id`) VALUES("Let Us C", 2, 5);
INSERT INTO `title`(`title`, `subject_id`, `publisher_id`) VALUES("Earth Facts",  3, 4);
INSERT INTO `title`(`title`, `subject_id`, `publisher_id`) VALUES("Know Database Management", 4, 2);
INSERT INTO `title`(`title`, `subject_id`, `publisher_id`) VALUES("JAVA - Basics", 5, 3);
INSERT INTO `title`(`title`, `subject_id`, `publisher_id`) VALUES("Vedic Mathematics", 6, 1);

-- Insert values into table title_author.
INSERT INTO `title_author`(`title_id`, `author_id`) VALUES(1, 1);
INSERT INTO `title_author`(`title_id`, `author_id`) VALUES(2, 5);
INSERT INTO `title_author`(`title_id`, `author_id`) VALUES(3, 1);
INSERT INTO `title_author`(`title_id`, `author_id`) VALUES(4, 6);
INSERT INTO `title_author`(`title_id`, `author_id`) VALUES(5, 3);
INSERT INTO `title_author`(`title_id`, `author_id`) VALUES(6, 2);

-- Insert values into table books.
INSERT INTO `books`(`accession_no`, `title_id`, `purchase_date`, `price`, `status`) VALUES("Book1", 1, '2017-07-14', 500.00, 'AVAILABLE');
INSERT INTO `books`(`accession_no`, `title_id`, `purchase_date`, `price`, `status`) VALUES("Book2", 2, '2017-04-23', 110.00, 'AVAILABLE');
INSERT INTO `books`(`accession_no`, `title_id`, `purchase_date`, `price`, `status`) VALUES("Book3", 3, '2017-11-15', 110.00, 'AVAILABLE');
INSERT INTO `books`(`accession_no`, `title_id`, `purchase_date`, `price`, `status`) VALUES("Book4", 4, '2016-05-16', 215.00, 'AVAILABLE');
INSERT INTO `books`(`accession_no`, `title_id`, `purchase_date`, `price`, `status`) VALUES("Book5", 5, '2016-03-13', 510.00, 'AVAILABLE');
INSERT INTO `books`(`accession_no`, `title_id`, `purchase_date`, `price`, `status`) VALUES("Book6", 6, '2015-04-30', 220.00, 'AVAILABLE');

-- Insert values into table book_issue.
INSERT INTO `book_issue`(`accession_no`, `member_id`) VALUES("Book6", 2);
INSERT INTO `book_issue`(`accession_no`, `member_id`) VALUES("Book1", 1);
INSERT INTO `book_issue`(`accession_no`, `member_id`) VALUES("Book4", 3);
INSERT INTO `book_issue`(`accession_no`, `member_id`) VALUES("Book2", 4);
INSERT INTO `book_issue`(`accession_no`, `member_id`) VALUES("Book3", 5);

-- Insert values into table book_return .
INSERT INTO `book_return`(`return_date`, `accession_no`, `member_id`, `issue_date`) VALUES('2017-09-16', "Book6", 2, '2017-09-01');
INSERT INTO `book_return`(`return_date`, `accession_no`, `member_id`, `issue_date`) VALUES('2017-09-07', "Book1", 1, '2017-08-24');
INSERT INTO `book_return`(`return_date`, `accession_no`, `member_id`, `issue_date`) VALUES('2017-10-04', "Book4", 3, '2017-09-21');
INSERT INTO `book_return`(`return_date`, `accession_no`, `member_id`, `issue_date`) VALUES('2017-09-25', "Book2", 4, '2017-09-10');
INSERT INTO `book_return`(`return_date`, `accession_no`, `member_id`, `issue_date`) VALUES('2017-10-01', "Book3", 5, '2017-09-16');

-- Close safe update mode.
SET SQL_SAFE_UPDATES = 0;

-- Update address_line2 field of members table.
UPDATE `members`
SET `address_line2` = "Jaipur";

-- Update address_line1 field of members table.
UPDATE `members`
SET `address_line1` = 'EPIP, Sitapura'
WHERE `category` = "Teacher";

-- Delete all rows from table publisher.
DELETE FROM `publisher`;

-- Entering data into publisher table using substitution variable.
SET @name = 'NotionPress';
SET @id = 1;
INSERT INTO `publisher`(`id`, `name`)
VALUES(@id, @name);

SET @name = 'Tata McGraw Hill';
SET @id = 2;
INSERT INTO `publisher`(`id`, `name`)
VALUES(@id, @name);

SET @name = 'Arihant Publications';
SET @id = 3;
INSERT INTO `publisher`(`id`, `name`)
VALUES(@id, @name);

SET @name = 'Taxmann Publications';
SET @id = 4;
INSERT INTO `publisher`(`id`, `name`)
VALUES(@id, @name);

SET @name = 'Genius Publications';
SET @id = 5;
INSERT INTO `publisher`(`id`, `name`)
VALUES(@id, @name);

SET @name = 'Ashirwad Publications';
SET @id = 6;
INSERT INTO `publisher`(`id`, `name`)
VALUES(@id, @name);

-- Insert values into table titles.
INSERT INTO `title`(`id`, `title`, `subject_id`, `publisher_id`) VALUES(1, "Harry Potter - Goblet of Fire", 1, 6);
INSERT INTO `title`(`id`, `title`, `subject_id`, `publisher_id`) VALUES(2, "Let Us C", 2, 5);
INSERT INTO `title`(`id`, `title`, `subject_id`, `publisher_id`) VALUES(3, "Earth Facts",  3, 4);
INSERT INTO `title`(`id`, `title`, `subject_id`, `publisher_id`) VALUES(4, "Know Database Management", 4, 2);
INSERT INTO `title`(`id`, `title`, `subject_id`, `publisher_id`) VALUES(5, "JAVA - Basics", 5, 3);
INSERT INTO `title`(`id`, `title`, `subject_id`, `publisher_id`) VALUES(6, "Vedic Mathematics", 6, 1);

-- Insert values into table books.
INSERT INTO `books`(`accession_no`, `title_id`, `purchase_date`, `price`, `status`) VALUES("Book1", 1, '2017-07-14', 500.00, 'AVAILABLE');
INSERT INTO `books`(`accession_no`, `title_id`, `purchase_date`, `price`, `status`) VALUES("Book2", 2, '2017-04-23', 110.00, 'AVAILABLE');
INSERT INTO `books`(`accession_no`, `title_id`, `purchase_date`, `price`, `status`) VALUES("Book3", 3, '2017-11-15', 110.00, 'AVAILABLE');
INSERT INTO `books`(`accession_no`, `title_id`, `purchase_date`, `price`, `status`) VALUES("Book4", 4, '2016-05-16', 215.00, 'AVAILABLE');
INSERT INTO `books`(`accession_no`, `title_id`, `purchase_date`, `price`, `status`) VALUES("Book5", 5, '2016-03-13', 510.00, 'AVAILABLE');
INSERT INTO `books`(`accession_no`, `title_id`, `purchase_date`, `price`, `status`) VALUES("Book6", 6, '2015-04-30', 220.00, 'AVAILABLE');
INSERT INTO `books`(`accession_no`, `title_id`, `purchase_date`, `price`, `status`) VALUES("Book7", 1, '2013-11-23', 235.00, 'AVAILABLE');
INSERT INTO `books`(`accession_no`, `title_id`, `purchase_date`, `price`, `status`) VALUES("Book8", 2, '2015-02-23', 240.00, 'AVAILABLE');
INSERT INTO `books`(`accession_no`, `title_id`, `purchase_date`, `price`, `status`) VALUES("Book9", 4, '2017-11-15', 110.00, 'AVAILABLE');
INSERT INTO `books`(`accession_no`, `title_id`, `purchase_date`, `price`, `status`) VALUES("Book10", 4, '2016-05-16', 215.00, 'AVAILABLE');
INSERT INTO `books`(`accession_no`, `title_id`, `purchase_date`, `price`, `status`) VALUES("Book11", 1, '2016-03-13', 510.00, 'AVAILABLE');

-- Insert values into table book_issue.
INSERT INTO `book_issue`(`accession_no`, `member_id`) VALUES("Book6", 2);
INSERT INTO `book_issue`(`accession_no`, `member_id`) VALUES("Book1", 1);
INSERT INTO `book_issue`(`accession_no`, `member_id`) VALUES("Book4", 3);
INSERT INTO `book_issue`(`accession_no`, `member_id`) VALUES("Book2", 4);
INSERT INTO `book_issue`(`accession_no`, `member_id`) VALUES("Book3", 5);
INSERT INTO `book_issue`(`accession_no`, `member_id`) VALUES("Book4", 1);
INSERT INTO `book_issue`(`accession_no`, `member_id`) VALUES("Book2", 2);
INSERT INTO `book_issue`(`accession_no`, `member_id`) VALUES("Book3", 6);
INSERT INTO `book_issue`(`accession_no`, `member_id`) VALUES("Book4", 2);
INSERT INTO `book_issue`(`accession_no`, `member_id`) VALUES("Book2", 1);
INSERT INTO `book_issue`(`accession_no`, `member_id`) VALUES("Book3", 4);
INSERT INTO `book_issue`(`issue_date`, `accession_no`, `member_id`) VALUES('2017-06-6', "Book4", 4);
INSERT INTO `book_issue`(`issue_date`, `accession_no`, `member_id`) VALUES('2017-07-3', "Book2", 3);
INSERT INTO `book_issue`(`issue_date`, `accession_no`, `member_id`) VALUES('2017-06-1', "Book3", 2);

-- Insert values into table title_author.
INSERT INTO `title_author`(`title_id`, `author_id`) VALUES(1, 1);
INSERT INTO `title_author`(`title_id`, `author_id`) VALUES(2, 5);
INSERT INTO `title_author`(`title_id`, `author_id`) VALUES(3, 1);
INSERT INTO `title_author`(`title_id`, `author_id`) VALUES(4, 6);
INSERT INTO `title_author`(`title_id`, `author_id`) VALUES(5, 3);
INSERT INTO `title_author`(`title_id`, `author_id`) VALUES(6, 2);

-- Insert values into table book_return .
INSERT INTO `book_return`(`return_date`, `accession_no`, `member_id`, `issue_date`) VALUES('2017-09-16', "Book6", 2, '2017-09-01');
INSERT INTO `book_return`(`return_date`, `accession_no`, `member_id`, `issue_date`) VALUES('2017-09-07', "Book1", 1, '2017-08-24');
INSERT INTO `book_return`(`return_date`, `accession_no`, `member_id`, `issue_date`) VALUES('2017-10-04', "Book4", 3, '2017-09-21');
INSERT INTO `book_return`(`return_date`, `accession_no`, `member_id`, `issue_date`) VALUES('2017-09-25', "Book2", 4, '2017-09-10');
INSERT INTO `book_return`(`return_date`, `accession_no`, `member_id`, `issue_date`) VALUES('2017-09-07', "Book2", 1, '2017-05-24');
INSERT INTO `book_return`(`return_date`, `accession_no`, `member_id`, `issue_date`) VALUES('2017-09-25', "Book4", 4, '2017-05-10');

-- Delete rows with Publisher1 from table title.
DELETE FROM `title` WHERE `publisher_id` = 'Publisher1';