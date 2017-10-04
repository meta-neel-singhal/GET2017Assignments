package com.metacube.shoppingcart.dao;

import java.io.Serializable;

import com.metacube.shoppingcart.enums.Status;

/**
 * The Interface AbstractDao.
 * 
 * @author Neel Singhal
 *
 * @param <T> generic data type.
 * @param <ID> generic data type.
 */
public interface AbstractDao<T, ID extends Serializable> {
	<S extends T> Status add(S entity);

	T findOne(ID primaryKey);

	Iterable<T> findAll();

	Status delete(ID primaryKey);

	<S extends T>Status edit(S entity,ID primaryKey);
}
