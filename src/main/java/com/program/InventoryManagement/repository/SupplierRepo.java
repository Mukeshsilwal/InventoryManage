package com.program.InventoryManagement.repository;

import com.program.InventoryManagement.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepo extends JpaRepository<Supplier,Integer> {
}
