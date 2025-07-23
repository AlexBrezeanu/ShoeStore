package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor          // ✅ Needed for JSON deserialization and JPA
@AllArgsConstructor
public class CategoryDTO {
    private Integer id;
    private String name;
}
