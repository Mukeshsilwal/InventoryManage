package com.program.InventoryManagement.service;

import com.program.InventoryManagement.payload.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);
    ProductDto updateProduct(int id,ProductDto productDto);
    List<ProductDto> getAllProduct();
    ProductDto getProductById(int id);
    void deleteProductById(int id);
    ProductDto createProductWithSupplier(ProductDto productDto,int sId);
}
