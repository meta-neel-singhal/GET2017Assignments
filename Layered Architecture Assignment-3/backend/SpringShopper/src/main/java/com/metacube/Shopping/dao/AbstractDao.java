package com.metacube.Shopping.dao;

import java.io.Serializable;

import com.metacube.Shopping.Product.Model.Product;

/**
 * The Interface AbstractDao.
 * 
 * @author Neel Singhal
 *
 * @param <T> generic data type.
 * @param <ID> generic data type.
 */
public interface AbstractDao<T, ID extends Serializable> {
	Boolean add(T entity);

	T findOne(ID primaryKey);

	Iterable<T> findAll();

	Boolean delete(int id);
	
    Boolean edit(Product entity, int id);

}
