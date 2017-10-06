package com.metacube.Shopping.Service;

import com.metacube.Shopping.Product.Model.Product;

public interface ProductService {
    Iterable<Product> getAllProducts();
    Product getProductById(int id);
    Boolean deleteProduct(int id);
    Boolean saveProduct(Product newProduct);
    Boolean editProduct(Product dtoToModel, int id);
}
