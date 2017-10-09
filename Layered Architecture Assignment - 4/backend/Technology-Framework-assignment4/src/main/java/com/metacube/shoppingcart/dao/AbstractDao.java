package com.metacube.shoppingcart.dao;

import java.io.Serializable;

import com.metacube.shoppingcart.enums.Status;

/**
 * The Interface AbstractDao.
 *
 * @param <T>
 *            the generic type
 * @param <ID>
 *            the generic type
 *            
 * @author Neel Singhal
 */
public interface AbstractDao<T, ID extends Serializable> {

	<S extends T> Status add(S entity);

	T findOne(ID primaryKey);

	Iterable<T> findAll();

	Status delete(int id);

	<S extends T> Status updateProduct(S entity, int id);
}
