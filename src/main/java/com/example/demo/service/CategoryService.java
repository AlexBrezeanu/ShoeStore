package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepo;

    public CategoryService(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public Category saveCategory(Category category) {
        return categoryRepo.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    public Optional<Category> getCategoryById(Integer id) {
        return categoryRepo.findById(id);
    }

    public void deleteCategory(Integer id) {
        categoryRepo.deleteById(id);
    }
}
