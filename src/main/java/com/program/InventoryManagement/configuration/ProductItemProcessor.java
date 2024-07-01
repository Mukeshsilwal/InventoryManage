package com.program.InventoryManagement.configuration;

import com.program.InventoryManagement.payload.ProductDto;
import org.springframework.batch.item.ItemProcessor;

public class ProductItemProcessor implements ItemProcessor<ProductDto,ProductDto> {
    @Override
    public ProductDto process(ProductDto productDto) throws Exception {
        return productDto;
    }
}
