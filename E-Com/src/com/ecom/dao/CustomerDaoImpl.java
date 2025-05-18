package com.ecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ecom.model.Category;
import com.ecom.model.Customer;
import com.ecom.utility.DBUtility;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void insertCustomer(Customer customer) throws SQLException {
		DBUtility db=new DBUtility();
		Connection con=db.connect();
		String cmd="insert into customer value (?,?,?)";
		 PreparedStatement   pst=con.prepareStatement(cmd);
		pst.setInt(1, customer.getId());
		pst.setString(2, customer.getName());
		pst.setString(3, customer.getCity());
		pst.executeUpdate();
		//db.close();
	}

	@Override
	public Customer getById(int id) throws SQLException {
		Customer customer = null;
		DBUtility db=new DBUtility();
		Connection con=db.connect();
		String cmd="Select * from Customer where id=?";
		
		PreparedStatement pst=con.prepareStatement(cmd);
		pst.setInt(1, id);
	    ResultSet rs=pst.executeQuery();
	    while(rs.next())
	    {
	    	customer = new Customer();
             customer.setId(rs.getInt("id"));
             customer.setCity(rs.getString("city"));
             customer.setName(rs.getString("name"));
             
	    }
	    // This to get the connection establish to product table 
		return customer;
		
	}

	
	
}
