package com.metacube.get.layarch.service;

import com.metacube.get.layarch.enums.Status;
import com.metacube.get.layarch.model.Product;

/**
 * The interface ProductService.
 * 
 * @author Neel Singhal
 */
public interface ProductService {
	Iterable<Product> getAllProducts();

	Product getProductById(int id);

	Status deleteProduct(int id);

	Status updateProduct(Product product, int id);

	Status addProduct(Product product);
}
