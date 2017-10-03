DROP DATABASE shopping_cart;
CREATE DATABASE shopping_cart;
CREATE USER 'get_user'@'localhost' IDENTIFIED BY 'get_pwd';
GRANT ALL ON shopping_cart.* TO 'get_user'@'localhost';

USE shopping_cart;

CREATE TABLE Products (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(25),
  img VARCHAR(200),
  price DOUBLE
);
