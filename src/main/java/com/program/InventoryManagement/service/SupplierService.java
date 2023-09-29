package com.program.InventoryManagement.service;

import com.program.InventoryManagement.payload.SupplierDto;

import java.util.List;

public interface SupplierService {
    SupplierDto createSupplier(SupplierDto supplierDto);
    SupplierDto updateSupplier(Integer id,SupplierDto supplierDto);
    List<SupplierDto> getAllUser();
    SupplierDto getSupplierById(Integer id);
    void deleteSupplier(Integer id);
    SupplierDto createSupplier(SupplierDto supplierDto,Integer uId);

}
