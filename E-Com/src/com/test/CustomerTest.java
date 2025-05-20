package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ecom.model.Customer;
import com.ecom.service.CustomerService;

public class CustomerTest {
	CustomerService customerService;
	
	@BeforeEach
	public void init()
	{
		customerService=new CustomerService();
	}
	@Test
    public void testInsertIntoCustomer() throws SQLException {
        Customer customer = new Customer();
        customer.setName("Kartik Rajaram");
        customer.setCity("Shrirampur");

        customerService.insertIntoCustomer(customer);
       
       
        // If no exception is thrown, test is assumed to be passed
        System.out.println("Test Passed: Customer inserted successfully -> " + customer);
    }

}
