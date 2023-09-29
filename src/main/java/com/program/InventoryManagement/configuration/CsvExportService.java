package com.program.InventoryManagement.configuration;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import com.program.InventoryManagement.entity.Product;
import com.program.InventoryManagement.model.CsvData1;
import com.program.InventoryManagement.payload.OrderDto;
import com.program.InventoryManagement.payload.ProductDto;
import com.program.InventoryManagement.repository.CsvRepo;
import com.program.InventoryManagement.service.CsvService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CsvExportService {
    private final CsvService csvService;
    public void exportDataToCsv(List<ProductDto> data, String csvFilePath) throws IOException {
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(csvFilePath))) {

            String[] header = {"productName", "productNo"};
            csvWriter.writeNext(header);


            for (ProductDto product : data) {
                String[] row = {product.getProductName(),String.valueOf(product.getProductNo())};
                csvWriter.writeNext(row);

            }
        }
    }

    public void exportDataToCsv1(List<OrderDto> data, String csvFilePath) throws IOException {
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(csvFilePath))) {

            String[] header = {"orderName", "product","user","supplier"};
            csvWriter.writeNext(header);

            for (OrderDto orderDto : data) {
                String[] row = {orderDto.getOrderName(), String.valueOf(orderDto.getProduct()), String.valueOf(orderDto.getSupplier()), String.valueOf(orderDto.getUser())};
                csvWriter.writeNext(row);

            }
        }
    }
    public void saveCsvData(CsvData1 csvData, String fileName) throws IOException {
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(fileName, true))) {
            csvWriter.writeNext(new String[]{csvData.getProductName(), csvData.getProductNo()});
        }
    }
    public void importCsvData(String fileName) throws IOException, CsvValidationException {
        try (CSVReader csvReader = new CSVReader(new FileReader(fileName))) {
            String[] nextLine;
            while ((nextLine = csvReader.readNext()) != null) {
                String productName = nextLine[0];
                String productNo = nextLine[1];

                CsvData1 csvData = new CsvData1();
                csvData.setProductName(productName);
                csvData.setProductNo(productNo);
                this.csvService.saveCsvData(csvData,fileName);

            }
        }
    }
}
