package com.program.InventoryManagement.controller;

import com.program.InventoryManagement.exception.ApiResponse;
import com.program.InventoryManagement.payload.SupplierDto;
import com.program.InventoryManagement.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api3")
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;

    @GetMapping("/{id}")
    public ResponseEntity<SupplierDto> getSupplierById(@PathVariable Integer id){
        SupplierDto supplierDto=this.supplierService.getSupplierById(id);
        return new ResponseEntity<>(supplierDto, HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<SupplierDto>> getAllSupplier(){
        List<SupplierDto> supplierDtos=this.supplierService.getAllUser();
        return new ResponseEntity<>(supplierDtos,HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<SupplierDto> createSupplier(@RequestBody SupplierDto supplierDto){
        SupplierDto supplierDto1=this.supplierService.createSupplier(supplierDto);
        return new ResponseEntity<>(supplierDto1,HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<SupplierDto> updateSupplier(@RequestBody SupplierDto supplierDto,@PathVariable Integer id){
        SupplierDto supplierDto1=this.supplierService.updateSupplier(id,supplierDto);
        return new ResponseEntity<>(supplierDto1,HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse> deleteSupplier(@PathVariable Integer id){
        this.supplierService.deleteSupplier(id);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Supplier is deleted By User",HttpStatus.OK),HttpStatus.OK);
    }
    @PostMapping("/user/{uId}")
    public ResponseEntity<SupplierDto> createSupplier(@RequestBody  SupplierDto supplierDto,
                                                     @PathVariable Integer uId)
    {
        SupplierDto supplierDto1=this.supplierService.createSupplier(supplierDto,uId);
        return new ResponseEntity<>(supplierDto1,HttpStatus.CREATED);
    }
}
