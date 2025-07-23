package com.example.demo.service;

import com.example.demo.dto.ProductDTO;
import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProductDTOs();
    ProductDTO getProductById(Integer id);
    ProductDTO saveProductFromDTO(ProductDTO dto);
    ProductDTO updateProduct(Integer id, ProductDTO dto);
    void deleteProduct(Integer id);
}
