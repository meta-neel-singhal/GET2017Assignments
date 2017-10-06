package com.metacube.Shopping.dao;
import java.io.Serializable;

public interface AbstractDao<T, ID extends Serializable>
{
    Boolean save(T entity);
    T findOne(ID primaryKey);
    Iterable<T> findAll();
    Long count();
    boolean delete(int id);
    boolean exists(ID primaryKey);
}
