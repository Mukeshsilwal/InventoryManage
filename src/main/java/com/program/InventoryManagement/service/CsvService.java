package com.program.InventoryManagement.service;

import com.program.InventoryManagement.model.CsvData1;

public interface CsvService {

    void saveCsvData(CsvData1 csvData1,String csvPath);
}
