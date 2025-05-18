package com.ecom.service;

import java.sql.SQLException;
import java.time.LocalDate;

import com.ecom.dao.CustomerDaoImpl;
import com.ecom.dao.ProductDaoImpl;
import com.ecom.dao.PurchaseDaoImpl;
import com.ecom.model.Customer;
import com.ecom.model.Product;
import com.ecom.model.Purchase;

public class PurchaseService {
	CustomerDaoImpl customerDao=new CustomerDaoImpl();
	PurchaseDaoImpl purchaseDao=new PurchaseDaoImpl();
	ProductDaoImpl productDao=new ProductDaoImpl();
	
	public void  insertIntoPurchase(int customer_id,int product_id)
	{
		
		try {
			Purchase purchase=new Purchase();
			int id=(int) (Math.random()*100000);
			purchase.setId(id);
			
			purchase.setDateOfPurchase(LocalDate.now());
			
			Customer customer=customerDao.getById(customer_id);
			purchase.setCustomer(customer);
			
			Product product=productDao.getById(product_id);
			purchase.setProduct(product);
			
			if (customer == null && product==null) {
	            System.out.println(" No customer and product id found : " );
	            return; //stop execution if category doesn't exist
	        }
			purchaseDao.insertPurchase(purchase);
			System.out.println("Date inserted SuccessFully in purchase ....");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
