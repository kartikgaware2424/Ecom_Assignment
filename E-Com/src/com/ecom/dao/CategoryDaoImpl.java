package com.ecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ecom.model.Category;
import com.ecom.utility.DBUtility;

public class CategoryDaoImpl implements CategoryDao {
// We don't need to print so use Category instead of the list 
	@Override
	public Category getById(int id) throws SQLException {
		Category category = null;
		DBUtility db=new DBUtility();
		Connection con=db.connect();
		String cmd="Select * from category where id=?";
		
		PreparedStatement pst=con.prepareStatement(cmd);
		pst.setInt(1, id);
	    ResultSet rs=pst.executeQuery();
	    while(rs.next())
	    {
	    	 category = new Category();
             category.setId(rs.getInt("id"));
             category.setName(rs.getString("name"));
	    }
	    // This to get the connection establish to product table 
		return category;
	}
	

}
