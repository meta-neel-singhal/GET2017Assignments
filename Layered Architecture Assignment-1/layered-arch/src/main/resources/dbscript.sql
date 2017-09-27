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

INSERT INTO `shopping_cart`.`products` (`id`, `name`, `img`, `price`) VALUES (1, 'Udit', 'https://pimg.tradeindia.com/03542897/s/2/Organic-Product.jpg', 290.50);

INSERT INTO `shopping_cart`.`products` (`id`, `name`, `img`, `price`) VALUES (2, 'Shivam', 'http://ignitewoo.com/wp-content/uploads/2013/11/woocommerce-vendor-stores-product-vendors.png', 1000.23);
