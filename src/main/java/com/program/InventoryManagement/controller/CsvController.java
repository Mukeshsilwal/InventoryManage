package com.program.InventoryManagement.controller;

import com.program.InventoryManagement.configuration.CsvExportService;
import com.program.InventoryManagement.payload.ProductDto;
import com.program.InventoryManagement.service.OrderService;
import com.program.InventoryManagement.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/csv")
@RequiredArgsConstructor
public class CsvController {
    private final CsvExportService csvExportService;
    private final ProductService productService;
    private final OrderService orderService;

    @GetMapping("/export")
    public void exportData() throws IOException {
        List<ProductDto> data = productService.getAllProduct();
                csvExportService.exportDataToCsv(data, "exportedProduct.csv");
    }


}
