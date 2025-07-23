package com.example.demo.service;

import com.example.demo.dto.CategoryDTO;
import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAllCategories();
    CategoryDTO getCategoryById(Integer id);
    CategoryDTO addCategory(CategoryDTO dto);
    CategoryDTO updateCategory(CategoryDTO dto);
    void deleteCategory(Integer id);
}
