package com.example.demo.service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepo;
    private final CategoryRepository categoryRepo;

    public ProductService(ProductRepository productRepo, CategoryRepository categoryRepo) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }

    public List<ProductDTO> getAllProductDTOs() {
        return productRepo.findAll().stream()
                .map(Product::convertToDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO saveProductFromDTO(ProductDTO dto) {
        Category category = categoryRepo.findByName(dto.getCategoryName())
                .orElseThrow(() -> new RuntimeException("Category not found: " + dto.getCategoryName()));

        Product product = convertToEntity(dto, category);
        Product saved = productRepo.save(product);
        return saved.convertToDTO();
    }

    public ProductDTO updateProduct(Integer id, ProductDTO productDTO) {
        Product existingProduct = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        existingProduct.setName(productDTO.getName());
        existingProduct.setColour(productDTO.getColour());
        existingProduct.setSize(productDTO.getSize());
        existingProduct.setPrice(productDTO.getPrice());

        if (productDTO.getCategoryId() != null) {
            Category category = categoryRepo.findById(productDTO.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found with id: " + productDTO.getCategoryId()));
            existingProduct.setCategory(category);
        }

        Product savedProduct = productRepo.save(existingProduct);
        return savedProduct.convertToDTO();
    }

    public ProductDTO getProductById(Integer id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        return product.convertToDTO();
    }

    public void deleteProduct(Integer id) {
        productRepo.deleteById(id);
    }

    private Product convertToEntity(ProductDTO dto, Category category) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setColour(dto.getColour());
        product.setSize(dto.getSize());
        product.setPrice(dto.getPrice());
        product.setCategory(category);
        return product;
    }
}
