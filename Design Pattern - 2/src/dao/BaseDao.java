package dao;
import model.BaseEntity;
import model.Product;

/**
 * Interface to Add, Delete, Update and Get products.
 * 
 * @author Neel Singhal
 */
public interface BaseDao {
	public Product get(String entityCode);
	public void add(BaseEntity entity);
	public void update(BaseEntity entity);
	public void delete(BaseEntity entity);
}
