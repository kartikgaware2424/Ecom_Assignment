package com.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ecom.service.PurchaseService;

public class PurchaseTest {

    private PurchaseService purchaseService;

    @BeforeEach
    public void setup() {
        purchaseService = new PurchaseService();
    }

    @Test
    public void testInsertIntoPurchaseWithValidIds() {
        int validCustomerId = 1;  // make sure this exists in your DB
        int validProductId = 1;   // make sure this exists in your DB

        purchaseService.insertIntoPurchase(validCustomerId, validProductId);

        // you should see: "Date inserted SuccessFully in purchase ...." in the console
        System.out.println("testInsertIntoPurchaseWithValidIds executed");
    }

    @Test
    public void testInsertIntoPurchaseWithInvalidIds() {
        int invalidCustomerId = -1;  // Doesn't exist
        int invalidProductId = -1;   // Doesn't exist

        purchaseService.insertIntoPurchase(invalidCustomerId, invalidProductId);

        // you should see: "No customer and product id found" or an error message
        System.out.println("testInsertIntoPurchaseWithInvalidIds executed");
    }
}
