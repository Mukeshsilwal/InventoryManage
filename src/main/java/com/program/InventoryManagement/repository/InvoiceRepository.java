package com.program.InventoryManagement.repository;

import com.program.InventoryManagement.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
}
