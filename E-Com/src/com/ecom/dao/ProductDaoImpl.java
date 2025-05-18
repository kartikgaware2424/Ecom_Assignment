package com.ecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecom.model.Customer;
import com.ecom.model.Product;
import com.ecom.utility.DBUtility;


public class ProductDaoImpl implements ProductDao {

	@Override
	public void insertProduct(Product product) throws SQLException {
		DBUtility db=new DBUtility();
		Connection con=db.connect();
		String cmd = "INSERT INTO product (id, title, price, description, category_id) VALUES (?, ?, ?, ?, ?)";
		

	    PreparedStatement   pst=con.prepareStatement(cmd);
		pst.setInt(1, product.getId());
		pst.setString(2, product.getTitle());
        pst.setDouble(3, product.getPrice());
        pst.setString(4, product.getDescription());
        pst.setInt(5, product.getCategory().getId());
		pst.executeUpdate();
		
	}

	@Override
	public List<Product> getByCategoryId(Product product ,int categeory_id) throws SQLException {
		DBUtility db=new DBUtility();
		Connection con=db.connect();
		String cmd="Select * from product where category_id=?";
		PreparedStatement   pst=con.prepareStatement(cmd);
		pst.setInt(1, categeory_id);
		ResultSet rs=pst.executeQuery();
		List<Product> list =new ArrayList<>();
		while(rs.next())
		{
			Product p = new Product(); 
	        p.setId(rs.getInt("id"));
	        p.setTitle(rs.getString("title"));
	        p.setPrice(rs.getDouble("price"));
	        p.setDescription(rs.getString("description"));
	        p.setCategory(product.getCategory());

	        list.add(p);
			
		}
		
		return list;
	}

	@Override
	public Product getById(int id) throws SQLException {
		Product product = null;
		DBUtility db=new DBUtility();
		Connection con=db.connect();
		String cmd="Select * from Product where id=?";
		
		PreparedStatement pst=con.prepareStatement(cmd);
		pst.setInt(1, id);
	    ResultSet rs=pst.executeQuery();
	    while(rs.next())
	    {
	    	product = new Product();
	    	product.setId(rs.getInt("id"));
	    	product.setTitle(rs.getString("title"));
	    	product.setPrice(rs.getDouble("price"));
	    	product.setDescription(rs.getString("description"));
	    	product.setCategory(product.getCategory());
	                
	    }
	    // This to get the connection establish to product table 
		return product;
	}

}
