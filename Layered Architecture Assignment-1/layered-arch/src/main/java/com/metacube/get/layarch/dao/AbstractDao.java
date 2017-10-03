package com.metacube.get.layarch.dao;

import java.io.Serializable;

import com.metacube.get.layarch.enums.Status;

/**
 * The Interface AbstractDao.
 * 
 * @author Neel Singhal
 *
 * @param <T> generic data type.
 * @param <ID> generic data type.
 */
public interface AbstractDao<T, ID extends Serializable> {
	<S extends T> S save(S entity);

	T findOne(ID primaryKey);

	Iterable<T> findAll();

	Long count();

	Status delete(ID id);

	<S extends T> Status update(S product, ID primaryKey);

	<S extends T> Status add(S product);

	boolean exists(ID primaryKey);
}
