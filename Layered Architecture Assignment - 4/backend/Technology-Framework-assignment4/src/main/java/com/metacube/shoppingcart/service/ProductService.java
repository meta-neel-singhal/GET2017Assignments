package com.metacube.shoppingcart.service;

import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.model.Product;

/**
 * The Interface ProductService.
 * 
 * @author Neel Singhal
 */
public interface ProductService {

	Iterable<Product> getAllProducts();

	Product getProductById(int id);

	Status addProduct(Product entity);

	Status deleteProductById(int id);

	Status updateProduct(Product entity, int id);
}
