package com.example.demo.service.implementations;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepo;

    public CategoryServiceImpl(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepo.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryById(Integer id) {
        Category category = categoryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return convertToDTO(category);
    }

    @Override
    public CategoryDTO addCategory(CategoryDTO dto) {
        Category category = new Category();
        category.setName(dto.getName());
        return convertToDTO(categoryRepo.save(category));
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO dto) {
        Category existing = categoryRepo.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        existing.setName(dto.getName());
        return convertToDTO(categoryRepo.save(existing));
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepo.deleteById(id);
    }

    private CategoryDTO convertToDTO(Category category) {
        return new CategoryDTO(category.getId(), category.getName());
    }
}
