package com.example.demo.service;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepo;

    public CategoryService(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public CategoryDTO addCategory(CategoryDTO dto) {
        Category category = new Category();
        category.setName(dto.getName());
        Category saved = categoryRepo.save(category);
        return saved.convertToDTO();
    }

    public List<CategoryDTO> getAllCategories() {
        return categoryRepo.findAll().stream()
                .map(Category::convertToDTO)
                .collect(Collectors.toList());
    }

    public void deleteCategory(Integer id) {
        categoryRepo.deleteById(id);
    }

    public CategoryDTO getCategoryById(Integer id) {
        Category category = categoryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        return category.convertToDTO();
    }

    public CategoryDTO updateCategory(CategoryDTO dto) {

        Category existing = categoryRepo.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + dto.getId()));

        existing.setName(dto.getName());

        Category saved = categoryRepo.save(existing);
        return saved.convertToDTO();
    }

}
