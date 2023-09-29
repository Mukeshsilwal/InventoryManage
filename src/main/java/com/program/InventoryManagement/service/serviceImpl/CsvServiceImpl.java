package com.program.InventoryManagement.service.serviceImpl;

import com.program.InventoryManagement.model.CsvData1;
import com.program.InventoryManagement.repository.CsvRepo;
import com.program.InventoryManagement.service.CsvService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CsvServiceImpl implements CsvService {
    private final CsvRepo csvRepo;
    @Override
    public void saveCsvData(CsvData1 csvData1, String csvPath) {
        this.csvRepo.save(csvData1);

    }
}
