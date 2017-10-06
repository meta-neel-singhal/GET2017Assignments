package com.metacube.Shopping.facade;

import com.metacube.Shopping.dto.ProductDto;

/**
 * The Interface ProductFacade.
 * 
 * @author Neel Singhal
 */
public interface ProductFacade {
	Iterable<ProductDto> getAllProducts();

	ProductDto getProductById(int id);

	Boolean deleteProduct(int id);

	Boolean addProduct(ProductDto newProduct);

	Object editProduct(ProductDto product, int id);
}
