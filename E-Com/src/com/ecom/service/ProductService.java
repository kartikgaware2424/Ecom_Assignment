package com.ecom.service;

import com.ecom.dao.CategoryDaoImpl;
import com.ecom.dao.ProductDaoImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ecom.dao.CategoryDao;
import com.ecom.dao.ProductDao;
import com.ecom.model.Category;
import com.ecom.model.Product;


public class ProductService {
	private CategoryDao categoryDao=new CategoryDaoImpl();
	private ProductDao productDao=new ProductDaoImpl();
	Scanner sc=new Scanner(System.in);
public void insertProduct(Product product,int category_id) 
{
	try {
		int id=(int) (Math.random()*100000);
		product.setId(id);
		Category category;
		category = categoryDao.getById(category_id);
		if (category == null) {
            System.out.println(" No category found with ID: " + category_id);
            return; //stop execution if category doesn't exist
        }
		product.setCategory(category);
		productDao.insertProduct(product);
		System.out.println("Product inserted Successfully...");
	} catch (SQLException e) {
		
		System.out.println(e.getMessage());
	}
	
	
	
}

public void getProductsByCategoryId(int category_id)
{
	try {
		Category category;
		category = categoryDao.getById(category_id);
		if (category == null) {
            System.out.println(" No product found with this category ID: " + category_id);
            return; //stop execution if category doesn't exist
        }
		 Product product1 = new Product(); // for category info
		 product1.setCategory(category);

	    List<Product> productList = productDao.getByCategoryId(product1, category_id);
	    
	    if (productList.isEmpty()) {
            System.out.println("No products found for this category.");
        }
	    else
	    {
	    	for (Product p : productList) {
                System.out.println("ID:" + p.getId());
                System.out.println("Title:" + p.getTitle());
                System.out.println("Price:" + p.getPrice());
                System.out.println("Description:" + p.getDescription());
          
            }
	    }
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}
}
}
