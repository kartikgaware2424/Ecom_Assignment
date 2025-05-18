package com.ecom.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.ecom.model.Customer;
import com.ecom.model.Product;
import com.ecom.service.CustomerService;
import com.ecom.service.ProductService;
import com.ecom.service.PurchaseService;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CustomerService customerService=new CustomerService();
		ProductService productService=new ProductService();
		Customer customer=new Customer();
		PurchaseService purchaseService=new PurchaseService();
		
		
		while(true)
		{
			System.out.println("********************Ecom Menu ****************");
			//The add customer is done to test the code 
			System.out.println("1. Add Customer"); 
			System.out.println("2. Add Product ");
			System.out.println("3.Get Product From Category_Id");
			System.out.println("4.Add Purchase ");
			System.out.println("0.Exit");
			
			int input  = sc.nextInt(); 
			if(input == 0) {
				System.out.println("Exiting... Thank you");
				break; 
			}
				
			switch(input) {
			case 1:
				
				System.out.println("Enter the name :");
				sc.nextLine();
                customer.setName(sc.nextLine());
				System.out.println("Enter the city :");
				customer.setCity(sc.next());
				
				try {
					customerService.insertIntoCustomer(customer);
				} catch (SQLException e) {
				System.out.println(e.getMessage());
				}
				break;
			case 2:
				   Product product=new Product();
				  System.out.print("Enter product title: ");
				    sc.nextLine(); 
			        product.setTitle(sc.nextLine());

			        System.out.print("Enter product price: ");
			        product.setPrice(sc.nextDouble());

			        sc.nextLine(); 

			        System.out.print("Enter product description: ");
			        product.setDescription(sc.nextLine());

			        System.out.print("Enter category ID (must exist): ");
			        int catId = sc.nextInt();
			        productService.insertProduct(product, catId);
			        
			        
				break;
			case 3: 
				  System.out.print("Enter category ID to fetch products: ");
				   int catIdToFetch = sc.nextInt();
				    productService.getProductsByCategoryId(catIdToFetch);
				
				break;
				
			case 4:
				 System.out.print("Enter customer ID: ");
				 int custId = sc.nextInt();
				 System.out.print("Enter product ID: ");
				 int prodId = sc.nextInt();
				 purchaseService.insertIntoPurchase(custId, prodId);
				 
				break;
			default: 
				System.out.println("Invaid Input!!!");
				
			
			}
			
			
			
			}
		}
	}


