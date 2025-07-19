package com.example.demo.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecondHandProduct extends Product {
    private String condition; // e.g., "Good", "Like New", etc.

    public SecondHandProduct() {
        super();
    }

    public SecondHandProduct(String name, String colour, int size, double price, Category category, String condition) {
        super(name, colour, size, price, category);
        this.condition = condition;}

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
