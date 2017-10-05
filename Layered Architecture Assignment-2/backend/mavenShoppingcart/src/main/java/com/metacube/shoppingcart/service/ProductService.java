package com.metacube.shoppingcart.service;

import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.model.Product;

/**
 * The interface ProductService.
 * 
 * @author Neel Singhal
 */
public interface ProductService {
	Iterable<Product> getAllProducts();

	Product getProductById(int id);

	Status deleteProduct(int id);

	Status editProduct(Product product, int id);

	Status addProduct(Product product);
}

