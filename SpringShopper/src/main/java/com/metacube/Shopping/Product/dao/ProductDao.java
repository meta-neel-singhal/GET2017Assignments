package com.metacube.Shopping.Product.dao;

import com.metacube.Shopping.Product.Model.Product;
import com.metacube.Shopping.dao.AbstractDao;


public interface ProductDao extends AbstractDao<Product, Integer> {

    Boolean edit(Product entity, int id);

}
