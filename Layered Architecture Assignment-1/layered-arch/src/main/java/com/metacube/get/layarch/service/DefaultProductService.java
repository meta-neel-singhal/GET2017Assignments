package com.metacube.get.layarch.service;

import com.metacube.get.layarch.dao.user.ProductDao;
import com.metacube.get.layarch.model.Product;

public class DefaultProductService implements ProductService
{
	ProductDao productDao;

	public DefaultProductService(ProductDao productDao) {
		this.productDao = productDao;
	}


	@Override public Product getProductById(int id)
	{
		return productDao.findOne(id);
	}

	@Override
	public Iterable<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}
}
