package com.program.InventoryManagement.service;

import com.program.InventoryManagement.payload.SupplierDto;

import java.util.List;

public interface SupplierService {
    SupplierDto createSupplier(SupplierDto supplierDto,int pId);
    SupplierDto updateSupplier(int id,SupplierDto supplierDto);
    List<SupplierDto> getAllUser();
    SupplierDto getSupplierById(int id);
    void deleteSupplier(int id);
    SupplierDto getProductBySupplierId(int id);

}
