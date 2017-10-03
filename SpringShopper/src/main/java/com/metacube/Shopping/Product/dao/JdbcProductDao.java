package com.metacube.Shopping.Product.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.metacube.Shopping.Product.Model.Product;
import com.metacube.Shopping.dao.GenericJdbcDao;

@Component("productDao")
public class JdbcProductDao extends GenericJdbcDao <Product, Integer> implements ProductDao
{
    private String tableName = "Product";
    
    
    public void setTableName(String tableName) {
        this.tableName = "Product";
    }

    @Override protected String getTableName()
    {
        return tableName;
    }

    @Override protected Product extractResultSetRow(final ResultSet resultSet)
    {
        Product product = new Product();

        try
        {
            product.setImageUrl(resultSet.getString("imageUrl"));
            product.setPrice(resultSet.getDouble("price"));
            product.setName(resultSet.getString("name"));
            product.setId(resultSet.getInt("id"));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return product;
    }

    @Override protected String getPrimaryKeyColoumnName()
    {
        return "id";
    }

}

