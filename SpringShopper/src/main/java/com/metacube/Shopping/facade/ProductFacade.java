package com.metacube.Shopping.facade;

import com.metacube.Shopping.dto.ProductDto;

public interface ProductFacade {
    Iterable<ProductDto> getAllProducts();
    ProductDto getProductById(int id);
    Boolean deleteProduct(int id);
    Boolean saveProduct(ProductDto newProduct);
    Object editProduct(ProductDto product, int id);
}
