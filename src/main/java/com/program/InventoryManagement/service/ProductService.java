package com.program.InventoryManagement.service;

import com.program.InventoryManagement.payload.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);
    ProductDto updateProduct(Integer id,ProductDto productDto);
    List<ProductDto> getAllProduct();
    ProductDto getProductById(Integer id);
    void deleteProductById(Integer id);
    ProductDto createProduct(ProductDto productDto,Integer uId,Integer supplierId);
//    ProductDto createCart(ProductDto productDto,Integer id);
}
