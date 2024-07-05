package com.program.InventoryManagement.service.serviceImpl;

import com.program.InventoryManagement.entity.Product;
import com.program.InventoryManagement.entity.Supplier;
import com.program.InventoryManagement.exception.ResourceNotFoundException;
import com.program.InventoryManagement.payload.ProductDto;
import com.program.InventoryManagement.repository.ProductRepo;
import com.program.InventoryManagement.repository.SupplierRepo;
import com.program.InventoryManagement.repository.UserRepo;
import com.program.InventoryManagement.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    private final UserRepo userRepo;
    private final SupplierRepo supplierRepo;
    private final ModelMapper modelMapper;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product=this.dtoToProduct(productDto);
        Product product1=this.productRepo.save(product);
        return productToDto(product1);
    }

    @Override
    public ProductDto updateProduct(int id, ProductDto productDto) {
        Product product=this.productRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Product","id",id));
        product.setProductNo(productDto.getProductNo());
        product.setProductName(productDto.getProductName());
        Product product1=this.productRepo.save(product);
        return productToDto(product1);
    }

    @Override
    public List<ProductDto> getAllProduct() {
        List<Product> products=this.productRepo.findAll();
        List<ProductDto> productDtos=products.stream().map((product)->this.productToDto(product)).collect(Collectors.toList());
        return productDtos;
    }

    @Override
    public ProductDto getProductById(int id) {
        Product product=this.productRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Product","id",id));
        return productToDto(product);
    }

    @Override
    public void deleteProductById(int id) {
        Product product=this.productRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Product","id",id));
        this.productRepo.delete(product);

    }

    @Override
    public ProductDto createProductWithSupplier(ProductDto productDto, int sId) {
        Supplier supplier=this.supplierRepo.findById(sId).orElseThrow(()->new ResourceNotFoundException("Supplier","id",sId));
        Product product=this.dtoToProduct(productDto);
        product.setSupplier(supplier);
        Product product1=this.productRepo.save(product);
        return productToDto(product1);
    }

    public Product dtoToProduct(ProductDto productDto){
        Product product=this.modelMapper.map(productDto,Product.class);
        return  product;
    }
    public ProductDto productToDto(Product product){
        ProductDto productDto=this.modelMapper.map(product,ProductDto.class);
        return productDto;
    }
}
