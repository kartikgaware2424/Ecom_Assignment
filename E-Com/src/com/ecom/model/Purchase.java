package com.ecom.model;

import java.time.LocalDate;

public class Purchase {
	    private int id;
	    private LocalDate dateOfPurchase;
	    private Customer customer;  
	    private Product product;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public LocalDate getDateOfPurchase() {
			return dateOfPurchase;
		}
		public void setDateOfPurchase(LocalDate dateOfPurchase) {
			this.dateOfPurchase = dateOfPurchase;
		}
		public Customer getCustomer() {
			return customer;
		}
		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
		public Product getProduct() {
			return product;
		}
		public void setProduct(Product product) {
			this.product = product;
		}
		@Override
		public String toString() {
			return "Purchase [id=" + id + ", dateOfPurchase=" + dateOfPurchase + ", customer=" + customer + ", product="
					+ product + "]";
		}
		public Purchase(int id, LocalDate dateOfPurchase, Customer customer, Product product) {
			super();
			this.id = id;
			this.dateOfPurchase = dateOfPurchase;
			this.customer = customer;
			this.product = product;
		}
		public Purchase() {
			
		}
		
		
	    

}
