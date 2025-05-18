package com.ecom.dao;

import java.sql.SQLException;

import com.ecom.model.Customer;

public interface CustomerDao {

	void insertCustomer(Customer customer) throws SQLException;
   Customer getById(int id) throws SQLException;
}
