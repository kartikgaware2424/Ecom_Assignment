package com.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ecom.model.Product;
import com.ecom.service.ProductService;

public class ProductTest {

    private ProductService productService;

    @BeforeEach
    public void setup() {
        productService = new ProductService();
    }

    @Test
    public void testInsertProductWithValidCategory() {
        Product product = new Product();
        product.setTitle("Wireless Keyboard");
        product.setPrice(1299.00);
        product.setDescription("Bluetooth enabled keyboard");

        int validCategoryId = 1; // make sure this category ID exists in your DB

        // just call the method — check console manually
        productService.insertProduct(product, validCategoryId);

        // we should manually verify the output in console: "Product inserted Successfully..."
        System.out.println("testInsertProductWithValidCategory executed");
    }

    @Test
    public void testGetProductsByCategoryId() {
        int categoryId = 1; // Ensure this ID exists in DB and has products

        //  call the method — observe console output
        productService.getProductsByCategoryId(categoryId);

        // console should show product details or "No products found"
        System.out.println("testGetProductsByCategoryId executed");
    }
}
