package com.ecom.dao;


import java.sql.SQLException;
import java.util.List;

import com.ecom.model.Product;

public interface ProductDao {

	void insertProduct(Product product) throws SQLException;
	Product getById(int id) throws SQLException;
	List<Product> getByCategoryId(Product product,int categeory_id) throws SQLException;
}
