package com.metacube.get.layarch.facade;

import com.metacube.get.layarch.dto.ProductDto;
import com.metacube.get.layarch.enums.Status;
import com.metacube.get.layarch.model.Product;

/**
 * The Interface ProductFacade.
 * 
 * @author Neel Singhal
 */
public interface ProductFacade {
	Iterable<ProductDto> getAllProducts();

	ProductDto getProductById(int id);

	Status deleteProduct(int id);

	Status updateProduct(Product product, int id);

	Status addProduct(Product product);
}
