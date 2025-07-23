package com.example.demo;

import com.example.demo.dto.ProductDTO;
import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.implementations.ProductServiceImpl;
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
    private ProductServiceImpl productService;

    private Product sampleProduct;
    private Category sampleCategory;
    private ProductDTO sampleProductDTO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        sampleCategory = new Category(1, "Sport Shoes");

        sampleProduct = new Product(1, sampleCategory, "Runner X", "Red", 42, 99.99);

        sampleProductDTO = new ProductDTO();
        sampleProductDTO.setId(1);
        sampleProductDTO.setName("Runner X");
        sampleProductDTO.setColour("Red");
        sampleProductDTO.setSize(42);
        sampleProductDTO.setPrice(99.99);
        sampleProductDTO.setCategoryId(1);
        sampleProductDTO.setCategoryName("Sport Shoes");
    }

    @Test
    public void testAddProduct() {
        when(categoryRepo.findById(1)).thenReturn(Optional.of(sampleCategory));
        when(productRepo.save(any(Product.class))).thenReturn(sampleProduct);

        ProductDTO result = productService.saveProductFromDTO(sampleProductDTO);

        assertNotNull(result);
        assertEquals("Runner X", result.getName());
        assertEquals(42, result.getSize());
        verify(categoryRepo, times(1)).findById(1);
        verify(productRepo, times(1)).save(any(Product.class));
    }

    @Test
    public void testGetAllProducts() {
        when(productRepo.findAll()).thenReturn(List.of(sampleProduct));

        List<ProductDTO> products = productService.getAllProductDTOs();

        assertFalse(products.isEmpty());
        assertEquals(1, products.size());
        assertEquals("Runner X", products.get(0).getName());
        verify(productRepo, times(1)).findAll();
    }

    @Test
    public void testGetProductById() {
        when(productRepo.findById(1)).thenReturn(Optional.of(sampleProduct));

        ProductDTO result = productService.getProductById(1);

        assertNotNull(result);
        assertEquals("Runner X", result.getName());
        verify(productRepo, times(1)).findById(1);
    }
}
