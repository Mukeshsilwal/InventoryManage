package com.program.InventoryManagement.repository;

import com.program.InventoryManagement.model.CsvData1;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CsvRepo  extends JpaRepository<CsvData1,Integer> {
}
