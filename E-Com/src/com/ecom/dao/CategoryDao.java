package com.ecom.dao;

import java.sql.SQLException;

import com.ecom.model.Category;

public interface CategoryDao {
	
	// This is done the establish the connection in the product table so that
	// we can add the fk category_id in the product table 
	
	 Category getById(int id) throws SQLException;

}
