package com.metacube.shoppingcart.dao;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.model.Product;

/**
 * The Class HibernateDao.
 *
 * @param <T>
 *            the generic type
 * @param <ID>
 *            the generic type
 *            
 * @author Neel Singhal
 */
public abstract class HibernateDao<T, ID extends Serializable> implements
		AbstractDao<T, ID> {

	@Autowired
	private SessionFactory sessionFactory;

	private Class<T> modelClass;

	/**
	 * Gets the session factory.
	 *
	 * @return the session factory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Sets the session factory.
	 *
	 * @param sessionFactory
	 *            the new session factory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Gets the model class.
	 *
	 * @return the model class
	 */
	public Class<T> getModelClass() {
		return modelClass;
	}

	/**
	 * Instantiates a new hibernate dao.
	 *
	 * @param modelClass
	 *            the model class
	 */
	public HibernateDao(Class<T> modelClass) {
		this.modelClass = modelClass;
	}

	/**
	 * Gets the list of products.
	 */
	@Override
	public Iterable<T> findAll() {
		List<T> productList = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria cr = session.createCriteria(getModelClass());
			productList = cr.list();

		} catch (Exception e) {
			productList = Collections.emptyList();
		}

		return productList;
	}

	/**
	 * Get the details of a product.
	 */
	@Override
	public T findOne(final ID primaryKey) {
		Product product = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			product = (Product) session.get(Product.class, primaryKey);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

		return (T) product;
	}

	/**
	 * Delete a product.
	 */
	@Override
	public Status delete(int primaryKey) {
		Status result = Status.Success;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Product product = (Product) session.get(Product.class, primaryKey);
			session.delete(product);
		} catch (Exception e) {
			result = Status.Error_Occured;
		}
		
		return result;

	}

	/**
	 * Add a product.
	 */
	@Override
	public <S extends T> Status add(final S entity) {
		Status result = Status.Success;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.save(entity);
		} catch (Exception e) {
			result = Status.Error_Occured;
		}
		
		return result;
	}

	/**
	 * Update a product.
	 */
	@Override
	public <S extends T> Status updateProduct(S entity, int id) {
		Status result = Status.Added;
		try {

			Session session = this.sessionFactory.getCurrentSession();
			Product update = (Product) entity;
			Product product = (Product) session.get(Product.class, id);
			product.setName(update.getName());
			product.setPrice(update.getPrice());
			product.setImg(update.getImg());
			session.update(product);

		} catch (Exception e) {
			result = Status.Error_Occured;
		}

		return result;
	}
}
