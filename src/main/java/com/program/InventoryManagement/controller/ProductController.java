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
@RequestMapping("/api4")
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    private final ProductService productService;
    private Logger logger= LoggerFactory.getLogger(ProductController.class);

    @GetMapping("/")
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
    @PostMapping("/")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        ProductDto productDto1=this.productService.createProduct(productDto);
        return new ResponseEntity<>(productDto1,HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Integer id,@RequestBody ProductDto productDto){
        ProductDto productDto1=this.productService.updateProduct(id,productDto);
        return new ResponseEntity<>(productDto1,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Integer id){
        this.productService.deleteProductById(id);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Product is deleted",HttpStatus.OK),HttpStatus.OK);
    }
    @PostMapping("/user/{uId}/supplier/{supplierId}/")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto,
                                                    @PathVariable Integer uId,
                                                    @PathVariable Integer supplierId
                                                    ){
        ProductDto productDto1=this.productService.createProduct(productDto,uId,supplierId);
        return new ResponseEntity<>(productDto1,HttpStatus.CREATED);
    }
//    @PostMapping("/cart/{id}")
//    public ResponseEntity<ProductDto> createCart(@RequestBody ProductDto productDto,@PathVariable Integer id){
//        ProductDto productDto1=this.productService.createCart(productDto,id);
//        return new ResponseEntity<>(productDto1,HttpStatus.CREATED);
//    }




}
