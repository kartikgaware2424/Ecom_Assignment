package com.ecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ecom.model.Purchase;
import com.ecom.utility.DBUtility;

public class PurchaseDaoImpl implements PurchaseDao {

	@Override
	public void insertPurchase(Purchase purchase) throws SQLException {
		    DBUtility db = new DBUtility();
	        Connection con = db.connect();
	        String cmd = "insert into purchase (id, date_of_purchase, customer_id, product_id) VALUES (?, ?, ?, ?)";
	        PreparedStatement pst = con.prepareStatement(cmd);
	        pst.setInt(1, purchase.getId());
	        pst.setString(2, purchase.getDateOfPurchase().toString());
	        pst.setInt(3, purchase.getCustomer().getId()); 
	        pst.setInt(4, purchase.getProduct().getId());   

	       

	        pst.executeUpdate();
		
	}

}
