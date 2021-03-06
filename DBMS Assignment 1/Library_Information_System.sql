-- Create database.
CREATE DATABASE `library_information_system`;

-- Select database.
USE `library_information_system`;

-- Create table members.
CREATE TABLE `members`(
    `id` VARCHAR(10) PRIMARY KEY,
    `name` VARCHAR(45) NOT NULL,
    `address_line1` VARCHAR(30) NOT NULL,
    `address_line2` VARCHAR(30) NOT NULL,
    `category` VARCHAR(20) NOT NULL
);

-- Create table author.
CREATE TABLE `author`(
    `id` VARCHAR(10) PRIMARY KEY,
    `name` VARCHAR(45) NOT NULL
);

-- Create table subjects.
CREATE TABLE `subjects`(
    `id` VARCHAR(10) PRIMARY KEY,
    `name` VARCHAR(20) NOT NULL
);

-- Create table publisher.
CREATE TABLE `publisher`(
    `id` VARCHAR(10) PRIMARY KEY,
    `name` VARCHAR(45) NOT NULL
);

-- Create table title.
CREATE TABLE `title`(
    `id` VARCHAR(10) PRIMARY KEY,
    `title` VARCHAR(50) NOT NULL,
    `subject_id` VARCHAR(10),
    `publisher_id` VARCHAR(10),
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
    `title_id` VARCHAR(10),
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
    `title_id` VARCHAR(10),
    `author_id` VARCHAR(10),
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
    `member_id` VARCHAR(10),
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
    `member_id` VARCHAR(10),
    `issue_date` DATE NOT NULL,
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
    `id` VARCHAR(10) PRIMARY KEY,
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
INSERT INTO `author`(`id`, `name`) VALUES("Author1", "J. K. Rowling");
INSERT INTO `author`(`id`, `name`) VALUES("Author2", "Chetan Bhagat");
INSERT INTO `author`(`id`, `name`) VALUES("Author3", "Harold Robbins");
INSERT INTO `author`(`id`, `name`) VALUES("Author4", "James Gosling");
INSERT INTO `author`(`id`, `name`) VALUES("Author5", "Danielle Steel");
INSERT INTO `author`(`id`, `name`) VALUES("Author6", "William Shakespeare");

-- Insert values into table publisher.
INSERT INTO `publisher`(`id`, `name`) VALUES("Publisher1", "NotionPress");
INSERT INTO `publisher`(`id`, `name`) VALUES("Publisher2", "Tata McGraw Hill");
INSERT INTO `publisher`(`id`, `name`) VALUES("Publisher3", "Arihant Publications");
INSERT INTO `publisher`(`id`, `name`) VALUES("Publisher4", "Taxmann Publications");
INSERT INTO `publisher`(`id`, `name`) VALUES("Publisher5", "Genius Publications");
INSERT INTO `publisher`(`id`, `name`) VALUES("Publisher6", "Ashirwad Publications");

-- Insert values into table subjects.
INSERT INTO `subjects`(`id`, `name`) VALUES("Subject1", "DBMS");
INSERT INTO `subjects`(`id`, `name`) VALUES("Subject2", "C++ Programming");
INSERT INTO `subjects`(`id`, `name`) VALUES("Subject3", "Oracle");
INSERT INTO `subjects`(`id`, `name`) VALUES("Subject4", "JavaScript");
INSERT INTO `subjects`(`id`, `name`) VALUES("Subject5", "JAVA");
INSERT INTO `subjects`(`id`, `name`) VALUES("Subject6", "Mathematics");

-- Insert values into table members.
INSERT INTO `members`(`id`, `name`, `address_line1`, `address_line2`, `category`) VALUES("Member1", "Neel Singhal", "Sector-3", "Gopalpura", "Student");
INSERT INTO `members`(`id`, `name`, `address_line1`, `address_line2`, `category`) VALUES("Member2", "Udit Saxena", "Sector-14", "Shanti Nagar", "Teacher");
INSERT INTO `members`(`id`, `name`, `address_line1`, `address_line2`, `category`) VALUES("Member3", "Gaurav Tak", "Sector-6", "Sanganer", "Student");
INSERT INTO `members`(`id`, `name`, `address_line1`, `address_line2`, `category`) VALUES("Member4", "Shivam Lalwani", "Sector-13", "Pratap Nagar", "Teacher");
INSERT INTO `members`(`id`, `name`, `address_line1`, `address_line2`, `category`) VALUES("Member5", "Gourav Gandhi", "Sector-2", "Choti Chopad", "Professor");

-- Insert values into table titles.
INSERT INTO `title`(`id`, `title`, `subject_id`, `publisher_id`) VALUES("Title1", "Harry Potter - Goblet of Fire", "Subject1", "Publisher6");
INSERT INTO `title`(`id`, `title`, `subject_id`, `publisher_id`) VALUES("Title2", "Let Us C", "Subject2", "Publisher5");
INSERT INTO `title`(`id`, `title`, `subject_id`, `publisher_id`) VALUES("Title3", "Earth Facts",  "Subject3", "Publisher4");
INSERT INTO `title`(`id`, `title`, `subject_id`, `publisher_id`) VALUES("Title4", "Know Database Management", "Subject4", "Publisher2");
INSERT INTO `title`(`id`, `title`, `subject_id`, `publisher_id`) VALUES("Title5", "JAVA - Basics", "Subject5", "Publisher3");
INSERT INTO `title`(`id`, `title`, `subject_id`, `publisher_id`) VALUES("Title6", "Vedic Mathematics", "Subject6", "Publisher1");

-- Insert values into table title_author.
INSERT INTO `title_author`(`title_id`, `author_id`) VALUES("Title1", "Author1");
INSERT INTO `title_author`(`title_id`, `author_id`) VALUES("Title2", "Author5");
INSERT INTO `title_author`(`title_id`, `author_id`) VALUES("Title3", "Author1");
INSERT INTO `title_author`(`title_id`, `author_id`) VALUES("Title4", "Author6");
INSERT INTO `title_author`(`title_id`, `author_id`) VALUES("Title5", "Author3");
INSERT INTO `title_author`(`title_id`, `author_id`) VALUES("Title6", "Author2");

-- Insert values into table books.
INSERT INTO `books`(`accession_no`, `title_id`, `purchase_date`, `price`, `status`) VALUES("Book1", "Title1", '2017-07-14', 500.00, 'AVAILABLE');
INSERT INTO `books`(`accession_no`, `title_id`, `purchase_date`, `price`, `status`) VALUES("Book2", "Title2", '2017-04-23', 110.00, 'AVAILABLE');
INSERT INTO `books`(`accession_no`, `title_id`, `purchase_date`, `price`, `status`) VALUES("Book3", "Title3", '2017-11-15', 110.00, 'AVAILABLE');
INSERT INTO `books`(`accession_no`, `title_id`, `purchase_date`, `price`, `status`) VALUES("Book4", "Title4", '2016-05-16', 215.00, 'AVAILABLE');
INSERT INTO `books`(`accession_no`, `title_id`, `purchase_date`, `price`, `status`) VALUES("Book5", "Title5", '2016-03-13', 510.00, 'AVAILABLE');
INSERT INTO `books`(`accession_no`, `title_id`, `purchase_date`, `price`, `status`) VALUES("Book6", "Title6", '2015-04-30', 220.00, 'AVAILABLE');

-- Insert values into table book_issue.
INSERT INTO `book_issue`(`accession_no`, `member_id`) VALUES("Book6", "Member2");
INSERT INTO `book_issue`(`accession_no`, `member_id`) VALUES("Book1", "Member1");
INSERT INTO `book_issue`(`accession_no`, `member_id`) VALUES("Book4", "Member3");
INSERT INTO `book_issue`(`accession_no`, `member_id`) VALUES("Book2", "Member4");
INSERT INTO `book_issue`(`accession_no`, `member_id`) VALUES("Book3", "Member5");

-- Insert values into table book_return .
INSERT INTO `book_return`(`return_date`, `accession_no`, `member_id`, `issue_date`) VALUES('2017-09-16', "Book6", "Member2", '2017-09-01');
INSERT INTO `book_return`(`return_date`, `accession_no`, `member_id`, `issue_date`) VALUES('2017-09-07', "Book1", "Member1", '2017-08-24');
INSERT INTO `book_return`(`return_date`, `accession_no`, `member_id`, `issue_date`) VALUES('2017-10-04', "Book4", "Member3", '2017-09-21');
INSERT INTO `book_return`(`return_date`, `accession_no`, `member_id`, `issue_date`) VALUES('2017-09-25', "Book2", "Member4", '2017-09-10');
INSERT INTO `book_return`(`return_date`, `accession_no`, `member_id`, `issue_date`) VALUES('2017-10-01', "Book3", "Member5", '2017-09-16');

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
SET @id = 'Publisher1';
INSERT INTO `publisher`(`id`, `name`)
VALUES(@id, @name);

SET @name = 'Tata McGraw Hill';
SET @id = 'Publisher2';
INSERT INTO `publisher`(`id`, `name`)
VALUES(@id, @name);

SET @name = 'Arihant Publications';
SET @id = 'Publisher3';
INSERT INTO `publisher`(`id`, `name`)
VALUES(@id, @name);

SET @name = 'Taxmann Publications';
SET @id = 'Publisher4';
INSERT INTO `publisher`(`id`, `name`)
VALUES(@id, @name);

SET @name = 'Genius Publications';
SET @id = 'Publisher5';
INSERT INTO `publisher`(`id`, `name`)
VALUES(@id, @name);

SET @name = 'Ashirwad Publications';
SET @id = 'Publisher6';
INSERT INTO `publisher`(`id`, `name`)
VALUES(@id, @name);

-- Insert values into table titles.
INSERT INTO `title`(`id`, `title`, `subject_id`, `publisher_id`) VALUES("Title1", "Harry Potter - Goblet of Fire", "Subject1", "Publisher6");
INSERT INTO `title`(`id`, `title`, `subject_id`, `publisher_id`) VALUES("Title2", "Let Us C", "Subject2", "Publisher5");
INSERT INTO `title`(`id`, `title`, `subject_id`, `publisher_id`) VALUES("Title3", "Earth Facts",  "Subject3", "Publisher4");
INSERT INTO `title`(`id`, `title`, `subject_id`, `publisher_id`) VALUES("Title4", "Know Database Management", "Subject4", "Publisher2");
INSERT INTO `title`(`id`, `title`, `subject_id`, `publisher_id`) VALUES("Title5", "JAVA - Basics", "Subject5", "Publisher3");
INSERT INTO `title`(`id`, `title`, `subject_id`, `publisher_id`) VALUES("Title6", "Vedic Mathematics", "Subject6", "Publisher1");

-- Insert values into table books.
INSERT INTO `books`(`accession_no`, `title_id`, `purchase_date`, `price`, `status`) VALUES("Book1", "Title1", '2017-07-14', 500.00, 'AVAILABLE');
INSERT INTO `books`(`accession_no`, `title_id`, `purchase_date`, `price`, `status`) VALUES("Book2", "Title2", '2017-04-23', 110.00, 'AVAILABLE');
INSERT INTO `books`(`accession_no`, `title_id`, `purchase_date`, `price`, `status`) VALUES("Book3", "Title3", '2017-11-15', 110.00, 'AVAILABLE');
INSERT INTO `books`(`accession_no`, `title_id`, `purchase_date`, `price`, `status`) VALUES("Book4", "Title4", '2016-05-16', 215.00, 'AVAILABLE');
INSERT INTO `books`(`accession_no`, `title_id`, `purchase_date`, `price`, `status`) VALUES("Book5", "Title5", '2016-03-13', 510.00, 'AVAILABLE');
INSERT INTO `books`(`accession_no`, `title_id`, `purchase_date`, `price`, `status`) VALUES("Book6", "Title6", '2015-04-30', 220.00, 'AVAILABLE');

-- Insert values into table book_issue.
INSERT INTO `book_issue`(`accession_no`, `member_id`) VALUES("Book6", "Member2");
INSERT INTO `book_issue`(`accession_no`, `member_id`) VALUES("Book1", "Member1");
INSERT INTO `book_issue`(`accession_no`, `member_id`) VALUES("Book4", "Member3");
INSERT INTO `book_issue`(`accession_no`, `member_id`) VALUES("Book2", "Member4");
INSERT INTO `book_issue`(`accession_no`, `member_id`) VALUES("Book3", "Member5");

-- Insert values into table title_author.
INSERT INTO `title_author`(`title_id`, `author_id`) VALUES("Title1", "Author1");
INSERT INTO `title_author`(`title_id`, `author_id`) VALUES("Title2", "Author5");
INSERT INTO `title_author`(`title_id`, `author_id`) VALUES("Title3", "Author1");
INSERT INTO `title_author`(`title_id`, `author_id`) VALUES("Title4", "Author6");
INSERT INTO `title_author`(`title_id`, `author_id`) VALUES("Title5", "Author3");
INSERT INTO `title_author`(`title_id`, `author_id`) VALUES("Title6", "Author2");

-- Insert values into table book_return .
INSERT INTO `book_return`(`return_date`, `accession_no`, `member_id`, `issue_date`) VALUES('2017-09-16', "Book6", "Member2", '2017-09-01');
INSERT INTO `book_return`(`return_date`, `accession_no`, `member_id`, `issue_date`) VALUES('2017-09-07', "Book1", "Member1", '2017-08-24');
INSERT INTO `book_return`(`return_date`, `accession_no`, `member_id`, `issue_date`) VALUES('2017-10-04', "Book4", "Member3", '2017-09-21');
INSERT INTO `book_return`(`return_date`, `accession_no`, `member_id`, `issue_date`) VALUES('2017-09-25', "Book2", "Member4", '2017-09-10');

-- Delete rows with Publisher1 from table title.
DELETE FROM `title` WHERE `publisher_id` = 'Publisher1';
