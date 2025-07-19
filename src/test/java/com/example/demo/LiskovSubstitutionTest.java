package com.example.demo;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.model.SecondHandProduct;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LiskovSubstitutionTest {

    @Test
    void testSecondHandProductBehavesLikeProduct() {
        Category category = new Category(1, "Used Shoes");

        Product product = new SecondHandProduct("Street Kicks", "Grey", 42, 49.99, category, "Good");

        String name = product.getName();
        double price = product.getPrice();

        assertEquals("Street Kicks", name);
        assertEquals(49.99, price);
        assertTrue(product instanceof SecondHandProduct);
    }
}
