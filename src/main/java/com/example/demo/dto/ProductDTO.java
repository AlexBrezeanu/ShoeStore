package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {
    private Integer id;
    private String name;
    private String colour;
    private int size;
    private double price;
    private String categoryName;
    private Integer categoryId;
}
