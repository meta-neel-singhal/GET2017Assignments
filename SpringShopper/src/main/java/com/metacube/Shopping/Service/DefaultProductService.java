package com.metacube.Shopping.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.Shopping.Product.Model.Product;
import com.metacube.Shopping.Product.dao.ProductDao;


@Component("productService")
public class DefaultProductService implements ProductService {
    @Autowired
    ProductDao productDao;
    
    public DefaultProductService() {
        
    }

    public ProductDao getProductDao() {
        return productDao;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public DefaultProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public Iterable<Product> getAllProducts()
    {
        return productDao.findAll();
    }

    public Product getProductById(final int id)
    {
        return productDao.findOne(id);
    }

    public Boolean deleteProduct(int id) {
        
        return productDao.delete(id);
    }
    public Boolean editProduct(Product entity,int id) {
        System.out.println("A call here in edit service");
        return productDao.edit(entity,id);
    }

    
    public Boolean saveProduct(Product newProduct) {
        return productDao.save(newProduct);
    }
}
