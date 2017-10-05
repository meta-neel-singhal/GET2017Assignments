package com.metacube.shoppingcart.facade;

import com.metacube.shoppingcart.dto.ProductDto;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.model.Product;

/**
 * The Interface ProductFacade.
 * 
 * @author Neel Singhal
 */
public interface ProductFacade {
	Iterable<ProductDto> getAllProducts();

	ProductDto getProductById(int id);

	Status deleteProduct(int id);

	Status editProduct(Product product, int id);

	Status addProduct(Product product);
}