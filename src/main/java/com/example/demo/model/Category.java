package com.example.demo.model;

import com.example.demo.dto.CategoryDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    public CategoryDTO convertToDTO() {
        CategoryDTO dto = new CategoryDTO();
        dto.setName(this.getName());
        return dto;
    }
}
