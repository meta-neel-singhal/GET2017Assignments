package com.metacube.DAO;

import com.metacube.model.BaseEntity;
import com.metacube.model.ProductVo;
import java.util.List;

/**
 *
 * @author Neel Singhal
 */
public interface BaseDao<T extends BaseEntity> {
    public List<Object> getAllProduct();
    public void addproduct();
    public <Object> T updateproduct(int id);
    public void deleteproduct(int id);
    public <Object> T searchproduct(int id);
}
