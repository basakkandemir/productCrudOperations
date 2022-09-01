package com.example.productCRM.service;

import com.example.productCRM.model.dto.ProductDTO;
import com.example.productCRM.model.entity.Product;

import java.util.List;

public interface ProductService {
    void addProduct(ProductDTO productDTO);
    void deleteProduct(Long id);
    void updateProduct(ProductDTO productDTO);
    List<ProductDTO> getProductList();

    Long sumProducts();

    Long sumProductsFilterByName(String name);

    List<Product> filterPrice(Long price);

    Double averageProduct();
}
