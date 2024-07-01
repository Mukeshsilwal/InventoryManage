package com.program.InventoryManagement.controller;

import com.program.InventoryManagement.exception.ApiResponse;
import com.program.InventoryManagement.payload.ProductDto;
import com.program.InventoryManagement.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    private final ProductService productService;
    private Logger logger= LoggerFactory.getLogger(ProductController.class);

    @GetMapping("/get")
    public ResponseEntity<List<ProductDto>> getAllProduct(){
        logger.info("Get endpoint is hitted");
        List<ProductDto> productDto=this.productService.getAllProduct();
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Integer id){
        ProductDto productDto=this.productService.getProductById(id);
        return new ResponseEntity<>(productDto,HttpStatus.OK);
    }
    @PostMapping("/admin/products/create")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        ProductDto productDto1=this.productService.createProduct(productDto);
        return new ResponseEntity<>(productDto1,HttpStatus.CREATED);
    }
    @PutMapping("/admin/products/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Integer id,@RequestBody ProductDto productDto){
        ProductDto productDto1=this.productService.updateProduct(id,productDto);
        return new ResponseEntity<>(productDto1,HttpStatus.OK);
    }
    @DeleteMapping("/admin/products/{id}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Integer id){
        this.productService.deleteProductById(id);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Product is deleted",HttpStatus.OK),HttpStatus.OK);
    }
    @PostMapping("/user/{uId}/supplier/")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto,
                                                    @PathVariable Integer uId){
        ProductDto productDto1=this.productService.createProduct(productDto,uId);
        return new ResponseEntity<>(productDto1,HttpStatus.CREATED);
    }
}
