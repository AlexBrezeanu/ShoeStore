package com.example.demo.model;

import com.example.demo.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private String name;
    private String colour;
    @Column(name = "_size")
    private Integer size;
    private double price;

    public Product(String name, String colour, Integer size, double price, Category category) {
        this.name = name;
        this.colour = colour;
        this.size = size;
        this.price = price;
        this.category = category;
    }

    public ProductDTO convertToDTO() {
        ProductDTO dto = new ProductDTO();
        dto.setName(this.getName());
        dto.setColour(this.getColour());
        dto.setSize(this.getSize());
        dto.setPrice(this.getPrice());
        dto.setCategoryName(this.getCategory().getName());
        return dto;
    }

}

