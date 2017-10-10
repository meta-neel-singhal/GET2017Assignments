create database get_testdb;
use get_testdb;

create TABLE Product (
  id INT AUTO_INCREMENT PRIMARY KEY,
   name VARCHAR(25),
   price double
   
);
INSERT INTO `get_testdb`.`Product` (`name`, `PRICE`) VALUES ('p','1000');
INSERT INTO `get_testdb`.`Product` (`name`, `PRICE`) VALUES ('raj' , '2300');


