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
@RequestMapping("/supplier")
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;

    @GetMapping("/get/{id}")
    public ResponseEntity<SupplierDto> getSupplierById(@PathVariable int id){
        SupplierDto supplierDto=this.supplierService.getSupplierById(id);
        return new ResponseEntity<>(supplierDto, HttpStatus.OK);
    }
    @GetMapping("/get")
    public ResponseEntity<List<SupplierDto>> getAllSupplier(){
        List<SupplierDto> supplierDtos=this.supplierService.getAllUser();
        return new ResponseEntity<>(supplierDtos,HttpStatus.OK);
    }
    @PutMapping("/admin/suppliers/{id}")
    public ResponseEntity<SupplierDto> updateSupplier(@RequestBody SupplierDto supplierDto,@PathVariable Integer id){
        SupplierDto supplierDto1=this.supplierService.updateSupplier(id,supplierDto);
        return new ResponseEntity<>(supplierDto1,HttpStatus.OK);
    }
    @DeleteMapping("/admin/supplier/{id}")
    public ResponseEntity<ApiResponse> deleteSupplier(@PathVariable Integer id){
        this.supplierService.deleteSupplier(id);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Supplier is deleted By User",HttpStatus.OK),HttpStatus.OK);
    }
    @PostMapping("/create/{pid}")
    public ResponseEntity<SupplierDto> createSupplier(@RequestBody  SupplierDto supplierDto,@PathVariable int pid)
    {
        SupplierDto supplierDto1=this.supplierService.createSupplier(supplierDto,pid);
        return new ResponseEntity<>(supplierDto1,HttpStatus.CREATED);
    }
}
