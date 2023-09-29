package com.program.InventoryManagement.repository;

import com.program.InventoryManagement.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
