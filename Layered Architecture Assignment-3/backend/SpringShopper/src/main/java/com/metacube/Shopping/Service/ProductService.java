package com.metacube.Shopping.Service;

import com.metacube.Shopping.Product.Model.Product;

/**
 * The interface ProductService.
 * 
 * @author Neel Singhal
 */
public interface ProductService {
	Iterable<Product> getAllProducts();

	Product getProductById(int id);

	Boolean deleteProduct(int id);

	Boolean addProduct(Product newProduct);

	Boolean editProduct(Product dtoToModel, int id);
}
