package com.example.demo;

import com.example.demo.dto.ProductDTO;
import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    @Mock
    private ProductRepository productRepo;

    @Mock
    private CategoryRepository categoryRepo;

    @InjectMocks
    private ProductService productService;

    private Product sampleProduct;
    private Category sampleCategory;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        sampleCategory = new Category(null, "Sport Shoes");
        sampleProduct = new Product(null, sampleCategory, "Runner X", "Red", 42, 99.99);
    }

    @Test
    public void testAddProduct() {
        when(productRepo.save(sampleProduct)).thenReturn(sampleProduct);
        when(categoryRepo.findByName(sampleProduct.getCategory().getName())).thenReturn(Optional.of(sampleCategory));

        ProductDTO saved = productService.saveProductFromDTO(sampleProduct.convertToDTO());

        assertNotNull(saved);
        assertEquals("Runner X", saved.getName());
        verify(productRepo, times(1)).save(sampleProduct);
    }

    @Test
    public void testGetAllProducts() {
        when(productRepo.findAll()).thenReturn(List.of(sampleProduct));

        List<ProductDTO> products = productService.getAllProductDTOs();

        assertFalse(products.isEmpty());
        assertEquals(1, products.size());
        verify(productRepo, times(1)).findAll();
    }

    @Test
    public void testGetProductById() {
        when(productRepo.findById(1)).thenReturn(Optional.of(sampleProduct));

        ProductDTO productDTO = productService.getProductById(1);

        assertNotNull(productDTO);
        assertEquals("Runner X", productDTO.getName());
        verify(productRepo, times(1)).findById(1);
    }
}

