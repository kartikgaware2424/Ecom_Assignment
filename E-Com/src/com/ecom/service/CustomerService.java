package com.ecom.service;

import java.sql.SQLException;

import com.ecom.dao.CustomerDaoImpl;
import com.ecom.dao.CustomerDao;
import com.ecom.model.Customer;

public class CustomerService {
	CustomerDao dao=new CustomerDaoImpl();
	public  void insertIntoCustomer(Customer customer) throws SQLException
	{
		
		int id=(int) (Math.random()*100000);
		customer.setId(id);
		dao.insertCustomer(customer);
		System.out.println("The data is inserted SuccessFully!!");
	}

}
