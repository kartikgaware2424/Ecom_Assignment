package com.ecom.dao;

import java.sql.SQLException;

import com.ecom.model.Purchase;

public interface PurchaseDao {
	 void insertPurchase(Purchase purchase) throws SQLException;
}
