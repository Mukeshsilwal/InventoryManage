package com.program.InventoryManagement.service.serviceImpl;

import com.program.InventoryManagement.entity.Product;
import com.program.InventoryManagement.entity.Supplier;
import com.program.InventoryManagement.exception.ResourceNotFoundException;
import com.program.InventoryManagement.payload.SupplierDto;
import com.program.InventoryManagement.repository.OrderRepo;
import com.program.InventoryManagement.repository.ProductRepo;
import com.program.InventoryManagement.repository.SupplierRepo;
import com.program.InventoryManagement.repository.UserRepo;
import com.program.InventoryManagement.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepo supplierRepo;
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;
    private  final ProductRepo productRepo;
    private final OrderRepo orderRepo;
    @Override
    public SupplierDto createSupplier(SupplierDto supplierDto,int pId) {
        Supplier supplier=this.dtoToSupplier(supplierDto);
        Supplier supplier1=this.supplierRepo.save(supplier);
        return supplierToDto(supplier1);
    }

    @Override
    public SupplierDto updateSupplier(int id, SupplierDto supplierDto) {
        Supplier supplier=this.supplierRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Supplier","id",id));
        supplier.setSupplierName(supplierDto.getSupplierName());
        Supplier supplier1=this.supplierRepo.save(supplier);
        return supplierToDto(supplier1);
    }

    @Override
    public List<SupplierDto> getAllUser() {
        List<Supplier> suppliers=this.supplierRepo.findAll();
        List<SupplierDto> supplierDtos=suppliers.stream().map((supplier)->this.supplierToDto(supplier)).collect(Collectors.toList());
        return supplierDtos;
    }

    @Override
    public SupplierDto getSupplierById(int id) {
        Supplier supplier=this.supplierRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Supplier","id",id));
        return supplierToDto(supplier);
    }

    @Override
    public void deleteSupplier(int id) {
        Supplier supplier=this.supplierRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Supplier","id",id));
        this.supplierRepo.delete(supplier);
    }

    @Override
    public SupplierDto getProductBySupplierId(int id) {
        return null;
    }

    public Supplier dtoToSupplier(SupplierDto supplierDto){
        Supplier supplier=this.modelMapper.map(supplierDto,Supplier.class);
        return supplier;
    }
    public SupplierDto supplierToDto(Supplier supplier){
        SupplierDto supplierDto=this.modelMapper.map(supplier,SupplierDto.class);
        return supplierDto;
    }

}
